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


// import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;

import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BrisanjeKlaseArtikalGUI {

	private JFrame frmBrisanjeKlaseArtikla;
	private JTextField txtNaziv;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeKlaseArtikalGUI window = new BrisanjeKlaseArtikalGUI();
					window.frmBrisanjeKlaseArtikla.setVisible(true);
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
		frmBrisanjeKlaseArtikla = new JFrame();
		frmBrisanjeKlaseArtikla.setTitle("Brisanje klase artikla");
		frmBrisanjeKlaseArtikla.setBounds(100, 100, 346, 243);
		frmBrisanjeKlaseArtikla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBrisanjeKlaseArtikla.getContentPane().setLayout(null);
		
		JLabel lblBrisanjeKlaseArtikla = new JLabel("Brisanje klase artikla");
		lblBrisanjeKlaseArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBrisanjeKlaseArtikla.setHorizontalAlignment(SwingConstants.LEFT);
		lblBrisanjeKlaseArtikla.setForeground(new Color(0, 128, 0));
		lblBrisanjeKlaseArtikla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBrisanjeKlaseArtikla.setBounds(22, 22, 147, 35);
		frmBrisanjeKlaseArtikla.getContentPane().add(lblBrisanjeKlaseArtikla);
		
		JLabel lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(265, 42, 46, 14);
		frmBrisanjeKlaseArtikla.getContentPane().add(lblKorisnik);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 68, 289, 2);
		frmBrisanjeKlaseArtikla.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Unesite naziv klase artikla koju želite obrisati:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(22, 91, 251, 14);
		frmBrisanjeKlaseArtikla.getContentPane().add(lblNewLabel);
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(21, 116, 290, 20);
		frmBrisanjeKlaseArtikla.getContentPane().add(txtNaziv);
		txtNaziv.setColumns(10);
		
		JButton btnObrisi = new JButton("Obriši");
		
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					KlasaArtikalaKontroler.izbrisi(txtNaziv.getText());
				}
				catch(Exception i){
					Component frame = null;
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		
		btnObrisi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnObrisi.setBounds(223, 168, 89, 23);
		frmBrisanjeKlaseArtikla.getContentPane().add(btnObrisi);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frmBrisanjeKlaseArtikla.dispose();
			frmBrisanjeKlaseArtikla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOdustani.setBounds(22, 168, 89, 23);
		frmBrisanjeKlaseArtikla.getContentPane().add(btnOdustani);
	}

}
