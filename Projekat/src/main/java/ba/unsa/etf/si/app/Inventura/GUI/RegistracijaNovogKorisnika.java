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

public class RegistracijaNovogKorisnika {

	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
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
					window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					window.frame.setVisible(true);
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
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void pokreni(JFrame _frameRoditelj, TipZaposlenika _korisnik) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistracijaNovogKorisnika window = new RegistracijaNovogKorisnika();
					
					window.frameRoditelj=_frameRoditelj;
					window.korisnik=_korisnik;
					window.lblKorisnik.setText(window.korisnik.getIme().toUpperCase());
					
					FormaKontroler.postaviFormu(window.frameRoditelj, window.frame, false);
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
		frame = new JFrame();
		frame.setTitle("Registracija korisnika");
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 551, 462);
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
		
		JLabel lozinka = new JLabel("Lozinka:");
		lozinka.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lozinka.setBounds(122, 306, 67, 14);
		frame.getContentPane().add(lozinka);
		
		textLozinka = new JTextField();
		textLozinka.setBounds(226, 304, 152, 20);
		frame.getContentPane().add(textLozinka);
		textLozinka.setColumns(10);
		
		JLabel lblNivoPrivilegija = new JLabel("Nivo privilegije:");
		lblNivoPrivilegija.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNivoPrivilegija.setBounds(122, 332, 80, 14);
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
		comboPrivilegije.setBounds(226, 329, 152, 20);
		frame.getContentPane().add(comboPrivilegije);
		
		JButton btnZavrsi = new JButton("Odustani");
		btnZavrsi.setBackground(new Color(143, 188, 143));
		btnZavrsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnZavrsi.setBounds(43, 389, 125, 23);
		frame.getContentPane().add(btnZavrsi);
		
		JButton registruj = new JButton("Registruj");
		registruj.setBackground(new Color(143, 188, 143));
		
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
		registruj.setBounds(336, 389, 129, 23);
		frame.getContentPane().add(registruj);
		
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
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnikoIme.setBounds(122, 275, 80, 14);
		frame.getContentPane().add(lblKorisnikoIme);
		
		textKorisnickoIme = new JTextField();
		textKorisnickoIme.setBounds(226, 273, 152, 20);
		frame.getContentPane().add(textKorisnickoIme);
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
