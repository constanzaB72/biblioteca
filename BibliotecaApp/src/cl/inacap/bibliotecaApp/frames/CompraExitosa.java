package cl.inacap.bibliotecaApp.frames;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CompraExitosa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton; 

	public CompraExitosa() {
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("ACEPTAR");
				getRootPane().setDefaultButton(okButton);
				getContentPane().add(okButton);
			}
		}
	}
	
	public void addFinalizarListener(ActionListener ing) {
		okButton.addActionListener(ing);
	}
}

