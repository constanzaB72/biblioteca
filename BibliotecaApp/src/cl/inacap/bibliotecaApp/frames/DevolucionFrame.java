package cl.inacap.bibliotecaApp.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cl.inacap.biblioteca.utils.ButtonColumn;
import cl.inacap.bibliotecaModel.dto.Libro;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class DevolucionFrame extends JFrame {
	JTable table;
	private JTextField txtClienteDevolucion;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	public DevolucionFrame(List<Libro> listaLibros) {
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 700, 500);
		String[] columnNames = { "isbn", "titulo", ""};
		DefaultTableModel model =new DefaultTableModel(columnNames,0); 
		if(listaLibros!=null & !listaLibros.isEmpty()) {
			for(int fila=0;fila<listaLibros.size();fila++) {
				Object[] columna=new Object[] {listaLibros.get(fila).getIsbn(),listaLibros.get(fila).getTitulo(),"Agregar"};
				model.addRow(columna);
			}
		}
		
		JLabel lblClienteDevolucion = new JLabel("Rut de Cliente: ");
		lblClienteDevolucion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClienteDevolucion.setBounds(29, 101, 200, 30);
		getContentPane().add(lblClienteDevolucion);
		
		txtClienteDevolucion = new JTextField();
		txtClienteDevolucion.setBounds(29, 130, 200, 30);
		getContentPane().add(txtClienteDevolucion);
		txtClienteDevolucion.setColumns(10);
		
		table = new JTable(model);
		String[] columnNames2 = { "isbn", "titulo","Precio","Cantidad", ""};
		DefaultTableModel model2 =new DefaultTableModel(columnNames2,0);
		
		
		table.setBounds(30, 40, 100, 200);		
		JScrollPane sp = new JScrollPane(table);		
		sp.setBounds(29, 167, 630, 150);
		getContentPane().add(sp);
		Action Agregar = new AbstractAction()
		{
		    
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
		        JTable auxTable = (JTable)e.getSource();
		        int fila = Integer.valueOf( e.getActionCommand() );
		        String isbn= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 0);
		        String titulo= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 1);
		        String precio= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 2);
		        Object[] columna=new Object[] {isbn,titulo,listaLibros.get(fila).getPrecio(),"","Quitar"};
		        ((DefaultTableModel)table.getModel()).addRow(columna);	       
		        
		        ((DefaultTableModel)auxTable.getModel()).removeRow(fila);
		        
		    }
		};
		
		Action Quitar = new AbstractAction()
		{
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e)
		    {
		        JTable auxTable = (JTable)e.getSource();
		        int fila = Integer.valueOf( e.getActionCommand() );
		        String isbn= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 0);
		        String titulo= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 1);
		        //String precio=(String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 2);
		        Object[] columna=new Object[] {isbn,titulo,"Agregar"};
		        ((DefaultTableModel)table.getModel()).addRow(columna);	       
		        
		        ((DefaultTableModel)auxTable.getModel()).removeRow(fila);
		        
		        
		    }
			
		};
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(533, 415, 100, 23);
		getContentPane().add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(423, 415, 100, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setIcon(new ImageIcon(DevolucionFrame.class.getResource("/img/fastheader.jpg")));
		lblHeader.setBounds(0, 0, 700, 90);
		getContentPane().add(lblHeader);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(239, 130, 89, 30);
		getContentPane().add(btnBuscar);
		
		
		
		this.setVisible(true);

	}
	public void addConfirmarAgregar(ActionListener ing) {
		btnConfirmar.addActionListener(ing);
	}
	public void addCancelarAgregar(ActionListener ing) {
		btnCancelar.addActionListener(ing);
	}
}
