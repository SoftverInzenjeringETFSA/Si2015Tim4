package ba.unsa.etf.si.app.Inventura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class InventuraGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventuraGUI window = new InventuraGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventuraGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 899, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sistem");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Postavke");
		menuBar.add(mnNewMenu_1);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novi popis robe");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(332, 25, 289, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Artikal ID:");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(344, 104, 63, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNazivArtikla = new JLabel("Naziv artikla:");
		lblNazivArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNazivArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivArtikla.setBounds(332, 139, 75, 21);
		frame.getContentPane().add(lblNazivArtikla);
		
		JLabel lblKlasaArtikla = new JLabel("Klasa artikla:");
		lblKlasaArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKlasaArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKlasaArtikla.setBounds(332, 171, 75, 21);
		frame.getContentPane().add(lblKlasaArtikla);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(418, 140, 203, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(418, 108, 203, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(418, 175, 203, 20);
		frame.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 25, 279, 521);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Naziv proizvoda", "Koli\u010Dina"
			}
		));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(332, 71, 289, 2);
		frame.getContentPane().add(separator);
		
		JLabel label = new JLabel("Prodaja:");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(332, 203, 75, 21);
		frame.getContentPane().add(label);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(418, 207, 203, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel label_1 = new JLabel("Koli\u010Dina:");
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(332, 247, 75, 21);
		frame.getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(418, 248, 102, 20);
		frame.getContentPane().add(textField_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(528, 244, 93, 27);
		frame.getContentPane().add(comboBox_2);
		
		JLabel label_2 = new JLabel("Cijena:");
		label_2.setVerticalAlignment(SwingConstants.BOTTOM);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(332, 284, 75, 21);
		frame.getContentPane().add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setColumns(10);
		textField_3.setBounds(418, 285, 102, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel label_3 = new JLabel("KM");
		label_3.setVerticalAlignment(SwingConstants.BOTTOM);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setBounds(528, 291, 46, 14);
		frame.getContentPane().add(label_3);
		
		JButton button = new JButton("<< Dodaj artikal");
		button.setBounds(332, 523, 122, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Zaklju\u010Di dokument");
		button_1.setBounds(490, 523, 143, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label_4 = new JLabel("ime prijavljenog korisnika");
		label_4.setVerticalAlignment(SwingConstants.BOTTOM);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(646, 30, 214, 37);
		frame.getContentPane().add(label_4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(673, 71, 187, 2);
		frame.getContentPane().add(separator_1);
		
		JList list = new JList();
		list.setBounds(673, 104, 187, 373);
		frame.getContentPane().add(list);
		
		JLabel label_5 = new JLabel("U\u010Destvuju u kreiranju dokumenta:");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setBounds(673, 90, 214, 14);
		frame.getContentPane().add(label_5);
	}
}
