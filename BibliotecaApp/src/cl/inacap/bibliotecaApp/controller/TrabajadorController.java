package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cl.inacap.bibliotecaApp.frames.TrabajadorFrame;
import cl.inacap.bibliotecaModel.dao.TrabajadoresDAO;
import cl.inacap.bibliotecaModel.dto.Trabajador;

public class TrabajadorController {

	private Trabajador trabajador;
	private String rut;
	TrabajadorFrame trabajadorFrame;

	TrabajadoresDAO trabajadorDAO = new TrabajadoresDAO();

	public TrabajadorController(String rut) {
		this.rut=rut;
		trabajador = trabajadorDAO.findByRut(this.rut);
		trabajadorFrame = new TrabajadorFrame(trabajador);
		trabajadorFrame.addSalirListener(new SalirListener());
		trabajadorFrame.addComprarListener( new ComprarListener());
		trabajadorFrame.addVenderListener(new VenderListener());
		trabajadorFrame.addArrendarListener(new ArrendarListener());
		trabajadorFrame.addEjemplaresListener(new EjemplaresListener());
		trabajadorFrame.addMultasListener(new MultasListener());
		//trabajadorFrame.setVisible(true);
	}
	class EjemplaresListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			EjemplaresController ejemplarCotroller = new EjemplaresController();
			
		}
	}
	class MultasListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			DevolucionController  devolucionController= new DevolucionController();
			
		}
	}

	class SalirListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			LoginController Login = new LoginController();
			trabajadorFrame.dispose();
			
		}
	}
	class ComprarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			CompraController comprar = new CompraController(rut,"trabajador");
			trabajadorFrame.dispose();
			
		}
	}
	//Vender Controller
	class VenderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			VentaController venta = new VentaController(rut,"trabajador");
			trabajadorFrame.dispose();
			
		}
	}
	
	class ArrendarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			ArriendoController arriendo = new ArriendoController(rut,"trabajador");
			trabajadorFrame.dispose();
			
		}
	}

}
