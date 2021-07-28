package cl.inacap.bibliotecaApp.frames;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.SwingConstants;

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
	private JButton btnRegistrar; 
	private JButton btnCorreos;
	private JButton btnTelefonos;
	private JButton btnDireccion;
	private JList ListaDireccion; 
	private JList ListaCorreos; 
	private JList ListaTelefonos; 

	
	public RegistrarFrame() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PlusIcon2 = new JLabel("");
		PlusIcon2.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/plus.png")));
		PlusIcon2.setHorizontalAlignment(SwingConstants.CENTER);
		PlusIcon2.setBounds(585, 278, 30, 30);
		contentPane.add(PlusIcon2);
		
		JLabel lblHeaderRegistrar = new JLabel("");
		lblHeaderRegistrar.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/fastheader.jpg")));
		lblHeaderRegistrar.setBounds(0, 0, 800, 80);
		contentPane.add(lblHeaderRegistrar);
		
		JLabel lblNombreRegistrar = new JLabel("Nombre: ");
		lblNombreRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreRegistrar.setBounds(64, 200, 200, 25);
		contentPane.add(lblNombreRegistrar);
		
		txtRutRegistrar = new JTextField();
		txtRutRegistrar.setBounds(64, 158, 200, 30);
		contentPane.add(txtRutRegistrar);
		txtRutRegistrar.setColumns(10);
		
		JLabel lblRutRegistrar = new JLabel("Rut: ");
		lblRutRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRutRegistrar.setBounds(64, 134, 200, 25);
		contentPane.add(lblRutRegistrar);
		
		txtNombreIngresar = new JTextField();
		txtNombreIngresar.setBounds(64, 226, 200, 30);
		contentPane.add(txtNombreIngresar);
		txtNombreIngresar.setColumns(10);
		
		JLabel lblApellidoPaRegistrar = new JLabel("Apellido Paterno: ");
		lblApellidoPaRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellidoPaRegistrar.setBounds(64, 275, 200, 25);
		contentPane.add(lblApellidoPaRegistrar);
		
		txtApellidoPaRegistrar = new JTextField();
		txtApellidoPaRegistrar.setBounds(64, 299, 200, 30);
		contentPane.add(txtApellidoPaRegistrar);
		txtApellidoPaRegistrar.setColumns(10);
		
		JLabel lblApellidoMaRegistrar = new JLabel("Apellido Materno: ");
		lblApellidoMaRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellidoMaRegistrar.setBounds(64, 340, 200, 25);
		contentPane.add(lblApellidoMaRegistrar);
		
		txtApellidoMaRegistrar = new JTextField();
		txtApellidoMaRegistrar.setBounds(64, 365, 200, 30);
		contentPane.add(txtApellidoMaRegistrar);
		txtApellidoMaRegistrar.setColumns(10);
		
		JLabel lblNacimientoRegistrar = new JLabel("Fecha de Nacimiento: ");
		lblNacimientoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNacimientoRegistrar.setBounds(64, 430, 200, 30);
		contentPane.add(lblNacimientoRegistrar);
		
		txtNacimientoRegistrar = new JTextField();
		txtNacimientoRegistrar.setBounds(64, 460, 200, 30);
		contentPane.add(txtNacimientoRegistrar);
		txtNacimientoRegistrar.setColumns(10);
		
		JLabel lblDireccionRegistrar = new JLabel("Direcci\u00F3n: ");
		lblDireccionRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDireccionRegistrar.setBounds(386, 130, 200, 30);
		contentPane.add(lblDireccionRegistrar);
		
		txtDireccionRegistrar = new JTextField();
		txtDireccionRegistrar.setBounds(386, 158, 200, 30);
		contentPane.add(txtDireccionRegistrar);
		txtDireccionRegistrar.setColumns(10);
		
		JLabel lblTelefonoRegistrar = new JLabel("Tel\u00E9fono: ");
		lblTelefonoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefonoRegistrar.setBounds(386, 250, 200, 30);
		contentPane.add(lblTelefonoRegistrar);
		
		txtTelefonoRegistrar = new JTextField();
		txtTelefonoRegistrar.setBounds(386, 278, 200, 30);
		contentPane.add(txtTelefonoRegistrar);
		txtTelefonoRegistrar.setColumns(10);
		
		JLabel lblCorreoRegistrar = new JLabel("Correo electr\u00F3nico:");
		lblCorreoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorreoRegistrar.setBounds(386, 361, 212, 30);
		contentPane.add(lblCorreoRegistrar);
		
		txtCorreoRegistrar = new JTextField();
		txtCorreoRegistrar.setBounds(386, 396, 200, 30);
		contentPane.add(txtCorreoRegistrar);
		txtCorreoRegistrar.setColumns(10);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrar.setBounds(417, 516, 157, 30);
		contentPane.add(btnRegistrar);
		
		JLabel lblRegistrarUsuario = new JLabel("Registrar Usuario");
		lblRegistrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistrarUsuario.setBounds(311, 89, 200, 41);
		contentPane.add(lblRegistrarUsuario);
				
		JLabel lblNacimientoRegistrar_1 = new JLabel("Fecha de Contrato: ");
		lblNacimientoRegistrar_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNacimientoRegistrar_1.setBounds(64, 490, 200, 30);
		contentPane.add(lblNacimientoRegistrar_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(64, 520, 200, 30);
		contentPane.add(textField);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBounds(186, 393, 99, 30);
		rdbtnCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(rdbtnCliente);
		
		JRadioButton rdbtnTrabajador= new JRadioButton("Trabajador");
		rdbtnTrabajador.setBounds(64, 393, 120, 30);
		rdbtnTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(rdbtnTrabajador);
		
		ButtonGroup tipoRegistro=new ButtonGroup();
		tipoRegistro.add(rdbtnTrabajador);
		tipoRegistro.add(rdbtnCliente);
		
		DefaultListModel direcionModel = new DefaultListModel();
		ListaDireccion = new JList(direcionModel);
		ListaDireccion.setBounds(386, 195, 200, 30);
		contentPane.add(ListaDireccion);
		
		DefaultListModel telefonoModel = new DefaultListModel();
		ListaTelefonos = new JList(telefonoModel);
		ListaTelefonos.setBounds(386, 317, 200, 30);
		contentPane.add(ListaTelefonos);
		
		DefaultListModel correoModel = new DefaultListModel();
		ListaCorreos = new JList(correoModel);
		ListaCorreos.setBounds(386, 432, 200, 30);
		contentPane.add(ListaCorreos);
		
		JLabel PlusIcon1 = new JLabel("");
		PlusIcon1.setHorizontalAlignment(SwingConstants.CENTER);
		PlusIcon1.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/plus.png")));
		PlusIcon1.setBounds(585, 158, 30, 30);
		contentPane.add(PlusIcon1);
		
		JLabel PlusIcon3 = new JLabel("");
		PlusIcon3.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/plus.png")));
		PlusIcon3.setHorizontalAlignment(SwingConstants.CENTER);
		PlusIcon3.setBounds(585, 396, 30, 30);
		contentPane.add(PlusIcon3);
		//Btn Add
		btnCorreos = new JButton("");
		btnCorreos.setBounds(585, 396, 30, 30);
		contentPane.add(btnCorreos);
		
		btnTelefonos = new JButton("");
		btnTelefonos.setBounds(585, 278, 30, 30);
		contentPane.add(btnTelefonos);
		
		btnDireccion = new JButton("");
		btnDireccion.setBounds(585, 158, 30, 30);
		contentPane.add(btnDireccion);
		
	}
	public void addConfirmaRegistrar(ActionListener ing) {
		btnRegistrar.addActionListener(ing);
	}
	
	public void addAgregarCorreos(ActionListener ing) {
		btnCorreos.addActionListener(ing);
	}
	
	public void addAgregarTelefonos(ActionListener ing) {
		btnTelefonos.addActionListener(ing);
	}
	
	public void addAgregarDireccion(ActionListener ing) {
		btnDireccion.addActionListener(ing);
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	public JTextField getTxtRutRegistrar() {
		return txtRutRegistrar;
	}
	public void setTxtRutRegistrar(JTextField txtRutRegistrar) {
		this.txtRutRegistrar = txtRutRegistrar;
	}
	public JTextField getTxtNombreIngresar() {
		return txtNombreIngresar;
	}
	public void setTxtNombreIngresar(JTextField txtNombreIngresar) {
		this.txtNombreIngresar = txtNombreIngresar;
	}
	public JTextField getTxtApellidoPaRegistrar() {
		return txtApellidoPaRegistrar;
	}
	public void setTxtApellidoPaRegistrar(JTextField txtApellidoPaRegistrar) {
		this.txtApellidoPaRegistrar = txtApellidoPaRegistrar;
	}
	public JTextField getTxtApellidoMaRegistrar() {
		return txtApellidoMaRegistrar;
	}
	public void setTxtApellidoMaRegistrar(JTextField txtApellidoMaRegistrar) {
		this.txtApellidoMaRegistrar = txtApellidoMaRegistrar;
	}
	public JTextField getTxtNacimientoRegistrar() {
		return txtNacimientoRegistrar;
	}
	public void setTxtNacimientoRegistrar(JTextField txtNacimientoRegistrar) {
		this.txtNacimientoRegistrar = txtNacimientoRegistrar;
	}
	public JTextField getTxtDireccionRegistrar() {
		return txtDireccionRegistrar;
	}
	public void setTxtDireccionRegistrar(JTextField txtDireccionRegistrar) {
		this.txtDireccionRegistrar = txtDireccionRegistrar;
	}
	public JTextField getTxtTelefonoRegistrar() {
		return txtTelefonoRegistrar;
	}
	public void setTxtTelefonoRegistrar(JTextField txtTelefonoRegistrar) {
		this.txtTelefonoRegistrar = txtTelefonoRegistrar;
	}
	public JTextField getTxtCorreoRegistrar() {
		return txtCorreoRegistrar;
	}
	public void setTxtCorreoRegistrar(JTextField txtCorreoRegistrar) {
		this.txtCorreoRegistrar = txtCorreoRegistrar;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}
	public JButton getBtnCorreos() {
		return btnCorreos;
	}
	public void setBtnCorreos(JButton btnCorreos) {
		this.btnCorreos = btnCorreos;
	}
	public JButton getBtnTelefonos() {
		return btnTelefonos;
	}
	public void setBtnTelefonos(JButton btnTelefonos) {
		this.btnTelefonos = btnTelefonos;
	}
	public JButton getBtnDireccion() {
		return btnDireccion;
	}
	public void setBtnDireccion(JButton btnDireccion) {
		this.btnDireccion = btnDireccion;
	}
	public JList getListaDireccion() {
		return ListaDireccion;
	}
	public void setListaDireccion(JList listaDireccion) {
		ListaDireccion = listaDireccion;
	}
	public JList getListaCorreos() {
		return ListaCorreos;
	}
	public void setListaCorreos(JList listaCorreos) {
		ListaCorreos = listaCorreos;
	}
	public JList getListaTelefonos() {
		return ListaTelefonos;
	}
	public void setListaTelefonos(JList listaTelefonos) {
		ListaTelefonos = listaTelefonos;
	}
	
	
	
	
}
