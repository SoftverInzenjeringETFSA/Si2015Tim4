package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.log4j.Logger;

import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
import ba.unsa.etf.si.app.Inventura.Model.ValidacijaArtikla;

import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class BrisanjeArtikla {
	
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTextField txtBarkod;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BrisanjeArtikla window = new BrisanjeArtikla();
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
					BrisanjeArtikla window = new BrisanjeArtikla();
					
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
	public BrisanjeArtikla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setTitle("Uklanjanje artikla");
		frame.setBounds(100, 100, 361, 205);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUklanjanjeArtikla = new JLabel("Uklanjanje artikla");
		lblUklanjanjeArtikla.setHorizontalAlignment(SwingConstants.LEFT);
		lblUklanjanjeArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUklanjanjeArtikla.setBounds(36, 11, 128, 36);
		lblUklanjanjeArtikla.setForeground(new Color(0, 128, 0));
		lblUklanjanjeArtikla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblArtikalId = new JLabel("Unesite Bar kod artikla koji želite obrisati:");
		lblArtikalId.setBounds(36, 66, 299, 14);
		
		final JLabel VbarCode = new JLabel("  ");
		VbarCode.setBounds(36, 112, 6, 14);
		txtBarkod = new JTextField();
		txtBarkod.setBounds(36, 91, 207, 20);
		txtBarkod.setColumns(10);
		
		JButton btnNewButton = new JButton("Odustani");
		btnNewButton.setBounds(36, 132, 87, 23);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnNewButton.setBackground(new Color(143, 188, 143));
		
		JButton btnNewButton_1 = new JButton("Obriši");
		btnNewButton_1.setBounds(168, 132, 81, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String barkod=txtBarkod.getText();
				try {
					if(ValidacijaArtikla.validirajBarkod(txtBarkod.getText())){
					Artikal art=ArtikliKontroler.nadjiBarKod(barkod);
						//Artikal art=new Artikal();
					//art=ArtikliKontroler.nadjiBarKod(barkod);
					ArtikliKontroler.izbrisi(art.getId());
					JOptionPane.showMessageDialog(null, "Artikal uspljesno izbrisan");
					}
					
				} catch (Exception e1) {
					
					logger.info(e1);
					JOptionPane.showMessageDialog(null, "Artikal nije u bazi");
				}
			}
		});
		btnNewButton_1.setBackground(new Color(143, 188, 143));
		
		txtBarkod.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				
				if(ValidacijaArtikla.validirajBarkod(txtBarkod.getText())) {
					txtBarkod.setBackground(Color.WHITE);
					VbarCode.setText("  ");
				}
				else{
					txtBarkod.setBackground(Color.getHSBColor(0, 80, 100));
					VbarCode.setText("treba imati 13 znakova");
					VbarCode.setForeground(Color.RED);
				}
					
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajBarkod(txtBarkod.getText())) {
					txtBarkod.setBackground(Color.WHITE);
					VbarCode.setText("  ");
				}
				else{
					txtBarkod.setBackground(Color.getHSBColor(0, 80, 100));
					VbarCode.setText("treba imati 13 znakova");
					VbarCode.setForeground(Color.RED);
				}
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajBarkod(txtBarkod.getText())) {
					txtBarkod.setBackground(Color.WHITE);
					VbarCode.setText("  ");
				}
				else{
					txtBarkod.setBackground(Color.getHSBColor(0, 80, 100));
					VbarCode.setText("treba imati 13 znakova");
					VbarCode.setForeground(Color.RED);
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 53, 277, 2);
		separator.setForeground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(VbarCode);
		frame.getContentPane().add(lblUklanjanjeArtikla);
		frame.getContentPane().add(lblArtikalId);
		frame.getContentPane().add(separator);
		frame.getContentPane().add(txtBarkod);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(btnNewButton_1);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setBounds(209, 32, 102, 14);
		frame.getContentPane().add(lblKorisnik);
	}
}
