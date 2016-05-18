package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;

public class ModifikacijaKlaseArtiklaGUI {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTextField txtNaziv;
	private JList<KlasaArtikla> listKlase;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ModifikacijaKlaseArtiklaGUI window = new ModifikacijaKlaseArtiklaGUI();
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
					ModifikacijaKlaseArtiklaGUI window = new ModifikacijaKlaseArtiklaGUI();
					
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
	public ModifikacijaKlaseArtiklaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Modifikacija klase artikla");
		frame.setBounds(100, 100, 342, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblKlaseArtikala = new JLabel("Klase artikala:");
		lblKlaseArtikala.setHorizontalAlignment(SwingConstants.LEFT);
		lblKlaseArtikala.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKlaseArtikala.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKlaseArtikala.setBounds(20, 107, 77, 14);
		frame.getContentPane().add(lblKlaseArtikala);
		
		listKlase = new JList();
		listKlase.setBounds(20, 132, 290, 102);
		frame.getContentPane().add(listKlase);
		postaviListu();
		
		JLabel lblNoviNaziv = new JLabel("Novi naziv:");
		lblNoviNaziv.setHorizontalAlignment(SwingConstants.LEFT);
		lblNoviNaziv.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNoviNaziv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNoviNaziv.setBounds(20, 256, 69, 14);
		frame.getContentPane().add(lblNoviNaziv);
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(20, 281, 290, 20);
		frame.getContentPane().add(txtNaziv);
		txtNaziv.setColumns(10);
		
		JButton btnIzmjeni = new JButton("Izmjeni");
		btnIzmjeni.setBackground(new Color(143, 188, 143));
		btnIzmjeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					KlasaArtikla klasa = (KlasaArtikla)listKlase.getSelectedValue();
					
					if(listKlase.getSelectedValue()==null){
						JOptionPane.showMessageDialog(null, "Niste oznacili klasu artikla koju zelite modifikovati!");
						return;
					}
					else if(txtNaziv.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Unesite novo ime klase artikla!");
						return;
					}
					else if(klasa.getNaziv().equals(txtNaziv.getText())){
						JOptionPane.showMessageDialog(null, "Klasa artikla se vec tako zove!");
						return;
					}
					
					klasa.setNaziv(txtNaziv.getText());
					KlasaArtikalaKontroler.izmijeni(klasa);
					
					JOptionPane.showMessageDialog(null, "Uspjesno ste modifikovali klasu artikla!");
					postaviListu();
				}
				catch(Exception i){
					logger.info(i);
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		
		btnIzmjeni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIzmjeni.setBounds(221, 322, 89, 23);
		frame.getContentPane().add(btnIzmjeni);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setBackground(new Color(143, 188, 143));
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOdustani.setBounds(20, 322, 89, 23);
		frame.getContentPane().add(btnOdustani);
		
		JLabel lblModifikacijaKlaseArtikla = new JLabel("Modifikacija klase artikla");
		lblModifikacijaKlaseArtikla.setForeground(new Color(0, 128, 0));
		lblModifikacijaKlaseArtikla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModifikacijaKlaseArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblModifikacijaKlaseArtikla.setHorizontalAlignment(SwingConstants.LEFT);
		lblModifikacijaKlaseArtikla.setBounds(20, 27, 159, 34);
		frame.getContentPane().add(lblModifikacijaKlaseArtikla);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 72, 290, 14);
		frame.getContentPane().add(separator);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(196, 46, 114, 14);
		frame.getContentPane().add(lblKorisnik);
	}
	
	private void postaviListu(){
		List<KlasaArtikla> klase=KlasaArtikalaKontroler.lista();
		
		DefaultListModel<KlasaArtikla> model=new DefaultListModel<KlasaArtikla>();
		
		for(KlasaArtikla k:klase){
			model.addElement(k);
		}
		
		listKlase.setModel(model);
	}
}
