package cl.inacap.bibliotecaApp.frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class EjemplaresJIFrame extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);

	}

}
