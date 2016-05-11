package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.ValidacijaArtikla;

import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BrisanjeArtikla {

	private JFrame frame;
	private JTextField txtBarkod;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeArtikla window = new BrisanjeArtikla();
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
	public BrisanjeArtikla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setTitle("Uklanjanje artikla");
		frame.setBounds(100, 100, 361, 205);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUklanjanjeArtikla = new JLabel("Uklanjanje artikla");
		lblUklanjanjeArtikla.setForeground(new Color(0, 128, 0));
		lblUklanjanjeArtikla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblArtikalId = new JLabel("Unesite Bar kod artikla koji želite obrisati:");
		
		JLabel VbarCode = new JLabel("  ");
		txtBarkod = new JTextField();
		txtBarkod.setColumns(10);
		
		JButton btnNewButton = new JButton("Odustani");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(143, 188, 143));
		
		JButton btnNewButton_1 = new JButton("Obriši");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String barkod=txtBarkod.getText();
				try {
					if(ValidacijaArtikla.validirajBarkod(txtBarkod.getText())){
					Artikal art=new Artikal();
					art=ArtikliKontroler.nadjiBarKod(barkod);
					ArtikliKontroler.izbrisi(art.getId());
					JOptionPane.showMessageDialog(null, "Artikal uspljesno izbrisan");
					}
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Artikal nije u bazi");
				}
			}
		});
		btnNewButton_1.setBackground(new Color(143, 188, 143));
		
		txtBarkod.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajBarkod(txtBarkod.getText())) {
					txtBarkod.setBackground(Color.WHITE);
					VbarCode.setText("  ");
				}
				else{
					txtBarkod.setBackground(Color.getHSBColor(0, 80, 100));
					VbarCode.setText("treba imati 13 znakova");
					VbarCode.setForeground(Color.RED);
				}
					
				
			}

			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajBarkod(txtBarkod.getText())) {
					txtBarkod.setBackground(Color.WHITE);
					VbarCode.setText("  ");
				}
				else{
					txtBarkod.setBackground(Color.getHSBColor(0, 80, 100));
					VbarCode.setText("treba imati 13 znakova");
					VbarCode.setForeground(Color.RED);
				}
				
			}

			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajBarkod(txtBarkod.getText())) {
					txtBarkod.setBackground(Color.WHITE);
					VbarCode.setText("  ");
				}
				else{
					txtBarkod.setBackground(Color.getHSBColor(0, 80, 100));
					VbarCode.setText("treba imati 13 znakova");
					VbarCode.setForeground(Color.RED);
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(VbarCode)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblUklanjanjeArtikla, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblArtikalId, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(separator, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
									.addGap(32))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtBarkod, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(96))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUklanjanjeArtikla, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblArtikalId)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtBarkod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(VbarCode)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
