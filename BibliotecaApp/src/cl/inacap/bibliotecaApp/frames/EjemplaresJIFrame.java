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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public EjemplaresJIFrame() {
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 700, 500);
		String[] columnNames = { "N° de Serie", "ISBN", "Título" };
		String[][] data = {
	            { "123456", "1234567890123", "Papelucho" },
	            { "123456", "1234567890123", "Sherlock Holmes" },
	            { "123456", "1234567890123", "Sherlock Holmes" },
	            { "123456", "1234567890123", "Puerto Estelar" },
	            { "123456", "1234567890123", "Ana Frank" }        
		};
		table = new JTable(data,columnNames);
		table.setBounds(30, 40, 200, 300);
		table.setBorder(getBorder());
		JScrollPane sp = new JScrollPane(table);		
		getContentPane().add(sp, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
