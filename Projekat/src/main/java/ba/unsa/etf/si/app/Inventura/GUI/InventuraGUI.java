package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.InventuraKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.IzvjestajKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.Inventura;
import ba.unsa.etf.si.app.Inventura.Model.Izvjestaj;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public class InventuraGUI {
	
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	int brojac=1;
	private JTextField txtBarkod;
	private JTextField txtKolicina;
	private Artikal artikal=null;
	private JList listArtikli;
	private JTextField txtNaziv;
	private JTextField txtMjera;
	private List<String> popis=new ArrayList<String>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventuraGUI window = new InventuraGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void pokreni(JFrame _frameRoditelj, TipZaposlenika _korisnik) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventuraGUI window = new InventuraGUI();
					
					window.frameRoditelj=_frameRoditelj;
					window.korisnik=_korisnik;
					window.lblKorisnik.setText(window.korisnik.getIme().toUpperCase());
					
					FormaKontroler.postaviFormu(window.frameRoditelj, window.frame, false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventuraGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Inventura");
		frame.setBounds(100, 100, 665, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Novi popis robe");
		lblNewLabel.setBounds(277, 15, 143, 23);
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Unesite bar kod artikla:");
		lblNewLabel_1.setBounds(277, 82, 133, 21);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNazivArtikla = new JLabel("Izbrojana količina:");
		lblNazivArtikla.setBounds(277, 208, 100, 21);
		lblNazivArtikla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNazivArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNazivArtikla.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtBarkod = new JTextField();
		txtBarkod.setBounds(277, 114, 245, 20);
		txtBarkod.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(277, 49, 344, 10);
		
		txtKolicina = new JTextField();
		txtKolicina.setBounds(378, 208, 144, 20);
		txtKolicina.setHorizontalAlignment(SwingConstants.LEFT);
		txtKolicina.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj artikal");
		btnDodaj.setBounds(378, 250, 144, 23);
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(artikal==null){
						return;
					}
					
					Double kolicina=Double.parseDouble(txtKolicina.getText());
					
					// validacija podataka
					
					artikal.setKolicina(kolicina);
					
					if(!popis.contains(artikal.getBarkod())){
						DefaultListModel model=(DefaultListModel)listArtikli.getModel();
						
						model.addElement(artikal);
						popis.add(artikal.getBarkod());
					}
				}
				catch(NumberFormatException i){
					JOptionPane.showMessageDialog(frame, "Format broja nije ispravan.");
				}
			}
		});
		
		final JTextArea txtOpis = new JTextArea();
		txtOpis.setBounds(277, 315, 344, 121);
		frame.getContentPane().add(txtOpis);
		
		JButton btnObracun = new JButton("Zaključi i obračunaj");
		btnObracun.setBounds(478, 456, 143, 23);
		btnObracun.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnObracun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	/*
				try{
					Date datum=new Date();
					
					List<Artikal> artikliInventure=new ArrayList<Artikal>();
					DefaultListModel model=(DefaultListModel)listArtikli.getModel();
					
					int vel=model.size();
					for(int i=0;i<vel;i++){
						Artikal a=(Artikal)model.getElementAt(i);
						artikliInventure.add(a);
					}
					
					TipZaposlenika zaposlenik=new TipZaposlenika();
					
					String opis=txtOpis.getText();
					
					Inventura inventura=new Inventura(datum, opis, zaposlenik, artikliInventure);
					InventuraKontroler.dodaj(inventura);
					
					List<Artikal> artikliManjka=new ArrayList<Artikal>();
					List<Artikal> artikliViska=new ArrayList<Artikal>();
					
					List<Artikal> artikliPom=new ArrayList<Artikal>();
					
					List<Artikal> artikliBaze=ArtikliKontroler.lista();
					
					for(Artikal a1:artikliBaze){
						boolean popisan=false;
						for(Artikal a2:artikliInventure){
							if(a1.getBarkod()==a2.getBarkod()){
								popisan=true;
								
								Double kolicina=a2.getKolicina()-a1.getKolicina();
								if(kolicina<0){
									a1.setKolicina(-kolicina);
									artikliManjka.add(a1);
								}
								else if(kolicina>0){
									a1.setKolicina(kolicina);
									artikliViska.add(a1);
								}
								
								break;
							}
						}
						if(!popisan && a1.getKolicina()>0){
							artikliManjka.add(a1);
							artikliPom.add(a1);
						}
					}
					
					Izvjestaj manjak=new Izvjestaj("Manjak", inventura.getOpis(), inventura.getDatum(), artikliManjka);
					Izvjestaj visak=new Izvjestaj("Visak", inventura.getOpis(), inventura.getDatum(), artikliViska);
					
					IzvjestajKontroler.dodaj(manjak);
					IzvjestajKontroler.dodaj(visak);
					
					for(Artikal a:artikliInventure){
						ArtikliKontroler.izmijeni(a);
					}
					
					for(Artikal a:artikliPom){
						a.setKolicina(0.0);
						ArtikliKontroler.izmijeni(a);
					}
				}
				catch(Exception i){
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}	*/
			} 
		});
		
		lblKorisnik = new JLabel("ime prijavljenog korisnika");
		lblKorisnik.setBounds(478, 11, 143, 26);
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		listArtikli = new JList();
		listArtikli.setBounds(23, 51, 231, 428);
		
		JLabel lblNewLabel_2 = new JLabel("Popisani artikli:");
		lblNewLabel_2.setBounds(23, 25, 143, 23);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnOdustani.setBounds(277, 456, 140, 23);
		btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblNazivArtikla);
		frame.getContentPane().add(txtBarkod);
		frame.getContentPane().add(separator);
		frame.getContentPane().add(txtKolicina);
		frame.getContentPane().add(btnDodaj);
		frame.getContentPane().add(btnObracun);
		frame.getContentPane().add(lblKorisnik);
		frame.getContentPane().add(listArtikli);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(btnOdustani);
		
		
		
		JButton btnNadji = new JButton("Očitaj");
		btnNadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					artikal=ArtikliKontroler.nadjiBarKod(txtBarkod.getText());
					
					// validacija podataka
					txtNaziv.setText(artikal.getNaziv());
					txtMjera.setText(artikal.getMjera());
				}
				catch(Exception i){
					JOptionPane.showMessageDialog(frame, "Greska u bazi!");
				}
			}
		});
		btnNadji.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNadji.setBounds(532, 112, 89, 23);
		frame.getContentPane().add(btnNadji);
		
		txtNaziv = new JTextField();
		txtNaziv.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNaziv.setEnabled(false);
		txtNaziv.setBounds(378, 177, 144, 20);
		frame.getContentPane().add(txtNaziv);
		txtNaziv.setColumns(10);
		
		txtMjera = new JTextField();
		txtMjera.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMjera.setEnabled(false);
		txtMjera.setBounds(532, 208, 89, 20);
		frame.getContentPane().add(txtMjera);
		txtMjera.setColumns(10);
		
		JLabel lblNazivArtikla_1 = new JLabel("Naziv artikla:");
		lblNazivArtikla_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNazivArtikla_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivArtikla_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNazivArtikla_1.setBounds(277, 183, 91, 14);
		frame.getContentPane().add(lblNazivArtikla_1);
		
		JLabel lblOpis = new JLabel("Opis:");
		lblOpis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOpis.setVerticalAlignment(SwingConstants.BOTTOM);
		lblOpis.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpis.setBounds(277, 290, 46, 14);
		frame.getContentPane().add(lblOpis);
		
		
	}
}
