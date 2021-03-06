package cl.inacap.bibliotecaApp.frames;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrameBiblioteca {

	private JPanel contentPane;
	private JTextField txtUsuarioLogin;
	private JPasswordField passFContrasenaLogin;
	private JButton btnIngresar;
	private JButton btnRegistrar;
	private JComboBox cbTipoLogin;
	public LoginFrame() {		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloLogin = new JLabel("Sistema de Biblioteca");
		lblTituloLogin.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblTituloLogin.setBounds(275, 109, 381, 28);
		contentPane.add(lblTituloLogin);
		
		JLabel lblBienvenidoLogin = new JLabel("Bienvenid@");
		lblBienvenidoLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBienvenidoLogin.setBounds(275, 148, 198, 28);
		contentPane.add(lblBienvenidoLogin);
		
		JLabel lblUsuarioLogin = new JLabel("Usuario: ");
		lblUsuarioLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuarioLogin.setBounds(275, 386, 200, 30);
		contentPane.add(lblUsuarioLogin);
		
		JLabel lblContrasenaLogin = new JLabel("Contrase\u00F1a: ");
		lblContrasenaLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasenaLogin.setBounds(275, 466, 200, 30);
		contentPane.add(lblContrasenaLogin);
		
		txtUsuarioLogin = new JTextField();
		txtUsuarioLogin.setBounds(275, 415, 200, 30);
		contentPane.add(txtUsuarioLogin);
		txtUsuarioLogin.setColumns(10);
		
		cbTipoLogin = new JComboBox();
		cbTipoLogin.setBounds(576, 415, 200, 30);
		cbTipoLogin.addItem("Seleccione");
		cbTipoLogin.addItem("Trabajador");
		cbTipoLogin.addItem("Cliente");
		contentPane.add(cbTipoLogin);
		
		JLabel lblTipoLogin = new JLabel("Tipo Usuario: ");
		lblTipoLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoLogin.setBounds(576, 386, 200, 30);
		contentPane.add(lblTipoLogin);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIngresar.setBounds(599, 491, 150, 30);
		contentPane.add(btnIngresar);
		
		passFContrasenaLogin = new JPasswordField();
		passFContrasenaLogin.setBounds(275, 495, 200, 30);
		contentPane.add(passFContrasenaLogin);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRegistrar.setBounds(59, 430, 151, 30);
		contentPane.add(btnRegistrar);
		

		JLabel lbLogoLogin = new JLabel("");
		lbLogoLogin.setIcon(new ImageIcon(LoginFrame.class.getResource("/img/fastlogo.jpg")));
		lbLogoLogin.setBounds(0, 0, 265, 563);
		contentPane.add(lbLogoLogin);
	}

	public JTextField getTxtUsuarioLogin() {
		return txtUsuarioLogin;
	}

	public void setTxtUsuarioLogin(JTextField txtUsuarioLogin) {
		this.txtUsuarioLogin = txtUsuarioLogin;
	}

	public JPasswordField getPassFContrasenaLogin() {
		return passFContrasenaLogin;
	}

	public void setPassFContrasenaLogin(JPasswordField passFContrasenaLogin) {
		this.passFContrasenaLogin = passFContrasenaLogin;
	}
	public void addIngresarListener(ActionListener ing) {
		btnIngresar.addActionListener(ing);
		
		}
	public void addRegistrarListener(ActionListener ing) {
		btnRegistrar.addActionListener(ing);
		
		}

	public JComboBox getCbTipoLogin() {
		return cbTipoLogin;
	}

	public void setCbTipoLogin(JComboBox cbTipoLogin) {
		this.cbTipoLogin = cbTipoLogin;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

}
