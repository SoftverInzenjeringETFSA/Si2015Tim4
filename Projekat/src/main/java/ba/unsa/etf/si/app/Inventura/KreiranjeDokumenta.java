package ba.unsa.etf.si.app.Inventura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class KreiranjeDokumenta {

	private JFrame frmKreiranjeDokumenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KreiranjeDokumenta window = new KreiranjeDokumenta();
					window.frmKreiranjeDokumenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KreiranjeDokumenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKreiranjeDokumenta = new JFrame();
		frmKreiranjeDokumenta.setTitle("Kreiranje dokumenta");
		frmKreiranjeDokumenta.getContentPane().setBackground(Color.WHITE);
		frmKreiranjeDokumenta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kreiranje novog dokumenta");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(43, 43, 195, 19);
		frmKreiranjeDokumenta.getContentPane().add(lblNewLabel);
		
		JLabel lblImePrijavljenogKorisnika = new JLabel("ime prijavljenog korisnika");
		lblImePrijavljenogKorisnika.setBounds(293, 21, 131, 14);
		frmKreiranjeDokumenta.getContentPane().add(lblImePrijavljenogKorisnika);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(43, 75, 362, 2);
		frmKreiranjeDokumenta.getContentPane().add(separator);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(43, 88, 362, 89);
		frmKreiranjeDokumenta.getContentPane().add(textPane);
		
		JButton btnPridui = new JButton("Priduži se");
		btnPridui.setBounds(316, 188, 89, 23);
		frmKreiranjeDokumenta.getContentPane().add(btnPridui);
		
		JButton btnZavri = new JButton("Završi");
		btnZavri.setBounds(43, 227, 89, 23);
		frmKreiranjeDokumenta.getContentPane().add(btnZavri);
		
		JButton btnZaponiNovi = new JButton("Započni novi");
		btnZaponiNovi.setBounds(293, 227, 112, 23);
		frmKreiranjeDokumenta.getContentPane().add(btnZaponiNovi);
		frmKreiranjeDokumenta.setBounds(100, 100, 450, 300);
		frmKreiranjeDokumenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
