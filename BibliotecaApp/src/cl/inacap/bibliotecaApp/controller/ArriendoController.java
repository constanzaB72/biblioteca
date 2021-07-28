package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.table.DefaultTableModel;

import cl.inacap.bibliotecaApp.frames.ArriendoExitoso;
import cl.inacap.bibliotecaApp.frames.ArriendoFrame;
import cl.inacap.bibliotecaApp.frames.SelectEjemplarFrame;
import cl.inacap.bibliotecaModel.dao.ArriendosDAO;
import cl.inacap.bibliotecaModel.dao.ClientesDAO;
import cl.inacap.bibliotecaModel.dao.DetallesArriendosDAO;
import cl.inacap.bibliotecaModel.dao.EjemplarDAO;
import cl.inacap.bibliotecaModel.dao.LibrosDAO;
import cl.inacap.bibliotecaModel.dao.TrabajadoresDAO;
import cl.inacap.bibliotecaModel.dto.Arriendo;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.service.EjemplaresService;
import cl.inacap.bibliotecaModel.utils.Generador;
import cl.inacap.bibliotecaModel.utils.RutUtils;

public class ArriendoController {
	ArriendoFrame arriendoFrame;
	private ArriendoExitoso arriendoExitoso;
	private SelectEjemplarFrame selectEjemplarFrame;
	// DAO
	private LibrosDAO librosDAO = new LibrosDAO();
	private EjemplarDAO ejemplarDAO = new EjemplarDAO();
	private ClientesDAO clienteDAO= new ClientesDAO();
	private TrabajadoresDAO trabajadorDAO = new TrabajadoresDAO();
	private ArriendosDAO arriendosDAO= new ArriendosDAO();
	private DetallesArriendosDAO detallesArriendosDAO = new DetallesArriendosDAO();
	
	private RutUtils rutUtils=new RutUtils();
	private String rut;
	private String tipoUsuario;
	private Cliente cliente;
	private Trabajador trabajador;
	private Date fechaEntrega; 
	private List<Ejemplar> ejemplares;
	
	private EjemplaresService ejemplarService=new EjemplaresService();

	private List<Libro> libros;
	
	private Generador generador = new Generador();
	
	public ArriendoController(String rut, String tipoUsuario) {
		this.tipoUsuario=tipoUsuario;
		this.rut=rut;
		arriendoFrame = new ArriendoFrame();
		habilitarFecha(); 
		if(tipoUsuario.equals("cliente")) {
			arriendoFrame.getTxtClienteArriendo().setText(rut);
			arriendoFrame.getTxtClienteArriendo().setEditable(false);
			trabajador = trabajadorDAO.findByRut("20.127.772-9");//Josué
		}else {
			trabajador =trabajadorDAO.findByRut(rut);
		}
		
		ejemplares = ejemplarService.getAllEjemplaresDisponibles();
		arriendoFrame.addSelectListener(new SelectListener());
		arriendoFrame.addDateListener(new DateListener());
		arriendoFrame.addArrendarListener(new ArriendoListener());
		arriendoFrame.addMenuListener(new MenuListener());
	}
	
	//12.622.028-6
	//20.780.661-7
		
	class ArriendoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String valido = rutUtils.validarRut(arriendoFrame.getTxtClienteArriendo().getText());
			if (valido.equals("Valido")) {
				
			
			List<Ejemplar> ejemplaresArrendados = new ArrayList<Ejemplar>();
			libros=librosDAO.getAll();
			cliente =clienteDAO.findByRut(arriendoFrame.getTxtClienteArriendo().getText());
			int cantidadFilas = arriendoFrame.getTableLibros().getModel().getRowCount();
			for (int i = 0; i < cantidadFilas; i++) {
				Ejemplar ejemplar = new Ejemplar();
				ejemplar.setNumSerie((Integer) (arriendoFrame.getTableLibros().getModel().getValueAt(i, 0)));
				ejemplar.setIsbn(String.valueOf(arriendoFrame.getTableLibros().getModel().getValueAt(i, 1)));
				ejemplar.setTitulo(String.valueOf(arriendoFrame.getTableLibros().getModel().getValueAt(i, 2)));
				ejemplaresArrendados.add(ejemplar);
			}
			
			for(Ejemplar ej : ejemplaresArrendados) {
				ejemplarDAO.updateEstado(ej, "Arrendado");
				System.out.println("Estado cambiado");
			}
			Arriendo arriendo = new Arriendo();
			//arriendo.setIdArriendo(12);
			SimpleDateFormat format =new SimpleDateFormat("dd-MM-yyyy");
			arriendo.setIdCliente(cliente.getIdCliente());
			arriendo.setIdTrabajador(trabajador.getIdTrabajador());
			arriendo.setFechaArriendo(generador.generarFechaActual());
			arriendo.setFechaDevolucion(format.format(fechaEntrega));
			arriendo.setFechaEntrega("-");
			arriendo.setDiasRetraso(0);
			arriendo.setMulta(0);
			arriendo.setCostoTotal(Integer.parseInt(arriendoFrame.getTxtCosto().getText()));
			int idArriendo = arriendosDAO.crearArriendo(arriendo, cliente, trabajador);
			arriendo.setIdArriendo(idArriendo);
			
			detallesArriendosDAO.insertDetalleArriendo(arriendo, libros, ejemplaresArrendados);
			arriendoExitoso=new ArriendoExitoso();
			arriendoExitoso.addFinalizarListener(new FinalizarListener());
			arriendoExitoso.setVisible(true);
			
			
			}else {
				System.out.println("error "+valido);
			}
		}
	}
	class FinalizarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tipoUsuario.equals("cliente")) {
				ClienteController cliente = new ClienteController(rut);
			}else {
				TrabajadorController trabajador = new TrabajadorController(rut);
			}
			arriendoFrame.dispose();
			arriendoExitoso.setVisible(false);
			arriendoExitoso.dispose();
		}
	}

	class DateListener implements PropertyChangeListener {
		public void propertyChange(PropertyChangeEvent e) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			fechaEntrega = arriendoFrame.getDateChooser().getDate();
			if (fechaEntrega != null) {
				long diff = fechaEntrega.getTime() - (new Date()).getTime();
				System.out.println("diff: "+diff);
				TimeUnit time = TimeUnit.DAYS;
				long dias = time.convert(diff, TimeUnit.MILLISECONDS);
				System.out.println("dias: "+dias);
				int cantidadFilas = arriendoFrame.getTableLibros().getModel().getRowCount();
				int total = 0;
				for (int i = 0; i < cantidadFilas; i++) {
					total = (int) (total + 1000 + (200 * dias));
				}
				arriendoFrame.getTxtCosto().setText(String.valueOf(total));
			}

		}
	}
	class SelectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectEjemplarFrame = new SelectEjemplarFrame(ejemplares);
			int cantidadFilas = selectEjemplarFrame.getTable().getModel().getRowCount();
			DefaultTableModel model= (DefaultTableModel)selectEjemplarFrame.getTable().getModel();
			for (int i = 0; i < cantidadFilas; i++) {
				int valor=1000;
				model.setValueAt(valor, i, 3);				
			}
			selectEjemplarFrame.getTable().setModel(model);
			selectEjemplarFrame.setVisible(true);
			selectEjemplarFrame.addConfirmarAgregar(new AgregarListener());
			selectEjemplarFrame.addCancelarAgregar(new CancelarAgregarListener());
			
			
		
		}
	}
	class CancelarAgregarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectEjemplarFrame.dispose();
			
		}
	}
	class AgregarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel aux=(DefaultTableModel)selectEjemplarFrame.getTable2().getModel();
			arriendoFrame.getTableLibros().setModel(aux);
			arriendoFrame.getTableLibros().removeColumn(arriendoFrame.getTableLibros().getColumnModel().getColumn(4));
			
			selectEjemplarFrame.dispose();
			habilitarFecha();
			
		}
	}
	class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tipoUsuario.equals("cliente")) {
				ClienteController cliente = new ClienteController(rut);
			}else {
				TrabajadorController trabajador = new TrabajadorController(rut);
			}
			arriendoFrame.dispose();
		}
	}
	
	private void habilitarFecha() {
		if(arriendoFrame.getTableLibros().getModel().getRowCount()==0) {
			arriendoFrame.getDateChooser().setEnabled(false);
			arriendoFrame.getTxtCosto().setText("");
		}else {
			arriendoFrame.getDateChooser().setEnabled(true);
			
		}
	
	}
	
	
}

