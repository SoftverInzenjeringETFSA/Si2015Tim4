package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;



import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;


import java.util.List;

import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ModifikacijaKorisnika {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;

	private JTextField textID;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textJMBG;
	private JTextField textAdresa;
	private JTextField textBrojTelefona;
	private JTextField textEmail;
	private JTextField textKorisnickoIme;
	private JTextField textLozinka;

	private JList<TipZaposlenika> listKorisnici;
	private JComboBox<String> comboBoxPrivilegije;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ModifikacijaKorisnika window = new ModifikacijaKorisnika();
					window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
					ModifikacijaKorisnika window = new ModifikacijaKorisnika();
					
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
	public ModifikacijaKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Modifikacija korisnika");
		frame.getContentPane().setBackground(SystemColor.control);
		frame.getContentPane().setLayout(null);
		
		JLabel lblModifikacijaKorisnika = new JLabel("Modifikacija korisnika");
		lblModifikacijaKorisnika.setForeground(new Color(0, 128, 0));
		lblModifikacijaKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModifikacijaKorisnika.setBounds(43, 44, 134, 14);
		frame.getContentPane().add(lblModifikacijaKorisnika);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setForeground(new Color(0, 0, 0));
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(234, 46, 150, 14);
		frame.getContentPane().add(lblKorisnik);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(43, 69, 341, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblKorisnikoIme = new JLabel("Registrovani korisnici:");
		lblKorisnikoIme.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnikoIme.setBounds(43, 94, 150, 14);
		frame.getContentPane().add(lblKorisnikoIme);
		
		JLabel lblNivoPrivilegije = new JLabel("Nivo privilegije:");
		lblNivoPrivilegije.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNivoPrivilegije.setBounds(231, 120, 89, 14);
		frame.getContentPane().add(lblNivoPrivilegije);
		

		comboBoxPrivilegije = new JComboBox<String>();
		comboBoxPrivilegije.setToolTipText("Radnik\r\nŠef");
		comboBoxPrivilegije.setBounds(231, 145, 141, 20);
		frame.getContentPane().add(comboBoxPrivilegije);
		postaviPrivilegije();
		
		JButton btnSacuvaj = new JButton("Sačuvaj");
		btnSacuvaj.setBackground(new Color(143, 188, 143));
		btnSacuvaj.setBounds(334, 645, 89, 23);
		frame.getContentPane().add(btnSacuvaj);
		btnSacuvaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
						
					TipZaposlenika tmp = modifikujZaposlenika();
					if(tmp==null){
						return;
					}
					else{
					TipZaposlenikaKontroler.izmjeni(tmp);
					JOptionPane.showMessageDialog(null, "Korisnik uspjesno modifikovan!");
					postaviListu();
					
					return;
					}
				}
				catch(Exception i){
					logger.info(i);
					JOptionPane.showMessageDialog(null, "pada ovdje!");
				}
			}
		});
		
		listKorisnici= new JList();
		listKorisnici.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				TipZaposlenika z=listKorisnici.getSelectedValue();
				if(z!=null){
					if(z.getPrivilegija().equals("Sef")){
						comboBoxPrivilegije.setSelectedItem("Sef");
					}
					else{
						comboBoxPrivilegije.setSelectedItem("Skladistar");
					}
					textIme.setText(z.getIme());
					textPrezime.setText(z.getPrezime());
					textJMBG.setText(z.getJmbg());
					textAdresa.setText(z.getAdresa());
					textBrojTelefona.setText(z.getBrojtel());
					textEmail.setText(z.getEmail());
					textKorisnickoIme.setText(z.getKorisnickoime());
					textLozinka.setText(z.getLozinka());
				}
			}
		});
		listKorisnici.setBounds(43, 119, 150, 549);
		frame.getContentPane().add(listKorisnici);
		postaviListu();
		

		JButton btnZavrsi = new JButton("Odustani");
		btnZavrsi.setBackground(new Color(143, 188, 143));
		btnZavrsi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnZavrsi.setBounds(231, 645, 89, 23);
		frame.getContentPane().add(btnZavrsi);
		
		JLabel lblIme1 = new JLabel("Ime:");
		lblIme1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIme1.setBounds(231, 219, 46, 14);
		frame.getContentPane().add(lblIme1);
		
		textIme = new JTextField();
		textIme.setBounds(231, 235, 141, 20);
		frame.getContentPane().add(textIme);
		textIme.setColumns(10);
		
		JLabel lblPrezime1 = new JLabel("Prezime:");
		lblPrezime1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrezime1.setBounds(231, 266, 66, 14);
		frame.getContentPane().add(lblPrezime1);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(231, 291, 141, 20);
		frame.getContentPane().add(textPrezime);
		textPrezime.setColumns(10);
		

		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJmbg.setBounds(231, 322, 46, 14);
		frame.getContentPane().add(lblJmbg);
		
		textJMBG = new JTextField();
		textJMBG.setBounds(231, 347, 141, 20);
		frame.getContentPane().add(textJMBG);
		textJMBG.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdresa.setBounds(231, 373, 46, 14);
		frame.getContentPane().add(lblAdresa);
		
		textAdresa = new JTextField();
		textAdresa.setBounds(231, 388, 141, 20);
		frame.getContentPane().add(textAdresa);
		textAdresa.setColumns(10);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona:");
		lblBrojTelefona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBrojTelefona.setBounds(231, 419, 89, 14);
		frame.getContentPane().add(lblBrojTelefona);
		
		textBrojTelefona = new JTextField();
		textBrojTelefona.setBounds(231, 444, 141, 20);
		frame.getContentPane().add(textBrojTelefona);
		textBrojTelefona.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(231, 475, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(231, 500, 141, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail_1 = new JLabel("Korisničko ime:");
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail_1.setBounds(231, 531, 89, 14);
		frame.getContentPane().add(lblEmail_1);
		
		textKorisnickoIme = new JTextField();
		textKorisnickoIme.setBounds(231, 549, 141, 20);
		frame.getContentPane().add(textKorisnickoIme);
		textKorisnickoIme.setColumns(10);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLozinka.setBounds(231, 573, 66, 14);
		frame.getContentPane().add(lblLozinka);
		
		textLozinka = new JTextField();
		textLozinka.setBounds(231, 592, 141, 20);
		frame.getContentPane().add(textLozinka);
		textLozinka.setColumns(10);
		frame.setBounds(100, 100, 449, 718);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
		public TipZaposlenika modifikujZaposlenika() throws Exception
		{
			TipZaposlenika _zaposlenik = (TipZaposlenika)listKorisnici.getSelectedValue();
			
			if(_zaposlenik==null){
				JOptionPane.showMessageDialog(null, "Niste izabrali korisnika cije podatke zelite promijeniti!");
				return null;
			}
			
			String ime = textIme.getText();
			String prezime = textPrezime.getText();
			String JMBG = textJMBG.getText();
			String adresa = textAdresa.getText();
			String brojTelefona = textBrojTelefona.getText();
			String email = textEmail.getText();
			String korisnickoIme = textKorisnickoIme.getText();
			String lozinka = textLozinka.getText();
		
			String nivoPrivilegije =(String) comboBoxPrivilegije.getSelectedItem();
			
			List<TipZaposlenika> tipTemp= TipZaposlenikaKontroler.lista();
			
			if(ime==null || prezime==null || JMBG==null || adresa==null || brojTelefona==null || email==null || korisnickoIme==null || lozinka==null )
			{
				JOptionPane.showMessageDialog(null, "Niste unijeli sve potrebne parametre!");
				return null;
			}
			
			String priv=textKorisnickoIme.getText();
			TipZaposlenika me=TipZaposlenikaKontroler.nadjiKorisnickoIme(priv);
			
			for ( TipZaposlenika tip : tipTemp){
				if(me.getId()!=tip.getId() && tip.getKorisnickoime().equals(textKorisnickoIme.getText()))
				{
					JOptionPane.showMessageDialog(null, "Morate izabrati drugo korisnicko ime!");
						return null;
				}
				
				else if(tip.getLozinka().equals(textLozinka.getText()) || textLozinka.getText().length()<10 ){
					JOptionPane.showMessageDialog(null, "Morate izabrati drugu lozinku! \n\n (Napomena: lozinka mora imati 10 ili vise cifara)");
					return null;
				}
			}
			
			try
			{	
				String emailBox = textEmail.getText();
				String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
				 Boolean result = emailBox.matches(emailreg);
				 
				if(!JMBG.matches("[0-9]+") || JMBG.length()!=13){
					JOptionPane.showMessageDialog(null, "JMBG sadrzi samo brojeve i ima tacno 13 brojeva!");
					return null;
				}
				else if (!JMBG.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "JMBG sadrzi samo brojeve!");
					return null;
				}
				else if (!brojTelefona.matches("[0-9]+") || brojTelefona.length()<6) {
					JOptionPane.showMessageDialog(null, "Broj telefona sadrzi samo brojeve i ima minimalno 6 cifri!");
					return null;
				}
				else if(!ime.matches("[a-zA-Z]+")){
					JOptionPane.showMessageDialog(null, "Ime sadrzi samo slova!");
					return null;
				}
				else if(!prezime.matches("[a-zA-Z]+")){
					JOptionPane.showMessageDialog(null, "Prezime sadrzi samo slova!");
					return null;
				}
				else if(result == false){
					JOptionPane.showMessageDialog(null, "Email nije unesen u validnom formatu!");
					return null;
				}
				else{
				TipZaposlenika tip = new TipZaposlenika(ime, prezime, JMBG, adresa, brojTelefona, email, korisnickoIme, lozinka, nivoPrivilegije);
					_zaposlenik.izmjeniKorisnika(tip);
				}
			}
			catch (Exception e) 
			{
				logger.info(e);
			}	
			return _zaposlenik;
		}
		
		public void postaviListu(){
			List<TipZaposlenika> zaposlenik=TipZaposlenikaKontroler.lista();
			
			DefaultListModel<TipZaposlenika> model=new DefaultListModel<TipZaposlenika>();
			
			for(TipZaposlenika a:zaposlenik){
				model.addElement(a);
			
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

