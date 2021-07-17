package cl.inacap.bibliotecaApp.frames;

import java.awt.Color;

import javax.swing.JFrame;

public class JFrameBiblioteca extends JFrame {

	public JFrameBiblioteca() {
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);

		this.setLocationRelativeTo(null);
	}

}
