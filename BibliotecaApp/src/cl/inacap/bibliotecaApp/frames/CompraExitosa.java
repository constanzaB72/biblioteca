package cl.inacap.bibliotecaApp.frames;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CompraExitosa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar; 
	private JLabel lblAlerta;

	public CompraExitosa() {
		getContentPane().setLayout(null);
		
		lblAlerta = new JLabel("¡Registro Exitoso!");
		lblAlerta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlerta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlerta.setBounds(0, 120, 436, 14);
		getContentPane().add(lblAlerta);
		
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 253, 386, 10);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{

				btnAceptar = new JButton("ACEPTAR");
				btnAceptar.setBounds(170, 145, 89, 23);
				getContentPane().add(btnAceptar);
			
			}}
	}
	
	public void addFinalizarListener(ActionListener ing) {
		btnAceptar.addActionListener(ing);
	}
}
