package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.*;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;

public class DodavanjeKlaseArtiklaGUI {

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
					DodavanjeKlaseArtiklaGUI window = new DodavanjeKlaseArtiklaGUI();
					window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void pokreni(final JFrame _frameRoditelj, TipZaposlenika _korisnik) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeKlaseArtiklaGUI window = new DodavanjeKlaseArtiklaGUI();
					
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
	public DodavanjeKlaseArtiklaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Dodavanje klase artikla");
		frame.setBounds(100, 100, 365, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNazivKlaseArtikla = new JLabel("Naziv klase artikla:");
		lblNazivKlaseArtikla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNazivKlaseArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNazivKlaseArtikla.setHorizontalAlignment(SwingConstants.LEFT);
		lblNazivKlaseArtikla.setBounds(31, 94, 103, 14);
		frame.getContentPane().add(lblNazivKlaseArtikla);
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(31, 119, 290, 20);
		frame.getContentPane().add(txtNaziv);
		txtNaziv.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj klasu artikla");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try{
					KlasaArtikla klasa = new KlasaArtikla(txtNaziv.getText());
					KlasaArtikalaKontroler.dodaj(klasa);
					JOptionPane.showMessageDialog(null, "Klasa uspjesno dodana!");
				}
				catch(Exception i){
					Component frame = null;
					JOptionPane.showMessageDialog(frame, i.getMessage());
					JOptionPane.showMessageDialog(null, "Klasa vec postoji bazi!");
				}
				}
			
		});
		
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDodaj.setBounds(165, 158, 156, 23);
		frame.getContentPane().add(btnDodaj);
		
		JLabel lblNewLabel = new JLabel("Unos nove klase artikla");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(31, 32, 162, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 66, 290, 14);
		frame.getContentPane().add(separator);
		
		JButton btnZavrsi = new JButton("Završi");
		btnZavrsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnZavrsi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnZavrsi.setBounds(31, 158, 89, 23);
		frame.getContentPane().add(btnZavrsi);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(218, 40, 103, 14);
		frame.getContentPane().add(lblKorisnik);
		
		final JLabel Vnaziv = new JLabel("  ");
		Vnaziv.setForeground(Color.RED);
		Vnaziv.setBounds(31, 139, 223, 14);
		frame.getContentPane().add(Vnaziv);
		
		txtNaziv.getDocument().addDocumentListener(new DocumentListener(){
			public void changedUpdate(DocumentEvent arg0) {
				
				if(ValidacijaKlaseArtikla.validirajNaziv(txtNaziv.getText())) {
					txtNaziv.setBackground(Color.WHITE);
					Vnaziv.setText("  ");
				}
				else{
					txtNaziv.setBackground(Color.getHSBColor(0, 80, 100));
					Vnaziv.setText("Niste unjeli naziv");
				}
				
			}

			public void insertUpdate(DocumentEvent arg0) {
				
				if(ValidacijaArtikla.validirajNaziv(txtNaziv.getText())) {
					txtNaziv.setBackground(Color.WHITE);
					Vnaziv.setText("  ");
				}
				else{
					txtNaziv.setBackground(Color.getHSBColor(0, 80, 100));
					Vnaziv.setText("Niste unjeli naziv");
				}
				
			}

			public void removeUpdate(DocumentEvent arg0) {
				
				if(true==ValidacijaArtikla.validirajNaziv(txtNaziv.getText())) {
					txtNaziv.setBackground(Color.WHITE);
					Vnaziv.setText("  ");
				}
				else{
					txtNaziv.setBackground(Color.getHSBColor(0, 80, 100));
					Vnaziv.setText("Niste unjeli naziv");
				}
			}
		});
	}
}
