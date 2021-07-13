package cl.inacap.bibliotecaApp.frames;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;

public class TrabajadorFrame extends JFrameBiblioteca {

	private JPanel contentPane;

	public TrabajadorFrame() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JButton btnSalirMenu = new JButton("SALIR");
		btnSalirMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalirMenu.setBounds(34, 450, 150, 30);
		getContentPane().add(btnSalirMenu);
		
		JLabel lblTituloMenu = new JLabel("\u00BFQu\u00E9 desea hacer?");
		lblTituloMenu.setBackground(Color.BLACK);
		lblTituloMenu.setForeground(Color.DARK_GRAY);
		lblTituloMenu.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTituloMenu.setBounds(236, 43, 341, 30);
		getContentPane().add(lblTituloMenu);
		
		JLabel lblCompraIcono = new JLabel("");
		lblCompraIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/comprar.png")));
		lblCompraIcono.setBounds(309, 211, 65, 65);
		getContentPane().add(lblCompraIcono);
		
		JLabel lblVenderMenu = new JLabel("VENDER");
		lblVenderMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVenderMenu.setBounds(451, 287, 95, 30);
		getContentPane().add(lblVenderMenu);
		
		JLabel lblVentaIcono = new JLabel("");
		lblVentaIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/vender.png")));
		lblVentaIcono.setBounds(468, 211, 65, 65);
		getContentPane().add(lblVentaIcono);
		
		JLabel lblArrendarIcono = new JLabel("");
		lblArrendarIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/arrendar.png")));
		lblArrendarIcono.setBounds(623, 211, 65, 65);
		getContentPane().add(lblArrendarIcono);
		
		JLabel lblComprarMenu = new JLabel("COMPRAR");
		lblComprarMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComprarMenu.setBounds(290, 287, 110, 30);
		getContentPane().add(lblComprarMenu);
		
		JLabel lblArrendarMenu = new JLabel("ARRENDAR");
		lblArrendarMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblArrendarMenu.setBounds(599, 287, 122, 30);
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/fastLateral.jpg")));
		lblNewLabel.setBounds(0, 0, 220, 600);
		getContentPane().add(lblNewLabel);
		
		JLabel lblArrendarIcono_1 = new JLabel("");
		lblArrendarIcono_1.setBounds(589, 218, 80, 80);
		getContentPane().add(lblArrendarIcono_1);
		
		JLabel lblEjemplaresIcono = new JLabel("");
		lblEjemplaresIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/libros.png")));
		lblEjemplaresIcono.setBounds(542, 463, 35, 35);
		getContentPane().add(lblEjemplaresIcono);
		
		JLabel lblMultasIcono = new JLabel("");
		lblMultasIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/libros.png")));
		lblMultasIcono.setBounds(542, 509, 35, 35);
		getContentPane().add(lblMultasIcono);
		
		JLabel lblTextoEjemplares = new JLabel("VER EJEMPLARES");
		lblTextoEjemplares.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTextoEjemplares.setBounds(589, 468, 150, 30);
		getContentPane().add(lblTextoEjemplares);
		
		JLabel lbl = new JLabel("APLICAR MULTAS");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl.setBounds(589, 514, 150, 30);
		getContentPane().add(lbl);
	}
}
