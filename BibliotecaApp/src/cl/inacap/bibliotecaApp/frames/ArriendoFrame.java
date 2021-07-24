package cl.inacap.bibliotecaApp.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class ArriendoFrame extends JFrameBiblioteca {
	JTable table;
	JTable tableLibros;
	private JLabel txtCosto;
	private JDateChooser dateChooser;
	private JTextField txtClienteArriendo;
	private JTextField txtCostoArriendo;
	private JButton btnSeleccionarLibros;
	private JButton btnArrendar;
	private JButton btnVolverMenu;

	public ArriendoFrame() {
		getContentPane().setLayout(null);
		btnVolverMenu = new JButton("MENU");
		btnVolverMenu.setBounds(40, 450, 150, 30);
		btnVolverMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(btnVolverMenu);
		
		JLabel lblArrendarTexto = new JLabel("ARRENDAR");
		lblArrendarTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrendarTexto.setForeground(Color.WHITE);
		lblArrendarTexto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblArrendarTexto.setBounds(0, 340, 230, 25);
		getContentPane().add(lblArrendarTexto);
		
		JLabel lblArrendarTexto2 = new JLabel("LIBROS");
		lblArrendarTexto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrendarTexto2.setForeground(Color.WHITE);
		lblArrendarTexto2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblArrendarTexto2.setBounds(0, 370, 230, 25);
		getContentPane().add(lblArrendarTexto2);
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setIcon(new ImageIcon(CompraFrame.class.getResource("/img/Arrendarg.png")));
		lblAvatar.setBounds(0, 190, 230, 130);
		getContentPane().add(lblAvatar);
		
		JLabel lblLateralColor = new JLabel("");
		lblLateralColor.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/lateralColor.jpg")));
		lblLateralColor.setBounds(0, 0, 230, 600);
		getContentPane().add(lblLateralColor);
		
		JLabel lblClienteArriendo = new JLabel("Rut de Cliente: ");
		lblClienteArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClienteArriendo.setBounds(261, 99, 200, 30);
		getContentPane().add(lblClienteArriendo);
		
		txtClienteArriendo = new JTextField();
		txtClienteArriendo.setBounds(261, 128, 200, 30);
		getContentPane().add(txtClienteArriendo);
		txtClienteArriendo.setColumns(10);
		
		JLabel lblListadoDeLibros = new JLabel("Listado de libros: ");
		lblListadoDeLibros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListadoDeLibros.setBounds(261, 200, 200, 30);
		getContentPane().add(lblListadoDeLibros);
		
		String[] columnNames2 = { "isbn", "titulo","Precio","Cantidad"};
		DefaultTableModel model2 =new DefaultTableModel(columnNames2,0); 
		tableLibros = new JTable(model2);
		tableLibros.setBounds(30, 40, 100, 200);		
		JScrollPane Sp2 = new JScrollPane(tableLibros);		
		Sp2.setBounds(261, 230, 504, 118);
		getContentPane().add(Sp2);
		
		btnSeleccionarLibros = new JButton("Seleccionar libros");
		btnSeleccionarLibros.setHorizontalAlignment(SwingConstants.LEFT);
		btnSeleccionarLibros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSeleccionarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeleccionarLibros.setBounds(261, 169, 200, 30);
		getContentPane().add(btnSeleccionarLibros);
		
		JLabel lblEntregaArriendo = new JLabel("Fecha a Entregar: ");
		lblEntregaArriendo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEntregaArriendo.setBounds(261, 360, 200, 30);
		getContentPane().add(lblEntregaArriendo);

		dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dateChooser.setBounds(261, 390, 170, 30);
		dateChooser.setMinSelectableDate(new Date());
		getContentPane().add(dateChooser);
		
		JLabel lblCostoCompra = new JLabel("Costo total: ");
		lblCostoCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCostoCompra.setBounds(261, 425, 200, 30);
		getContentPane().add(lblCostoCompra);
		
		txtCosto = new JLabel();
		txtCosto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCosto.setBounds(261, 450, 200, 30);
		getContentPane().add(txtCosto);
		
		btnArrendar = new JButton("ARRENDAR");
		btnArrendar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnArrendar.setBounds(578, 496, 150, 30);
		getContentPane().add(btnArrendar);
		
		JLabel lblTiruloArriendo = new JLabel("Formulario de Arriendo");
		lblTiruloArriendo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTiruloArriendo.setBounds(340, 40, 330, 30);
		getContentPane().add(lblTiruloArriendo);
}
	
	public void addMenuListener(ActionListener ing) {
		btnVolverMenu.addActionListener(ing);
	}
	
	public void addSelectListener(ActionListener ing) {
		btnSeleccionarLibros.addActionListener(ing);
	}
	public void addArrendarListener(ActionListener ing) {
		btnArrendar.addActionListener(ing);
	}
	
	public void addDateListener(PropertyChangeListener ing) {
		dateChooser.addPropertyChangeListener(ing);
	}

	public JLabel getTxtCosto() {
		return txtCosto;
	}

	public void setTxtCosto(JLabel txtCosto) {
		this.txtCosto = txtCosto;
	}

	public JTextField getTxtClienteArriendo() {
		return txtClienteArriendo;
	}

	public void setTxtClienteArriendo(JTextField txtClienteArriendo) {
		this.txtClienteArriendo = txtClienteArriendo;
	}

	public JTextField getTxtCostoArriendo() {
		return txtCostoArriendo;
	}

	public void setTxtCostoArriendo(JTextField txtCostoArriendo) {
		this.txtCostoArriendo = txtCostoArriendo;
	}

	public JButton getBtnSeleccionarLibros() {
		return btnSeleccionarLibros;
	}

	public void setBtnSeleccionarLibros(JButton btnSeleccionarLibros) {
		this.btnSeleccionarLibros = btnSeleccionarLibros;
	}

	public JButton getBtnArrendar() {
		return btnArrendar;
	}

	public void setBtnArrendar(JButton btnArrendar) {
		this.btnArrendar = btnArrendar;
	}

	public JButton getBtnVolverMenu() {
		return btnVolverMenu;
	}

	public void setBtnVolverMenu(JButton btnVolverMenu) {
		this.btnVolverMenu = btnVolverMenu;
	}

	public JTable getTableLibros() {
		return tableLibros;
	}

	public void setTableLibros(JTable tableLibros) {
		this.tableLibros = tableLibros;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}
}
