package cl.inacap.bibliotecaApp.frames;


import javax.swing.JPanel;

import cl.inacap.bibliotecaModel.dto.Trabajador;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class TrabajadorFrame extends JFrameBiblioteca {

	private JPanel contentPane;
	private JLabel lblNombreTrabajador;

	public TrabajadorFrame(Trabajador trabajador) {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JButton btnSalirTrabajador = new JButton("SALIR");
		btnSalirTrabajador.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalirTrabajador.setBounds(43, 396, 150, 30);
		getContentPane().add(btnSalirTrabajador);
		
		JLabel lblTituloTrabajador = new JLabel("¿Que desea hacer?");
		lblTituloTrabajador.setBackground(Color.BLACK);
		lblTituloTrabajador.setForeground(Color.DARK_GRAY);
		lblTituloTrabajador.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTituloTrabajador.setBounds(341, 30, 350, 30);
		getContentPane().add(lblTituloTrabajador);
		
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
		
		JLabel lblBienvenidoTrabajador = new JLabel("Bienvenido");
		lblBienvenidoTrabajador.setForeground(Color.WHITE);
		lblBienvenidoTrabajador.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenidoTrabajador.setBounds(54, 155, 117, 25);
		getContentPane().add(lblBienvenidoTrabajador);
		
		lblNombreTrabajador = new JLabel(trabajador.getNombre());
		lblNombreTrabajador.setForeground(Color.WHITE);
		lblNombreTrabajador.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreTrabajador.setBounds(83, 360, 69, 25);
		getContentPane().add(lblNombreTrabajador);
		
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
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/userP.png")));
		lblAvatar.setBounds(54, 212, 130, 130);
		getContentPane().add(lblAvatar);
		
		JLabel lblLateralColor = new JLabel("");
		lblLateralColor.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/lateralColor.jpg")));
		lblLateralColor.setBounds(0, 0, 230, 600);
		getContentPane().add(lblLateralColor);
	}

	public JLabel getLblNombreTrabajador() {
		return lblNombreTrabajador;
	}

	public void setLblNombreTrabajador(JLabel lblNombreTrabajador) {
		this.lblNombreTrabajador = lblNombreTrabajador;
	}
	
}
