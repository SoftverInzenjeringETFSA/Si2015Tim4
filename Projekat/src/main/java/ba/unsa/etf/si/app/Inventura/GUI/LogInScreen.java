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

	private JFrame frmPrijavaNaSistem;
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
					window.frmPrijavaNaSistem.setVisible(true);
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
		frmPrijavaNaSistem = new JFrame();
		frmPrijavaNaSistem.getContentPane().setBackground(SystemColor.control);
		frmPrijavaNaSistem.setBackground(Color.DARK_GRAY);
		frmPrijavaNaSistem.setTitle("Prijava na sistem");
		frmPrijavaNaSistem.setBounds(100, 100, 260, 207);
		frmPrijavaNaSistem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblKorisnikoIme = new JLabel("Korisnièko ime:");
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		final JLabel validacija = new JLabel("  ");
		validacija.setForeground(Color.RED);
		
		JButton btnPotvrdi = new JButton("Prijava");
		btnPotvrdi.setBackground(new Color(143, 188, 143));
		btnPotvrdi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String priv;
				try {
					priv = provjerUserPass(textField.getText(), passwordField.getPassword());
					if(priv.equals("Skladistar"))
					{
						GlavniInterfejs g=new GlavniInterfejs();
						GlavniInterfejs.pokreni();
					}
					else if(priv.equals("Sef"))
					{
						ProsireniInterfejsGUI pg=new ProsireniInterfejsGUI();
						ProsireniInterfejsGUI.pokreni();
					}
					else if(priv.equals("nema")){
						validacija.setText("Korisnicko ime ili lozinka nisu tacni");	
					}
				} catch (Exception e) {
					System.out.print("Ne provjeri pass i ne nadje usera");
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Dobrodošli");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frmPrijavaNaSistem.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
							.addComponent(btnPotvrdi))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblLozinka, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblKorisnikoIme))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
								.addComponent(validacija, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(validacija)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKorisnikoIme, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLozinka))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(btnPotvrdi))
					.addContainerGap())
		);
		frmPrijavaNaSistem.getContentPane().setLayout(groupLayout);
	}
	
	public static String provjerUserPass(String username, char[] cs) throws Exception{
		
		String psw = new String(cs);
		TipZaposlenika tip = new TipZaposlenika();
		//tip = TipZaposlenikaKontroler.nadjiIme(username);
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
}
