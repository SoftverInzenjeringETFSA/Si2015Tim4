package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import ba.unsa.etf.si.app.Inventura.Model.Sef;
import ba.unsa.etf.si.app.Inventura.Model.Skladistar;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.Arrays;
import java.util.List;

public class RegistracijaNovogKorisnika {

	private JFrame frmRegistracijaNovogKorisnika;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<String> comboPrivilegije;
	
	private List<String> _priv = Arrays.asList("Sef","Skladistar");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistracijaNovogKorisnika window = new RegistracijaNovogKorisnika();
					window.frmRegistracijaNovogKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistracijaNovogKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistracijaNovogKorisnika = new JFrame();
		frmRegistracijaNovogKorisnika.setTitle("Registracija korisnika");
		frmRegistracijaNovogKorisnika.getContentPane().setBackground(SystemColor.control);
		frmRegistracijaNovogKorisnika.setBounds(100, 100, 450, 300);
		frmRegistracijaNovogKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistracijaNovogKorisnika.getContentPane().setLayout(null);
		
		JLabel lblRegistracijaNovogKorisnika = new JLabel("Registracija novog korisnika");
		lblRegistracijaNovogKorisnika.setBackground(new Color(255, 255, 255));
		lblRegistracijaNovogKorisnika.setBounds(43, 42, 195, 19);
		lblRegistracijaNovogKorisnika.setForeground(new Color(0, 128, 0));
		lblRegistracijaNovogKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmRegistracijaNovogKorisnika.getContentPane().add(lblRegistracijaNovogKorisnika);
		
		JLabel lblImePrijavljenogKorisnika = new JLabel("ime prijavljenog korisnika");
		lblImePrijavljenogKorisnika.setForeground(new Color(0, 0, 0));
		lblImePrijavljenogKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImePrijavljenogKorisnika.setBounds(289, 11, 176, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblImePrijavljenogKorisnika);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(43, 72, 367, 3);
		frmRegistracijaNovogKorisnika.getContentPane().add(separator);
		
		JLabel ime = new JLabel("Korisnicko ime:");
		ime.setBounds(122, 111, 80, 19);
		frmRegistracijaNovogKorisnika.getContentPane().add(ime);
		
		textField = new JTextField();
		textField.setBounds(226, 110, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lozinka = new JLabel("Lozinka:");
		lozinka.setBounds(132, 142, 67, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lozinka);
		
		textField_1 = new JTextField();
		textField_1.setBounds(226, 141, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNivoPrivilegija = new JLabel("Nivo privilegije:");
		lblNivoPrivilegija.setBounds(122, 173, 80, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblNivoPrivilegija);
		
		
		comboPrivilegije = new JComboBox<String>();
		if(_priv.size() != 0) {
			for(String m : _priv) {
				if(m != null) {
					comboPrivilegije.addItem(m);
				}
			}
		}
		comboPrivilegije.setToolTipText("Radnik\r\nŠef");
		comboPrivilegije.setBounds(226, 172, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(comboPrivilegije);
		
		JButton btnZavri = new JButton("Odustani");
		btnZavri.setBounds(88, 227, 89, 23);
		frmRegistracijaNovogKorisnika.getContentPane().add(btnZavri);
		
		JButton registruj = new JButton("Registruj");
		
		
		registruj.setToolTipText("");
		registruj.setBounds(278, 227, 89, 23);
		frmRegistracijaNovogKorisnika.getContentPane().add(registruj);
		
	}
	


}
