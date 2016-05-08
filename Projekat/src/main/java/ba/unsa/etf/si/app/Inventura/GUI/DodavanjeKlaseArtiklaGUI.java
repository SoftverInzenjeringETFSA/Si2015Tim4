package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;

public class DodavanjeKlaseArtiklaGUI {

	private JFrame frmUnosNoveKlase;
	private JTextField txtNaziv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeKlaseArtiklaGUI window = new DodavanjeKlaseArtiklaGUI();
					window.frmUnosNoveKlase.setVisible(true);
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
		frmUnosNoveKlase = new JFrame();
		frmUnosNoveKlase.setTitle("Dodavanje klase artikla");
		frmUnosNoveKlase.setBounds(100, 100, 365, 240);
		frmUnosNoveKlase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUnosNoveKlase.getContentPane().setLayout(null);
		
		JLabel lblNazivKlaseArtikla = new JLabel("Naziv klase artikla:");
		lblNazivKlaseArtikla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNazivKlaseArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNazivKlaseArtikla.setHorizontalAlignment(SwingConstants.LEFT);
		lblNazivKlaseArtikla.setBounds(31, 94, 103, 14);
		frmUnosNoveKlase.getContentPane().add(lblNazivKlaseArtikla);
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(31, 119, 290, 20);
		frmUnosNoveKlase.getContentPane().add(txtNaziv);
		txtNaziv.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj klasu artikla");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					KlasaArtikla klasa = new KlasaArtikla(txtNaziv.getText());
					KlasaArtikalaKontroler.dodaj(klasa);
				}
				catch(Exception i){
					Component frame = null;
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDodaj.setBounds(165, 158, 156, 23);
		frmUnosNoveKlase.getContentPane().add(btnDodaj);
		
		JLabel lblNewLabel = new JLabel("Unos nove klase artikla");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(31, 32, 244, 23);
		frmUnosNoveKlase.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 66, 290, 14);
		frmUnosNoveKlase.getContentPane().add(separator);
		
		JButton btnZavrsi = new JButton("Završi");
		btnZavrsi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnZavrsi.setBounds(31, 158, 89, 23);
		frmUnosNoveKlase.getContentPane().add(btnZavrsi);
		
		JLabel lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(275, 40, 46, 14);
		frmUnosNoveKlase.getContentPane().add(lblKorisnik);
	}
}
