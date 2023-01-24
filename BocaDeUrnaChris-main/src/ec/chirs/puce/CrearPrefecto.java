package ec.chirs.puce;

import javax.swing.JInternalFrame;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CrearPrefecto extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField txtName;

	private Prefecto prefecto;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnAgregar2;
	private JButton btnNuevo2;
	private JButton btnSalir;

	private List<Prefecto> prefectos;
	private int idPrefecto;
	
	public CrearPrefecto(List<Prefecto> prefectos) {
		idPrefecto=1;
		this.prefectos=prefectos;
		setTitle("CANDIDATOS A PREFECTO");
		setBounds(100, 100, 443, 385);
		getContentPane().setLayout(null);

		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(30, 25, 70, 15);
		getContentPane().add(lblNombres);

		txtName = new JTextField();
		txtName.setBounds(97, 23, 231, 19);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		btnNuevo2 = new JButton("Nuevo");
		btnNuevo2.addActionListener(this);
		btnNuevo2.setBounds(30, 72, 117, 25);
		getContentPane().add(btnNuevo2);

		btnAgregar2 = new JButton("Agregar");
		btnAgregar2.addActionListener(this);
		btnAgregar2.setBounds(157, 72, 117, 25);
		getContentPane().add(btnAgregar2);

		btnSalir = new JButton("Cancelar");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(286, 72, 117, 25);
		getContentPane().add(btnSalir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 115, 416, 224);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre" }));
		scrollPane.setViewportView(table);

		model = (DefaultTableModel) table.getModel();
		agregarFila();
	}

	private void nuevo() {
		prefecto = new Prefecto();
		// Limpiar los campos de texto
        txtName.setText("");
	 	}

	private void agregarPrefecto() {
        prefecto = new Prefecto();
        prefecto.setNombre(txtName.getText());
        prefectos.add(prefecto);
        txtName.setText("");
        model.addRow(new Object[] {prefecto.getNombre()});
        idPrefecto++;
    }

	private void agregarFila() {
        model.setRowCount(0);
        for (Prefecto prefecto : prefectos) {
            model.addRow(new Object[] {prefecto.getNombre()});
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo2) {
			nuevo();
		} else if (e.getSource() == btnAgregar2) {
			agregarPrefecto();
		} else if (e.getSource() == btnSalir) {
			dispose();
		}
	}

	public List<Prefecto> getPrefectos() {
		return prefectos;
	}

	public void setPrefectos(List<Prefecto> prefectos) {
		this.prefectos = prefectos;
	}

}
