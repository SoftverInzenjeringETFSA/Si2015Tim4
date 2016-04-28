package ba.unsa.etf.si.app.Inventura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;

public class DodavanjeArtikla {

	private JFrame frmDodavanjeArtikla;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeArtikla window = new DodavanjeArtikla();
					window.frmDodavanjeArtikla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeArtikla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeArtikla = new JFrame();
		frmDodavanjeArtikla.setTitle("Dodavanje artikla");
		frmDodavanjeArtikla.getContentPane().setBackground(new Color(255, 255, 255));
		
		JLabel lblDodavanjeArtikla = new JLabel("Unos novog artikla");
		lblDodavanjeArtikla.setForeground(new Color(0, 100, 0));
		lblDodavanjeArtikla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Naziv artikla:");
		
		JLabel lblNewLabel_1 = new JLabel("Klasa artikla:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		JButton btnZavri = new JButton("Završi");
		btnZavri.setBackground(new Color(143, 188, 143));
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.setBackground(new Color(143, 188, 143));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		GroupLayout groupLayout = new GroupLayout(frmDodavanjeArtikla.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnZavri, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
								.addComponent(btnUnesi, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDodavanjeArtikla))))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblDodavanjeArtikla, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnZavri)
						.addComponent(btnUnesi))
					.addContainerGap())
		);
		frmDodavanjeArtikla.getContentPane().setLayout(groupLayout);
		frmDodavanjeArtikla.setBackground(new Color(255, 255, 255));
		frmDodavanjeArtikla.setBounds(100, 100, 356, 263);
		frmDodavanjeArtikla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
