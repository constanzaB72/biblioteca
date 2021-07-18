package cl.inacap.bibliotecaApp.frames;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentaFrame extends JFrameBiblioteca {

	private JTextField textRutCliente;
	private JTextField txtCostoVenta;
	private JButton btnVolverMenu;

	public VentaFrame() {
		getContentPane().setLayout(null);
		
		btnVolverMenu = new JButton("MENU");
		btnVolverMenu.setBounds(40, 450, 150, 30);
		btnVolverMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(btnVolverMenu);
		
		JLabel lblVenderTexto = new JLabel("ARRENDAR");
		lblVenderTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenderTexto.setForeground(Color.WHITE);
		lblVenderTexto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVenderTexto.setBounds(0, 353, 230, 25);
		getContentPane().add(lblVenderTexto);
		
		JLabel lblVenderTexto2 = new JLabel("LIBROS");
		lblVenderTexto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenderTexto2.setForeground(Color.WHITE);
		lblVenderTexto2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVenderTexto2.setBounds(0, 380, 230, 25);
		getContentPane().add(lblVenderTexto2);
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setIcon(new ImageIcon(CompraFrame.class.getResource("/img/Comprarg.png")));
		lblAvatar.setBounds(0, 190, 230, 130);
		getContentPane().add(lblAvatar);
		
		JLabel lblLateralColor = new JLabel("");
		lblLateralColor.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/lateralColor.jpg")));
		lblLateralColor.setBounds(0, 0, 230, 600);
		getContentPane().add(lblLateralColor);
		
		JLabel lblClienteVenta = new JLabel("Rut de Cliente: ");
		lblClienteVenta.setBounds(261, 136, 200, 30);
		lblClienteVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblClienteVenta);
		
		textRutCliente = new JTextField();
		textRutCliente.setBounds(261, 165, 200, 30);
		getContentPane().add(textRutCliente);
		textRutCliente.setColumns(10);
		
		JLabel lblLibrosVenta = new JLabel("Libros: ");
		lblLibrosVenta.setBounds(261, 214, 200, 30);
		lblLibrosVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblLibrosVenta);
		
		JComboBox cbxLibrosVenta = new JComboBox();
		cbxLibrosVenta.setBounds(261, 244, 200, 30);
		getContentPane().add(cbxLibrosVenta);
		
		JLabel lblCantidadVenta = new JLabel("Cantidad: ");
		lblCantidadVenta.setBounds(492, 215, 200, 30);
		lblCantidadVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblCantidadVenta);
		
		JComboBox cbxCantidadVenta = new JComboBox();
		cbxCantidadVenta.setBounds(492, 244, 200, 30);
		getContentPane().add(cbxCantidadVenta);
		
		JLabel lblCostoVenta = new JLabel("Costo: ");
		lblCostoVenta.setBounds(261, 306, 200, 30);
		lblCostoVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblCostoVenta);
		
		txtCostoVenta = new JTextField();
		txtCostoVenta.setBounds(261, 336, 200, 30);
		txtCostoVenta.setColumns(10);
		getContentPane().add(txtCostoVenta);
		
		JButton btnVender = new JButton("VENDER");
		btnVender.setBounds(513, 336, 150, 30);
		btnVender.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(btnVender);
		
		JLabel lblTituloVenta = new JLabel("Formulario de Venta");
		lblTituloVenta.setBounds(340, 40, 300, 30);
		lblTituloVenta.setFont(new Font("Tahoma", Font.BOLD, 26));
		getContentPane().add(lblTituloVenta);
	}
	public void addMenuListener(ActionListener ing) {
		btnVolverMenu.addActionListener(ing);
	}
}
