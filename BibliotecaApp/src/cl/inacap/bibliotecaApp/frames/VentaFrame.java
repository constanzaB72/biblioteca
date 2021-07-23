package cl.inacap.bibliotecaApp.frames;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class VentaFrame extends JFrameBiblioteca {
	JTable table;
	JTable tableLibros;
	private JLabel txtCosto;
	private JButton btnVolverMenu;
	private JButton btnVender;
	private JTextField txtClienteVenta;
	private JButton btnSeleccionarLibros;
	private JComboBox cbxMetodoPago;

	public VentaFrame() {
		getContentPane().setLayout(null);
		
		btnVolverMenu = new JButton("MENU");
		btnVolverMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVolverMenu.setBounds(40, 450, 150, 30);
		getContentPane().add(btnVolverMenu);
		
		JLabel lblVenderTexto = new JLabel("VENDER");
		lblVenderTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenderTexto.setBackground(Color.WHITE);
		lblVenderTexto.setForeground(Color.WHITE);
		lblVenderTexto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVenderTexto.setBounds(0, 340, 230, 25);
		getContentPane().add(lblVenderTexto);
		
		JLabel lblVenderTexto2 = new JLabel("LIBROS");
		lblVenderTexto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenderTexto2.setForeground(Color.WHITE);
		lblVenderTexto2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVenderTexto2.setBounds(0, 370, 230, 25);
		getContentPane().add(lblVenderTexto2);
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setIcon(new ImageIcon(CompraFrame.class.getResource("/img/Venderg.png")));
		lblAvatar.setBounds(0, 190, 230, 130);
		getContentPane().add(lblAvatar);
		
		JLabel lblLateralColor = new JLabel("");
		lblLateralColor.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/lateralColor.jpg")));
		lblLateralColor.setBounds(0, 0, 230, 600);
		getContentPane().add(lblLateralColor);
		
		JLabel lblClienteVenta = new JLabel("Rut de Cliente: ");
		lblClienteVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClienteVenta.setBounds(261, 116, 200, 30);
		getContentPane().add(lblClienteVenta);
		
		txtClienteVenta = new JTextField();
		txtClienteVenta.setBounds(261, 145, 200, 30);
		getContentPane().add(txtClienteVenta);
		txtClienteVenta.setColumns(10);
		
		btnSeleccionarLibros = new JButton("Seleccionar libros");
		btnSeleccionarLibros.setHorizontalAlignment(SwingConstants.LEFT);
		btnSeleccionarLibros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSeleccionarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeleccionarLibros.setBounds(261, 191, 200, 30);
		getContentPane().add(btnSeleccionarLibros);
		
		String[] columnNames2 = { "isbn", "titulo","Precio","Cantidad"};
		DefaultTableModel model2 =new DefaultTableModel(columnNames2,0); 
		tableLibros = new JTable(model2);
		tableLibros.setBounds(30, 40, 100, 200);		
		JScrollPane Sp2 = new JScrollPane(tableLibros);		
		Sp2.setBounds(261, 262, 504, 118);
		getContentPane().add(Sp2);
		
		JLabel lblCostoVenta = new JLabel("Costo total: ");
		lblCostoVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCostoVenta.setBounds(261, 398, 200, 30);
		getContentPane().add(lblCostoVenta);
		
		txtCosto = new JLabel();
		txtCosto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCosto.setBounds(261, 427, 200, 30);
		getContentPane().add(txtCosto);
		
		JLabel lblTituloVenta = new JLabel("Formulario de Venta");
		lblTituloVenta.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTituloVenta.setBounds(340, 40, 300, 30);
		getContentPane().add(lblTituloVenta);
		
		btnVender = new JButton("VENDER");
		btnVender.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVender.setBounds(577, 495, 150, 30);
		getContentPane().add(btnVender);		
		
		
		JLabel lblListadoDeLibros = new JLabel("Listado de libros: ");
		lblListadoDeLibros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListadoDeLibros.setBounds(261, 232, 200, 30);
		getContentPane().add(lblListadoDeLibros);
		
		cbxMetodoPago = new JComboBox();
		cbxMetodoPago.setBounds(565, 427, 200, 30);
		cbxMetodoPago.addItem("Seleccione");
		cbxMetodoPago.addItem("Crédito");
		cbxMetodoPago.addItem("Débito");
		cbxMetodoPago.addItem("Efectivo");
		getContentPane().add(cbxMetodoPago);
		
	}

	public void addMenuListener(ActionListener ing) {
		btnVolverMenu.addActionListener(ing);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTable getTable2() {
		return tableLibros;
	}

	public void setTable2(JTable table2) {
		this.tableLibros = table2;
	}

	public JLabel getTxtCosto() {
		return txtCosto;
	}

	public void setTxtCosto(JLabel txtCosto) {
		this.txtCosto = txtCosto;
	}

	public JButton getBtnVolverMenu() {
		return btnVolverMenu;
	}

	public void setBtnVolverMenu(JButton btnVolverMenu) {
		this.btnVolverMenu = btnVolverMenu;
	}

	public JButton getBtnVender() {
		return btnVender;
	}

	public void setBtnVender(JButton btnComprar) {
		this.btnVender = btnComprar;
	}

	public JButton getBtnSeleccionarLibros() {
		return btnSeleccionarLibros;
	}

	public void setBtnSeleccionarLibros(JButton btnSeleccionarLibros) {
		this.btnSeleccionarLibros = btnSeleccionarLibros;
	}	
	public void addVentaListener(ActionListener ing) {
		btnVender.addActionListener(ing);
	}
	public void addSelectListener(ActionListener ing) {
		btnSeleccionarLibros.addActionListener(ing);
	}

	public JTable getTableLibros() {
		return tableLibros;
	}

	public void setTableLibros(JTable tableLibros) {
		this.tableLibros = tableLibros;
	}

	public JComboBox getCbxMetodoPago() {
		return cbxMetodoPago;
	}

	public void setCbxMetodoPago(JComboBox cbxMetodoPago) {
		this.cbxMetodoPago = cbxMetodoPago;
	}

	public JTextField getTxtClienteVenta() {
		return txtClienteVenta;
	}

	public void setTxtClienteVenta(JTextField txtClienteVenta) {
		this.txtClienteVenta = txtClienteVenta;
	}
	
	
}

