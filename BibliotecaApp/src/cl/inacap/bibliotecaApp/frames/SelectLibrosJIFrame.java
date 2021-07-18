package cl.inacap.bibliotecaApp.frames;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cl.inacap.bibliotecaModel.dto.Libro;

public class SelectLibrosJIFrame extends JInternalFrame {

	public SelectLibrosJIFrame(List<Libro> listaLibros) {
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 700, 500);
		String[] columnNames = { "isbn", "titulo" };
		String[][] data = {
	            { "123456", "12345", "$1000" },
	            { "123456", "12345", "$1000" },
	            { "123456", "12345", "$1000" },
	            { "123456", "12345", "$1000" },
	            { "123456", "12345", "$1000" }        
		};
		DefaultTableModel model =new DefaultTableModel(); 
		if(listaLibros!=null & !listaLibros.isEmpty()) {
			for(int fila=1;fila<=listaLibros.size();fila++) {
				model.setValueAt(listaLibros.get(fila).getIsbn(), fila, 1);
				model.setValueAt(listaLibros.get(fila).getTitulo(), fila, 2);
			}
		}
		
		JTable table = new JTable(model);
		table.setBounds(30, 40, 100, 200);		
		JScrollPane sp = new JScrollPane(table);		
		sp.setBounds(0, 0, 690, 118);
		getContentPane().add(sp);
		this.setVisible(true);

	}

}
