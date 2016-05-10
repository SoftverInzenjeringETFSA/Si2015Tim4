package ba.unsa.etf.si.app.Inventura.GUI;

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
import java.awt.SystemColor;
import javax.swing.JList;

public class ModifikacijaKorisnika {

	private JFrame frmModifikacijaKorisnika;

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
	public void postaviListu(){
		
		
		
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModifikacijaKorisnika = new JFrame();
		frmModifikacijaKorisnika.setTitle("Modifikacija korisnika");
		frmModifikacijaKorisnika.getContentPane().setBackground(SystemColor.control);
		frmModifikacijaKorisnika.getContentPane().setLayout(null);
		
		JLabel lblModifikacijaKorisnika = new JLabel("Modifikacija korisnika");
		lblModifikacijaKorisnika.setForeground(new Color(0, 128, 0));
		lblModifikacijaKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModifikacijaKorisnika.setBounds(43, 44, 134, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblModifikacijaKorisnika);
		
		JLabel lblImePrijavljenogKorisnika = new JLabel("ime prijavljenog korisnika");
		lblImePrijavljenogKorisnika.setForeground(new Color(0, 0, 0));
		lblImePrijavljenogKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImePrijavljenogKorisnika.setBounds(265, 22, 178, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblImePrijavljenogKorisnika);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(43, 69, 341, 2);
		frmModifikacijaKorisnika.getContentPane().add(separator);
		
		JLabel lblKorisnikoIme = new JLabel("Registrovani korisnici:");
		lblKorisnikoIme.setBounds(43, 94, 150, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblKorisnikoIme);
		
		JLabel lblNivoPrivilegije = new JLabel("Nivo privilegije:");
		lblNivoPrivilegije.setBounds(231, 142, 80, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblNivoPrivilegije);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Radnik\r\nŠef");
		comboBox.setBounds(233, 175, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(comboBox);
		
		JButton btnZavri = new JButton("Odustani");
		btnZavri.setBounds(222, 280, 89, 23);
		frmModifikacijaKorisnika.getContentPane().add(btnZavri);
		
		JButton btnSauvaj = new JButton("Sačuvaj");
		btnSauvaj.setBounds(330, 280, 89, 23);
		frmModifikacijaKorisnika.getContentPane().add(btnSauvaj);
		
		JList list = new JList();
		list.setBounds(43, 119, 150, 184);
		frmModifikacijaKorisnika.getContentPane().add(list);
		postavilistu();
		frmModifikacijaKorisnika.setBounds(100, 100, 445, 353);
		frmModifikacijaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
