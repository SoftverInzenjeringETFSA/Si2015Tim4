package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PromjenaLozinke {

	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromjenaLozinke window = new PromjenaLozinke();
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
					PromjenaLozinke window = new PromjenaLozinke();
					
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
	public PromjenaLozinke() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Promjena lozinke");
		frame.getContentPane().setBackground(SystemColor.control);
		
		JLabel lblNewLabel = new JLabel("Promjena lozinke");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(32, 34, 109, 19);
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 59, 298, 7);
		
		JLabel lblNewLabel_1 = new JLabel("Unesite staru lozinku:");
		lblNewLabel_1.setBounds(32, 80, 103, 14);
		
		JLabel lblNewLabel_2 = new JLabel("Unesite novu lozinku:");
		lblNewLabel_2.setBounds(32, 131, 102, 14);
		
		JLabel lblNewLabel_3 = new JLabel("Potvrdite novu lozinku:");
		lblNewLabel_3.setBounds(32, 169, 110, 14);
		
		textField = new JTextField();
		textField.setBounds(153, 77, 177, 20);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(152, 128, 178, 20);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(152, 166, 178, 20);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBounds(252, 212, 78, 23);
		btnPotvrdi.setBackground(new Color(143, 188, 143));
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setBounds(32, 212, 75, 23);
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		frame.getContentPane().setLayout(null);
		btnOdustani.setBackground(new Color(143, 188, 143));
		frame.getContentPane().add(btnOdustani);
		frame.getContentPane().add(btnPotvrdi);
		frame.getContentPane().add(lblNewLabel_3);
		frame.getContentPane().add(passwordField_1);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(separator);
		frame.getContentPane().add(lblNewLabel);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(227, 38, 102, 14);
		frame.getContentPane().add(lblKorisnik);
		frame.setBounds(100, 100, 385, 284);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
