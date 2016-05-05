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
	private JTextField textField_1;
	private JTextField textField_2;

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
		frame.setBounds(100, 100, 698, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novi popis robe");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(332, 25, 289, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Unesite bar kod artikla:");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(264, 104, 143, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNazivArtikla = new JLabel("Izbrojana količina:");
		lblNazivArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNazivArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivArtikla.setBounds(295, 139, 112, 21);
		frame.getContentPane().add(lblNazivArtikla);
		
		textField_1 = new JTextField();
		textField_1.setBounds(418, 108, 203, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(332, 71, 289, 2);
		frame.getContentPane().add(separator);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(417, 143, 102, 20);
		frame.getContentPane().add(textField_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(528, 140, 93, 27);
		frame.getContentPane().add(comboBox_2);
		
		JButton btnDodajArtikal = new JButton("Dodaj artikal");
		btnDodajArtikal.setBounds(393, 198, 122, 23);
		frame.getContentPane().add(btnDodajArtikal);
		
		JButton button_1 = new JButton("Zaklju\u010Di dokument");
		button_1.setBounds(484, 246, 143, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label_4 = new JLabel("ime prijavljenog korisnika");
		label_4.setVerticalAlignment(SwingConstants.BOTTOM);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(458, 2, 214, 37);
		frame.getContentPane().add(label_4);
		
		JList list = new JList();
		list.setBounds(23, 51, 231, 251);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Popisani artikli:");
		lblNewLabel_2.setBounds(23, 25, 143, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Odustani");
		btnNewButton.setBounds(311, 246, 140, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
