package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import org.apache.log4j.Logger;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;;

public class LogInScreen {

	private JFrame frame;
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LogInScreen window = new LogInScreen();
					window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.info(e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogInScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBackground(Color.DARK_GRAY);
		frame.setTitle("Prijava na sistem");
		frame.setBounds(100, 100, 260, 207);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnikoIme.setBounds(18, 70, 92, 14);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLozinka.setBounds(55, 95, 43, 14);
		
		textField = new JTextField();
		textField.setBounds(120, 67, 124, 20);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 93, 124, 20);
		
		final JLabel validacija = new JLabel("  ");
		validacija.setBounds(18, 42, 217, 14);
		validacija.setForeground(Color.RED);
		
		JButton btnPotvrdi = new JButton("Prijava");
		btnPotvrdi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPotvrdi.setBounds(153, 131, 82, 23);
		btnPotvrdi.setBackground(new Color(143, 188, 143));
		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				TipZaposlenika korisnik;
				try {
					korisnik = provjerUserPass(textField.getText(), new String(passwordField.getPassword()));
										
					if(korisnik.equals(null)){
						validacija.setText("Korisnicko ime ili lozinka nisu tačni!");	
					}
					else if("Skladistar".equals(korisnik.getPrivilegija()))
					{
						GlavniInterfejs.pokreni(frame, korisnik);
					}
					else if("Sef".equals(korisnik.getPrivilegija()))
					{
						ProsireniInterfejsGUI.pokreni(frame, korisnik);
					}
				}
				catch (Exception e) {
					logger.info(e);
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Dobrodošli");
		lblNewLabel.setBounds(85, 21, 80, 17);
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnExit = new JButton("Kraj");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExit.setBounds(42, 131, 82, 23);
		btnExit.setBackground(new Color(143, 188, 143));
		btnExit.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnPotvrdi);
		frame.getContentPane().add(lblKorisnikoIme);
		frame.getContentPane().add(lblLozinka);
		frame.getContentPane().add(btnExit);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(validacija);
		frame.getContentPane().add(lblNewLabel);
	}
	/*
	public static String provjerUserPass(String username, char[] cs) throws Exception{
		
		String psw = new String(cs);
		TipZaposlenika tip;
		tip = TipZaposlenikaKontroler.nadjiKorisnickoIme(username);
		if(tip==null){
			return "nema";
		}
		if(tip.getLozinka().equals(psw))
		{
			if("Sef".equals(tip.getPrivilegija())) return "Sef";
			else return "Skladistar";
		}
		else{
			return "Unesite validne podatke!";
		}
	}
	*/
	public static TipZaposlenika provjerUserPass(String username, String password) throws Exception{
		
		try{
			TipZaposlenika zaposlenik = TipZaposlenikaKontroler.nadjiKorisnickoIme(username);
			
			if(zaposlenik.getLozinka().equals(password)){
				return zaposlenik;
			}
		}
		catch(Exception i){
			logger.info(i);
		}
		
		return null;
	}
}
