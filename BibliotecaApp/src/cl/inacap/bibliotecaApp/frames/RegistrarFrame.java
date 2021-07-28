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
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class RegistrarFrame extends JFrameBiblioteca {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JPanel contentPane;
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
	private JRadioButton rdbtnCliente; 
	private JRadioButton rdbtnTrabajador;

	
	public RegistrarFrame() {
		//getContentPane().setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		
		JLabel PlusIcon2 = new JLabel("");
		PlusIcon2.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/plus.png")));
		PlusIcon2.setHorizontalAlignment(SwingConstants.CENTER);
		PlusIcon2.setBounds(585, 278, 30, 30);
		getContentPane().add(PlusIcon2);
		
		JLabel lblHeaderRegistrar = new JLabel("");
		lblHeaderRegistrar.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/fastheader.jpg")));
		lblHeaderRegistrar.setBounds(0, 0, 800, 80);
		getContentPane().add(lblHeaderRegistrar);
		
		JLabel lblNombreRegistrar = new JLabel("Nombre: ");
		lblNombreRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreRegistrar.setBounds(64, 200, 200, 25);
		getContentPane().add(lblNombreRegistrar);
		
		txtRutRegistrar = new JTextField();
		txtRutRegistrar.setBounds(64, 158, 200, 30);
		getContentPane().add(txtRutRegistrar);
		txtRutRegistrar.setColumns(10);
		
		JLabel lblRutRegistrar = new JLabel("Rut: ");
		lblRutRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRutRegistrar.setBounds(64, 134, 200, 25);
		getContentPane().add(lblRutRegistrar);
		
		txtNombreIngresar = new JTextField();
		txtNombreIngresar.setBounds(64, 226, 200, 30);
		getContentPane().add(txtNombreIngresar);
		txtNombreIngresar.setColumns(10);
		
		JLabel lblApellidoPaRegistrar = new JLabel("Apellido Paterno: ");
		lblApellidoPaRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellidoPaRegistrar.setBounds(64, 275, 200, 25);
		getContentPane().add(lblApellidoPaRegistrar);
		
		txtApellidoPaRegistrar = new JTextField();
		txtApellidoPaRegistrar.setBounds(64, 299, 200, 30);
		getContentPane().add(txtApellidoPaRegistrar);
		txtApellidoPaRegistrar.setColumns(10);
		
		JLabel lblApellidoMaRegistrar = new JLabel("Apellido Materno: ");
		lblApellidoMaRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellidoMaRegistrar.setBounds(64, 340, 200, 25);
		getContentPane().add(lblApellidoMaRegistrar);
		
		txtApellidoMaRegistrar = new JTextField();
		txtApellidoMaRegistrar.setBounds(64, 365, 200, 30);
		getContentPane().add(txtApellidoMaRegistrar);
		txtApellidoMaRegistrar.setColumns(10);
		
		JLabel lblNacimientoRegistrar = new JLabel("Fecha de Nacimiento: ");
		lblNacimientoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNacimientoRegistrar.setBounds(64, 430, 200, 30);
		getContentPane().add(lblNacimientoRegistrar);
		
		txtNacimientoRegistrar = new JTextField();
		txtNacimientoRegistrar.setBounds(64, 460, 200, 30);
		getContentPane().add(txtNacimientoRegistrar);
		txtNacimientoRegistrar.setColumns(10);
		
		JLabel lblDireccionRegistrar = new JLabel("Direcci\u00F3n: ");
		lblDireccionRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDireccionRegistrar.setBounds(386, 130, 200, 30);
		getContentPane().add(lblDireccionRegistrar);
		
		txtDireccionRegistrar = new JTextField();
		txtDireccionRegistrar.setBounds(386, 158, 200, 30);
		getContentPane().add(txtDireccionRegistrar);
		txtDireccionRegistrar.setColumns(10);
		
		JLabel lblTelefonoRegistrar = new JLabel("Tel\u00E9fono: ");
		lblTelefonoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefonoRegistrar.setBounds(386, 250, 200, 30);
		getContentPane().add(lblTelefonoRegistrar);
		
		txtTelefonoRegistrar = new JTextField();
		txtTelefonoRegistrar.setBounds(386, 278, 200, 30);
		getContentPane().add(txtTelefonoRegistrar);
		txtTelefonoRegistrar.setColumns(10);
		
		JLabel lblCorreoRegistrar = new JLabel("Correo electr\u00F3nico:");
		lblCorreoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorreoRegistrar.setBounds(386, 361, 212, 30);
		getContentPane().add(lblCorreoRegistrar);
		
		txtCorreoRegistrar = new JTextField();
		txtCorreoRegistrar.setBounds(386, 396, 200, 30);
		getContentPane().add(txtCorreoRegistrar);
		txtCorreoRegistrar.setColumns(10);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrar.setBounds(417, 516, 157, 30);
		getContentPane().add(btnRegistrar);
		
		JLabel lblRegistrarUsuario = new JLabel("Registrar Usuario");
		lblRegistrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistrarUsuario.setBounds(311, 89, 200, 41);
		getContentPane().add(lblRegistrarUsuario);
				
		JLabel lblNacimientoRegistrar_1 = new JLabel("Fecha de Contrato: ");
		lblNacimientoRegistrar_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNacimientoRegistrar_1.setBounds(64, 490, 200, 30);
		getContentPane().add(lblNacimientoRegistrar_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(64, 520, 200, 30);
		getContentPane().add(textField);
		
		rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBounds(186, 393, 99, 30);
		rdbtnCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(rdbtnCliente);
		
		rdbtnTrabajador= new JRadioButton("Trabajador");
		rdbtnTrabajador.setBounds(64, 393, 120, 30);
		rdbtnTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(rdbtnTrabajador);
		
		ButtonGroup tipoRegistro=new ButtonGroup();
		tipoRegistro.add(rdbtnTrabajador);
		tipoRegistro.add(rdbtnCliente);
		
		DefaultListModel direcionModel = new DefaultListModel();
		ListaDireccion = new JList(direcionModel);
		ListaDireccion.setBounds(386, 195, 200, 30);
		JScrollPane spDireccion = new JScrollPane(ListaDireccion);
		spDireccion.setBounds(386, 195, 200, 30);
		getContentPane().add(spDireccion);
		
		DefaultListModel telefonoModel = new DefaultListModel();
		ListaTelefonos = new JList(telefonoModel);
		ListaTelefonos.setBounds(386, 317, 200, 30);
		JScrollPane spTelefono = new JScrollPane(ListaTelefonos);
		spTelefono.setBounds(386, 317, 200, 30);
		getContentPane().add(spTelefono);
		
		DefaultListModel correoModel = new DefaultListModel();
		ListaCorreos = new JList(correoModel);
		ListaCorreos.setBounds(386, 432, 200, 30);
		JScrollPane spCorreo = new JScrollPane(ListaCorreos);
		spCorreo.setBounds(386, 432, 200, 30);
		getContentPane().add(spCorreo);
		
		JLabel PlusIcon1 = new JLabel("");
		PlusIcon1.setHorizontalAlignment(SwingConstants.CENTER);
		PlusIcon1.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/plus.png")));
		PlusIcon1.setBounds(585, 158, 30, 30);
		getContentPane().add(PlusIcon1);
		
		JLabel PlusIcon3 = new JLabel("");
		PlusIcon3.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/plus.png")));
		PlusIcon3.setHorizontalAlignment(SwingConstants.CENTER);
		PlusIcon3.setBounds(585, 396, 30, 30);
		getContentPane().add(PlusIcon3);
		//Btn Add
		btnCorreos = new JButton("");
		btnCorreos.setBounds(585, 396, 30, 30);
		btnCorreos.setOpaque(false);
		btnCorreos.setContentAreaFilled(false);
		btnCorreos.setBorderPainted(false);		
		getContentPane().add(btnCorreos);
		
		btnTelefonos = new JButton("");
		btnTelefonos.setBounds(585, 278, 30, 30);
		btnTelefonos.setOpaque(false);
		btnTelefonos.setContentAreaFilled(false);
		btnTelefonos.setBorderPainted(false);
		getContentPane().add(btnTelefonos);
		
		btnDireccion = new JButton("");
		btnDireccion.setBounds(585, 158, 30, 30);
		btnDireccion.setOpaque(false);
		btnDireccion.setContentAreaFilled(false);
		btnDireccion.setBorderPainted(false);
		getContentPane().add(btnDireccion);
		
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
	public JRadioButton getRdbtnCliente() {
		return rdbtnCliente;
	}
	public void setRdbtnCliente(JRadioButton rdbtnCliente) {
		this.rdbtnCliente = rdbtnCliente;
	}
	public JRadioButton getRdbtnTrabajador() {
		return rdbtnTrabajador;
	}
	public void setRdbtnTrabajador(JRadioButton rdbtnTrabajador) {
		this.rdbtnTrabajador = rdbtnTrabajador;
	}
	
	
	
	
}
