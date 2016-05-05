package ba.unsa.etf.si.app.Inventura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JList;
import java.awt.SystemColor;

public class ModifikacijaArtiklaGUI {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifikacijaArtiklaGUI window = new ModifikacijaArtiklaGUI();
					window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	public ModifikacijaArtiklaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 515, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modifikacija artikla");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(24, 30, 183, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblImePrijavljenogKorisnika = new JLabel("ime prijavljenog korisnika");
		lblImePrijavljenogKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImePrijavljenogKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImePrijavljenogKorisnika.setVerticalAlignment(SwingConstants.BOTTOM);
		lblImePrijavljenogKorisnika.setBounds(304, 11, 134, 37);
		frame.getContentPane().add(lblImePrijavljenogKorisnika);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 80, 414, 7);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Postojeći artikli:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setBounds(10, 112, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNazivArtikla = new JLabel("Naziv artikla:");
		lblNazivArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNazivArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivArtikla.setBounds(215, 129, 79, 14);
		frame.getContentPane().add(lblNazivArtikla);
		
		JLabel lblKlasaArtikla = new JLabel("Klasa artikla:");
		lblKlasaArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKlasaArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKlasaArtikla.setBounds(215, 154, 79, 14);
		frame.getContentPane().add(lblKlasaArtikla);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(304, 126, 134, 20);
		frame.getContentPane().add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(304, 151, 134, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnSauvaj = new JButton("Sa\u010Duvaj");
		btnSauvaj.setBounds(365, 300, 89, 23);
		frame.getContentPane().add(btnSauvaj);
		
		JButton btnZavri = new JButton("Odustani");
		btnZavri.setBounds(221, 300, 89, 23);
		frame.getContentPane().add(btnZavri);
		
		JLabel lblBarKod = new JLabel("Bar kod:");
		lblBarKod.setBounds(248, 179, 46, 14);
		frame.getContentPane().add(lblBarKod);
		
		textField = new JTextField();
		textField.setBounds(304, 176, 134, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Količina:");
		lblNewLabel_2.setBounds(248, 204, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cijena:");
		lblNewLabel_3.setBounds(248, 229, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mjerna jedinica:");
		lblNewLabel_4.setBounds(215, 254, 79, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(304, 201, 134, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(304, 226, 134, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(318, 251, 96, 20);
		frame.getContentPane().add(comboBox_1);
		
		JList list = new JList();
		list.setBounds(24, 136, 183, 187);
		frame.getContentPane().add(list);
	}
}
