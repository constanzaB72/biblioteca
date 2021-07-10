package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cl.inacap.bibliotecaApp.frames.LoginFrame;
import cl.inacap.bibliotecaApp.frames.MenuFrame;
import cl.inacap.bibliotecaModel.service.LoginService;

public class LoginController {
	LoginFrame loginFrame;
	MenuFrame menuFrame;
	LoginService loginService=new LoginService();
	
	public LoginController(){
		 loginFrame = new LoginFrame();	
		 loginFrame.addIngresarListener(new IngresarListener());		 
	}
	class IngresarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String usuario=loginFrame.getTxtUsuarioLogin().getText();
			String pass=String.valueOf(loginFrame.getPassFContrasenaLogin().getPassword());
			System.out.println("usuario: "+usuario+" pass: "+pass);
			if (loginService.validarUsuario(usuario, pass)) {
				System.out.println("usuario valido");
				menuFrame = new MenuFrame();
			}else {
				System.out.println("usuario no valido");
			}
			
		}		
	}
	

}
