package cl.inacap.bibliotecaApp.frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cl.inacap.biblioteca.utils.ButtonColumn;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Libro;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class SelectEjemplarFrame extends JFrame {
	JTable table2;
	JTable table;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	public SelectEjemplarFrame(List<Ejemplar> listaLibros) {
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 700, 500);
		String[] columnNames = { "serie","isbn", "titulo","precio",""};
		DefaultTableModel model =new DefaultTableModel(columnNames,0); 
		if(listaLibros!=null & !listaLibros.isEmpty()) {
			for(int fila=0;fila<listaLibros.size();fila++) {
				Object[] columna=new Object[] {
						listaLibros.get(fila).getNumSerie(),
						listaLibros.get(fila).getIsbn(),
						listaLibros.get(fila).getTitulo(),
						listaLibros.get(fila).getLibro().getPrecio(),
						"Agregar"};
				model.addRow(columna);
			}
		}
		
		table = new JTable(model);
		String[] columnNames2 = { "serie","isbn", "titulo","precio",""};
		DefaultTableModel model2 =new DefaultTableModel(columnNames2,0); 
		table2 = new JTable(model2);
		table2.setBounds(30, 40, 100, 200);		
		JScrollPane sp2 = new JScrollPane(table2);		
		sp2.setBounds(28, 260, 630, 118);
		getContentPane().add(sp2);
		
		
		table.setBounds(30, 40, 100, 200);		
		JScrollPane sp = new JScrollPane(table);		
		sp.setBounds(28, 120, 630, 118);
		getContentPane().add(sp);
		Action Agregar = new AbstractAction()
		{
		    
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
				
				// "serie","isbn", "titulo","precio",""
		        JTable auxTable = (JTable)e.getSource();
		        int fila = Integer.valueOf( e.getActionCommand() );
		        int serie =(Integer)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 0);
		        String isbn= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 1);
		        String titulo= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 2);
		        int precio= (Integer)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 3);
		        Object[] columna=new Object[] {serie,isbn,titulo,precio,"Quitar"};
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
		        int serie =(Integer)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 0);
		        String isbn= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 1);
		        String titulo= (String)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 2);
		        int precio= (Integer)((DefaultTableModel)auxTable.getModel()).getValueAt(fila, 3);
		        Object[] columna=new Object[] {serie,isbn,titulo,precio,"Agregar"};
		        ((DefaultTableModel)table.getModel()).addRow(columna);	       
		        
		        ((DefaultTableModel)auxTable.getModel()).removeRow(fila);
		        
		        
		    }
			
		};
		ButtonColumn buttonColumn = new ButtonColumn(table, Agregar, 4);	
		buttonColumn.setMnemonic(KeyEvent.VK_D);
		ButtonColumn buttonColumnTable2 = new ButtonColumn(table2, Quitar, 4);	
		buttonColumnTable2.setMnemonic(KeyEvent.VK_D);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(535, 415, 100, 23);
		getContentPane().add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(423, 415, 100, 23);
		getContentPane().add(btnCancelar);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(SelectEjemplarFrame.class.getResource("/img/fastheader.jpg")));
		lblNewLabel.setBounds(0, 0, 700, 90);
		getContentPane().add(lblNewLabel);
		
		
		
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