package ba.unsa.etf.si.app.Inventura.GUI;
import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
import ba.unsa.etf.si.app.Inventura.Model.ValidacijaArtikla;

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
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UklanjanjeKorisnika {

	private JFrame frmUklanjanjeKorisnika;
	private JTextField textName;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UklanjanjeKorisnika window = new UklanjanjeKorisnika();
					window.frmUklanjanjeKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
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
		frmUklanjanjeKorisnika = new JFrame();
		frmUklanjanjeKorisnika.getContentPane().setBackground(SystemColor.control);
		frmUklanjanjeKorisnika.setTitle("Uklanjanje korisnika");
		frmUklanjanjeKorisnika.setBackground(new Color(255, 255, 255));
		frmUklanjanjeKorisnika.setBounds(100, 100, 390, 238);
		frmUklanjanjeKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUklanjanjeKorisnika.getContentPane().setLayout(null);
		
		JLabel lblUklanjanjeKorisnika = new JLabel("Uklanjanje korisnika");
		lblUklanjanjeKorisnika.setForeground(new Color(0, 128, 0));
		lblUklanjanjeKorisnika.setBackground(new Color(0, 128, 0));
		lblUklanjanjeKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUklanjanjeKorisnika.setBounds(23, 44, 148, 20);
		frmUklanjanjeKorisnika.getContentPane().add(lblUklanjanjeKorisnika);
		
		JLabel lblImePrijavljenogKorisnika = new JLabel("ime prijavljenog korisnika");
		lblImePrijavljenogKorisnika.setForeground(new Color(0, 0, 0));
		lblImePrijavljenogKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImePrijavljenogKorisnika.setBounds(253, 11, 128, 18);
		frmUklanjanjeKorisnika.getContentPane().add(lblImePrijavljenogKorisnika);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 75, 350, 2);
		frmUklanjanjeKorisnika.getContentPane().add(separator);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setBounds(23, 100, 94, 14);
		frmUklanjanjeKorisnika.getContentPane().add(lblKorisnikoIme);
		
		textName = new JTextField();
		textName.setBounds(122, 97, 204, 20);
		frmUklanjanjeKorisnika.getContentPane().add(textName);
		textName.setColumns(10);
		
		JButton btnZavri = new JButton("Odustani");
		btnZavri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUklanjanjeKorisnika.dispose();
				frmUklanjanjeKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnZavri.setBounds(52, 139, 89, 23);
		frmUklanjanjeKorisnika.getContentPane().add(btnZavri);
		
		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ime=textName.getText();
				try{
					TipZaposlenika tip=new TipZaposlenika();
					tip=TipZaposlenikaKontroler.nadjiIme(ime);
					TipZaposlenikaKontroler.izbrisi(tip.getId());
		
				} catch (Exception e1) {
					
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Artikal nije u bazi");
				}
			}
		});
		
		btnUkloni.setBounds(188, 139, 89, 23);
		frmUklanjanjeKorisnika.getContentPane().add(btnUkloni);
	}

}
