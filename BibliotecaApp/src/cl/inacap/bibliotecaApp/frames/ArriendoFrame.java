package cl.inacap.bibliotecaApp.frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class ArriendoFrame extends JFrameBiblioteca {
	private JTextField txtClienteArriendo;
	private JTextField txtEntregaArriendo;
	private JTextField txtDevolucionArriendo;
	private JTextField txtCostoArriendo;

	public ArriendoFrame() {
		getContentPane().setLayout(null);
		JButton btnVolverMenu = new JButton("MENU");
		btnVolverMenu.setBounds(40, 450, 150, 30);
		btnVolverMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(btnVolverMenu);
		
		JLabel lblArrendarTexto = new JLabel("ARRENDAR");
		lblArrendarTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrendarTexto.setForeground(Color.WHITE);
		lblArrendarTexto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblArrendarTexto.setBounds(0, 353, 230, 25);
		getContentPane().add(lblArrendarTexto);
		
		JLabel lblArrendarTexto2 = new JLabel("LIBROS");
		lblArrendarTexto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrendarTexto2.setForeground(Color.WHITE);
		lblArrendarTexto2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblArrendarTexto2.setBounds(0, 380, 230, 25);
		getContentPane().add(lblArrendarTexto2);
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setIcon(new ImageIcon(CompraFrame.class.getResource("/img/Arrendarg.png")));
		lblAvatar.setBounds(0, 190, 230, 130);
		getContentPane().add(lblAvatar);
		
		JLabel lblLateralColor = new JLabel("");
		lblLateralColor.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/lateralColor.jpg")));
		lblLateralColor.setBounds(0, 0, 230, 600);
		getContentPane().add(lblLateralColor);
		
		JLabel lblClienteArriendo = new JLabel("Rut de Cliente: ");
		lblClienteArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClienteArriendo.setBounds(261, 116, 200, 30);
		getContentPane().add(lblClienteArriendo);
		
		txtClienteArriendo = new JTextField();
		txtClienteArriendo.setBounds(261, 145, 200, 30);
		getContentPane().add(txtClienteArriendo);
		txtClienteArriendo.setColumns(10);
		
		JLabel lblLibrosArriendo = new JLabel("Libros: ");
		lblLibrosArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLibrosArriendo.setBounds(261, 190, 200, 30);
		getContentPane().add(lblLibrosArriendo);
		
		JComboBox cbxLibrosArriendo = new JComboBox();
		cbxLibrosArriendo.setBounds(261, 220, 200, 30);
		getContentPane().add(cbxLibrosArriendo);
		
		JLabel lblEntregaArriendo = new JLabel("Fecha de Entrega: ");
		lblEntregaArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEntregaArriendo.setBounds(261, 272, 200, 30);
		getContentPane().add(lblEntregaArriendo);
		
		txtEntregaArriendo = new JTextField();
		txtEntregaArriendo.setColumns(10);
		txtEntregaArriendo.setBounds(261, 302, 200, 30);
		getContentPane().add(txtEntregaArriendo);
		
		JLabel lblDevolucionArriendo = new JLabel("Fecha de Devoluci\u00F3n: ");
		lblDevolucionArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDevolucionArriendo.setBounds(261, 348, 200, 30);
		getContentPane().add(lblDevolucionArriendo);
		
		txtDevolucionArriendo = new JTextField();
		txtDevolucionArriendo.setColumns(10);
		txtDevolucionArriendo.setBounds(261, 380, 200, 30);
		getContentPane().add(txtDevolucionArriendo);
		
		JRadioButton rdbtnMulta = new JRadioButton("Aplicar multa");
		rdbtnMulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMulta.setBounds(496, 379, 200, 30);
		getContentPane().add(rdbtnMulta);
		
		JLabel lblCostoArriendo = new JLabel("Costo total: ");
		lblCostoArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCostoArriendo.setBounds(261, 430, 200, 30);
		getContentPane().add(lblCostoArriendo);
		
		txtCostoArriendo = new JTextField();
		txtCostoArriendo.setColumns(10);
		txtCostoArriendo.setBounds(261, 460, 200, 30);
		getContentPane().add(txtCostoArriendo);
		
		JButton btnArrendar = new JButton("ARRENDAR");
		btnArrendar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnArrendar.setBounds(520, 460, 150, 30);
		getContentPane().add(btnArrendar);
		
		JLabel lblTiruloArriendo = new JLabel("Formulario de Arriendo");
		lblTiruloArriendo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTiruloArriendo.setBounds(340, 40, 330, 30);
		getContentPane().add(lblTiruloArriendo);
}
}
