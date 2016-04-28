package ba.unsa.etf.si.app.Inventura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ModifikacijaKorisnika {

	private JFrame frmModifikacijaKorisnika;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifikacijaKorisnika window = new ModifikacijaKorisnika();
					window.frmModifikacijaKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModifikacijaKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModifikacijaKorisnika = new JFrame();
		frmModifikacijaKorisnika.setTitle("Modifikacija korisnika");
		frmModifikacijaKorisnika.getContentPane().setBackground(new Color(255, 255, 255));
		frmModifikacijaKorisnika.getContentPane().setLayout(null);
		
		JLabel lblModifikacijaKorisnika = new JLabel("Modifikacija korisnika");
		lblModifikacijaKorisnika.setForeground(new Color(0, 128, 0));
		lblModifikacijaKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModifikacijaKorisnika.setBounds(43, 44, 134, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblModifikacijaKorisnika);
		
		JLabel lblImePrijavljenogKorisnika = new JLabel("ime prijavljenog korisnika");
		lblImePrijavljenogKorisnika.setForeground(new Color(0, 0, 0));
		lblImePrijavljenogKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImePrijavljenogKorisnika.setBounds(222, 21, 178, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblImePrijavljenogKorisnika);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(43, 69, 341, 2);
		frmModifikacijaKorisnika.getContentPane().add(separator);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setBounds(43, 94, 80, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblKorisnikoIme);
		
		textField = new JTextField();
		textField.setBounds(146, 91, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPretraga = new JButton("Pretraga");
		btnPretraga.setBounds(297, 90, 89, 23);
		frmModifikacijaKorisnika.getContentPane().add(btnPretraga);
		
		JCheckBox chckbxKorisnikPronaen = new JCheckBox("Korisnik pronađen");
		chckbxKorisnikPronaen.setBounds(275, 141, 119, 23);
		frmModifikacijaKorisnika.getContentPane().add(chckbxKorisnikPronaen);
		
		JLabel lblNovoKorisnikoIme = new JLabel("Novo korisničko ime:");
		lblNovoKorisnikoIme.setBounds(43, 196, 119, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblNovoKorisnikoIme);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 193, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNovaLozinka = new JLabel("Nova lozinka:");
		lblNovaLozinka.setBounds(77, 221, 64, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblNovaLozinka);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 218, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNivoPrivilegije = new JLabel("Nivo privilegije:");
		lblNivoPrivilegije.setBounds(61, 246, 80, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblNivoPrivilegije);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Radnik\r\nŠef");
		comboBox.setBounds(146, 243, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(comboBox);
		
		JButton btnZavri = new JButton("Završi");
		btnZavri.setBounds(22, 280, 89, 23);
		frmModifikacijaKorisnika.getContentPane().add(btnZavri);
		
		JButton btnSauvaj = new JButton("Sačuvaj");
		btnSauvaj.setBounds(314, 280, 89, 23);
		frmModifikacijaKorisnika.getContentPane().add(btnSauvaj);
		frmModifikacijaKorisnika.setBounds(100, 100, 445, 353);
		frmModifikacijaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
