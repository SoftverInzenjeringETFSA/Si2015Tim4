package ba.unsa.etf.si.app.Inventura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UnosSkladistaGUI {

	private JFrame frmUnosSkladita;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosSkladistaGUI window = new UnosSkladistaGUI();
					window.frmUnosSkladita.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnosSkladistaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUnosSkladita = new JFrame();
		frmUnosSkladita.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmUnosSkladita.setTitle("Unos skladišta");
		frmUnosSkladita.setBounds(100, 100, 440, 279);
		frmUnosSkladita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUnosSkladita.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unos skladišta");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 34, 198, 35);
		frmUnosSkladita.getContentPane().add(lblNewLabel);
		
		JLabel lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(347, 54, 46, 14);
		frmUnosSkladita.getContentPane().add(lblKorisnik);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 87, 371, 14);
		frmUnosSkladita.getContentPane().add(separator);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNaziv.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNaziv.setBounds(75, 115, 46, 14);
		frmUnosSkladita.getContentPane().add(lblNaziv);
		
		JLabel lblLokacija = new JLabel("Lokacija:");
		lblLokacija.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLokacija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLokacija.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLokacija.setBounds(69, 147, 52, 14);
		frmUnosSkladita.getContentPane().add(lblLokacija);
		
		textField = new JTextField();
		textField.setBounds(131, 112, 207, 20);
		frmUnosSkladita.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(131, 144, 207, 20);
		frmUnosSkladita.getContentPane().add(textField_1);
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUnesi.setBounds(304, 191, 89, 23);
		frmUnosSkladita.getContentPane().add(btnUnesi);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOdustani.setBounds(24, 191, 89, 23);
		frmUnosSkladita.getContentPane().add(btnOdustani);
	}

}
