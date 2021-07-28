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

/**
 * Clase encargada de trabajar como un controlador de cada evento que suceda en
 * el Frame Anclado, ademas de crear un Frame y mostrarlo en pantalla,
 * Implementa ActionListener, para poder escuchar cualquier evento ya sea de un
 * boton, input rellenado , envio de formulario, etc. Ademas implementa clases
 * DAO para la insercion de datos a la BD. Este controlador, cumple la funcion
 * de obtener los datos provenientes del logeo de un Cliente, su funcion es
 * recibir los datos , para luego con la ayuda de un metodo DAO, como el
 * findByRut podemos validar si los datos ingresados en el Login calzan con los
 * datos en la BD.
 * Si la Validacion es exitosa, procede a mostrar todas las
 * opciones que puede realizar el Usuario.
 * 
 * CREADA EL DIA 13-07-2021
 * 
 * @author Constanza Benavidez
 * 
 *
 */
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