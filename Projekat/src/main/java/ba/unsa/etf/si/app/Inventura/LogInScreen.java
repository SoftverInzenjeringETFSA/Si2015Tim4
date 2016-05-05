package ba.unsa.etf.si.app.Inventura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

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
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnPotvrdi = new JButton("Prijava");
		btnPotvrdi.setBackground(new Color(143, 188, 143));
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("Dobrodošli");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frmPrijavaNaSistem.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPotvrdi))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblKorisnikoIme)
								.addComponent(lblLozinka, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
					.addGap(33))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(77)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKorisnikoIme, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLozinka))
					.addGap(18)
					.addComponent(btnPotvrdi)
					.addContainerGap())
		);
		frmPrijavaNaSistem.getContentPane().setLayout(groupLayout);
	}
}
