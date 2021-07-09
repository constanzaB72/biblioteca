package cl.inacap.bibliotecaApp.frames;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class ArriendoFrame extends JFrameBiblioteca {
	private JTextField txtClienteArriendo;
	private JTextField txtEntregaArriendo;
	private JTextField txtDevolucionArriendo;
	private JTextField txtCostoArriendo;

	public ArriendoFrame() {
		getContentPane().setLayout(null);
		JButton btnVolverMenu = new JButton("MENU");
		btnVolverMenu.setBounds(34, 450, 150, 30);
		btnVolverMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(btnVolverMenu);
		
		JLabel lblLateralArrendar = new JLabel("Aqui va el icono de Arrendar");
		lblLateralArrendar.setBounds(10, 0, 200, 600);
		getContentPane().add(lblLateralArrendar);
		
		JLabel lblClienteArriendo = new JLabel("Rut de Cliente: ");
		lblClienteArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClienteArriendo.setBounds(261, 139, 200, 30);
		getContentPane().add(lblClienteArriendo);
		
		txtClienteArriendo = new JTextField();
		txtClienteArriendo.setBounds(261, 168, 200, 30);
		getContentPane().add(txtClienteArriendo);
		txtClienteArriendo.setColumns(10);
		
		JLabel lblLibrosArriendo = new JLabel("Libros: ");
		lblLibrosArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLibrosArriendo.setBounds(261, 209, 200, 30);
		getContentPane().add(lblLibrosArriendo);
		
		JComboBox cbxLibrosArriendo = new JComboBox();
		cbxLibrosArriendo.setBounds(261, 238, 200, 30);
		getContentPane().add(cbxLibrosArriendo);
		
		JLabel lblEntregaArriendo = new JLabel("Fecha de Entrega: ");
		lblEntregaArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEntregaArriendo.setBounds(261, 281, 200, 30);
		getContentPane().add(lblEntregaArriendo);
		
		txtEntregaArriendo = new JTextField();
		txtEntregaArriendo.setColumns(10);
		txtEntregaArriendo.setBounds(261, 310, 200, 30);
		getContentPane().add(txtEntregaArriendo);
		
		JLabel lblDevolucionArriendo = new JLabel("Fecha de Devoluci\u00F3n: ");
		lblDevolucionArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDevolucionArriendo.setBounds(261, 348, 200, 30);
		getContentPane().add(lblDevolucionArriendo);
		
		txtDevolucionArriendo = new JTextField();
		txtDevolucionArriendo.setColumns(10);
		txtDevolucionArriendo.setBounds(261, 378, 200, 30);
		getContentPane().add(txtDevolucionArriendo);
		
		JRadioButton rdbtnMulta = new JRadioButton("Aplicar multa");
		rdbtnMulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMulta.setBounds(520, 376, 200, 30);
		getContentPane().add(rdbtnMulta);
		
		JLabel lblCostoArriendo = new JLabel("Costo total: ");
		lblCostoArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCostoArriendo.setBounds(261, 419, 200, 30);
		getContentPane().add(lblCostoArriendo);
		
		txtCostoArriendo = new JTextField();
		txtCostoArriendo.setColumns(10);
		txtCostoArriendo.setBounds(261, 450, 200, 30);
		getContentPane().add(txtCostoArriendo);
		
		JButton btnArrendar = new JButton("ARRENDAR");
		btnArrendar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnArrendar.setBounds(520, 450, 150, 30);
		getContentPane().add(btnArrendar);
		
		JLabel lblTiruloArriendo = new JLabel("Formulario de Arriendo");
		lblTiruloArriendo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTiruloArriendo.setBounds(340, 40, 330, 30);
		getContentPane().add(lblTiruloArriendo);
}
}
