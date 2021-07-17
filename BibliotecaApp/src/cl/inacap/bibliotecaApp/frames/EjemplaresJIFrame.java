package cl.inacap.bibliotecaApp.frames;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class EjemplaresJIFrame extends JInternalFrame {
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemplaresJIFrame frame = new EjemplaresJIFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public EjemplaresJIFrame() {
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 700, 500);
		String[] columnNames = { "Id Detalle de Arriendo", "N° de Serie", "Costo" };
		String[][] data = {
	            { "123456", "12345", "$1000" },
	            { "123456", "12345", "$1000" },
	            { "123456", "12345", "$1000" },
	            { "123456", "12345", "$1000" },
	            { "123456", "12345", "$1000" }        
		};
		table = new JTable(data,columnNames);
		table.setBounds(30, 40, 100, 200);
		JScrollPane sp = new JScrollPane(table);		
		sp.setBounds(0, 0, 690, 471);
		getContentPane().add(sp);
		this.setVisible(true);
	}
}
