package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
// import ba.unsa.etf.si.app.Inventura.Model.Sef;
// import ba.unsa.etf.si.app.Inventura.Model.Skladistar;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;
//import ba.unsa.etf.si.app.Inventura.Model.Skladistar;


import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;


import java.util.List;

import java.awt.event.ActionEvent;

public class ModifikacijaKorisnika {

	private JFrame frmModifikacijaKorisnika;

	private JTextField textID;

	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textJMBG;
	private JTextField textAdresa;
	private JTextField textBrojTelefona;
	private JTextField textEmail;
	private JTextField textKorisnickoIme;
	private JTextField textLozinka;

	private JList listKorisnici;
	private JComboBox comboPrivilegije;
	private JComboBox comboBoxPrivilegije;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
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
		lblNivoPrivilegije.setBounds(231, 120, 80, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblNivoPrivilegije);
		

		comboBoxPrivilegije = new JComboBox();
		comboBoxPrivilegije.setToolTipText("Radnik\r\nŠef");
		comboBoxPrivilegije.setBounds(231, 145, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(comboBoxPrivilegije);
		postaviPrivilegije();
		
		JButton btnZavri = new JButton("Odustani");
		btnZavri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frmModifikacijaKorisnika.dispose();
			frmModifikacijaKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnZavri.setBounds(231, 645, 89, 23);
		frmModifikacijaKorisnika.getContentPane().add(btnZavri);
		
		JButton btnSauvaj = new JButton("Sačuvaj");
		btnSauvaj.setBounds(334, 645, 89, 23);
		frmModifikacijaKorisnika.getContentPane().add(btnSauvaj);
		btnSauvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					TipZaposlenika zaposlenik=(TipZaposlenika)listKorisnici.getSelectedValue();
					modifikujZaposlenika(zaposlenik);
					TipZaposlenikaKontroler.izmjeni(zaposlenik);
					
					postaviListu();
				}
				catch(Exception i){
					System.out.print("lalalala ");
					Component frame = null;
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		
		listKorisnici= new JList();
		listKorisnici.setBounds(43, 119, 150, 549);
		frmModifikacijaKorisnika.getContentPane().add(listKorisnici);
		 postaviListu();
		 
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(231, 176, 46, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblId);
		
		textID = new JTextField();
		textID.setBounds(231, 188, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textID);
		textID.setColumns(10);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(231, 219, 46, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblIme);
		
		textIme = new JTextField();
		textIme.setBounds(231, 235, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textIme);
		textIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(231, 266, 46, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblPrezime);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(231, 291, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textPrezime);
		textPrezime.setColumns(10);
		

		comboPrivilegije = new JComboBox();
		
		comboPrivilegije.setBounds(231, 145, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(comboPrivilegije);
		
		
		JButton btnZavrsi = new JButton("Odustani");
		btnZavrsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frmModifikacijaKorisnika.dispose();
			frmModifikacijaKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnZavrsi.setBounds(231, 645, 89, 23);
		frmModifikacijaKorisnika.getContentPane().add(btnZavrsi);
		
		
		
		listKorisnici = new JList();
		listKorisnici.setBounds(43, 119, 150, 549);
		frmModifikacijaKorisnika.getContentPane().add(listKorisnici);
		postaviListu();
		
		JLabel lblIme1 = new JLabel("Ime:");
		lblIme1.setBounds(231, 219, 46, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblIme1);
		
		textIme = new JTextField();
		textIme.setBounds(231, 235, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textIme);
		textIme.setColumns(10);
		
		JLabel lblPrezime1 = new JLabel("Prezime:");
		lblPrezime1.setBounds(231, 266, 46, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblPrezime1);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(231, 291, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textPrezime);
		textPrezime.setColumns(10);
		

		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBounds(231, 322, 46, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblJmbg);
		
		textJMBG = new JTextField();
		textJMBG.setBounds(231, 347, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textJMBG);
		textJMBG.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setBounds(231, 373, 46, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblAdresa);
		
		textAdresa = new JTextField();
		textAdresa.setBounds(231, 388, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textAdresa);
		textAdresa.setColumns(10);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona:");
		lblBrojTelefona.setBounds(231, 419, 66, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblBrojTelefona);
		
		textBrojTelefona = new JTextField();
		textBrojTelefona.setBounds(231, 444, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textBrojTelefona);
		textBrojTelefona.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(231, 475, 46, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(231, 500, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail_1 = new JLabel("Korisničko ime:");
		lblEmail_1.setBounds(231, 531, 80, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblEmail_1);
		
		textKorisnickoIme = new JTextField();
		textKorisnickoIme.setBounds(231, 549, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textKorisnickoIme);
		textKorisnickoIme.setColumns(10);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setBounds(231, 573, 46, 14);
		frmModifikacijaKorisnika.getContentPane().add(lblLozinka);
		
		textLozinka = new JTextField();
		textLozinka.setBounds(231, 592, 141, 20);
		frmModifikacijaKorisnika.getContentPane().add(textLozinka);
		textLozinka.setColumns(10);
		frmModifikacijaKorisnika.setBounds(100, 100, 449, 718);
		frmModifikacijaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
		public void modifikujZaposlenika(TipZaposlenika tip)
		{
			// TipZaposlenika _zaposlenik = (TipZaposlenika)list.getSelectedValue();
			String ime = textIme.getText();
			String prezime = textPrezime.getText();
			String JMBG = textJMBG.getText();
			String adresa = textAdresa.getText();
			String brojTelefona = textBrojTelefona.getText();
			String email = textEmail.getText();
			String korisnickoIme = textKorisnickoIme.getText();
			String lozinka = textLozinka.getText();
		
			String nivoPrivilegije =(String) comboBoxPrivilegije.getSelectedItem();
			
			
			try
			{
				tip = new TipZaposlenika(ime, prezime, JMBG, adresa, brojTelefona, email, korisnickoIme, lozinka, nivoPrivilegije);
			}
			catch (Exception e) 
			{
					System.out.print("ne promjeni sve vrijednosti");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		public void postaviListu(){
			List<TipZaposlenika> zaposlenik=TipZaposlenikaKontroler.lista();
			
			DefaultListModel model=new DefaultListModel();
			
			for(TipZaposlenika a:zaposlenik){
				model.addElement(a.getIme());
			}
			
			listKorisnici.setModel(model);
		}
		
		public void postaviPrivilegije(){
			String[] privilegije=new String[]{"Sef","Skladistar"};
					
			for(String s: privilegije){
				comboBoxPrivilegije.addItem(s);
			}
		}
}

