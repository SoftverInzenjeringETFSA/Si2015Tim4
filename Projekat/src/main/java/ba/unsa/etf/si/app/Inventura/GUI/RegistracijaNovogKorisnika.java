package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
//import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
//import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;
//import ba.unsa.etf.si.app.Inventura.Model.Artikal;
//import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;

import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
//import ba.unsa.etf.si.app.Inventura.Model.ValidacijaArtikla;

import javax.swing.JTextField;
//import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
//import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import org.apache.log4j.Logger;

public class RegistracijaNovogKorisnika {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTextField textIme;
	private JComboBox<String> comboPrivilegije;
	
	private List<String> _priv = Arrays.asList("Sef","Skladistar");
	private JTextField textPrezime;
	private JTextField textJMBG;
	private JTextField textAdresa;
	private JTextField textBrojTelefona;
	private JTextField textEmail;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
			
				try {
					RegistracijaNovogKorisnika window = new RegistracijaNovogKorisnika();
					window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.info(e);
				}
			}
		});
	}
	
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RegistracijaNovogKorisnika window = new RegistracijaNovogKorisnika();
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.info(e);
				}
			}
		});
	}
	
	public static void pokreni(final JFrame _frameRoditelj, final TipZaposlenika _korisnik) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RegistracijaNovogKorisnika window = new RegistracijaNovogKorisnika();
					
					window.frameRoditelj=_frameRoditelj;
					window.korisnik=_korisnik;
					window.lblKorisnik.setText(window.korisnik.getIme().toUpperCase());
					
					FormaKontroler.postaviFormu(window.frameRoditelj, window.frame, false);
				} catch (Exception e) {
					logger.info(e);
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
		frame = new JFrame();
		frame.setTitle("Registracija korisnika");
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 551, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistracijaNovogKorisnika = new JLabel("Registracija novog korisnika");
		lblRegistracijaNovogKorisnika.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistracijaNovogKorisnika.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRegistracijaNovogKorisnika.setBackground(new Color(255, 255, 255));
		lblRegistracijaNovogKorisnika.setBounds(43, 42, 195, 19);
		lblRegistracijaNovogKorisnika.setForeground(new Color(0, 128, 0));
		lblRegistracijaNovogKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblRegistracijaNovogKorisnika);
		
		lblKorisnik = new JLabel("ime prijavljenog korisnika");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setForeground(new Color(0, 0, 0));
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(248, 46, 160, 14);
		frame.getContentPane().add(lblKorisnik);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(43, 72, 367, 3);
		frame.getContentPane().add(separator);
		
		JLabel ime = new JLabel("Ime:");
		ime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ime.setBounds(122, 86, 80, 19);
		frame.getContentPane().add(ime);
		
		textIme = new JTextField();
		textIme.setBounds(226, 86, 152, 20);
		frame.getContentPane().add(textIme);
		textIme.setColumns(10);
		
		JLabel lblNivoPrivilegija = new JLabel("Nivo privilegije:");
		lblNivoPrivilegija.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNivoPrivilegija.setBounds(123, 283, 80, 14);
		frame.getContentPane().add(lblNivoPrivilegija);
		
		
		comboPrivilegije = new JComboBox<String>();
		if(_priv.size() != 0) {
			for(String m : _priv) {
				if(m != null) {
					comboPrivilegije.addItem(m);
				}
			}
		}
		comboPrivilegije.setToolTipText("Radnik\r\nŠef");
		comboPrivilegije.setBounds(227, 280, 152, 20);
		frame.getContentPane().add(comboPrivilegije);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrezime.setBounds(122, 116, 46, 14);
		frame.getContentPane().add(lblPrezime);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(226, 117, 152, 20);
		frame.getContentPane().add(textPrezime);
		textPrezime.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJmbg.setBounds(122, 151, 46, 14);
		frame.getContentPane().add(lblJmbg);
		
		textJMBG = new JTextField();
		textJMBG.setBounds(226, 148, 152, 20);
		frame.getContentPane().add(textJMBG);
		textJMBG.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdresa.setBounds(122, 176, 46, 14);
		frame.getContentPane().add(lblAdresa);
		
		textAdresa = new JTextField();
		textAdresa.setBounds(226, 179, 152, 20);
		frame.getContentPane().add(textAdresa);
		textAdresa.setColumns(10);
		
		JLabel lblBrojtel = new JLabel("Broj telefona:");
		lblBrojtel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBrojtel.setBounds(122, 213, 80, 14);
		frame.getContentPane().add(lblBrojtel);
		
		textBrojTelefona = new JTextField();
		textBrojTelefona.setBounds(226, 210, 152, 20);
		frame.getContentPane().add(textBrojTelefona);
		textBrojTelefona.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(122, 243, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(226, 241, 152, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnZavrsi = new JButton("Odustani");
		btnZavrsi.setBackground(new Color(143, 188, 143));
		btnZavrsi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnZavrsi.setBounds(44, 340, 125, 23);
		frame.getContentPane().add(btnZavrsi);
		
		JButton registruj = new JButton("Registruj");
		registruj.setBackground(new Color(143, 188, 143));
		
		registruj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				boolean postojiIme=false;
				try{	
					String ime = textIme.getText();
					String prezime = textPrezime.getText();
					String JMBG = textJMBG.getText();
					String brojTelefona = textBrojTelefona.getText();
					String email = textEmail.getText();
					
					String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

					 Boolean result = email.matches(emailreg);
					if(result == false){
						JOptionPane.showMessageDialog(null, "Email nije unesen u validnom formatu!");
						return;
					}
				
					if(!JMBG.matches("[0-9]+") || JMBG.length()!=13){
						JOptionPane.showMessageDialog(null, "JMBG broj sadrzi samo brojeve i ima tacno 13 brojeva!");
						return;
					}
					else if (!JMBG.matches("[0-9]+")) {
						JOptionPane.showMessageDialog(null, "JMBG sadrzi samo brojeve!");
						return;
					}
					else if (!brojTelefona.matches("[0-9]+") || brojTelefona.length()<6) {
						JOptionPane.showMessageDialog(null, "Broj telefona sadrzi samo brojeve i ima najmanje 6 cifara!");
						return;
					}
					else if(!validacijaImena(ime)){
						JOptionPane.showMessageDialog(null, "Ime sadrzi samo slova!");
						return;
					}
					else if(!validacijaImena(prezime)){
						JOptionPane.showMessageDialog(null, "Prezime sadrzi samo slova!");
						return;
					}
					else {
						TipZaposlenika zaposlenik = dodajZaposlenika();
						TipZaposlenikaKontroler.dodaj(zaposlenik);
						JOptionPane.showMessageDialog(null, "Uspjesno ste registrovali korisnika!\n" + "\nKorisnicko ime:    "+ zaposlenik.getKorisnickoime() + "\nLozinka:        " +zaposlenik.getLozinka());
					}			
				}	
				
				catch(Exception i){
					logger.info(i);
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Nesto je poslo po zlu.");
				}
			}
		});
		
		
		registruj.setToolTipText("");
		registruj.setBounds(337, 340, 129, 23);
		frame.getContentPane().add(registruj);
		
		
	}
		public TipZaposlenika dodajZaposlenika()
		{
			String ime = textIme.getText();
			String prezime = textPrezime.getText();
			String jmbg = textJMBG.getText();
			String adresa = textAdresa.getText();
			String telefon = textBrojTelefona.getText();
			String email = textEmail.getText();
			String korisnickoIme = TipZaposlenikaKontroler.generisiKorisnickoIme(ime, prezime);
			String sifra = TipZaposlenikaKontroler.generisiLozinku();
			String privilegija = (String)comboPrivilegije.getSelectedItem();
			
			TipZaposlenika novi = new TipZaposlenika();
		
			
			try
			{
				novi = new TipZaposlenika(ime, prezime, jmbg, adresa, telefon, email, korisnickoIme, sifra, privilegija);
			}
			catch (Exception e) 
			{
				logger.info(e);
			}
			return novi;
		
	}
	
		public boolean validacijaImena(String ime) {
		    return ime.matches("[a-zA-Z]+");
		}
	
}
