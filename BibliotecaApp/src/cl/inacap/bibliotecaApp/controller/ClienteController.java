package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cl.inacap.bibliotecaApp.controller.TrabajadorController.ArrendarListener;
import cl.inacap.bibliotecaApp.controller.TrabajadorController.ComprarListener;
import cl.inacap.bibliotecaApp.controller.TrabajadorController.SalirListener;
import cl.inacap.bibliotecaApp.controller.TrabajadorController.VenderListener;
import cl.inacap.bibliotecaApp.frames.ClienteFrame;
import cl.inacap.bibliotecaModel.dao.ClientesDAO;
import cl.inacap.bibliotecaModel.dto.Cliente;


public class ClienteController {

	private Cliente cliente;
	private String rut;
	ClienteFrame clienteFrame;

	ClientesDAO trabajadorDAO = new ClientesDAO();

	public ClienteController(String rut) {
		this.rut=rut;
		cliente = trabajadorDAO.findByRut(rut);
		clienteFrame = new ClienteFrame(cliente);
		clienteFrame.addSalirListener(new SalirListener());
		clienteFrame.addVenderListener(new VenderListener());
		clienteFrame.addArrendarListener(new ArrendarListener());
		//trabajadorFrame.setVisible(true);
	}

	class SalirListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			LoginController Login = new LoginController();
			clienteFrame.dispose();
			
		}
	}
	class VenderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			VentaController venta = new VentaController(rut,"cliente");
			clienteFrame.dispose();
			
		}
	}
	class ArrendarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			ArriendoController arriendo = new ArriendoController(rut,"cliente");
			clienteFrame.dispose();
			
		}
	}

}