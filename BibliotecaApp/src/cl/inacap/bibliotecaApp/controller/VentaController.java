package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import cl.inacap.bibliotecaApp.frames.SelectEjemplarFrame;
import cl.inacap.bibliotecaApp.frames.VentaExitosa;
import cl.inacap.bibliotecaApp.frames.VentaFrame;
import cl.inacap.bibliotecaModel.dao.BoletasDAO;
import cl.inacap.bibliotecaModel.dao.ClientesDAO;
import cl.inacap.bibliotecaModel.dao.DetallesBoletasDAO;
import cl.inacap.bibliotecaModel.dao.EjemplarDAO;
import cl.inacap.bibliotecaModel.dao.LibrosDAO;
import cl.inacap.bibliotecaModel.dao.TrabajadoresDAO;
import cl.inacap.bibliotecaModel.dao.VentasDAO;
import cl.inacap.bibliotecaModel.dto.Boleta;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.DetalleBoleta;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.service.EjemplaresService;
import cl.inacap.bibliotecaModel.utils.Generador;
import cl.inacap.bibliotecaModel.utils.RutUtils;

/**
 * Clase encargada de trabajar como un controlador de cada evento que suceda en
 * el Frame Anclado, ademas de crear un Frame y mostrarlo en pantalla,
 * Implementa ActionListener, para poder escuchar cualquier evento ya sea de un
 * boton, input rellenado , envio de formulario, etc. Ademas implementa clases
 * DAO para la insercion de datos a la BD. Este controlador, cumple la funcion
 * de obtener los datos provenientes del FrameVenta, y posterior a la captura de
 * los datos, lanzar un FrameVenta, para que el usuario pueda realizar las
 * opciones disponibles en la interfaz.
 * 
 * CREADA EL DIA 13-07-2021
 * 
 * @author Constanza Benavidez
 * 
 *
 */
public class VentaController {
	
	//Frame
	private VentaFrame ventaFrame;
	private VentaExitosa ventaExitosa;
	private SelectEjemplarFrame selectEjemplarFrame;
	//DAO
	private LibrosDAO librosDAO = new LibrosDAO();
	private LibrosDAO libroDao = new LibrosDAO();
	private EjemplarDAO ejemplarDAO = new EjemplarDAO();
	private ClientesDAO clienteDao = new ClientesDAO();
	private TrabajadoresDAO trabajadorDAO = new TrabajadoresDAO();
	
	
	private VentasDAO ventaDAO = new VentasDAO();
	private DetallesBoletasDAO detalleBoletasDAO =new DetallesBoletasDAO();
	private BoletasDAO boletasDAO = new BoletasDAO();
	
	private String rut;
	private String tipoUsuario;
	private Cliente cliente;
	private Trabajador trabajador;
	private RutUtils rutUtils=new RutUtils();
	
	private List<Libro> libros;
	private List<Ejemplar> ejemplares;
	
	
	private EjemplaresService ejemplarService=new EjemplaresService();
	
	private Generador generador = new Generador();
	
	public VentaController(String rut, String tipoUsuario) {
		this.rut=rut;
		this.tipoUsuario=tipoUsuario;
		ventaFrame = new VentaFrame();
		libros = librosDAO.getAll();
		if(tipoUsuario.equals("cliente")) {
			ventaFrame.getTxtClienteVenta().setText(rut);
			ventaFrame.getTxtClienteVenta().setEditable(false);
			trabajador = trabajadorDAO.findByRut("20.127.772-9");//Josué
		}else {
			trabajador =trabajadorDAO.findByRut(rut);
		}
		ejemplares = ejemplarService.getAllEjemplaresDisponibles();
		
		ventaFrame.addMenuListener(new MenuListener());
		ventaFrame.addSelectListener(new SelectListener());
		ventaFrame.addVentaListener(new VenderListener());
		
		ventaFrame.repaint();
	}
	class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tipoUsuario.equals("cliente")) {
				ClienteController cliente = new ClienteController(rut);
			}else {
				TrabajadorController trabajador = new TrabajadorController(rut);
			}
			ventaFrame.dispose();
		}
	}
	//class ventaListener
	class FinalizarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tipoUsuario.equals("cliente")) {
				ClienteController cliente = new ClienteController(rut);
			}else {
				TrabajadorController trabajador = new TrabajadorController(rut);
			}
			ventaFrame.dispose();
			ventaExitosa.setVisible(false);
			ventaExitosa.dispose();
		}
	}

	class SelectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectEjemplarFrame = new SelectEjemplarFrame(ejemplares);
			
			selectEjemplarFrame.setVisible(true);
			selectEjemplarFrame.addConfirmarAgregar(new AgregarListener());
			selectEjemplarFrame.addCancelarAgregar(new CancelarAgregarListener());
		}
	}
	class AgregarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel aux=(DefaultTableModel)selectEjemplarFrame.getTable2().getModel();
			ventaFrame.getTableLibros().setModel(aux);
			ventaFrame.getTableLibros().removeColumn(ventaFrame.getTableLibros().getColumnModel().getColumn(4));
			Integer suma=0;
			for(int fila=0;fila<aux.getRowCount();fila++) {
				suma=suma+((Integer) aux.getValueAt(fila, 3)/* */);				
			}
			ventaFrame.getTxtCosto().setText("$"+String.valueOf(suma));
			selectEjemplarFrame.dispose();
			
		}
	}
	class CancelarAgregarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectEjemplarFrame.dispose();
			
		}
	}

	class VenderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String valido = rutUtils.validarRut(ventaFrame.getTxtClienteVenta().getText());
			if (valido.equals("Valido")) {
				
			
			List<Ejemplar> ejemplaresVendidos = new ArrayList<Ejemplar>();
			Boleta boleta = new Boleta();
			int cantidadFilas = ventaFrame.getTableLibros().getModel().getRowCount();
			for (int i = 0; i < cantidadFilas; i++) {
				System.out.println("entra for " + i);
				Ejemplar ejemplar = new Ejemplar();
				ejemplar.setNumSerie((Integer) (ventaFrame.getTableLibros().getModel().getValueAt(i, 0)));
				ejemplar.setIsbn(String.valueOf(ventaFrame.getTableLibros().getModel().getValueAt(i, 1)));
				ejemplar.setTitulo(String.valueOf(ventaFrame.getTableLibros().getModel().getValueAt(i, 2)));
				ejemplaresVendidos.add(ejemplar);
			}
			
			for(Ejemplar ej : ejemplaresVendidos) {
				ejemplarDAO.updateEstado(ej, "Vendido");
				System.out.println("Estado cambiado");
			}
			
			boleta.setFolio(generador.generarFolioBoleta());
			boleta.setFechaVenta(generador.generarFechaActual());
			boleta.setHoraVenta(generador.generarHoraActual());
			boleta.setMetodoPago((String)ventaFrame.getCbxMetodoPago().getSelectedItem());
			
			Cliente cliente = clienteDao.findByRut(ventaFrame.getTxtClienteVenta().getText());
			if(cliente!=null && cliente.getRut()!=null) {
				boletasDAO.insertBoleta(boleta, cliente, trabajador);
				detalleBoletasDAO.insertDetalles(ejemplaresVendidos, libros, boleta);
				ventaDAO.insertVenta(boleta, cliente, trabajador);				
			}else {
				System.out.println("Cliente no valido: "+ventaFrame.getTxtClienteVenta().getText());
			}
			ventaExitosa= new VentaExitosa();
			ventaExitosa.addFinalizarListener(new FinalizarListener());
			ventaExitosa.setVisible(true);
		}else {
			System.out.println("error "+valido);
		}
		}
	}
	
	
}