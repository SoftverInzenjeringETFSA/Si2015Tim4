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
import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;

import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;


import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.*;
import ba.unsa.etf.si.app.Inventura.Model.ValidacijaArtikla;;


public class DodavanjeArtikla {

	private JFrame frame;
	private JTextField txtNaziv;
	private JTextField txtBarkod;
	private JTextField txtCijena;
	private JTextField txtKolicina;
	private JComboBox<KlasaArtikla> comboKlasa;
	private JComboBox<String> comboMjera;
	
	
	private List<KlasaArtikla> _artikli;
	private List<String> _mjera = Arrays.asList("kom", "kg", "g", "l", "dl");
	
	/**
	 * Launch the application.
	 */
	
	public static void  main(String[] args) {
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
	
	public static void  pokreni(){
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
		_artikli = KlasaArtikalaKontroler.lista();
		frame = new JFrame();
		frame.setTitle("Dodavanje artikla");
		frame.getContentPane().setBackground(SystemColor.control);
		
		JLabel lblDodavanjeArtikla = new JLabel("Unos novog artikla");
		lblDodavanjeArtikla.setForeground(new Color(0, 100, 0));
		lblDodavanjeArtikla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Naziv artikla:");
		
		JLabel lblNewLabel_1 = new JLabel("Klasa artikla:");
		
		
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
					if(ValidacijaArtikla.validirajNaziv(txtNaziv.getText()) && ValidacijaArtikla.validirajBarkod(txtBarkod.getText()) && ValidacijaArtikla.validirajCijenu(txtCijena.getText()) && ValidacijaArtikla.validirajKolicinu(txtKolicina.getText(),_mjera.get(comboMjera.getSelectedIndex())))
					{	
						Artikal a= new Artikal();
						a=dajArtikal();
						ArtikliKontroler.dodaj(a);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Nisu pravilno uneseni parametri");
					}					
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
		
		comboKlasa = new JComboBox<KlasaArtikla>();
		if(_artikli.size() != 0) {
			for(KlasaArtikla a : _artikli) {
				if(a != null) {
					comboKlasa.addItem(a);
				}
			}
		}
		
		
		JLabel lblCijenaArtikla = new JLabel("Cijena artikla:");
		
		txtCijena = new JTextField();
		txtCijena.setColumns(10);
		
		JLabel lblKoliinaArtikla = new JLabel("Količina artikla:");
		
		txtKolicina = new JTextField();
		txtKolicina.setColumns(10);
		
		JLabel lblMjernaJedinica = new JLabel("Mjerna jedinica:");
		
		
		comboMjera = new JComboBox<String>();
		if(_mjera.size() != 0) {
			for(String m : _mjera) {
				if(m != null) {
					comboMjera.addItem(m);
				}
			}
		}
		
		final JLabel VbarCode = new JLabel("  ");
		
		final JLabel Vnaziv = new JLabel("  ");
		
		final JLabel Vcijena = new JLabel("  ");
		
		final JLabel Vkolicina = new JLabel("  ");
		
		txtNaziv.getDocument().addDocumentListener(new DocumentListener(){
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajNaziv(txtNaziv.getText())) {
					txtNaziv.setBackground(Color.WHITE);
					Vnaziv.setText("  ");
				}
				else{
					txtNaziv.setBackground(Color.getHSBColor(0, 80, 100));
					Vnaziv.setText("Niste unjeli naziv");
					Vnaziv.setForeground(Color.RED);
				}
				
			}

			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajNaziv(txtNaziv.getText())) {
					txtNaziv.setBackground(Color.WHITE);
					Vnaziv.setText("  ");
				}
				else{
					txtNaziv.setBackground(Color.getHSBColor(0, 80, 100));
					Vnaziv.setText("Niste unjeli naziv");
					Vnaziv.setForeground(Color.RED);
				}
				
			}

			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(true==ValidacijaArtikla.validirajNaziv(txtNaziv.getText())) {
					txtNaziv.setBackground(Color.WHITE);
					Vnaziv.setText("  ");
				}
				else{
					txtNaziv.setBackground(Color.getHSBColor(0, 80, 100));
					Vnaziv.setText("Niste unjeli naziv");
					Vnaziv.setForeground(Color.RED);
				}
			}
		});
		
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
		
		txtCijena.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajCijenu(txtCijena.getText())) {
					txtCijena.setBackground(Color.WHITE);
					Vcijena.setText("  ");
				}
				else{
					txtCijena.setBackground(Color.getHSBColor(0, 80, 100));
					Vcijena.setText("mora biti broj");
					Vcijena.setForeground(Color.RED);
				}
					
				
			}

			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajCijenu(txtCijena.getText())) {
					txtCijena.setBackground(Color.WHITE);
					Vcijena.setText("  ");
				}
				else{
					txtCijena.setBackground(Color.getHSBColor(0, 80, 100));
					Vcijena.setText("mora biti broj");
					Vcijena.setForeground(Color.RED);
				}
				
			}

			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajCijenu(txtCijena.getText())) {
					txtCijena.setBackground(Color.WHITE);
					Vcijena.setText("  ");
				}
				else{
					txtCijena.setBackground(Color.getHSBColor(0, 80, 100));
					Vcijena.setText("mora biti broj");
					Vcijena.setForeground(Color.RED);
				}
			}
		});
		
		txtKolicina.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajKolicinu(txtKolicina.getText(), _mjera.get(comboMjera.getSelectedIndex()))){
					txtKolicina.setBackground(Color.WHITE);
					Vkolicina.setText("  ");
				}
				else{
					txtKolicina.setBackground(Color.getHSBColor(0, 80, 100));
					Vkolicina.setText("mora biti cijeli broj");
					Vkolicina.setForeground(Color.RED);
				}
			}

			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajKolicinu(txtKolicina.getText(), _mjera.get(comboMjera.getSelectedIndex()))){
					txtKolicina.setBackground(Color.WHITE);
					Vkolicina.setText("  ");
				}
				else{
					txtKolicina.setBackground(Color.getHSBColor(0, 80, 100));
					Vkolicina.setText("mora biti cijeli broj");
					Vkolicina.setForeground(Color.RED);
				}
				
			}

			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(ValidacijaArtikla.validirajKolicinu(txtKolicina.getText(), _mjera.get(comboMjera.getSelectedIndex()))){
					txtKolicina.setBackground(Color.WHITE);
					Vkolicina.setText("  ");
				}
				else{
					txtKolicina.setBackground(Color.getHSBColor(0, 80, 100));
					Vkolicina.setText("mora biti cijeli broj");
					Vkolicina.setForeground(Color.RED);
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDodavanjeArtikla))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBarKodArtikla)
								.addComponent(lblCijenaArtikla)
								.addComponent(lblNewLabel)
								.addComponent(lblKoliinaArtikla)
								.addComponent(lblNewLabel_1)
								.addComponent(lblMjernaJedinica)
								.addComponent(btnZavrsi, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboMjera, 0, 154, Short.MAX_VALUE)
								.addComponent(comboKlasa, 0, 154, Short.MAX_VALUE)
								.addComponent(Vnaziv)
								.addComponent(VbarCode)
								.addComponent(txtBarkod, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addComponent(Vcijena)
								.addComponent(btnUnesi, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(Vkolicina)
								.addComponent(txtNaziv, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(txtCijena, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(txtKolicina, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDodavanjeArtikla, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBarKodArtikla)
						.addComponent(txtBarkod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(VbarCode)
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addComponent(Vnaziv)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(comboKlasa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCijenaArtikla)
						.addComponent(txtCijena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addComponent(Vcijena)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoliinaArtikla)
						.addComponent(txtKolicina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addComponent(Vkolicina)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboMjera, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMjernaJedinica, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnUnesi)
						.addComponent(btnZavrsi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 318, 374);
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
		}
		
		return artikal;
	}
}
