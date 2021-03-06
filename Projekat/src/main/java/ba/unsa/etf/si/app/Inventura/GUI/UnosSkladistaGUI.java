	package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.SkladisteKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Skladiste;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnosSkladistaGUI {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;
	
	private JLabel lblKorisnik;
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UnosSkladistaGUI window = new UnosSkladistaGUI();
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
					UnosSkladistaGUI window = new UnosSkladistaGUI();
					
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
	public UnosSkladistaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setTitle("Unos skladišta");
		frame.setBounds(100, 100, 440, 279);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unos skladišta");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 34, 198, 35);
		frame.getContentPane().add(lblNewLabel);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(274, 54, 119, 14);
		frame.getContentPane().add(lblKorisnik);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 87, 371, 14);
		frame.getContentPane().add(separator);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNaziv.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNaziv.setBounds(75, 115, 46, 14);
		frame.getContentPane().add(lblNaziv);
		
		JLabel lblLokacija = new JLabel("Lokacija:");
		lblLokacija.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLokacija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLokacija.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLokacija.setBounds(69, 147, 52, 14);
		frame.getContentPane().add(lblLokacija);
		
		textField = new JTextField();
		textField.setBounds(131, 112, 207, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(131, 144, 207, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.setBackground(new Color(143, 188, 143));
		btnUnesi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String naziv=textField.getText();
				String lokacija=textField_1.getText();
				if(naziv==" "|| lokacija==" "){
					
					JOptionPane.showMessageDialog(frame, "Naziv ili lokacija nisu popunjeni.");
					

				}
				else{
				
				try{
					Skladiste s=new Skladiste(textField.getText(),textField_1.getText(),korisnik);
					SkladisteKontroler.dodajInfoOSkladistu(s);				
				}
				catch(Exception i){
					logger.info(i);
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
				
			}
			}	
		});
		btnUnesi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUnesi.setBounds(285, 191, 108, 23);
		frame.getContentPane().add(btnUnesi);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setBackground(new Color(143, 188, 143));
		btnOdustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOdustani.setBounds(43, 191, 108, 23);
		frame.getContentPane().add(btnOdustani);
	}



}

