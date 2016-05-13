package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;

import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.*;
import ba.unsa.etf.si.app.Inventura.Model.ValidacijaArtikla;
import javax.swing.SwingConstants;;


public class DodavanjeArtikla {

	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTextField txtNaziv;
	private JTextField txtBarkod;
	private JTextField txtCijena;
	private JTextField txtKolicina;
	private JComboBox<KlasaArtikla> comboKlasa;
	private JComboBox<String> comboMjera;

	private List<KlasaArtikla> _artikli;
	private List<String> _mjera = Arrays.asList("kom", "kg", "g", "l", "dl");
	
	/**
	 * Launch the application.
	 */
	
	public static void  main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeArtikla window = new DodavanjeArtikla();
					window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void  pokreni(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeArtikla window = new DodavanjeArtikla();
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
					DodavanjeArtikla window = new DodavanjeArtikla();
					
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
	public DodavanjeArtikla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_artikli = KlasaArtikalaKontroler.lista();
		frame = new JFrame();
		frame.setTitle("Dodavanje artikla");
		frame.getContentPane().setBackground(SystemColor.control);
		
		JLabel lblDodavanjeArtikla = new JLabel("Unos novog artikla");
		lblDodavanjeArtikla.setBounds(10, 11, 120, 32);
		lblDodavanjeArtikla.setForeground(new Color(0, 100, 0));
		lblDodavanjeArtikla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Naziv artikla:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(48, 112, 72, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Klasa artikla:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(48, 153, 72, 14);
		
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(126, 109, 166, 20);
		txtNaziv.setColumns(10);
		
		JButton btnZavrsi = new JButton("Odustani");
		btnZavrsi.setBounds(28, 304, 92, 23);
		btnZavrsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnZavrsi.setBackground(new Color(143, 188, 143));
		
		JButton btnUnesi = new JButton("Dodaj");
		btnUnesi.setBounds(197, 304, 95, 23);
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(ValidacijaArtikla.validirajNaziv(txtNaziv.getText()) && ValidacijaArtikla.validirajBarkod(txtBarkod.getText()) && ValidacijaArtikla.validirajCijenu(txtCijena.getText()) && ValidacijaArtikla.validirajKolicinu(txtKolicina.getText(),_mjera.get(comboMjera.getSelectedIndex())))
					{	
						Artikal a= new Artikal();
						a=dajArtikal();
						ArtikliKontroler.dodaj(a);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Nisu pravilno uneseni parametri");
					}					
				}
				catch(Exception i){
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		btnUnesi.setBackground(new Color(143, 188, 143));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 49, 270, 2);
		separator.setForeground(new Color(0, 0, 0));
		
		JLabel lblBarKodArtikla = new JLabel("Bar kod artikla:");
		lblBarKodArtikla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBarKodArtikla.setBounds(34, 72, 86, 14);
		
		txtBarkod = new JTextField();
		txtBarkod.setBounds(126, 66, 166, 20);
		txtBarkod.setColumns(10);
		
		comboKlasa = new JComboBox<KlasaArtikla>();
		comboKlasa.setBounds(126, 150, 166, 20);
		if(_artikli.size() != 0) {
			for(KlasaArtikla a : _artikli) {
				if(a != null) {
					comboKlasa.addItem(a);
				}
			}
		}
		
		
		JLabel lblCijenaArtikla = new JLabel("Cijena artikla:");
		lblCijenaArtikla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCijenaArtikla.setBounds(48, 191, 72, 14);
		
		txtCijena = new JTextField();
		txtCijena.setBounds(126, 188, 166, 20);
		txtCijena.setColumns(10);
		
		JLabel lblKoliinaArtikla = new JLabel("Količina artikla:");
		lblKoliinaArtikla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKoliinaArtikla.setBounds(34, 232, 86, 14);
		
		txtKolicina = new JTextField();
		txtKolicina.setBounds(126, 229, 166, 20);
		txtKolicina.setColumns(10);
		
		JLabel lblMjernaJedinica = new JLabel("Mjerna jedinica:");
		lblMjernaJedinica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMjernaJedinica.setBounds(28, 271, 92, 27);
		
		
		comboMjera = new JComboBox<String>();
		comboMjera.setBounds(126, 274, 166, 20);
		if(_mjera.size() != 0) {
			for(String m : _mjera) {
				if(m != null) {
					comboMjera.addItem(m);
				}
			}
		}
		
		final JLabel VbarCode = new JLabel("  ");
		VbarCode.setBounds(126, 92, 6, 14);
		
		final JLabel Vnaziv = new JLabel("  ");
		Vnaziv.setBounds(126, 130, 6, 14);
		
		final JLabel Vcijena = new JLabel("  ");
		Vcijena.setBounds(126, 209, 6, 14);
		
		final JLabel Vkolicina = new JLabel("  ");
		Vkolicina.setBounds(126, 251, 6, 14);
		
		txtNaziv.getDocument().addDocumentListener(new DocumentListener(){
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajNaziv(txtNaziv.getText())) {
					txtNaziv.setBackground(Color.WHITE);
					Vnaziv.setText("  ");
				}
				else{
					txtNaziv.setBackground(Color.getHSBColor(0, 80, 100));
					Vnaziv.setText("Niste unjeli naziv");
					Vnaziv.setForeground(Color.RED);
				}
				
			}

			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajNaziv(txtNaziv.getText())) {
					txtNaziv.setBackground(Color.WHITE);
					Vnaziv.setText("  ");
				}
				else{
					txtNaziv.setBackground(Color.getHSBColor(0, 80, 100));
					Vnaziv.setText("Niste unjeli naziv");
					Vnaziv.setForeground(Color.RED);
				}
				
			}

			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(true==ValidacijaArtikla.validirajNaziv(txtNaziv.getText())) {
					txtNaziv.setBackground(Color.WHITE);
					Vnaziv.setText("  ");
				}
				else{
					txtNaziv.setBackground(Color.getHSBColor(0, 80, 100));
					Vnaziv.setText("Niste unjeli naziv");
					Vnaziv.setForeground(Color.RED);
				}
			}
		});
		
		txtBarkod.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajBarkod(txtBarkod.getText())) {
					txtBarkod.setBackground(Color.WHITE);
					VbarCode.setText("  ");
				}
				else{
					txtBarkod.setBackground(Color.getHSBColor(0, 80, 100));
					VbarCode.setText("treba imati 13 znakova");
					VbarCode.setForeground(Color.RED);
				}
					
				
			}

			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajBarkod(txtBarkod.getText())) {
					txtBarkod.setBackground(Color.WHITE);
					VbarCode.setText("  ");
				}
				else{
					txtBarkod.setBackground(Color.getHSBColor(0, 80, 100));
					VbarCode.setText("treba imati 13 znakova");
					VbarCode.setForeground(Color.RED);
				}
				
			}

			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajBarkod(txtBarkod.getText())) {
					txtBarkod.setBackground(Color.WHITE);
					VbarCode.setText("  ");
				}
				else{
					txtBarkod.setBackground(Color.getHSBColor(0, 80, 100));
					VbarCode.setText("treba imati 13 znakova");
					VbarCode.setForeground(Color.RED);
				}
			}
		});
		
		txtCijena.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajCijenu(txtCijena.getText())) {
					txtCijena.setBackground(Color.WHITE);
					Vcijena.setText("  ");
				}
				else{
					txtCijena.setBackground(Color.getHSBColor(0, 80, 100));
					Vcijena.setText("mora biti broj");
					Vcijena.setForeground(Color.RED);
				}
					
				
			}

			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajCijenu(txtCijena.getText())) {
					txtCijena.setBackground(Color.WHITE);
					Vcijena.setText("  ");
				}
				else{
					txtCijena.setBackground(Color.getHSBColor(0, 80, 100));
					Vcijena.setText("mora biti broj");
					Vcijena.setForeground(Color.RED);
				}
				
			}

			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajCijenu(txtCijena.getText())) {
					txtCijena.setBackground(Color.WHITE);
					Vcijena.setText("  ");
				}
				else{
					txtCijena.setBackground(Color.getHSBColor(0, 80, 100));
					Vcijena.setText("mora biti broj");
					Vcijena.setForeground(Color.RED);
				}
			}
		});
		
		txtKolicina.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajKolicinu(txtKolicina.getText(), _mjera.get(comboMjera.getSelectedIndex()))){
					txtKolicina.setBackground(Color.WHITE);
					Vkolicina.setText("  ");
				}
				else{
					txtKolicina.setBackground(Color.getHSBColor(0, 80, 100));
					Vkolicina.setText("mora biti cijeli broj");
					Vkolicina.setForeground(Color.RED);
				}
			}

			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajKolicinu(txtKolicina.getText(), _mjera.get(comboMjera.getSelectedIndex()))){
					txtKolicina.setBackground(Color.WHITE);
					Vkolicina.setText("  ");
				}
				else{
					txtKolicina.setBackground(Color.getHSBColor(0, 80, 100));
					Vkolicina.setText("mora biti cijeli broj");
					Vkolicina.setForeground(Color.RED);
				}
				
			}

			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajKolicinu(txtKolicina.getText(), _mjera.get(comboMjera.getSelectedIndex()))){
					txtKolicina.setBackground(Color.WHITE);
					Vkolicina.setText("  ");
				}
				else{
					txtKolicina.setBackground(Color.getHSBColor(0, 80, 100));
					Vkolicina.setText("mora biti cijeli broj");
					Vkolicina.setForeground(Color.RED);
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblDodavanjeArtikla);
		frame.getContentPane().add(separator);
		frame.getContentPane().add(lblBarKodArtikla);
		frame.getContentPane().add(lblCijenaArtikla);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblKoliinaArtikla);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblMjernaJedinica);
		frame.getContentPane().add(btnZavrsi);
		frame.getContentPane().add(comboMjera);
		frame.getContentPane().add(comboKlasa);
		frame.getContentPane().add(Vnaziv);
		frame.getContentPane().add(VbarCode);
		frame.getContentPane().add(txtBarkod);
		frame.getContentPane().add(Vcijena);
		frame.getContentPane().add(btnUnesi);
		frame.getContentPane().add(Vkolicina);
		frame.getContentPane().add(txtNaziv);
		frame.getContentPane().add(txtCijena);
		frame.getContentPane().add(txtKolicina);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(171, 22, 109, 14);
		frame.getContentPane().add(lblKorisnik);
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 318, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Artikal dajArtikal() {
		
		String naziv=txtNaziv.getText();
		KlasaArtikla klasa=(KlasaArtikla)comboKlasa.getSelectedItem();
		String barkod=txtBarkod.getText();
		Double cijena=Double.parseDouble(txtCijena.getText());
		Double kolicina=Double.parseDouble(txtKolicina.getText());
		String mjera=(String)comboMjera.getSelectedItem();
		
		Artikal artikal=new Artikal();
		try {
			artikal = new Artikal(naziv, klasa, barkod, cijena, kolicina, mjera);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return artikal;
	}
}
