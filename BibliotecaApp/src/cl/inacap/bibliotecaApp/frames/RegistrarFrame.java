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
import javax.swing.JCheckBox;

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
	private JTextField textField;

	
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
		lblNombreRegistrar.setBounds(64, 199, 109, 25);
		contentPane.add(lblNombreRegistrar);
		
		txtRutRegistrar = new JTextField();
		txtRutRegistrar.setBounds(64, 158, 250, 30);
		contentPane.add(txtRutRegistrar);
		txtRutRegistrar.setColumns(10);
		
		JLabel lblRutRegistrar = new JLabel("Rut: ");
		lblRutRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRutRegistrar.setBounds(64, 134, 67, 25);
		contentPane.add(lblRutRegistrar);
		
		txtNombreIngresar = new JTextField();
		txtNombreIngresar.setBounds(64, 229, 250, 30);
		contentPane.add(txtNombreIngresar);
		txtNombreIngresar.setColumns(10);
		
		JLabel lblApellidoPaRegistrar = new JLabel("Apellido Paterno: ");
		lblApellidoPaRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellidoPaRegistrar.setBounds(64, 275, 174, 25);
		contentPane.add(lblApellidoPaRegistrar);
		
		txtApellidoPaRegistrar = new JTextField();
		txtApellidoPaRegistrar.setBounds(64, 299, 250, 30);
		contentPane.add(txtApellidoPaRegistrar);
		txtApellidoPaRegistrar.setColumns(10);
		
		JLabel lblApellidoMaRegistrar = new JLabel("Apellido Materno: ");
		lblApellidoMaRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellidoMaRegistrar.setBounds(64, 340, 187, 25);
		contentPane.add(lblApellidoMaRegistrar);
		
		txtApellidoMaRegistrar = new JTextField();
		txtApellidoMaRegistrar.setBounds(64, 365, 250, 30);
		contentPane.add(txtApellidoMaRegistrar);
		txtApellidoMaRegistrar.setColumns(10);
		
		JLabel lblNacimientoRegistrar = new JLabel("Fecha de Nacimiento: ");
		lblNacimientoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNacimientoRegistrar.setBounds(410, 131, 213, 30);
		contentPane.add(lblNacimientoRegistrar);
		
		txtNacimientoRegistrar = new JTextField();
		txtNacimientoRegistrar.setBounds(410, 158, 194, 30);
		contentPane.add(txtNacimientoRegistrar);
		txtNacimientoRegistrar.setColumns(10);
		
		JLabel lblDireccionRegistrar = new JLabel("Direcci\u00F3n: ");
		lblDireccionRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDireccionRegistrar.setBounds(410, 272, 136, 30);
		contentPane.add(lblDireccionRegistrar);
		
		txtDireccionRegistrar = new JTextField();
		txtDireccionRegistrar.setBounds(410, 299, 250, 30);
		contentPane.add(txtDireccionRegistrar);
		txtDireccionRegistrar.setColumns(10);
		
		JLabel lblTelefonoRegistrar = new JLabel("Tel\u00E9fono: ");
		lblTelefonoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefonoRegistrar.setBounds(410, 337, 118, 30);
		contentPane.add(lblTelefonoRegistrar);
		
		txtTelefonoRegistrar = new JTextField();
		txtTelefonoRegistrar.setBounds(410, 365, 250, 30);
		contentPane.add(txtTelefonoRegistrar);
		txtTelefonoRegistrar.setColumns(10);
		
		JLabel lblCorreoRegistrar = new JLabel("Correo electr\u00F3nico:");
		lblCorreoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorreoRegistrar.setBounds(410, 406, 212, 30);
		contentPane.add(lblCorreoRegistrar);
		
		txtCorreoRegistrar = new JTextField();
		txtCorreoRegistrar.setBounds(410, 434, 250, 30);
		contentPane.add(txtCorreoRegistrar);
		txtCorreoRegistrar.setColumns(10);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrar.setBounds(513, 507, 157, 30);
		contentPane.add(btnRegistrar);
		
		JLabel lblRegistrarUsuario = new JLabel("Registrar Usuario");
		lblRegistrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistrarUsuario.setBounds(311, 89, 200, 41);
		contentPane.add(lblRegistrarUsuario);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Cliente");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxNewCheckBox.setBounds(610, 155, 99, 30);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxTrabajador = new JCheckBox("Trabajador");
		chckbxTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxTrabajador.setBounds(610, 226, 136, 30);
		contentPane.add(chckbxTrabajador);
		
		JLabel lblNacimientoRegistrar_1 = new JLabel("Fecha de Contrato: ");
		lblNacimientoRegistrar_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNacimientoRegistrar_1.setBounds(410, 196, 244, 30);
		contentPane.add(lblNacimientoRegistrar_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(410, 229, 194, 30);
		contentPane.add(textField);
	}
}
