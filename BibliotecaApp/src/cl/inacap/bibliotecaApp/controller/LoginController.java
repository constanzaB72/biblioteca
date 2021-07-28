package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.omg.CORBA.Request;

import cl.inacap.bibliotecaApp.frames.ClienteFrame;
import cl.inacap.bibliotecaApp.frames.LoginFrame;
import cl.inacap.bibliotecaApp.frames.RegistrarFrame;
import cl.inacap.bibliotecaApp.frames.TrabajadorFrame;
import cl.inacap.bibliotecaModel.service.LoginService;

/**
 * Clase encargada de trabajar como un controlador de cada evento que suceda en
 * el Frame Anclado, ademas de crear un Frame y mostrarlo en pantalla,
 * Implementa ActionListener, para poder escuchar cualquier evento ya sea de un
 * boton, input rellenado , envio de formulario, etc. Su funcion es crear un
 * FrameLogin, una vez el formulario haya sido llenado y enviado, mediante el
 * ActionListener, queda escuchando para ir llamando a ciertos controllers para
 * realizar validaciones sobre el tipo de Usuario.
 * 
 * CREADA EL DIA 13-07-2021
 * 
 * @author Constanza Benavidez
 * 
 *
 */
public class LoginController {
	LoginFrame loginFrame;
	TrabajadorController trabajadorController;
	ClienteController clienteController;
	ClienteFrame clienteFrame;
	LoginService loginService = new LoginService();

	public LoginController() {
		loginFrame = new LoginFrame();
		loginFrame.addIngresarListener(new IngresarListener());
		loginFrame.addRegistrarListener(new RegistrarListener());
	}

	class RegistrarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			RegistrarController r =new RegistrarController();
		}
	}
	
	class IngresarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String usuario=loginFrame.getTxtUsuarioLogin().getText();
			String pass=String.valueOf(loginFrame.getPassFContrasenaLogin().getPassword());
		    String tipoUsuario=String.valueOf(loginFrame.getCbTipoLogin().getSelectedItem());
			System.out.println("usuario: "+usuario+" pass: "+pass);
			if (loginService.validarUsuario(usuario, pass,tipoUsuario)) {
				System.out.println("usuario valido");
				if(tipoUsuario.equals("Trabajador")) {
					trabajadorController = new TrabajadorController(usuario);
				}else {
					clienteController = new ClienteController(usuario);
				}
				loginFrame.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null,"Usuario no válido");
				loginFrame.getPassFContrasenaLogin().setText("");
			}
			
			
		}
		
	}

	
}
