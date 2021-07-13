package cl.inacap.bibliotecaApp.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClienteFrame extends JFrameBiblioteca {

	private JPanel contentPane;

	public ClienteFrame() {
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JButton btnSalirMenu = new JButton("SALIR");
		btnSalirMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalirMenu.setBounds(34, 450, 150, 30);
		getContentPane().add(btnSalirMenu);
		
		JLabel lblTituloMenu = new JLabel("Que desea hacer?");
		lblTituloMenu.setBackground(Color.BLACK);
		lblTituloMenu.setForeground(Color.WHITE);
		lblTituloMenu.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTituloMenu.setBounds(236, 43, 341, 30);
		getContentPane().add(lblTituloMenu);
		
		JLabel lblCompraIcono = new JLabel("");
		lblCompraIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/userP.png")));
		lblCompraIcono.setBounds(368, 205, 80, 80);
		getContentPane().add(lblCompraIcono);
		
		JLabel lblArrendarIcono = new JLabel("");
		lblArrendarIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/userP.png")));
		lblArrendarIcono.setBounds(535, 205, 80, 80);
		getContentPane().add(lblArrendarIcono);
		
		JLabel lblComprarMenu = new JLabel("COMPRAR");
		lblComprarMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComprarMenu.setBounds(356, 287, 111, 30);
		getContentPane().add(lblComprarMenu);
		
		JLabel lblArrendarMenu = new JLabel("ARRENDAR");
		lblArrendarMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblArrendarMenu.setBounds(520, 287, 117, 30);
		getContentPane().add(lblArrendarMenu);
		
		JLabel lblBienvenidoMenu = new JLabel("Bienvenido");
		lblBienvenidoMenu.setForeground(Color.WHITE);
		lblBienvenidoMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenidoMenu.setBounds(45, 173, 117, 25);
		getContentPane().add(lblBienvenidoMenu);
		
		JLabel lblNombreMenu = new JLabel("Camilo");
		lblNombreMenu.setForeground(Color.WHITE);
		lblNombreMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreMenu.setBounds(75, 403, 69, 25);
		getContentPane().add(lblNombreMenu);
		
		JLabel lblPanelLateral = new JLabel("New label");
		lblPanelLateral.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/fastLateral.jpg")));
		lblPanelLateral.setBounds(0, 0, 220, 600);
		getContentPane().add(lblPanelLateral);
	}
}