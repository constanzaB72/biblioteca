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
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

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
	private JTextField txtDireccionRegistrar;
	private JTextField txtTelefonoRegistrar;
	private JTextField txtCorreoRegistrar;
	private JButton btnRegistrar; 
	private JButton btnCorreos;
	private JButton btnTelefonos;
	private JButton btnDireccion;
	private JList ListaDireccion; 
	private JList ListaCorreos; 
	private JList ListaTelefonos; 
	private JRadioButton rdbtnCliente; 
	private JRadioButton rdbtnTrabajador;
	private JDateChooser dataNacimiento;
	private JDateChooser dataContrato;
	private JTextField textPassword;
	private JLabel lblPassword;

	
	public RegistrarFrame() {
		//getContentPane().setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblHeaderRegistrar = new JLabel("");
		lblHeaderRegistrar.setVerticalAlignment(SwingConstants.TOP);
		lblHeaderRegistrar.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/fastheader.jpg")));
		lblHeaderRegistrar.setBounds(0, 0, 800, 78);
		getContentPane().add(lblHeaderRegistrar);
		
		JLabel lblNombreRegistrar = new JLabel("Nombre: ");
		lblNombreRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreRegistrar.setBounds(24, 196, 200, 25);
		getContentPane().add(lblNombreRegistrar);
		
		txtRutRegistrar = new JTextField();
		txtRutRegistrar.setBounds(24, 159, 200, 30);
		getContentPane().add(txtRutRegistrar);
		txtRutRegistrar.setColumns(10);
		
		JLabel lblRutRegistrar = new JLabel("Rut: ");
		lblRutRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRutRegistrar.setBounds(24, 133, 200, 25);
		getContentPane().add(lblRutRegistrar);
		
		txtNombreIngresar = new JTextField();
		txtNombreIngresar.setBounds(24, 221, 200, 30);
		getContentPane().add(txtNombreIngresar);
		txtNombreIngresar.setColumns(10);
		
		JLabel lblApellidoPaRegistrar = new JLabel("Apellido Paterno: ");
		lblApellidoPaRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellidoPaRegistrar.setBounds(24, 262, 200, 25);
		getContentPane().add(lblApellidoPaRegistrar);
		
		txtApellidoPaRegistrar = new JTextField();
		txtApellidoPaRegistrar.setBounds(24, 290, 200, 30);
		getContentPane().add(txtApellidoPaRegistrar);
		txtApellidoPaRegistrar.setColumns(10);
		
		JLabel lblApellidoMaRegistrar = new JLabel("Apellido Materno: ");
		lblApellidoMaRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellidoMaRegistrar.setBounds(304, 262, 200, 25);
		getContentPane().add(lblApellidoMaRegistrar);
		
		txtApellidoMaRegistrar = new JTextField();
		txtApellidoMaRegistrar.setBounds(304, 290, 200, 30);
		getContentPane().add(txtApellidoMaRegistrar);
		txtApellidoMaRegistrar.setColumns(10);
		
		JLabel lblNacimientoRegistrar = new JLabel("Fecha de Nacimiento: ");
		lblNacimientoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNacimientoRegistrar.setBounds(551, 193, 200, 30);
		getContentPane().add(lblNacimientoRegistrar);
		
		JLabel lblDireccionRegistrar = new JLabel("Direcci\u00F3n: ");
		lblDireccionRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDireccionRegistrar.setBounds(551, 331, 200, 30);
		getContentPane().add(lblDireccionRegistrar);
		
		txtDireccionRegistrar = new JTextField();
		txtDireccionRegistrar.setBounds(551, 357, 200, 30);
		getContentPane().add(txtDireccionRegistrar);
		txtDireccionRegistrar.setColumns(10);
		
		JLabel lblTelefonoRegistrar = new JLabel("Tel\u00E9fono: ");
		lblTelefonoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefonoRegistrar.setBounds(24, 331, 200, 30);
		getContentPane().add(lblTelefonoRegistrar);
		
		txtTelefonoRegistrar = new JTextField();
		txtTelefonoRegistrar.setBounds(24, 357, 200, 30);
		getContentPane().add(txtTelefonoRegistrar);
		txtTelefonoRegistrar.setColumns(10);
		
		JLabel lblCorreoRegistrar = new JLabel("Correo electr\u00F3nico:");
		lblCorreoRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorreoRegistrar.setBounds(304, 331, 212, 30);
		getContentPane().add(lblCorreoRegistrar);
		
		txtCorreoRegistrar = new JTextField();
		txtCorreoRegistrar.setBounds(304, 357, 200, 30);
		getContentPane().add(txtCorreoRegistrar);
		txtCorreoRegistrar.setColumns(10);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrar.setBounds(341, 515, 157, 30);
		getContentPane().add(btnRegistrar);
		
		JLabel lblRegistrarUsuario = new JLabel("Registrar Usuario");
		lblRegistrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistrarUsuario.setBounds(316, 78, 200, 41);
		getContentPane().add(lblRegistrarUsuario);
				
		JLabel lblNacimientoRegistrar_1 = new JLabel("Fecha de Contrato: ");
		lblNacimientoRegistrar_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNacimientoRegistrar_1.setBounds(551, 130, 200, 30);
		getContentPane().add(lblNacimientoRegistrar_1);
		
		rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBounds(154, 96, 99, 30);
		rdbtnCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(rdbtnCliente);
		
		rdbtnTrabajador= new JRadioButton("Trabajador");
		rdbtnTrabajador.setBounds(24, 96, 120, 30);
		rdbtnTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(rdbtnTrabajador);
		
		ButtonGroup tipoRegistro=new ButtonGroup();
		tipoRegistro.add(rdbtnTrabajador);
		tipoRegistro.add(rdbtnCliente);
		
		DefaultListModel direcionModel = new DefaultListModel();
		
		DefaultListModel telefonoModel = new DefaultListModel();
		
		DefaultListModel correoModel = new DefaultListModel();		
		
		
		
		dataNacimiento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dataNacimiento.setBounds(551, 221, 200, 30);
		getContentPane().add(dataNacimiento);
		
		dataContrato = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dataContrato.setBounds(551, 159, 200, 30);
		getContentPane().add(dataContrato);
		ListaTelefonos = new JList(telefonoModel);
		
		
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(304, 159, 200, 30);
		getContentPane().add(textPassword);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(304, 133, 200, 25);
		getContentPane().add(lblPassword);
		
		JLabel PlusIcon1 = new JLabel("");
		PlusIcon1.setHorizontalAlignment(SwingConstants.CENTER);
		PlusIcon1.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/plus.png")));
		PlusIcon1.setBounds(752, 357, 30, 30);
		getContentPane().add(PlusIcon1);
		
		JLabel PlusIcon2 = new JLabel("");
		PlusIcon2.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/plus.png")));
		PlusIcon2.setHorizontalAlignment(SwingConstants.CENTER);
		PlusIcon2.setBounds(223, 357, 30, 30);
		getContentPane().add(PlusIcon2);
		
		JLabel PlusIcon3 = new JLabel("");
		PlusIcon3.setIcon(new ImageIcon(RegistrarFrame.class.getResource("/img/plus.png")));
		PlusIcon3.setHorizontalAlignment(SwingConstants.CENTER);
		PlusIcon3.setBounds(502, 357, 30, 30);
		getContentPane().add(PlusIcon3);
		
		
		
		// Btn Add
		btnTelefonos = new JButton("");
		btnTelefonos.setBounds(223, 357, 30, 30);
		btnTelefonos.setOpaque(false);
		btnTelefonos.setContentAreaFilled(false);
		btnTelefonos.setBorderPainted(false);
		getContentPane().add(btnTelefonos);
		
		btnCorreos = new JButton("");
		btnCorreos.setBounds(502, 357, 30, 30);
		btnCorreos.setOpaque(false);
		btnCorreos.setContentAreaFilled(false);
		btnCorreos.setBorderPainted(false);
		getContentPane().add(btnCorreos);

		btnDireccion = new JButton("");
		btnDireccion.setBounds(752, 357, 30, 30);
		btnDireccion.setOpaque(false);
		btnDireccion.setContentAreaFilled(false);
		btnDireccion.setBorderPainted(false);
		getContentPane().add(btnDireccion);
		
		// getContentPane().add(ListaTelefonos);
		ListaTelefonos.setBounds(24, 391, 198, 48);
		JScrollPane spTelefono = new JScrollPane(ListaTelefonos);
		// spTelefono.add(ListaTelefonos);
		spTelefono.setBounds(24, 391, 198, 48);
		getContentPane().add(spTelefono);

		ListaCorreos = new JList(correoModel);
		getContentPane().add(ListaCorreos);
		ListaCorreos.setBounds(306, 393, 198, 48);
		JScrollPane spCorreo = new JScrollPane(ListaCorreos);
		spCorreo.setBounds(306, 393, 198, 48);
		getContentPane().add(spCorreo);

		ListaDireccion = new JList(direcionModel);
		getContentPane().add(ListaDireccion);
		ListaDireccion.setBounds(551, 393, 198, 48);
		JScrollPane spDireccion = new JScrollPane(ListaDireccion);
		spDireccion.setBounds(551, 393, 198, 48);
		getContentPane().add(spDireccion);
		
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
	public JDateChooser getDataNacimiento() {
		return dataNacimiento;
	}
	public void setDataNacimiento(JDateChooser dataNacimiento) {
		this.dataNacimiento = dataNacimiento;
	}
	public JDateChooser getDataContrato() {
		return dataContrato;
	}
	public void setDataContrato(JDateChooser dataContrato) {
		this.dataContrato = dataContrato;
	}
	public JLabel getLblPassword() {
		return lblPassword;
	}
	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}
	public JTextField getTextPassword() {
		return textPassword;
	}
	public void setTextPassword(JTextField textPassword) {
		this.textPassword = textPassword;
	}
	
	
}
