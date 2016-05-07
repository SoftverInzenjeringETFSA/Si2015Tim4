package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class izlazniDokument {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					izlazniDokument window = new izlazniDokument();
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
	public izlazniDokument() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblKreiranjeIzlaznogDokumenta = new JLabel("Kreiranje izlaznog dokumenta:");
		lblKreiranjeIzlaznogDokumenta.setForeground(new Color(0, 128, 0));
		lblKreiranjeIzlaznogDokumenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime");
		
		JLabel lblPostojeiArtikli = new JLabel("Postojeći artikli:");
		
		JLabel lblDodaniArtikli = new JLabel("Dodani artikli");
		
		JList list = new JList();
		
		JList list_1 = new JList();
		
		JList list_2 = new JList();
		
		JLabel lblUnesiteKoliinu = new JLabel("Unesite količinu:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj >>");
		
		JButton btnOdustani = new JButton("Odustani");
		
		JButton btnZakljuiDokument = new JButton("Zaključi dokument");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPostojeiArtikli)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(112))
								.addComponent(list_2, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUnesiteKoliinu)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDodaj))
							.addGap(76)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDodaniArtikli)
						.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(215)
					.addComponent(lblKreiranjeIzlaznogDokumenta)
					.addContainerGap(279, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(215)
					.addComponent(btnOdustani, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnZakljuiDokument)
					.addContainerGap(247, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(586, Short.MAX_VALUE)
					.addComponent(lblKorisnikoIme)
					.addGap(33))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(141)
							.addComponent(lblUnesiteKoliinu)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(btnDodaj)
							.addGap(143))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblKorisnikoIme)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblDodaniArtikli)
									.addGap(18)
									.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(96)
											.addComponent(lblPostojeiArtikli))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(36)
											.addComponent(lblKreiranjeIzlaznogDokumenta)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(list)
										.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZakljuiDokument)
						.addComponent(btnOdustani))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
