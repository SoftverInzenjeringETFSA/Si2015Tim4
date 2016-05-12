package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class izlazniDokument {

	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					izlazniDokument window = new izlazniDokument();
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
					izlazniDokument window = new izlazniDokument();
					
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
	public izlazniDokument() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblKreiranjeIzlaznogDokumenta = new JLabel("Kreiranje izlaznog dokumenta:");
		lblKreiranjeIzlaznogDokumenta.setBounds(215, 36, 215, 20);
		lblKreiranjeIzlaznogDokumenta.setForeground(new Color(0, 128, 0));
		lblKreiranjeIzlaznogDokumenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(507, 11, 158, 20);
		
		JLabel lblPostojeiArtikli = new JLabel("Postojeći artikli:");
		lblPostojeiArtikli.setBounds(10, 96, 75, 14);
		
		JLabel lblDodaniArtikli = new JLabel("Dodani artikli");
		lblDodaniArtikli.setBounds(442, 94, 61, 14);
		
		JList list = new JList();
		list.setBounds(10, 128, 100, 0);
		
		JList list_1 = new JList();
		list_1.setBounds(442, 126, 223, 257);
		
		JList list_2 = new JList();
		list_2.setBounds(10, 128, 212, 255);
		
		JLabel lblUnesiteKoliinu = new JLabel("Unesite količinu:");
		lblUnesiteKoliinu.setBounds(280, 141, 77, 14);
		
		textField = new JTextField();
		textField.setBounds(280, 166, 86, 20);
		textField.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj >>");
		btnDodaj.setBounds(280, 223, 79, 23);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnOdustani.setBounds(215, 407, 112, 23);
		
		JButton btnZakljuiDokument = new JButton("Zaključi dokument");
		btnZakljuiDokument.setBounds(345, 407, 117, 23);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblPostojeiArtikli);
		frame.getContentPane().add(list);
		frame.getContentPane().add(list_2);
		frame.getContentPane().add(lblUnesiteKoliinu);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(btnDodaj);
		frame.getContentPane().add(lblDodaniArtikli);
		frame.getContentPane().add(list_1);
		frame.getContentPane().add(lblKreiranjeIzlaznogDokumenta);
		frame.getContentPane().add(btnOdustani);
		frame.getContentPane().add(btnZakljuiDokument);
		frame.getContentPane().add(lblKorisnik);
	}

}
