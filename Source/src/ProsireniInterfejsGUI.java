import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JList;

public class ProsireniInterfejsGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProsireniInterfejsGUI window = new ProsireniInterfejsGUI();
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
	public ProsireniInterfejsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 887, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 24, 272, 539);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Naziv proizvoda", "Koli\u010Dina"
			}
		));
		
		JLabel lblDokument = new JLabel("Novi ulazni dokument");
		lblDokument.setVerticalAlignment(SwingConstants.TOP);
		lblDokument.setHorizontalAlignment(SwingConstants.LEFT);
		lblDokument.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDokument.setBackground(SystemColor.menu);
		lblDokument.setBounds(329, 24, 289, 39);
		frame.getContentPane().add(lblDokument);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(329, 72, 289, 2);
		frame.getContentPane().add(separator);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(415, 102, 203, 20);
		frame.getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("Artikal ID:");
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(341, 98, 63, 21);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Naziv artikla:");
		label_2.setVerticalAlignment(SwingConstants.BOTTOM);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(329, 133, 75, 21);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		textField_1.setBounds(415, 134, 203, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel label_3 = new JLabel("Klasa artikla:");
		label_3.setVerticalAlignment(SwingConstants.BOTTOM);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(329, 165, 75, 21);
		frame.getContentPane().add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(415, 169, 203, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblProdaja = new JLabel("Prodaja:");
		lblProdaja.setVerticalAlignment(SwingConstants.BOTTOM);
		lblProdaja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProdaja.setBounds(329, 200, 75, 21);
		frame.getContentPane().add(lblProdaja);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(415, 204, 203, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblKoliina = new JLabel("Koli\u010Dina:");
		lblKoliina.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKoliina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKoliina.setBounds(329, 244, 75, 21);
		frame.getContentPane().add(lblKoliina);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(415, 245, 102, 20);
		frame.getContentPane().add(textField_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(525, 241, 93, 27);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblCijena = new JLabel("Cijena:");
		lblCijena.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCijena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCijena.setBounds(329, 281, 75, 21);
		frame.getContentPane().add(lblCijena);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setColumns(10);
		textField_3.setBounds(415, 282, 102, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setHorizontalAlignment(SwingConstants.LEFT);
		lblKm.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKm.setBounds(525, 288, 46, 14);
		frame.getContentPane().add(lblKm);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(415, 343, 203, 20);
		frame.getContentPane().add(comboBox_3);
		
		JLabel lblTipDokumenta = new JLabel("Tip dokumenta:");
		lblTipDokumenta.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTipDokumenta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipDokumenta.setBounds(311, 339, 93, 21);
		frame.getContentPane().add(lblTipDokumenta);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(329, 394, 289, 95);
		frame.getContentPane().add(textArea);
		
		JLabel lblKomentar = new JLabel("Komentar:");
		lblKomentar.setHorizontalAlignment(SwingConstants.LEFT);
		lblKomentar.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKomentar.setBounds(329, 369, 63, 14);
		frame.getContentPane().add(lblKomentar);
		
		JButton button = new JButton("<< Dodaj artikal");
		button.setBounds(329, 540, 122, 23);
		frame.getContentPane().add(button);
		
		JButton btnZakljuiDokument = new JButton("Zaklju\u010Di dokument");
		btnZakljuiDokument.setBounds(475, 540, 143, 23);
		frame.getContentPane().add(btnZakljuiDokument);
		
		JList list = new JList();
		list.setBounds(658, 102, 187, 387);
		frame.getContentPane().add(list);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(658, 72, 187, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel label = new JLabel("ime prijavljenog korisnika");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(631, 31, 214, 37);
		frame.getContentPane().add(label);
		
		JLabel lblUestvujuUKreiranju = new JLabel("U\u010Destvuju u kreiranju dokumenta:");
		lblUestvujuUKreiranju.setHorizontalAlignment(SwingConstants.LEFT);
		lblUestvujuUKreiranju.setBounds(658, 85, 214, 14);
		frame.getContentPane().add(lblUestvujuUKreiranju);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnSistem = new JMenu("Sistem");
		menuBar.add(mnSistem);
		
		JMenu mnNovi = new JMenu("Novi");
		mnSistem.add(mnNovi);
		
		JMenuItem mntmUlazniDokument = new JMenuItem("Ulazni dokument");
		mntmUlazniDokument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblDokument.setText("Novi ulazni dokument");
			}
		});
		mnNovi.add(mntmUlazniDokument);
		
		JMenuItem mntmIzlazniDokument = new JMenuItem("Izlazni dokument");
		mntmIzlazniDokument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblDokument.setText("Novi izlazni dokument");
			}
		});
		mnNovi.add(mntmIzlazniDokument);
		
		JMenuItem mntmInventura = new JMenuItem("Inventura");
		mnNovi.add(mntmInventura);
		
		JMenuBar menuBar_2 = new JMenuBar();
		mnNovi.add(menuBar_2);
		
		JMenuItem mntmOdjava = new JMenuItem("Odjava");
		mnSistem.add(mntmOdjava);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnSistem.add(menuBar_1);
		
		JMenu mnPostavke = new JMenu("Postavke");
		menuBar.add(mnPostavke);
		
		JMenu mnAdministracija = new JMenu("Administracija");
		menuBar.add(mnAdministracija);
		
		JMenu mnArtikli = new JMenu("Artikli");
		mnAdministracija.add(mnArtikli);
		
		JMenuItem mntmUnos = new JMenuItem("Unos");
		mnArtikli.add(mntmUnos);
		
		JMenuItem mntmModifikacija = new JMenuItem("Modifikacija");
		mntmModifikacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifikacijaArtiklaGUI forma=new ModifikacijaArtiklaGUI();
				forma.main(null);
			}
		});
		mnArtikli.add(mntmModifikacija);
		
		JMenuItem mntmBrisanje = new JMenuItem("Brisanje");
		mnArtikli.add(mntmBrisanje);
		
		JMenuBar menuBar_4 = new JMenuBar();
		mnArtikli.add(menuBar_4);
		
		JMenu mnKorisnici = new JMenu("Korisnici");
		mnAdministracija.add(mnKorisnici);
		
		JMenuItem mntmUnos_1 = new JMenuItem("Unos");
		mnKorisnici.add(mntmUnos_1);
		
		JMenuItem mntmModifikacija_1 = new JMenuItem("Modifikacija");
		mnKorisnici.add(mntmModifikacija_1);
		
		JMenuItem mntmBrisanje_1 = new JMenuItem("Brisanje");
		mnKorisnici.add(mntmBrisanje_1);
		
		JMenuBar menuBar_5 = new JMenuBar();
		mnKorisnici.add(menuBar_5);
		
		JMenuBar menuBar_3 = new JMenuBar();
		mnAdministracija.add(menuBar_3);
	}
}
