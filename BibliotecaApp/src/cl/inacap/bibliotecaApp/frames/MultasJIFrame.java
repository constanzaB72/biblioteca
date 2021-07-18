package cl.inacap.bibliotecaApp.frames;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MultasJIFrame extends JInternalFrame {
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultasJIFrame frame = new MultasJIFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MultasJIFrame() {
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
		getContentPane().setLayout(null);
		table = new JTable(data,columnNames);
		table.setBounds(30, 40, 100, 200);
		JScrollPane sp = new JScrollPane(table);		
		sp.setBounds(0, 0, 690, 471);
		getContentPane().add(sp);
		this.setVisible(true);
	}
}

