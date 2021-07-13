package cl.inacap.bibliotecaApp.main;

import java.awt.EventQueue;

import cl.inacap.bibliotecaApp.frames.ArriendoFrame;
import cl.inacap.bibliotecaApp.frames.CompraFrame;
import cl.inacap.bibliotecaApp.frames.LoginFrame;
import cl.inacap.bibliotecaApp.frames.TrabajadorFrame;
import cl.inacap.bibliotecaApp.frames.RegistrarFrame;
import cl.inacap.bibliotecaApp.frames.VentaFrame;

public class main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ArriendoFrame a= new ArriendoFrame();
					//VentaFrame v=new VentaFrame();
					//CompraFrame c=new CompraFrame();
					//MenuFrame m =new MenuFrame();
					//RegistrarFrame r =new RegistrarFrame();
					LoginFrame frame = new LoginFrame();					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
