package ba.unsa.etf.si.app.Inventura;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class OtpisDokument {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtpisDokument window = new OtpisDokument();
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
	public OtpisDokument() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblKreiranjeOtpisDokumenta = new JLabel("Kreiranje dokumenta otpisa:");
		lblKreiranjeOtpisDokumenta.setForeground(new Color(0, 128, 0));
		lblKreiranjeOtpisDokumenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime");
		
		JLabel lblPostojeiArtikli = new JLabel("Postojeći artikli:");
		
		JLabel lblDodaniArtikli = new JLabel("Dodani artikli");
		
		JList list = new JList();
		
		JList list_1 = new JList();
		
		JList list_2 = new JList();
		
		JLabel lblUnesiteKoliinu = new JLabel("Unesite količinu:");
		
		
		JButton btnDodaj = new JButton("Dodaj >>");
		
		JButton btnOdustani = new JButton("Odustani");
		
		JButton btnZakljuiDokument = new JButton("Zaključi dokument");
		
		JLabel lblNewLabel = new JLabel("Komentar:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPostojeiArtikli)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(112))
								.addComponent(list_2, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
							.addGap(67)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUnesiteKoliinu)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDodaj)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
							.addGap(67)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDodaniArtikli)
						.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(215)
					.addComponent(lblKreiranjeOtpisDokumenta)
					.addContainerGap(270, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(586, Short.MAX_VALUE)
					.addComponent(lblKorisnikoIme)
					.addGap(33))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(215, Short.MAX_VALUE)
					.addComponent(btnOdustani, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnZakljuiDokument)
					.addGap(223))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblKorisnikoIme)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblDodaniArtikli)
							.addGap(18)
							.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(96)
									.addComponent(lblPostojeiArtikli))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(36)
									.addComponent(lblKreiranjeOtpisDokumenta)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(list)
								.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUnesiteKoliinu)
									.addGap(8)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(22)
									.addComponent(lblNewLabel)
									.addGap(16)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(35)
									.addComponent(btnDodaj)))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnZakljuiDokument)
						.addComponent(btnOdustani))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
