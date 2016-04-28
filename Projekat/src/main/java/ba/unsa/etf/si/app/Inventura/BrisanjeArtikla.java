package ba.unsa.etf.si.app.Inventura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;

public class BrisanjeArtikla {

	private JFrame frmUklanjanjeArtikla;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeArtikla window = new BrisanjeArtikla();
					window.frmUklanjanjeArtikla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BrisanjeArtikla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUklanjanjeArtikla = new JFrame();
		frmUklanjanjeArtikla.getContentPane().setBackground(new Color(255, 255, 255));
		frmUklanjanjeArtikla.setTitle("Uklanjanje artikla");
		frmUklanjanjeArtikla.setBounds(100, 100, 361, 205);
		frmUklanjanjeArtikla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUklanjanjeArtikla = new JLabel("Uklanjanje artikla");
		lblUklanjanjeArtikla.setForeground(new Color(0, 128, 0));
		lblUklanjanjeArtikla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblArtikalId = new JLabel("Artikal ID:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Završi");
		btnNewButton.setBackground(new Color(143, 188, 143));
		
		JButton btnNewButton_1 = new JButton("Ukloni");
		btnNewButton_1.setBackground(new Color(143, 188, 143));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		GroupLayout groupLayout = new GroupLayout(frmUklanjanjeArtikla.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblArtikalId)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
									.addGap(39))
								.addComponent(lblUklanjanjeArtikla, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))))
					.addGap(32))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUklanjanjeArtikla, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArtikalId))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		frmUklanjanjeArtikla.getContentPane().setLayout(groupLayout);
	}

}