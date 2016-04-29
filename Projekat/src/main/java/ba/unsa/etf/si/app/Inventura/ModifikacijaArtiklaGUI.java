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

public class ModifikacijaArtiklaGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 459, 357);
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
		lblImePrijavljenogKorisnika.setBounds(280, 11, 134, 37);
		frame.getContentPane().add(lblImePrijavljenogKorisnika);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 80, 390, 7);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Arikal ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setBounds(24, 111, 67, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNazivArtikla = new JLabel("Naziv artikla:");
		lblNazivArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNazivArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivArtikla.setBounds(111, 195, 79, 14);
		frame.getContentPane().add(lblNazivArtikla);
		
		JLabel lblKlasaArtikla = new JLabel("Klasa artikla:");
		lblKlasaArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKlasaArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKlasaArtikla.setBounds(111, 220, 79, 14);
		frame.getContentPane().add(lblKlasaArtikla);
		
		textField = new JTextField();
		textField.setBounds(101, 108, 214, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(200, 192, 214, 20);
		frame.getContentPane().add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(200, 217, 214, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnPretraga = new JButton("Pretraga");
		btnPretraga.setBounds(325, 107, 89, 23);
		frame.getContentPane().add(btnPretraga);
		
		JButton btnSauvaj = new JButton("Sa\u010Duvaj");
		btnSauvaj.setBounds(325, 268, 89, 23);
		frame.getContentPane().add(btnSauvaj);
		
		JButton btnZavri = new JButton("Zavr\u0161i");
		btnZavri.setBounds(24, 268, 89, 23);
		frame.getContentPane().add(btnZavri);
		
		JCheckBox chckbxArtikalPronaen = new JCheckBox("Artikal prona\u0111en");
		chckbxArtikalPronaen.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxArtikalPronaen.setBounds(280, 152, 134, 23);
		frame.getContentPane().add(chckbxArtikalPronaen);
	}

}
