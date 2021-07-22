package cl.inacap.bibliotecaApp.frames;

import javax.swing.JPanel;

import cl.inacap.bibliotecaModel.dto.Trabajador;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TrabajadorFrame extends JFrameBiblioteca {

	private JPanel contentPane;
	private JLabel lblNombreTrabajador;
	private JButton btnSalirTrabajador;
	private JButton btnComprar;
	private JButton btnVender;
	private JButton btnArrendar;

	public TrabajadorFrame(Trabajador trabajador) {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);		
		

		btnSalirTrabajador = new JButton("SALIR");
		btnSalirTrabajador.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalirTrabajador.setBounds(40, 450, 150, 30);
		getContentPane().add(btnSalirTrabajador);

		JLabel lblTituloTrabajador = new JLabel("¿Que desea hacer?");
		lblTituloTrabajador.setBackground(Color.BLACK);
		lblTituloTrabajador.setForeground(Color.DARK_GRAY);
		lblTituloTrabajador.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTituloTrabajador.setBounds(341, 30, 350, 30);
		getContentPane().add(lblTituloTrabajador);

		JLabel lblCompraIcono = new JLabel("");
		lblCompraIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/comprar.png")));
		lblCompraIcono.setBounds(309, 210, 65, 65);
		getContentPane().add(lblCompraIcono);

		JLabel lblVenderMenu = new JLabel("VENDER");
		lblVenderMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVenderMenu.setBounds(451, 288, 95, 30);
		getContentPane().add(lblVenderMenu);

		JLabel lblVentaIcono = new JLabel("");
		lblVentaIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/vender.png")));
		lblVentaIcono.setBounds(468, 210, 65, 65);
		getContentPane().add(lblVentaIcono);

		JLabel lblArrendarIcono = new JLabel("");
		lblArrendarIcono.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/arrendar.png")));
		lblArrendarIcono.setBounds(623, 210, 65, 65);
		getContentPane().add(lblArrendarIcono);

		JLabel lblComprarMenu = new JLabel("COMPRAR");
		lblComprarMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComprarMenu.setBounds(290, 288, 110, 30);
		getContentPane().add(lblComprarMenu);

		JLabel lblArrendarMenu = new JLabel("ARRENDAR");
		lblArrendarMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblArrendarMenu.setBounds(599, 288, 122, 30);
		getContentPane().add(lblArrendarMenu);

		JLabel lblBienvenidoTrabajador = new JLabel("Bienvenido");
		lblBienvenidoTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoTrabajador.setForeground(Color.WHITE);
		lblBienvenidoTrabajador.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenidoTrabajador.setBounds(0, 155, 230, 25);
		getContentPane().add(lblBienvenidoTrabajador);

		lblNombreTrabajador = new JLabel(trabajador.getNombre());
		lblNombreTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTrabajador.setForeground(Color.WHITE);
		lblNombreTrabajador.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreTrabajador.setBounds(0, 340, 230, 25);
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
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/userP.png")));
		lblAvatar.setBounds(0, 190, 230, 130);
		getContentPane().add(lblAvatar);

		JLabel lblLateralColor = new JLabel("");
		lblLateralColor.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/lateralColor.jpg")));
		lblLateralColor.setBounds(0, 0, 230, 600);
		getContentPane().add(lblLateralColor);
		
		btnComprar = new JButton("");
		btnComprar.setBounds(290, 211, 110, 106);
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);		
		btnComprar.setBorderPainted(false);
		getContentPane().add(btnComprar);
		
		btnVender = new JButton("");
		btnVender.setBounds(451, 211, 95, 106);
		btnVender.setOpaque(false);
		btnVender.setContentAreaFilled(false);
		btnVender.setBorderPainted(false);
		getContentPane().add(btnVender);
		
		btnArrendar = new JButton("");
		btnArrendar.setBounds(599, 211, 122, 106);
		btnArrendar.setOpaque(false);
		btnArrendar.setContentAreaFilled(false);
		btnArrendar.setBorderPainted(false);
		getContentPane().add(btnArrendar);
		
		
	}

	public JLabel getLblNombreTrabajador() {
		return lblNombreTrabajador;
	}

	public void setLblNombreTrabajador(JLabel lblNombreTrabajador) {
		this.lblNombreTrabajador = lblNombreTrabajador;
	}

	public void addSalirListener(ActionListener ing) {
		btnSalirTrabajador.addActionListener(ing);
	}
	public void addVenderListener(ActionListener ing) {
		btnVender.addActionListener(ing);
	}
	public void addComprarListener(ActionListener ing) {
		btnComprar.addActionListener(ing);
	}
	public void addArrendarListener(ActionListener ing) {
		btnArrendar.addActionListener(ing);
	}
}
