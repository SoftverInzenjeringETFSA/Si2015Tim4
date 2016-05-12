package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OtpisDokument {

	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtpisDokument window = new OtpisDokument();
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
					OtpisDokument window = new OtpisDokument();
					
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
	public OtpisDokument() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblKreiranjeOtpisDokumenta = new JLabel("Kreiranje dokumenta otpisa:");
		lblKreiranjeOtpisDokumenta.setBounds(215, 47, 200, 20);
		lblKreiranjeOtpisDokumenta.setForeground(new Color(0, 128, 0));
		lblKreiranjeOtpisDokumenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(525, 11, 140, 23);
		
		JLabel lblPostojeiArtikli = new JLabel("Postojeći artikli:");
		lblPostojeiArtikli.setBounds(10, 107, 75, 14);
		
		JLabel lblDodaniArtikli = new JLabel("Dodani artikli");
		lblDodaniArtikli.setBounds(442, 105, 61, 14);
		
		JList list = new JList();
		list.setBounds(10, 139, 100, 0);
		
		JList list_1 = new JList();
		list_1.setBounds(442, 137, 223, 257);
		
		JList list_2 = new JList();
		list_2.setBounds(10, 139, 212, 255);
		
		JLabel lblUnesiteKoliinu = new JLabel("Unesite količinu:");
		lblUnesiteKoliinu.setBounds(289, 139, 77, 14);
		
		
		JButton btnDodaj = new JButton("Dodaj >>");
		btnDodaj.setBounds(289, 288, 79, 23);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnOdustani.setBounds(215, 412, 112, 23);
		
		JButton btnZakljuiDokument = new JButton("Zaključi dokument");
		btnZakljuiDokument.setBounds(345, 412, 117, 23);
		
		JLabel lblNewLabel = new JLabel("Komentar:");
		lblNewLabel.setBounds(289, 203, 78, 14);
		
		textField = new JTextField();
		textField.setBounds(289, 161, 86, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(289, 233, 86, 20);
		textField_1.setColumns(10);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblPostojeiArtikli);
		frame.getContentPane().add(list);
		frame.getContentPane().add(list_2);
		frame.getContentPane().add(lblUnesiteKoliinu);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(btnDodaj);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblDodaniArtikli);
		frame.getContentPane().add(list_1);
		frame.getContentPane().add(lblKreiranjeOtpisDokumenta);
		frame.getContentPane().add(lblKorisnik);
		frame.getContentPane().add(btnOdustani);
		frame.getContentPane().add(btnZakljuiDokument);
	}

}
