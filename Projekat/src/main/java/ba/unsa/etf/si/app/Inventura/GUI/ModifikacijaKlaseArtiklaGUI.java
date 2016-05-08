package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import ba.unsa.etf.si.app.Inventura.Servis.Servis;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;

public class ModifikacijaKlaseArtiklaGUI {

	private JFrame frmModifikacijaKlaseArtikla;
	private JTextField txtNaziv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifikacijaKlaseArtiklaGUI window = new ModifikacijaKlaseArtiklaGUI();
					window.frmModifikacijaKlaseArtikla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
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
		frmModifikacijaKlaseArtikla = new JFrame();
		frmModifikacijaKlaseArtikla.setTitle("Modifikacija klase artikla");
		frmModifikacijaKlaseArtikla.setBounds(100, 100, 342, 407);
		frmModifikacijaKlaseArtikla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModifikacijaKlaseArtikla.getContentPane().setLayout(null);
		
		JLabel lblKlaseArtikala = new JLabel("Klase artikala:");
		lblKlaseArtikala.setHorizontalAlignment(SwingConstants.LEFT);
		lblKlaseArtikala.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKlaseArtikala.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKlaseArtikala.setBounds(20, 107, 77, 14);
		frmModifikacijaKlaseArtikla.getContentPane().add(lblKlaseArtikala);
		
		JList listKlase = new JList();
		listKlase.setBounds(20, 132, 290, 102);
		frmModifikacijaKlaseArtikla.getContentPane().add(listKlase);
		
		JLabel lblNoviNaziv = new JLabel("Novi naziv:");
		lblNoviNaziv.setHorizontalAlignment(SwingConstants.LEFT);
		lblNoviNaziv.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNoviNaziv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNoviNaziv.setBounds(20, 256, 69, 14);
		frmModifikacijaKlaseArtikla.getContentPane().add(lblNoviNaziv);
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(20, 281, 290, 20);
		frmModifikacijaKlaseArtikla.getContentPane().add(txtNaziv);
		txtNaziv.setColumns(10);
		
		JButton btnIzmjeni = new JButton("Izmjeni");
		btnIzmjeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					KlasaArtikla klasa = new KlasaArtikla();
					klasa=Servis.KlaseArtikala.nadji(txtNaziv.getText()); // validacija jel nasao??
					Servis.KlaseArtikala.izmijeni(klasa);
				}
				catch(Exception i){
					Component frame = null;
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		
		btnIzmjeni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIzmjeni.setBounds(221, 322, 89, 23);
		frmModifikacijaKlaseArtikla.getContentPane().add(btnIzmjeni);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOdustani.setBounds(20, 322, 89, 23);
		frmModifikacijaKlaseArtikla.getContentPane().add(btnOdustani);
		
		JLabel lblModifikacijaKlaseArtikla = new JLabel("Modifikacija klase artikla");
		lblModifikacijaKlaseArtikla.setForeground(new Color(0, 128, 0));
		lblModifikacijaKlaseArtikla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModifikacijaKlaseArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblModifikacijaKlaseArtikla.setHorizontalAlignment(SwingConstants.LEFT);
		lblModifikacijaKlaseArtikla.setBounds(20, 27, 209, 34);
		frmModifikacijaKlaseArtikla.getContentPane().add(lblModifikacijaKlaseArtikla);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 72, 290, 14);
		frmModifikacijaKlaseArtikla.getContentPane().add(separator);
		
		JLabel lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(241, 46, 69, 14);
		frmModifikacijaKlaseArtikla.getContentPane().add(lblKorisnik);
	}
}
