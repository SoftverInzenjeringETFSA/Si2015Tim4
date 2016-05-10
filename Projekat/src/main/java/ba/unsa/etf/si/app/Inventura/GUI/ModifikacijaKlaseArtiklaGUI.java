package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;


import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;

public class ModifikacijaKlaseArtiklaGUI {

	private JFrame frame;
	private JTextField txtNaziv;
	private JList listKlase;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifikacijaKlaseArtiklaGUI window = new ModifikacijaKlaseArtiklaGUI();
					window.frame.setVisible(true);
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
		btnIzmjeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					KlasaArtikla klasa = (KlasaArtikla)listKlase.getSelectedValue();
					klasa.setNaziv(txtNaziv.getText());
					KlasaArtikalaKontroler.izmijeni(klasa);
					
					postaviListu();
				}
				catch(Exception i){
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		
		btnIzmjeni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIzmjeni.setBounds(221, 322, 89, 23);
		frame.getContentPane().add(btnIzmjeni);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
			frmModifikacijaKlaseArtikla.dispose();
			frmModifikacijaKlaseArtikla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			frame.dispose();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			*/
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
		lblModifikacijaKlaseArtikla.setBounds(20, 27, 209, 34);
		frame.getContentPane().add(lblModifikacijaKlaseArtikla);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 72, 290, 14);
		frame.getContentPane().add(separator);
		
		JLabel lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(241, 46, 69, 14);
		frame.getContentPane().add(lblKorisnik);
	}
	
	private void postaviListu(){
		List<KlasaArtikla> klase=KlasaArtikalaKontroler.lista();
		
		DefaultListModel model=new DefaultListModel();
		
		for(KlasaArtikla k:klase){
			model.addElement(k);
		}
		
		listKlase.setModel(model);
	}
}
