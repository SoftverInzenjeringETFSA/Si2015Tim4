package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;

import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
import ba.unsa.etf.si.app.Inventura.Model.ValidacijaArtikla;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

public class RegistracijaNovogKorisnika {

	private JFrame frmRegistracijaNovogKorisnika;
	private JTextField textIme;
	private JTextField textLozinka;
	private JComboBox<String> comboPrivilegije;
	
	private List<String> _priv = Arrays.asList("Sef","Skladistar");
	private JTextField textPrezime;
	private JTextField textJMBG;
	private JTextField textAdresa;
	private JTextField textBrojTelefona;
	private JTextField textEmail;
	private JTextField textKorisnickoIme;
	
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
	
	public static void pokreni() {
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
		frmRegistracijaNovogKorisnika.setBounds(100, 100, 551, 462);
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
		
		JLabel ime = new JLabel("Ime:");
		ime.setBounds(122, 86, 80, 19);
		frmRegistracijaNovogKorisnika.getContentPane().add(ime);
		
		textIme = new JTextField();
		textIme.setBounds(226, 86, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textIme);
		textIme.setColumns(10);
		
		JLabel lozinka = new JLabel("Lozinka:");
		lozinka.setBounds(122, 307, 67, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lozinka);
		
		textLozinka = new JTextField();
		textLozinka.setBounds(226, 304, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textLozinka);
		textLozinka.setColumns(10);
		
		JLabel lblNivoPrivilegija = new JLabel("Nivo privilegije:");
		lblNivoPrivilegija.setBounds(122, 332, 80, 14);
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
		comboPrivilegije.setBounds(226, 329, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(comboPrivilegije);
		
		JButton btnZavri = new JButton("Odustani");
		btnZavri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frmRegistracijaNovogKorisnika.dispose();
			frmRegistracijaNovogKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnZavri.setBounds(43, 389, 89, 23);
		frmRegistracijaNovogKorisnika.getContentPane().add(btnZavri);
		
		JButton registruj = new JButton("Registruj");
		
		registruj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
						TipZaposlenika a= new TipZaposlenika();
						a=dodajZaposlenika();
						TipZaposlenikaKontroler.dodaj(a);
					}					
				
				catch(Exception i){
					Component frame = null;
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		
		
		registruj.setToolTipText("");
		registruj.setBounds(376, 389, 89, 23);
		frmRegistracijaNovogKorisnika.getContentPane().add(registruj);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(122, 116, 46, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblPrezime);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(226, 117, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textPrezime);
		textPrezime.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBounds(122, 151, 46, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblJmbg);
		
		textJMBG = new JTextField();
		textJMBG.setBounds(226, 148, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textJMBG);
		textJMBG.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setBounds(122, 176, 46, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblAdresa);
		
		textAdresa = new JTextField();
		textAdresa.setBounds(226, 179, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textAdresa);
		textAdresa.setColumns(10);
		
		JLabel lblBrojtel = new JLabel("Broj telefona:");
		lblBrojtel.setBounds(122, 213, 80, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblBrojtel);
		
		textBrojTelefona = new JTextField();
		textBrojTelefona.setBounds(226, 210, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textBrojTelefona);
		textBrojTelefona.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(122, 251, 46, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(226, 248, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setBounds(122, 282, 80, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblKorisnikoIme);
		
		textKorisnickoIme = new JTextField();
		textKorisnickoIme.setBounds(226, 273, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textKorisnickoIme);
		textKorisnickoIme.setColumns(10);
	}
		public TipZaposlenika dodajZaposlenika()
		{
			String imeZaposlenika = textIme.getText();
			String prezime = textPrezime.getText();
			String JMBG = textJMBG.getText();
			String adresa = textAdresa.getText();
			String brojTelefona = textBrojTelefona.getText();
			String email = textEmail.getText();
			String korisnickoIme = textKorisnickoIme.getText();
			String sifraZaposlenik = textLozinka.getText();
			String nivoPrivilegije =(String) comboPrivilegije.getSelectedItem();
			TipZaposlenika novi = new TipZaposlenika();
			try
			{
				novi = new TipZaposlenika(imeZaposlenika, prezime, JMBG, adresa, brojTelefona, email, korisnickoIme, sifraZaposlenik, nivoPrivilegije);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return novi;
		
	}
}
