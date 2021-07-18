package cl.inacap.bibliotecaApp.frames;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class CompraFrame extends JFrameBiblioteca {

	private JTextField txtCosto;
	private JComboBox cbxLibros; 
	private JComboBox cbxDistribuidor;
	private JButton btnVolverMenu;

	public CompraFrame() {
		getContentPane().setLayout(null);
		
		btnVolverMenu = new JButton("MENU");
		btnVolverMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVolverMenu.setBounds(40, 450, 150, 30);
		getContentPane().add(btnVolverMenu);
		
		JLabel lblComprarTexto = new JLabel("COMPRAR");
		lblComprarTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprarTexto.setBackground(Color.WHITE);
		lblComprarTexto.setForeground(Color.WHITE);
		lblComprarTexto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComprarTexto.setBounds(0, 342, 230, 25);
		getContentPane().add(lblComprarTexto);
		
		JLabel lblComprarTexto2 = new JLabel("LIBROS");
		lblComprarTexto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprarTexto2.setForeground(Color.WHITE);
		lblComprarTexto2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComprarTexto2.setBounds(0, 378, 230, 25);
		getContentPane().add(lblComprarTexto2);
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setIcon(new ImageIcon(CompraFrame.class.getResource("/img/Comprarg.png")));
		lblAvatar.setBounds(0, 190, 230, 130);
		getContentPane().add(lblAvatar);
		
		JLabel lblLateralColor = new JLabel("");
		lblLateralColor.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/lateralColor.jpg")));
		lblLateralColor.setBounds(0, 0, 230, 600);
		getContentPane().add(lblLateralColor);
		
		cbxLibros = new JComboBox();
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
		
		cbxDistribuidor = new JComboBox();
		cbxDistribuidor.setBounds(261, 165, 200, 30);
		getContentPane().add(cbxDistribuidor);
		
		JLabel lblCantidadCompra = new JLabel("Cantidad: ");
		lblCantidadCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCantidadCompra.setBounds(491, 214, 200, 30);
		getContentPane().add(lblCantidadCompra);
		
		JComboBox cbxCantidad = new JComboBox();
		cbxCantidad.setBounds(492, 244, 200, 30);
		getContentPane().add(cbxCantidad);
		
		JLabel lblCostoCompra = new JLabel("Costo: ");
		lblCostoCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCostoCompra.setBounds(261, 306, 200, 30);
		getContentPane().add(lblCostoCompra);
		
		txtCosto = new JTextField();
		txtCosto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCosto.setBounds(261, 336, 200, 30);
		getContentPane().add(txtCosto);
		txtCosto.setColumns(10);
		
		JLabel lblTituloCompra = new JLabel("Formulario de Compra");
		lblTituloCompra.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTituloCompra.setBounds(340, 40, 300, 30);
		getContentPane().add(lblTituloCompra);
		
		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnComprar.setBounds(578, 493, 150, 30);
		getContentPane().add(btnComprar);
		
	}

	public JComboBox getCbxLibros() {
		return cbxLibros;
	}

	public void setCbxLibros(JComboBox cbxLibros) {
		this.cbxLibros = cbxLibros;
	}

	public JComboBox getCbxDistribuidor() {
		return cbxDistribuidor;
	}

	public void setCbxDistribuidor(JComboBox cbxDistribuidor) {
		this.cbxDistribuidor = cbxDistribuidor;
	}
	public void addMenuListener(ActionListener ing) {
		btnVolverMenu.addActionListener(ing);
	}
	
	
}
