package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;


import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodavanjeArtikla {

	private JFrame frame;
	private JTextField txtNaziv;
	private JTextField txtBarkod;
	private JTextField txtCijena;
	private JTextField txtKolicina;
	private JComboBox comboKlasa;
	private JComboBox comboMjera;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeArtikla window = new DodavanjeArtikla();
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
	public DodavanjeArtikla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Dodavanje artikla");
		frame.getContentPane().setBackground(SystemColor.control);
		
		JLabel lblDodavanjeArtikla = new JLabel("Unos novog artikla");
		lblDodavanjeArtikla.setForeground(new Color(0, 100, 0));
		lblDodavanjeArtikla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Naziv artikla:");
		
		JLabel lblNewLabel_1 = new JLabel("Klasa artikla:");
		
		//ovdje napisati kako da povuce iz baze sve klase artikla??
		
		txtNaziv = new JTextField();
		txtNaziv.setColumns(10);
		JButton btnZavrsi = new JButton("Odustani");
		btnZavrsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnZavrsi.setBackground(new Color(143, 188, 143));
		
		JButton btnUnesi = new JButton("Dodaj");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Artikal a= new Artikal();
					a=dajArtikal();
					ArtikliKontroler.dodaj(a);
					System.out.println(a.getNaziv());
					
				}
				catch(Exception i){
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		btnUnesi.setBackground(new Color(143, 188, 143));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		
		JLabel lblBarKodArtikla = new JLabel("Bar kod artikla:");
		
		txtBarkod = new JTextField();
		txtBarkod.setColumns(10);
		
		comboKlasa = new JComboBox();
		
		JLabel lblCijenaArtikla = new JLabel("Cijena artikla:");
		
		txtCijena = new JTextField();
		txtCijena.setColumns(10);
		
		JLabel lblKoliinaArtikla = new JLabel("Količina artikla:");
		
		txtKolicina = new JTextField();
		txtKolicina.setColumns(10);
		
		JLabel lblMjernaJedinica = new JLabel("Mjerna jedinica:");
		
		comboMjera = new JComboBox();
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDodavanjeArtikla))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblCijenaArtikla)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblBarKodArtikla)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel)
												.addComponent(lblKoliinaArtikla)
												.addComponent(lblMjernaJedinica)))
										.addComponent(lblNewLabel_1))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboMjera, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtKolicina)
										.addComponent(txtCijena)
										.addComponent(comboKlasa, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtNaziv)
										.addComponent(txtBarkod, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnZavrsi, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnUnesi, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDodavanjeArtikla, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBarKodArtikla)
						.addComponent(txtBarkod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboKlasa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCijena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCijenaArtikla))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoliinaArtikla)
						.addComponent(txtKolicina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMjernaJedinica)
						.addComponent(comboMjera, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnZavrsi)
						.addComponent(btnUnesi))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 303, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Artikal dajArtikal() {
		
		String naziv=txtNaziv.getText();
		KlasaArtikla klasa=(KlasaArtikla)comboKlasa.getSelectedItem();
		String barkod=txtBarkod.getText();
		Double cijena=Double.parseDouble(txtCijena.getText());
		Double kolicina=Double.parseDouble(txtKolicina.getText());
		String mjera=(String)comboMjera.getSelectedItem();
		
		Artikal artikal=new Artikal();
		try {
			artikal = new Artikal(naziv, klasa, barkod, cijena, kolicina, mjera);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ss");
		}
		
		return artikal;
	}
}
