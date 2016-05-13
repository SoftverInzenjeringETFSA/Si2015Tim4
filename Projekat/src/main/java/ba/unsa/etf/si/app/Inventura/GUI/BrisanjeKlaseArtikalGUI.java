package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BrisanjeKlaseArtikalGUI {

	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTextField txtNaziv;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeKlaseArtikalGUI window = new BrisanjeKlaseArtikalGUI();
					window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
					BrisanjeKlaseArtikalGUI window = new BrisanjeKlaseArtikalGUI();
					
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
	public BrisanjeKlaseArtikalGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Brisanje klase artikla");
		frame.setBounds(100, 100, 346, 243);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBrisanjeKlaseArtikla = new JLabel("Brisanje klase artikla");
		lblBrisanjeKlaseArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBrisanjeKlaseArtikla.setHorizontalAlignment(SwingConstants.LEFT);
		lblBrisanjeKlaseArtikla.setForeground(new Color(0, 128, 0));
		lblBrisanjeKlaseArtikla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBrisanjeKlaseArtikla.setBounds(22, 22, 147, 35);
		frame.getContentPane().add(lblBrisanjeKlaseArtikla);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(203, 42, 108, 14);
		frame.getContentPane().add(lblKorisnik);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 68, 289, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Unesite naziv klase artikla koju želite obrisati:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(22, 91, 251, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(21, 116, 290, 20);
		frame.getContentPane().add(txtNaziv);
		txtNaziv.setColumns(10);
		
		JButton btnObrisi = new JButton("Obriši");
		btnObrisi.setBackground(new Color(143, 188, 143));
		
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv=txtNaziv.getText();
				try{
					KlasaArtikla art=new KlasaArtikla();
					art=KlasaArtikalaKontroler.nadjiIme(naziv);
					KlasaArtikalaKontroler.izbrisi(art.getId());
				}
				catch(Exception i){
					System.out.print("baci izuzetak");
					Component frame = null;
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		
		btnObrisi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnObrisi.setBounds(215, 168, 97, 23);
		frame.getContentPane().add(btnObrisi);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setBackground(new Color(143, 188, 143));
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOdustani.setBounds(22, 168, 97, 23);
		frame.getContentPane().add(btnOdustani);
	}

}
