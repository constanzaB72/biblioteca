package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cl.inacap.bibliotecaApp.frames.LoginFrame;
import cl.inacap.bibliotecaModel.service.LoginService;

public class LoginController {
	LoginFrame frame;
	LoginService loginService=new LoginService();
	
	public LoginController(){
		 frame = new LoginFrame();	
		 frame.addIngresarListener(new IngresarListener());		 
	}
	class IngresarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String usuario=frame.getTxtUsuarioLogin().getText();
			String pass=String.valueOf(frame.getPassFContrasenaLogin().getPassword());
			System.out.println("usuario: "+usuario+" pass: "+pass);
			if (loginService.validarUsuario(usuario, pass)) {
				System.out.println("usuario valido");
			}else {
				System.out.println("usuario no valido");
			}
			
		}		
	}
	

}
