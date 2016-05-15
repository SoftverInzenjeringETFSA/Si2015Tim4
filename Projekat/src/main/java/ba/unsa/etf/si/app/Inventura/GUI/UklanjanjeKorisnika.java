package ba.unsa.etf.si.app.Inventura.GUI;
import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
//import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

public class UklanjanjeKorisnika {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTextField textName;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UklanjanjeKorisnika window = new UklanjanjeKorisnika();
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
					UklanjanjeKorisnika window = new UklanjanjeKorisnika();
					
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
	public UklanjanjeKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setTitle("Uklanjanje korisnika");
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 390, 238);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUklanjanjeKorisnika = new JLabel("Uklanjanje korisnika");
		lblUklanjanjeKorisnika.setForeground(new Color(0, 128, 0));
		lblUklanjanjeKorisnika.setBackground(new Color(0, 128, 0));
		lblUklanjanjeKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUklanjanjeKorisnika.setBounds(10, 46, 148, 20);
		frame.getContentPane().add(lblUklanjanjeKorisnika);
		
		lblKorisnik = new JLabel("ime prijavljenog korisnika");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setForeground(new Color(0, 0, 0));
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(212, 47, 148, 18);
		frame.getContentPane().add(lblKorisnik);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 75, 350, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnikoIme.setBounds(23, 100, 94, 14);
		frame.getContentPane().add(lblKorisnikoIme);
		
		textName = new JTextField();
		textName.setBounds(122, 97, 204, 20);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		JButton btnZavrsi = new JButton("Odustani");
		btnZavrsi.setBackground(new Color(143, 188, 143));
		btnZavrsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnZavrsi.setBounds(51, 153, 106, 23);
		frame.getContentPane().add(btnZavrsi);
		
		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.setBackground(new Color(143, 188, 143));
		btnUkloni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ime=textName.getText();
				try{
					TipZaposlenika tip=new TipZaposlenika();
					tip=TipZaposlenikaKontroler.nadjiIme(ime);
					TipZaposlenikaKontroler.izbrisi(tip.getId());
		
				} catch (Exception e1) {
					logger.info(e);
					JOptionPane.showMessageDialog(null, "Artikal nije u bazi");
				}
			}
		});
		
		btnUkloni.setBounds(212, 153, 106, 23);
		frame.getContentPane().add(btnUkloni);
	}

}
