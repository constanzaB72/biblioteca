package cl.inacap.bibliotecaApp.frames;


import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentaFrame extends JFrameBiblioteca {

	private JTextField textRutCliente;
	private JTextField txtCostoVenta;

	public VentaFrame() {
		getContentPane().setLayout(null);
		
		JButton btnVolverMenu = new JButton("MENU");
		btnVolverMenu.setBounds(34, 450, 150, 30);
		btnVolverMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(btnVolverMenu);
		
		JLabel lblLateralVender = new JLabel("Aqui va el icono de Vender");
		lblLateralVender.setBounds(10, 0, 200, 600);
		getContentPane().add(lblLateralVender);
		
		JLabel lblClienteVenta = new JLabel("Rut de Cliente: ");
		lblClienteVenta.setBounds(261, 149, 200, 30);
		lblClienteVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblClienteVenta);
		
		textRutCliente = new JTextField();
		textRutCliente.setBounds(261, 178, 200, 30);
		getContentPane().add(textRutCliente);
		textRutCliente.setColumns(10);
		
		JLabel lblLibrosVenta = new JLabel("Libros: ");
		lblLibrosVenta.setBounds(261, 216, 200, 30);
		lblLibrosVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblLibrosVenta);
		
		JComboBox cbxLibrosVenta = new JComboBox();
		cbxLibrosVenta.setBounds(261, 245, 200, 30);
		getContentPane().add(cbxLibrosVenta);
		
		JLabel lblCantidadVenta = new JLabel("Cantidad: ");
		lblCantidadVenta.setBounds(491, 217, 200, 30);
		lblCantidadVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblCantidadVenta);
		
		JComboBox cbxCantidadVenta = new JComboBox();
		cbxCantidadVenta.setBounds(491, 246, 200, 30);
		getContentPane().add(cbxCantidadVenta);
		
		JLabel lblCostoVenta = new JLabel("Costo: ");
		lblCostoVenta.setBounds(261, 284, 200, 30);
		lblCostoVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblCostoVenta);
		
		txtCostoVenta = new JTextField();
		txtCostoVenta.setBounds(261, 314, 200, 30);
		txtCostoVenta.setColumns(10);
		getContentPane().add(txtCostoVenta);
		
		JButton btnVender = new JButton("VENDER");
		btnVender.setBounds(518, 310, 150, 30);
		btnVender.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(btnVender);
		
		JLabel lblTituloVenta = new JLabel("Formulario de Venta");
		lblTituloVenta.setBounds(340, 40, 300, 30);
		lblTituloVenta.setFont(new Font("Tahoma", Font.BOLD, 26));
		getContentPane().add(lblTituloVenta);
	}
}
