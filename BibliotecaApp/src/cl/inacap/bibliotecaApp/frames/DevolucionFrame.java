package cl.inacap.bibliotecaApp.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cl.inacap.biblioteca.utils.ButtonColumn;
import cl.inacap.bibliotecaModel.dao.ArriendosDAO;
import cl.inacap.bibliotecaModel.dao.EjemplarDAO;
import cl.inacap.bibliotecaModel.dto.Arriendo;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Libro;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class DevolucionFrame extends JFrame {
	JTable table;
	private JTextField txtClienteDevolucion;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JButton btnMulta; 
	private JButton btnBuscar;
	private JTextField txtMonto;

	public DevolucionFrame() {
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 700, 500);
		
		ArriendosDAO arriendosDAO = new ArriendosDAO();
		List<Arriendo> listaArriendos = arriendosDAO.getByRutCliente("20.780.661-7");

		String[] columnNames = { "Id Arriendo", "Fecha de Arriendo", "Fecha de Entrega", "Dias de Retraso", "Multa",
				"Costo total" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);
		if (listaArriendos != null && !listaArriendos.isEmpty()) {
			for (int fila = 0; fila < listaArriendos.size(); fila++) {
				Object[] columna = new Object[] { listaArriendos.get(fila).getIdArriendo(),
						listaArriendos.get(fila).getFechaArriendo(), listaArriendos.get(fila).getFechaEntrega(),
						listaArriendos.get(fila).getDiasRetraso(), listaArriendos.get(fila).getMulta(),
						listaArriendos.get(fila).getCostoTotal() };
				model.addRow(columna);
			}

		}
		table.setBounds(30, 40, 100, 200);
		JScrollPane sp2 = new JScrollPane(table);
		sp2.setBounds(29, 171, 651, 150);
		getContentPane().add(sp2);

		JLabel lblClienteDevolucion = new JLabel("Rut de Cliente: ");
		lblClienteDevolucion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClienteDevolucion.setBounds(29, 101, 200, 30);
		getContentPane().add(lblClienteDevolucion);

		txtClienteDevolucion = new JTextField();
		txtClienteDevolucion.setBounds(29, 130, 200, 30);
		getContentPane().add(txtClienteDevolucion);
		txtClienteDevolucion.setColumns(10);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(533, 415, 100, 23);
		getContentPane().add(btnConfirmar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(423, 415, 100, 23);
		getContentPane().add(btnCancelar);

		JLabel lblHeader = new JLabel("");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setIcon(new ImageIcon(DevolucionFrame.class.getResource("/img/fastheader.jpg")));
		lblHeader.setBounds(0, 0, 700, 90);
		getContentPane().add(lblHeader);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(239, 130, 89, 30);
		getContentPane().add(btnBuscar);

		JLabel lblMontoMulta = new JLabel("Monto multa:");
		lblMontoMulta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMontoMulta.setBounds(29, 331, 200, 30);
		getContentPane().add(lblMontoMulta);

		txtMonto = new JTextField();
		txtMonto.setBounds(29, 358, 175, 30);
		getContentPane().add(txtMonto);
		txtMonto.setColumns(10);

		btnMulta = new JButton("Aplicar multa");
		btnMulta.setBounds(214, 362, 113, 23);
		getContentPane().add(btnMulta);

		this.setVisible(true);

	}

	public void addConfirmarAgregar(ActionListener ing) {
		btnConfirmar.addActionListener(ing);
	}
	public void addAplicarMulta(ActionListener ing) {
		btnMulta.addActionListener(ing);
	}

	public void addCancelarAgregar(ActionListener ing) {
		btnCancelar.addActionListener(ing);
	}

	public void addBuscarRut(ActionListener ing) {
		btnBuscar.addActionListener(ing);
	}
}
