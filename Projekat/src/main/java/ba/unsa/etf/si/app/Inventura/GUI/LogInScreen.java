package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;;

public class LogInScreen {

	private JFrame frame;
	
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInScreen window = new LogInScreen();
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
			
			public void actionPerformed(ActionEvent arg0) {
				
				TipZaposlenika korisnik;
				try {
					korisnik = provjerUserPass(textField.getText(), new String(passwordField.getPassword()));
										
					if(korisnik==null){
						validacija.setText("Korisnicko ime ili lozinka nisu tačni!");	
					}
					else if(korisnik.getPrivilegija().equals("Skladistar"))
					{
						GlavniInterfejs.pokreni(frame, korisnik);
					}
					else if(korisnik.getPrivilegija().equals("Sef"))
					{
						ProsireniInterfejsGUI.pokreni(frame, korisnik);
					}
				}
				catch (Exception e) {
					System.out.print("Ne provjeri pass i ne nadje usera");
					e.printStackTrace();
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
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
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
	
	public static String provjerUserPass(String username, char[] cs) throws Exception{
		
		String psw = new String(cs);
		TipZaposlenika tip = new TipZaposlenika();
		tip = TipZaposlenikaKontroler.nadjiKorisnickoIme(username);
		if(tip==null){
			return "nema";
		}
		if(tip.getLozinka().equals(psw))
		{
			if(tip.getPrivilegija().equals("Sef")) return "Sef";
			else return "Skladistar";
		}
		else{
			return "Unesite validne podatke!";
		}
	}
	
	public static TipZaposlenika provjerUserPass(String username, String password) throws Exception{
		
		try{
			TipZaposlenika zaposlenik = TipZaposlenikaKontroler.nadjiKorisnickoIme(username);
			
			if(zaposlenik.getLozinka().equals(password)){
				return zaposlenik;
			}
			else{
				return null;
			}
		}
		catch(Exception i){
			return null;
		}
	}
}
