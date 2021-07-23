package cl.inacap.bibliotecaApp.frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import cl.inacap.biblioteca.utils.ButtonColumn;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cl.inacap.bibliotecaModel.dto.Libro;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class EjemplaresFrame extends JFrame {
	JTable table2;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	public EjemplaresFrame(List<Libro> listaLibros) {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
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
		String[] columnNames2 = { "NumSerie","isbn", "titulo","estado"};
		DefaultTableModel model2 =new DefaultTableModel(columnNames2,0); 
		table2 = new JTable(model2);
		table2.setBounds(30, 40, 100, 200);		
		JScrollPane sp2 = new JScrollPane(table2);		
		sp2.setBounds(23, 144, 651, 226);
		getContentPane().add(sp2);
		Action Agregar = new AbstractAction()
		{
		    
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
		        JTable auxTable = (JTable)e.getSource();
		        int fila = Integer.valueOf( e.getActionCommand() );
		        String isbn= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 0);
		        String titulo= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 1);
		        String estado= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 2);
		        Object[] columna=new Object[] {isbn,titulo,listaLibros.get(fila).getPrecio(),"","Quitar"};
		        ((DefaultTableModel)table2.getModel()).addRow(columna);	       
		        
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
		        Object[] columna=new Object[] {isbn,titulo,"Agregar"};
		        ((DefaultTableModel)table2.getModel()).addRow(columna);	       
		        
		        ((DefaultTableModel)auxTable.getModel()).removeRow(fila);
		        
		        
		    }
			
		};
		ButtonColumn buttonColumn = new ButtonColumn(table2, Agregar, 2);	
		buttonColumn.setMnemonic(KeyEvent.VK_D);
		ButtonColumn buttonColumnTable2 = new ButtonColumn(table2, Quitar, 4);	
		buttonColumnTable2.setMnemonic(KeyEvent.VK_D);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(535, 415, 100, 23);
		getContentPane().add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(423, 415, 100, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(EjemplaresFrame.class.getResource("/img/fastheader.jpg")));
		lblNewLabel.setBounds(0, 0, 700, 90);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ejemplares");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(23, 100, 651, 34);
		getContentPane().add(lblNewLabel_1);
		
		
		
		this.setVisible(true);

	}
	public void addConfirmarAgregar(ActionListener ing) {
		btnConfirmar.addActionListener(ing);
	}
	public void addCancelarAgregar(ActionListener ing) {
		btnCancelar.addActionListener(ing);
	}
	public JTable getTable2() {
		return table2;
	}
	public void setTable2(JTable table2) {
		this.table2 = table2;
	}
}
