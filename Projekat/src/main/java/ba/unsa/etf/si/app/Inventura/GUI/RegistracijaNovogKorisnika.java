package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.JTextField;
import javax.swing.JList;
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

	private JTextField textField;	
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	
	/**
	 * Launch the application.
	 */
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

		frmRegistracijaNovogKorisnika.setBounds(100, 100, 400, 478);

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

		JLabel ime1 = new JLabel("Korisnicko ime:");
		ime1.setBounds(68, 254, 80, 19);
		frmRegistracijaNovogKorisnika.getContentPane().add(ime1);
		
		textField = new JTextField();
		textField.setBounds(158, 253, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lozinka1 = new JLabel("Lozinka:");
		lozinka1.setBounds(102, 284, 67, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lozinka1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 281, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNivoPrivilegija1 = new JLabel("Nivo privilegije:");
		lblNivoPrivilegija1.setBounds(68, 318, 80, 14);

		frmRegistracijaNovogKorisnika.getContentPane().add(lblNivoPrivilegija1);
		
		
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

		comboPrivilegije.setBounds(158, 315, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(comboPrivilegije);
		
		JButton btnZavri1 = new JButton("Odustani");
		btnZavri1.setBounds(68, 405, 89, 23);

		frmRegistracijaNovogKorisnika.getContentPane().add(btnZavri1);
		
		JButton registruj = new JButton("Registruj");
		registruj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				String privilegija=(String) comboPrivilegije.getSelectedItem();
				String ime=textField_2.getText();
				String prezime=textField_3.getText();
				String jmbg=textField_4.getText();
				String brtel=textField_5.getText();
				String adresa=textField_6.getText();
				String mail=textField_7.getText();
				String korime=textField.getText();
				String pass=textField_1.getText();

				TipZaposlenika z=new TipZaposlenika(ime,prezime,jmbg,adresa,brtel,mail,korime,pass,privilegija);
				TipZaposlenikaKontroler tzk=new TipZaposlenikaKontroler();
				tzk.dodaj(z);
			    } 
				catch (Exception e) {
				e.printStackTrace();
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

		/*public TipZaposlenika dodajZaposlenika()
		{
			String ime = textIme.getText();
			String prezime = textPrezime.getText();
			String JMBG = textJMBG.getText();
			String adresa = textAdresa.getText();
			String brojTelefona = textBrojTelefona.getText();
			String email = textEmail.getText();
			String korisnickoIme = textKorisnickoIme.getText();
			String lozinka = textLozinka.getText();
			String nivoPrivilegije =(String) comboPrivilegije.getSelectedItem();
			TipZaposlenika novi = new TipZaposlenika();
			try
			{
				//public TipZaposlenika(int _id, String _ime, Skladistar _skladistar, Sef _sef,String _prezime,String _jmbg, String _adresa, String _brojTel, String _email, String _korisnickoIme, String _lozinka)
				novi = new TipZaposlenika(id, ime, , , prezime, JMBG, adresa, brojTelefona, email, korisnickoIme, lozinka);
				//iznad fali u konstruktoru tipZaposlenika, skladistar ili sef, to je Amra rekla riješiti
				//dodavanje u bazu
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return novi;
		
		}*/

		registruj.setBounds(240, 405, 89, 23);
		frmRegistracijaNovogKorisnika.getContentPane().add(registruj);
		
		JLabel lblNewLabel = new JLabel("Ime:");
		lblNewLabel.setBounds(102, 97, 46, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime:");
		lblNewLabel_1.setBounds(90, 129, 46, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("JMBG:");
		lblNewLabel_2.setBounds(102, 154, 46, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adresa:");
		lblNewLabel_3.setBounds(100, 204, 62, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail:");
		lblNewLabel_4.setBounds(102, 229, 46, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Broj telefona:");
		lblNewLabel_5.setBounds(68, 179, 80, 14);
		frmRegistracijaNovogKorisnika.getContentPane().add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(158, 94, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(158, 126, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(158, 151, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(158, 176, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(158, 201, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(158, 229, 152, 20);
		frmRegistracijaNovogKorisnika.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		

	}
}
