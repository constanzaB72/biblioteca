package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cl.inacap.bibliotecaApp.frames.TrabajadorFrame;
import cl.inacap.bibliotecaModel.dao.TrabajadoresDAO;
import cl.inacap.bibliotecaModel.dto.Trabajador;

public class TrabajadorController {

	private Trabajador trabajador;
	TrabajadorFrame trabajadorFrame;

	TrabajadoresDAO trabajadorDAO = new TrabajadoresDAO();

	public TrabajadorController(String rut) {
		trabajador = trabajadorDAO.findByRut(rut);
		trabajadorFrame = new TrabajadorFrame(trabajador);
		trabajadorFrame.addSalirListener(new SalirListener());
		//trabajadorFrame.setVisible(true);
	}

	class SalirListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			LoginController Login = new LoginController();
			trabajadorFrame.dispose();
			
		}
	}

}
