package ba.unsa.etf.si.app.Inventura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UklanjanjeKorisnika {

	private JFrame frmUklanjanjeKorisnika;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UklanjanjeKorisnika window = new UklanjanjeKorisnika();
					window.frmUklanjanjeKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UklanjanjeKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUklanjanjeKorisnika = new JFrame();
		frmUklanjanjeKorisnika.getContentPane().setBackground(new Color(255, 255, 255));
		frmUklanjanjeKorisnika.setTitle("Uklanjanje korisnika");
		frmUklanjanjeKorisnika.setBackground(new Color(255, 255, 255));
		frmUklanjanjeKorisnika.setBounds(100, 100, 450, 300);
		frmUklanjanjeKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUklanjanjeKorisnika.getContentPane().setLayout(null);
		
		JLabel lblUklanjanjeKorisnika = new JLabel("Uklanjanje korisnika");
		lblUklanjanjeKorisnika.setForeground(new Color(0, 128, 0));
		lblUklanjanjeKorisnika.setBackground(new Color(0, 128, 0));
		lblUklanjanjeKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUklanjanjeKorisnika.setBounds(42, 44, 148, 20);
		frmUklanjanjeKorisnika.getContentPane().add(lblUklanjanjeKorisnika);
		
		JLabel lblImePrijavljenogKorisnika = new JLabel("ime prijavljenog korisnika");
		lblImePrijavljenogKorisnika.setForeground(new Color(0, 0, 0));
		lblImePrijavljenogKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImePrijavljenogKorisnika.setBounds(253, 11, 128, 18);
		frmUklanjanjeKorisnika.getContentPane().add(lblImePrijavljenogKorisnika);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(42, 75, 350, 2);
		frmUklanjanjeKorisnika.getContentPane().add(separator);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setBounds(85, 100, 79, 14);
		frmUklanjanjeKorisnika.getContentPane().add(lblKorisnikoIme);
		
		textField = new JTextField();
		textField.setBounds(188, 97, 204, 20);
		frmUklanjanjeKorisnika.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnZavri = new JButton("Završi");
		btnZavri.setBounds(42, 190, 89, 23);
		frmUklanjanjeKorisnika.getContentPane().add(btnZavri);
		
		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.setBounds(303, 190, 89, 23);
		frmUklanjanjeKorisnika.getContentPane().add(btnUkloni);
	}

}
