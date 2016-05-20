package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import org.apache.log4j.Logger;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PromjenaLozinke {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JPasswordField txtStaraLozinka;
	private JPasswordField passwordNovaLozinka1;
	private JPasswordField passwordNovaLozinka2;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtJMBG;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PromjenaLozinke window = new PromjenaLozinke();
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
					PromjenaLozinke window = new PromjenaLozinke();
					
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
		
		JLabel lblUnesiteIme = new JLabel("Unesite ime:");
		lblUnesiteIme.setBounds(35, 77, 109, 14);
		frame.getContentPane().add(lblUnesiteIme);
		
		txtIme = new JTextField();
		txtIme.setBounds(174, 74, 156, 20);
		frame.getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblUnesitePrezime = new JLabel("Unesite prezime:");
		lblUnesitePrezime.setBounds(35, 108, 106, 14);
		frame.getContentPane().add(lblUnesitePrezime);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(174, 105, 156, 20);
		frame.getContentPane().add(txtPrezime);
		txtPrezime.setColumns(10);
		
		JLabel lblUnesiteJmbg = new JLabel("Unesite JMBG:");
		lblUnesiteJmbg.setBounds(35, 139, 96, 14);
		frame.getContentPane().add(lblUnesiteJmbg);
		
		txtJMBG = new JTextField();
		txtJMBG.setBounds(174, 136, 156, 20);
		frame.getContentPane().add(txtJMBG);
		txtJMBG.setColumns(10);
		frame.setBounds(100, 100, 413, 379);
		JLabel lblNewLabel = new JLabel("Promjena lozinke");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(32, 34, 109, 19);
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 59, 298, 7);
		
		JLabel lblNewLabel_1 = new JLabel("Unesite staru lozinku:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(35, 182, 129, 14);
		
		JLabel lblNewLabel_2 = new JLabel("Unesite novu lozinku:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(35, 246, 129, 14);
		
		JLabel lblNewLabel_3 = new JLabel("Potvrdite novu lozinku:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(32, 277, 132, 14);
		
		txtStaraLozinka = new JPasswordField();
		txtStaraLozinka.setBounds(174, 180, 156, 20);
		txtStaraLozinka.setColumns(10);
		
		passwordNovaLozinka1 = new JPasswordField();
		passwordNovaLozinka1.setBounds(174, 244, 156, 20);
		
		passwordNovaLozinka2 = new JPasswordField();
		passwordNovaLozinka2.setBounds(174, 275, 156, 20);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String staraLozinka=txtStaraLozinka.getText();
				String ime=txtIme.getText();
				String prezime=txtPrezime.getText();
				String JMBG = txtJMBG.getText();
				@SuppressWarnings("deprecation")
				String novaLozinka1=new String(passwordNovaLozinka1.getText());
				String novaLozinka2=new String(passwordNovaLozinka2.getText());
				
				if(korisnik.getLozinka().equals(staraLozinka) && novaLozinka1.equals(novaLozinka2) && (novaLozinka1.length()>=10) && novaLozinka2.length()>=10 && korisnik.getIme().equals(ime) && korisnik.getPrezime().equals(prezime) && korisnik.getJmbg().equals(JMBG))
				{
					korisnik.setLozinka(novaLozinka1);
					
					try{
						
						TipZaposlenikaKontroler.izmjeni(korisnik);
						JOptionPane.showMessageDialog(null, "Lozinka uspjesno promjenjena!");
					}
					catch(Exception i){
						logger.info(i);
						korisnik.setLozinka(staraLozinka);
						JOptionPane.showMessageDialog(null, i.getMessage());
					}
				}
				else if(!korisnik.getIme().equals(ime) || (!korisnik.getPrezime().equals(prezime)) || (!korisnik.getJmbg().equals(JMBG)))
				{
					JOptionPane.showMessageDialog(null, "Unesite ispravne lične podatke!");
				}
				else if(!korisnik.getLozinka().equals(staraLozinka)){
					JOptionPane.showMessageDialog(null, "Unesite ispravnu staru lozinku!");
				}
				else if(!novaLozinka1.equals(novaLozinka2)){
					JOptionPane.showMessageDialog(null, "Nova lozinka mora biti ista u oba polja!");
				}
				else if(novaLozinka1.length()<10 || novaLozinka2.length()<10){
					JOptionPane.showMessageDialog(null, "Lozinka mora biti duza od 10 karaktera!");
				}
			}
		});
		btnPotvrdi.setBounds(239, 306, 91, 23);
		btnPotvrdi.setBackground(new Color(143, 188, 143));
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOdustani.setBounds(32, 306, 91, 23);
		btnOdustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		frame.getContentPane().setLayout(null);
		btnOdustani.setBackground(new Color(143, 188, 143));
		frame.getContentPane().add(btnOdustani);
		frame.getContentPane().add(btnPotvrdi);
		frame.getContentPane().add(lblNewLabel_3);
		frame.getContentPane().add(passwordNovaLozinka2);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(passwordNovaLozinka1);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(txtStaraLozinka);
		frame.getContentPane().add(separator);
		frame.getContentPane().add(lblNewLabel);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(227, 38, 102, 14);
		frame.getContentPane().add(lblKorisnik);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
