package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cl.inacap.bibliotecaApp.frames.ClienteFrame;
import cl.inacap.bibliotecaModel.dao.ClientesDAO;
import cl.inacap.bibliotecaModel.dto.Cliente;


public class ClienteController {

	private Cliente cliente;
	ClienteFrame clienteFrame;

	ClientesDAO trabajadorDAO = new ClientesDAO();

	public ClienteController(String rut) {
		cliente = trabajadorDAO.findByRut(rut);
		clienteFrame = new ClienteFrame(cliente);
		clienteFrame.addSalirListener(new SalirListener());
		//trabajadorFrame.setVisible(true);
	}

	class SalirListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			LoginController Login = new LoginController();
			clienteFrame.dispose();
			
		}
	}

}