package cl.inacap.bibliotecaApp.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistrarFrame extends JFrameBiblioteca {

	private JPanel contentPane;
	private JTextField txtRutRegistrar;
	private JTextField txtNombreIngresar;
	private JTextField txtApellidoPaRegistrar;
	private JTextField txtApellidoMaRegistrar;
	private JTextField txtNacimientoRegistrar;
	private JTextField txtDireccionRegistrar;
	private JTextField txtTelefonoRegistrar;
	private JTextField txtCorreoRegistrar;

	
	public RegistrarFrame() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeaderRegistrar = new JLabel("New label");
		lblHeaderRegistrar.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/fastheader.jpg")));
		lblHeaderRegistrar.setBounds(0, 0, 800, 80);
		contentPane.add(lblHeaderRegistrar);
		
		JLabel lblNombreRegistrar = new JLabel("Nombre: ");
		lblNombreRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreRegistrar.setBounds(64, 217, 109, 25);
		contentPane.add(lblNombreRegistrar);
		
		txtRutRegistrar = new JTextField();
		txtRutRegistrar.setBounds(64, 176, 250, 30);
		contentPane.add(txtRutRegistrar);
		txtRutRegistrar.setColumns(10);
		
		JLabel lblRutRegistrar = new JLabel("Rut: ");
		lblRutRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRutRegistrar.setBounds(64, 148, 67, 25);
		contentPane.add(lblRutRegistrar);
		
		txtNombreIngresar = new JTextField();
		txtNombreIngresar.setBounds(64, 242, 250, 30);
		contentPane.add(txtNombreIngresar);
		txtNombreIngresar.setColumns(10);
		
		JLabel lblApellidoPaRegistrar = new JLabel("Apellido Paterno: ");
		lblApellidoPaRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellidoPaRegistrar.setBounds(64, 284, 174, 25);
		contentPane.add(lblApellidoPaRegistrar);
		
		txtApellidoPaRegistrar = new JTextField();
		txtApellidoPaRegistrar.setBounds(64, 311, 250, 30);
		contentPane.add(txtApellidoPaRegistrar);
		txtApellidoPaRegistrar.setColumns(10);
		
		JLabel lblApellidoMaRegistrar = new JLabel("Apellido Materno: ");
		lblApellidoMaRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellidoMaRegistrar.setBounds(64, 352, 187, 25);
		contentPane.add(lblApellidoMaRegistrar);
		
		txtApellidoMaRegistrar = new JTextField();
		txtApellidoMaRegistrar.setBounds(64, 377, 250, 30);
		contentPane.add(txtApellidoMaRegistrar);
		txtApellidoMaRegistrar.setColumns(10);
		
		JLabel lblNacimientoRegistrar = new JLabel("Fecha de Nacimiento: ");
		lblNacimientoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNacimientoRegistrar.setBounds(64, 427, 244, 30);
		contentPane.add(lblNacimientoRegistrar);
		
		txtNacimientoRegistrar = new JTextField();
		txtNacimientoRegistrar.setBounds(64, 455, 250, 30);
		contentPane.add(txtNacimientoRegistrar);
		txtNacimientoRegistrar.setColumns(10);
		
		JLabel lblDireccionRegistrar = new JLabel("Direcci\u00F3n: ");
		lblDireccionRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDireccionRegistrar.setBounds(428, 145, 136, 30);
		contentPane.add(lblDireccionRegistrar);
		
		txtDireccionRegistrar = new JTextField();
		txtDireccionRegistrar.setBounds(428, 176, 250, 30);
		contentPane.add(txtDireccionRegistrar);
		txtDireccionRegistrar.setColumns(10);
		
		JLabel lblTelefonoRegistrar = new JLabel("Tel\u00E9fono: ");
		lblTelefonoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefonoRegistrar.setBounds(428, 214, 118, 30);
		contentPane.add(lblTelefonoRegistrar);
		
		txtTelefonoRegistrar = new JTextField();
		txtTelefonoRegistrar.setBounds(428, 242, 250, 30);
		contentPane.add(txtTelefonoRegistrar);
		txtTelefonoRegistrar.setColumns(10);
		
		JLabel lblCorreoRegistrar = new JLabel("Correo electr\u00F3nico:");
		lblCorreoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorreoRegistrar.setBounds(428, 281, 212, 30);
		contentPane.add(lblCorreoRegistrar);
		
		txtCorreoRegistrar = new JTextField();
		txtCorreoRegistrar.setBounds(428, 311, 250, 30);
		contentPane.add(txtCorreoRegistrar);
		txtCorreoRegistrar.setColumns(10);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrar.setBounds(447, 451, 157, 30);
		contentPane.add(btnRegistrar);
		
		JLabel lblRegistrarUsuario = new JLabel("Registrar Usuario");
		lblRegistrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistrarUsuario.setBounds(311, 89, 200, 41);
		contentPane.add(lblRegistrarUsuario);
	}

}
