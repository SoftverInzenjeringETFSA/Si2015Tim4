package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;

import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ModifikacijaArtiklaGUI {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTextField txtNaziv;
	private JTextField txtBarkod;
	private JTextField txtKolicina;
	private JTextField txtCijena;
	private JComboBox<KlasaArtikla> comboKlasa;
	private JComboBox<String> comboMjera;
	private JList<Artikal> listArtikli;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ModifikacijaArtiklaGUI window = new ModifikacijaArtiklaGUI();
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
					ModifikacijaArtiklaGUI window = new ModifikacijaArtiklaGUI();
					
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
	public ModifikacijaArtiklaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 475, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modifikacija artikla");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(24, 30, 183, 39);
		frame.getContentPane().add(lblNewLabel);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setBounds(304, 30, 134, 37);
		frame.getContentPane().add(lblKorisnik);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 80, 414, 7);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Postojeći artikli:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setBounds(20, 112, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNazivArtikla = new JLabel("Naziv artikla:");
		lblNazivArtikla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNazivArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNazivArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivArtikla.setBounds(215, 129, 79, 14);
		frame.getContentPane().add(lblNazivArtikla);
		
		JLabel lblKlasaArtikla = new JLabel("Klasa artikla:");
		lblKlasaArtikla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKlasaArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKlasaArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKlasaArtikla.setBounds(215, 154, 79, 14);
		frame.getContentPane().add(lblKlasaArtikla);
		
		txtNaziv = new JTextField();
		txtNaziv.setColumns(10);
		txtNaziv.setBounds(304, 126, 134, 20);
		frame.getContentPane().add(txtNaziv);
		
		comboKlasa = new JComboBox<KlasaArtikla>();
		comboKlasa.setBounds(304, 151, 134, 20);
		frame.getContentPane().add(comboKlasa);
		postaviKlase();
		
		JButton btnSacuvaj = new JButton("Sa\u010Duvaj");
		btnSacuvaj.setBackground(new Color(143, 188, 143));
		btnSacuvaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Artikal artikal=(Artikal)listArtikli.getSelectedValue();
					Double cijena=Double.parseDouble(txtCijena.getText());
					Double kolicina=Double.parseDouble(txtKolicina.getText());
					String barkod=txtBarkod.getText();
					
					if(!barkod.matches("[0-9]+") && (barkod.length()<13 || barkod.length()>13)){
						JOptionPane.showMessageDialog(null, "Barkod sadrzi samo brojeve i ima tacno 13 brojeva!");
						return;
					}
					if (!barkod.matches("[0-9]+")) {
						JOptionPane.showMessageDialog(null, "Barkod sadrzi samo brojeve!");
						return;
					}
					else if(barkod.length()<13 || barkod.length()>13){
						JOptionPane.showMessageDialog(null, "Barkod sadrzi tacno 13 brojeva!");
						return;
					}
					if(cijena<0){ 
						JOptionPane.showMessageDialog(null, "Cijena ne moze biti negativna!");
						return;
					}
					else if(kolicina<0){ 
						JOptionPane.showMessageDialog(null, "Kolicina ne moze biti negativna!");
						return;
					}
					izmjeniArtikal(artikal);
					ArtikliKontroler.izmijeni(artikal);
					JOptionPane.showMessageDialog(null, "Artikal uspjesno modifikovan!");
					postaviListu();
				}
				catch(Exception i){
					logger.info(i);
					Component frame = null;
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		btnSacuvaj.setBounds(349, 300, 89, 23);
		frame.getContentPane().add(btnSacuvaj);
		
		JButton btnZavrsi = new JButton("Odustani");
		btnZavrsi.setBackground(new Color(143, 188, 143));
		btnZavrsi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnZavrsi.setBounds(221, 300, 89, 23);
		frame.getContentPane().add(btnZavrsi);
		
		JLabel lblBarKod = new JLabel("Bar kod:");
		lblBarKod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBarKod.setBounds(248, 179, 46, 14);
		frame.getContentPane().add(lblBarKod);
		
		txtBarkod = new JTextField();
		txtBarkod.setBounds(304, 176, 134, 20);
		frame.getContentPane().add(txtBarkod);
		txtBarkod.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Količina:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(248, 204, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cijena:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(248, 228, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mjerna jedinica:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(205, 253, 89, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtKolicina = new JTextField();
		txtKolicina.setBounds(304, 201, 134, 20);
		frame.getContentPane().add(txtKolicina);
		txtKolicina.setColumns(10);
		
		txtCijena = new JTextField();
		txtCijena.setBounds(304, 226, 134, 20);
		frame.getContentPane().add(txtCijena);
		txtCijena.setColumns(10);
		
		comboMjera = new JComboBox<String>();
		comboMjera.setBounds(304, 251, 134, 20);
		frame.getContentPane().add(comboMjera);
		postaviMjere();
		
		listArtikli = new JList<Artikal>();
		listArtikli.setBounds(20, 137, 183, 187);
		frame.getContentPane().add(listArtikli);
		postaviListu();
	}

	public void izmjeniArtikal(Artikal artikal) {
		String naziv=txtNaziv.getText();
		KlasaArtikla klasa=(KlasaArtikla)comboKlasa.getSelectedItem();
		String barkod=txtBarkod.getText();
		
		Double cijena=Double.parseDouble(txtCijena.getText());
		Double kolicina=Double.parseDouble(txtKolicina.getText());
		
		
		String mjera=(String)comboMjera.getSelectedItem();
		
		try {
			artikal.setNaziv(naziv);
			artikal.setKlasaArtikla(klasa);
			artikal.setBarkod(barkod);
			artikal.setCijena(cijena);
			artikal.setKolicina(kolicina);
			artikal.setMjera(mjera);
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	public void postaviListu(){
		List<Artikal> artikli=ArtikliKontroler.lista();
		
		DefaultListModel<Artikal> model=new DefaultListModel<Artikal>();
		
		for(Artikal a:artikli){
			model.addElement(a);
		}
		
		listArtikli.setModel(model);
	}
	
	public void postaviKlase(){
		List<KlasaArtikla> klase=KlasaArtikalaKontroler.lista();
				
		for(KlasaArtikla k:klase){
			comboKlasa.addItem(k);
		}
	}
	
	public void postaviMjere(){
		String[] mjere=new String[]{"komad","kilogram","gram","litar","decilitar"}; // ovo je napamet
		
		for(String s:mjere){
			comboMjera.addItem(s);
		}
	}
}
