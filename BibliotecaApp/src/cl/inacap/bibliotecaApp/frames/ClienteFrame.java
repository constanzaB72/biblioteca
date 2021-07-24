package cl.inacap.bibliotecaApp.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cl.inacap.bibliotecaModel.dto.Cliente;
import javax.swing.SwingConstants;

public class ClienteFrame extends JFrameBiblioteca {

	private JPanel contentPane;
	private JButton btnSalirCliente;
	private JButton btnArrendar;
	private JButton btnVender;

	public ClienteFrame(Cliente cliente) {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);
		
		btnSalirCliente = new JButton("SALIR");
		btnSalirCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalirCliente.setBounds(40, 450, 150, 30);
		getContentPane().add(btnSalirCliente);
		
		JLabel lblTituloCliente = new JLabel("¿Que desea hacer?");
		lblTituloCliente.setBackground(Color.BLACK);
		lblTituloCliente.setForeground(Color.DARK_GRAY);
		lblTituloCliente.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTituloCliente.setBounds(350, 37, 341, 30);
		getContentPane().add(lblTituloCliente);
		
		JLabel lblCompraIcono = new JLabel("");
		lblCompraIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/comprar.png")));
		lblCompraIcono.setBounds(380, 210, 65, 65);
		getContentPane().add(lblCompraIcono);
		
		JLabel lblArrendarIcono = new JLabel("");
		lblArrendarIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/arrendar.png")));
		lblArrendarIcono.setBounds(572, 210, 65, 65);
		getContentPane().add(lblArrendarIcono);
		
		JLabel lblComprarCliente = new JLabel("COMPRAR");
		lblComprarCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComprarCliente.setBounds(360, 288, 110, 30);
		getContentPane().add(lblComprarCliente);
		
		JLabel lblArrendarCliente = new JLabel("ARRENDAR");
		lblArrendarCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblArrendarCliente.setBounds(546, 288, 122, 30);
		getContentPane().add(lblArrendarCliente);
		
		btnVender = new JButton("");
		btnVender.setBounds(360, 288, 110, 30);
		btnVender.setOpaque(false);
		btnVender.setContentAreaFilled(false);
		btnVender.setBorderPainted(false);
		getContentPane().add(btnVender);
		
		btnArrendar = new JButton("");
		btnArrendar.setBounds(546, 288, 122, 30);
		btnArrendar.setOpaque(false);
		btnArrendar.setContentAreaFilled(false);
		btnArrendar.setBorderPainted(false);
		getContentPane().add(btnArrendar);
		
		JLabel lblBienvenidoCliente = new JLabel("Bienvenido");
		lblBienvenidoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoCliente.setForeground(Color.WHITE);
		lblBienvenidoCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenidoCliente.setBounds(0, 155, 230, 25);
		getContentPane().add(lblBienvenidoCliente);
		
		JLabel lblNombreCliente = new JLabel(cliente.getNombre());
		lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCliente.setForeground(Color.WHITE);
		lblNombreCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreCliente.setBounds(0, 340, 230, 25);
		getContentPane().add(lblNombreCliente);
		
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/userP.png")));
		lblAvatar.setBounds(0, 190, 230, 130);
		getContentPane().add(lblAvatar);
		
		JLabel lblLateralColor = new JLabel("");
		lblLateralColor.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/lateralColor.jpg")));
		lblLateralColor.setBounds(0, 0, 230, 600);
		getContentPane().add(lblLateralColor);
	}
	public void addSalirListener(ActionListener ing) {
		btnSalirCliente.addActionListener(ing);	}	
	
	public void addVenderListener(ActionListener ing) {
		btnVender.addActionListener(ing);
	}
	public void addArrendarListener(ActionListener ing) {
		btnArrendar.addActionListener(ing);
	}
	public JButton getBtnSalirCliente() {
		return btnSalirCliente;
	}
	public void setBtnSalirCliente(JButton btnSalirCliente) {
		this.btnSalirCliente = btnSalirCliente;
	}
	public JButton getBtnArrendar() {
		return btnArrendar;
	}
	public void setBtnArrendar(JButton btnArrendar) {
		this.btnArrendar = btnArrendar;
	}
	public JButton getBtnVender() {
		return btnVender;
	}
	public void setBtnVender(JButton btnVender) {
		this.btnVender = btnVender;
	}
	
}
