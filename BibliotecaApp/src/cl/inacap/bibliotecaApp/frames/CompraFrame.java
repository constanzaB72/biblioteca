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

public class CompraFrame extends JFrameBiblioteca {
	JTable table;
	JTable tableLibros;
	private JLabel txtCosto;
	private JComboBox cbxDistribuidor;
	private JButton btnVolverMenu;
	private JButton btnComprar;
	private JButton btnSeleccionarLibros;
	private JComboBox cbxMetodoPago;

	public CompraFrame() {
		getContentPane().setLayout(null);
		String[] columnNames = { "isbn", "titulo","cantidad", "valor",""};
		DefaultTableModel model =new DefaultTableModel(columnNames,0); 
		
		btnVolverMenu = new JButton("MENU");
		btnVolverMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVolverMenu.setBounds(40, 450, 150, 30);
		getContentPane().add(btnVolverMenu);
		
		JLabel lblComprarTexto = new JLabel("COMPRAR");
		lblComprarTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprarTexto.setBackground(Color.WHITE);
		lblComprarTexto.setForeground(Color.WHITE);
		lblComprarTexto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComprarTexto.setBounds(0, 342, 230, 25);
		getContentPane().add(lblComprarTexto);
		
		JLabel lblComprarTexto2 = new JLabel("LIBROS");
		lblComprarTexto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprarTexto2.setForeground(Color.WHITE);
		lblComprarTexto2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComprarTexto2.setBounds(0, 378, 230, 25);
		getContentPane().add(lblComprarTexto2);
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setIcon(new ImageIcon(CompraFrame.class.getResource("/img/Comprarg.png")));
		lblAvatar.setBounds(0, 190, 230, 130);
		getContentPane().add(lblAvatar);
		
		JLabel lblLateralColor = new JLabel("");
		lblLateralColor.setIcon(new ImageIcon(TrabajadorFrame.class.getResource("/img/lateralColor.jpg")));
		lblLateralColor.setBounds(0, 0, 230, 600);
		getContentPane().add(lblLateralColor);
		
		JLabel lblDistribuidorCompra = new JLabel("Distribuidor: ");
		lblDistribuidorCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDistribuidorCompra.setBounds(261, 110, 200, 30);
		getContentPane().add(lblDistribuidorCompra);
		
		cbxDistribuidor = new JComboBox();
		cbxDistribuidor.setBounds(261, 139, 200, 30);
		getContentPane().add(cbxDistribuidor);
		
		
		String[] columnNames2 = { "isbn", "titulo","Precio","Cantidad"};
		DefaultTableModel model2 =new DefaultTableModel(columnNames2,0); 
		tableLibros = new JTable(model2);
		tableLibros.setBounds(30, 40, 100, 200);		
		JScrollPane Sp2 = new JScrollPane(tableLibros);		
		Sp2.setBounds(261, 262, 504, 118);
		getContentPane().add(Sp2);
		
		JLabel lblCostoCompra = new JLabel("Costo total: ");
		lblCostoCompra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCostoCompra.setBounds(261, 398, 200, 30);
		getContentPane().add(lblCostoCompra);
		
		txtCosto = new JLabel();
		txtCosto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCosto.setBounds(261, 427, 200, 30);
		getContentPane().add(txtCosto);
		
		JLabel lblTituloCompra = new JLabel("Formulario de Compra");
		lblTituloCompra.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTituloCompra.setBounds(340, 40, 300, 30);
		getContentPane().add(lblTituloCompra);
		
		btnComprar = new JButton("COMPRAR");
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnComprar.setBounds(577, 495, 150, 30);
		getContentPane().add(btnComprar);
		
		btnSeleccionarLibros = new JButton("Seleccionar libros");
		btnSeleccionarLibros.setHorizontalAlignment(SwingConstants.LEFT);
		btnSeleccionarLibros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSeleccionarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeleccionarLibros.setBounds(261, 191, 200, 30);
		getContentPane().add(btnSeleccionarLibros);
		
		JLabel lblListadoDeLibros = new JLabel("Listado de libros: ");
		lblListadoDeLibros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListadoDeLibros.setBounds(261, 232, 200, 30);
		getContentPane().add(lblListadoDeLibros);
		
		cbxMetodoPago = new JComboBox();
		cbxMetodoPago.setBounds(565, 427, 200, 30);
		cbxMetodoPago.addItem("Seleccione");
		cbxMetodoPago.addItem("Seleccione");
		cbxMetodoPago.addItem("Seleccione");
		getContentPane().add(cbxMetodoPago);
		
	}

	public JComboBox getCbxDistribuidor() {
		return cbxDistribuidor;
	}

	public void setCbxDistribuidor(JComboBox cbxDistribuidor) {
		this.cbxDistribuidor = cbxDistribuidor;
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

	public JButton getBtnComprar() {
		return btnComprar;
	}

	public void setBtnComprar(JButton btnComprar) {
		this.btnComprar = btnComprar;
	}

	public JButton getBtnSeleccionarLibros() {
		return btnSeleccionarLibros;
	}

	public void setBtnSeleccionarLibros(JButton btnSeleccionarLibros) {
		this.btnSeleccionarLibros = btnSeleccionarLibros;
	}	
	public void addCompraListener(ActionListener ing) {
		btnComprar.addActionListener(ing);
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
	
}
