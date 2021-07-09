package cl.inacap.bibliotecaApp.frames;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSeparator;

public class CompraFrame extends JFrameBiblioteca {

	private JTextField txtCosto;

	public CompraFrame() {
		getContentPane().setLayout(null);
		
		JButton btnVolverMenu = new JButton("MEN\u00DA");
		btnVolverMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVolverMenu.setBounds(34, 450, 150, 30);
		getContentPane().add(btnVolverMenu);
		
		JLabel lblLateralComprar = new JLabel("Aqui va el icono de Comprar");
		lblLateralComprar.setBounds(10, 0, 200, 600);
		getContentPane().add(lblLateralComprar);
		
		JComboBox cbxLibros = new JComboBox();
		cbxLibros.setBounds(261, 244, 200, 30);
		getContentPane().add(cbxLibros);
		
		JLabel lblDistribuidorCompra = new JLabel("Distribuidor: ");
		lblDistribuidorCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDistribuidorCompra.setBounds(261, 136, 200, 30);
		getContentPane().add(lblDistribuidorCompra);
		
		JLabel lblLibrosCompra = new JLabel("Libros: ");
		lblLibrosCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLibrosCompra.setBounds(261, 214, 200, 30);
		getContentPane().add(lblLibrosCompra);
		
		JComboBox cbxDistribuidor = new JComboBox();
		cbxDistribuidor.setBounds(261, 165, 200, 30);
		getContentPane().add(cbxDistribuidor);
		
		JLabel lblCantidadCompra = new JLabel("Cantidad: ");
		lblCantidadCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCantidadCompra.setBounds(491, 214, 200, 30);
		getContentPane().add(lblCantidadCompra);
		
		JComboBox cbxCantidad = new JComboBox();
		cbxCantidad.setBounds(491, 244, 200, 30);
		getContentPane().add(cbxCantidad);
		
		JLabel lblCostoCompra = new JLabel("Costo: ");
		lblCostoCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCostoCompra.setBounds(261, 296, 200, 30);
		getContentPane().add(lblCostoCompra);
		
		txtCosto = new JTextField();
		txtCosto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCosto.setBounds(261, 326, 200, 30);
		getContentPane().add(txtCosto);
		txtCosto.setColumns(10);
		
		JLabel lblTituloCompra = new JLabel("Formulario de Compra");
		lblTituloCompra.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTituloCompra.setBounds(340, 40, 300, 30);
		getContentPane().add(lblTituloCompra);
		
		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnComprar.setBounds(514, 325, 150, 30);
		getContentPane().add(btnComprar);
		
	}
}
