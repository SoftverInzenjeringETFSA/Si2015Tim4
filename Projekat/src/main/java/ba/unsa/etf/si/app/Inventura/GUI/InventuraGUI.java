package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.InventuraKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.IzvjestajKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.Inventura;
import ba.unsa.etf.si.app.Inventura.Model.Izvjestaj;
import ba.unsa.etf.si.app.Inventura.Model.MojaTabela;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class InventuraGUI {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	int brojac=1;
	private JTextField txtBarkod;
	private JTextField txtKolicina;
	private Artikal artikal=null;
	private JTextField txtNaziv;
	private JTextField txtMjera;
	private List<Long> popis=new ArrayList<Long>();
	private List<Double> kolicine=new ArrayList<Double>();
	private MojaTabela tabela;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InventuraGUI window = new InventuraGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.info(e);
				}
			}
		});
	}
	
	public static void pokreni(final JFrame _frameRoditelj, final TipZaposlenika _korisnik) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InventuraGUI window = new InventuraGUI();
					
					window.frameRoditelj=_frameRoditelj;
					window.korisnik=_korisnik;
					window.lblKorisnik.setText(window.korisnik.getIme().toUpperCase());
					
					FormaKontroler.postaviFormu(window.frameRoditelj, window.frame, false);
				} catch (Exception e) {
					logger.info(e);
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
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(artikal==null){
						return;
					}
					
					Double kolicina=Double.parseDouble(txtKolicina.getText());
					
					// validacija podataka
										
					if(!popis.contains(artikal.getId())){
						
						popis.add(artikal.getId());
						kolicine.add(kolicina);
						String[] red=new String[]{artikal.getNaziv(), kolicina.toString()};
						tabela.dodajRed(artikal, red);
					}
					else{
						JOptionPane.showMessageDialog(null, "Artkal je već dodat na popis.");
					}
				}
				catch(NumberFormatException i){
					logger.info(i);
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
			@Override
			public void actionPerformed(ActionEvent e) {	
				
				Izvjestaj manjakIzvjestaj=new Izvjestaj();
				Izvjestaj visakIzvjestaj=new Izvjestaj();
				Inventura inventura= new Inventura();
				Double ukupnoPrebrojano=0.0;
				try{
					Date datum=new Date();
					
					List<Artikal> artikliInventure=new ArrayList<Artikal>();
					List<Object> objekti=tabela.getObjekti();
					
					
					for(Object o:objekti){
						Artikal a=(Artikal)o;
					    
						Double trenutnoStanje=a.getKolicina();
					    
						a.setKolicina(kolicine.get(objekti.indexOf(o)));
						artikliInventure.add(a);
						ukupnoPrebrojano = ukupnoPrebrojano + a.getKolicina();
						
						Double razlika = (a.getKolicina()-trenutnoStanje);
						
						if(razlika>0)
						{
							visakIzvjestaj=new Izvjestaj("Visak", txtOpis.getText(), datum, razlika);
							IzvjestajKontroler.dodaj(visakIzvjestaj);
							ArtikliKontroler.izmijeni(a);
						}
						else if(razlika<0){
							manjakIzvjestaj=new Izvjestaj("Manjak", txtOpis.getText(), datum, razlika);
							IzvjestajKontroler.dodaj(manjakIzvjestaj);
							ArtikliKontroler.izmijeni(a);
						}
						else if(razlika==0){
							return;
						}
						else  {
							return;
						}
						
					}
					
					String opis=txtOpis.getText();
					if(ukupnoPrebrojano==0){
						JOptionPane.showMessageDialog(null, "Klasa artikla nije izabrana!");
						return;
					}
					inventura=new Inventura(datum, opis, ukupnoPrebrojano, korisnik);
					InventuraKontroler.dodaj(inventura);
					JOptionPane.showMessageDialog(null, "Uspjesno spasena inventura, i kreiran izvjestaj manja/viska!");
					
				}
				catch(Exception i){
					logger.info(i);
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}	
			} 
		});
		
		lblKorisnik = new JLabel("ime prijavljenog korisnika");
		lblKorisnik.setBounds(478, 11, 143, 26);
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_2 = new JLabel("Popisani artikli:");
		lblNewLabel_2.setBounds(23, 25, 143, 23);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			@Override
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
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(btnOdustani);
		
		
		
		JButton btnNadji = new JButton("Očitaj");
		btnNadji.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					artikal=ArtikliKontroler.nadjiBarKod(txtBarkod.getText());
					
					// validacija podataka
					txtNaziv.setText(artikal.getNaziv());
					txtMjera.setText(artikal.getMjera());
				}
				catch(Exception i){
					logger.info(i);
					JOptionPane.showMessageDialog(frame, "Artikal ne postoji u bazi!");
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 57, 224, 379);
		frame.getContentPane().add(scrollPane);
		
		tabela = new MojaTabela();
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Naziv artikla", "Popisana količina"
			}
		));
		scrollPane.setViewportView(tabela);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int brojReda=tabela.getSelectedRow();
				tabela.obrisiRed(brojReda);
				popis.remove(brojReda);
				kolicine.remove(brojReda);
			}
		});
		btnNewButton.setBounds(100, 457, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
