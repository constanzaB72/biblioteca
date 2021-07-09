package cl.inacap.bibliotecaApp.frames;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;

public class MenuFrame extends JFrameBiblioteca {

	private JPanel contentPane;

	public MenuFrame() {
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JButton btnSalirMenu = new JButton("SALIR");
		btnSalirMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalirMenu.setBounds(34, 450, 150, 30);
		getContentPane().add(btnSalirMenu);
		
		JLabel lblTituloMenu = new JLabel("\u00BFQu\u00E9 desea hacer?");
		lblTituloMenu.setBackground(Color.BLACK);
		lblTituloMenu.setForeground(Color.WHITE);
		lblTituloMenu.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTituloMenu.setBounds(236, 43, 341, 30);
		getContentPane().add(lblTituloMenu);
		
		JLabel lblCompraIcono = new JLabel("");
		lblCompraIcono.setIcon(new ImageIcon(MenuFrame.class.getResource("/img/userP.png")));
		lblCompraIcono.setBounds(309, 205, 80, 80);
		getContentPane().add(lblCompraIcono);
		
		JLabel lblVenderMenu = new JLabel("VENDER");
		lblVenderMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVenderMenu.setBounds(450, 287, 150, 30);
		getContentPane().add(lblVenderMenu);
		
		JLabel lblVentaIcono = new JLabel("");
		lblVentaIcono.setIcon(new ImageIcon(MenuFrame.class.getResource("/img/userP.png")));
		lblVentaIcono.setBounds(440, 205, 80, 80);
		getContentPane().add(lblVentaIcono);
		
		JLabel lblArrendarIcono = new JLabel("");
		lblArrendarIcono.setIcon(new ImageIcon(MenuFrame.class.getResource("/img/userP.png")));
		lblArrendarIcono.setBounds(589, 205, 80, 80);
		getContentPane().add(lblArrendarIcono);
		
		JLabel lblComprarMenu = new JLabel("COMPRAR");
		lblComprarMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComprarMenu.setBounds(298, 287, 150, 30);
		getContentPane().add(lblComprarMenu);
		
		JLabel lblArrendarMenu = new JLabel("ARRENDAR");
		lblArrendarMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblArrendarMenu.setBounds(574, 287, 150, 30);
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
		lblNewLabel.setIcon(new ImageIcon(MenuFrame.class.getResource("/img/fastLateral.jpg")));
		lblNewLabel.setBounds(0, 0, 220, 600);
		getContentPane().add(lblNewLabel);
	}
}
