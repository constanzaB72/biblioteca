package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cl.inacap.bibliotecaApp.frames.EjemplaresFrame;

public class EjemplaresController {
	private EjemplaresFrame ejemplaresFrame;

	public EjemplaresController() {
		ejemplaresFrame = new EjemplaresFrame();
		ejemplaresFrame.addAceptar(new AceptarListener());

	}

	class AceptarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ejemplaresFrame.setVisible(false);
			ejemplaresFrame.dispose();

		}
	}

}
