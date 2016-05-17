package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.IzvjestajKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.Izvjestaj;
import ba.unsa.etf.si.app.Inventura.Model.MojaTabela;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class izlazniDokument {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTextField txtKolicina;
	private MojaTabela tabelaDodani;
	private MojaTabela tabelaPostojeci;
	private List<Double> kolicine=new ArrayList<Double>();
	private JTextArea txtOpis;
	private JComboBox comboVrsta;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					izlazniDokument window = new izlazniDokument();
					window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.info(e);
				}
			}
		});
	}
	
	public static void pokreni(final JFrame _frameRoditelj, final TipZaposlenika _korisnik) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					izlazniDokument window = new izlazniDokument();
					
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
	public izlazniDokument() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 817, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblKreiranjeIzlaznogDokumenta = new JLabel("Kreiranje dokumenta:");
		lblKreiranjeIzlaznogDokumenta.setBounds(215, 36, 215, 20);
		lblKreiranjeIzlaznogDokumenta.setForeground(new Color(0, 128, 0));
		lblKreiranjeIzlaznogDokumenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(507, 11, 158, 20);
		
		JLabel lblPostojeiArtikli = new JLabel("Postojeći artikli:");
		lblPostojeiArtikli.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPostojeiArtikli.setBounds(20, 94, 112, 14);
		
		JLabel lblDodaniArtikli = new JLabel("Dodani artikli");
		lblDodaniArtikli.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDodaniArtikli.setBounds(555, 94, 100, 14);
		
		JLabel lblUnesiteKoliinu = new JLabel("Unesite količinu:");
		lblUnesiteKoliinu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUnesiteKoliinu.setBounds(280, 150, 100, 14);
		
		txtKolicina = new JTextField();
		txtKolicina.setBounds(280, 175, 244, 20);
		txtKolicina.setColumns(10);
		
		Double ukRazlika=0.0;
		
		JButton btnDodaj = new JButton("Dodaj >>");
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// validacija svega
				
				int brojReda=tabelaPostojeci.getSelectedRow();
				Artikal artikal=(Artikal)tabelaPostojeci.dajRed(brojReda);
				
				try{
					
					Double kolicina=Double.parseDouble(txtKolicina.getText());
					
					if(kolicina<0){
						JOptionPane.showMessageDialog(null, "Kolicina ne moze biti negativna!");
						return;
					}
					
					
				
					
					//if(kolicina<0 || (artikal.getMjera().equals("kom") && kolicina!=Math.floor(kolicina))){
					//	JOptionPane.showMessageDialog(null,	"Kolicina pozitivna itd.");
					//	return;
					//}
					
					String[] red=new String[]{artikal.getNaziv(), Double.toString(kolicina)};
					
					tabelaDodani.dodajRed(artikal, red);
					
					kolicine.add(kolicina);
					
				}
				catch(Exception i){
					logger.info(i);
					JOptionPane.showMessageDialog(null, "Mozete unijeti samo brojeve!");
				}
			}
		});
		btnDodaj.setBounds(345, 206, 100, 23);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setBackground(new Color(143, 188, 143));
		btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnOdustani.setBounds(256, 423, 142, 23);
		
		JButton btnZakljuiDokument = new JButton("Zaključi dokument");
		btnZakljuiDokument.setBackground(new Color(143, 188, 143));
		btnZakljuiDokument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double priv=0.0;
				Double priv_after=0.0;
				List<Object> objekti=tabelaDodani.getObjekti();
				for(Object o:objekti){
					Artikal artikal=(Artikal)o;
					try{
						priv=priv+artikal.getKolicina();
						priv_after=priv_after+kolicine.get(objekti.indexOf(o));
						
						//artikal.getKolicina()-kolicine.get(objekti.indexOf(o)
						artikal.setKolicina(kolicine.get(objekti.indexOf(o)));
						ArtikliKontroler.izmijeni(artikal);
					}
					catch(Exception i){
						logger.info(i);
						JOptionPane.showMessageDialog(null, i.getMessage());
					}
				}
				
				/*
				List<Artikal> artikli=ArtikliKontroler.lista();
				for(Artikal a:artikli){
					String[] red=new String[]{a.getNaziv(), Double.toString(a.getKolicina())};
					tabelaPostojeci.dodajRed(a,	red);
				}*/
				txtKolicina.setText("");
				
				Izvjestaj i=new Izvjestaj(comboVrsta.getSelectedItem().toString(),txtOpis.getText(),new Date(), priv_after-priv);
				IzvjestajKontroler.dodaj(i);
				
				tabelaPostojeci.isprazni();
				tabelaDodani.isprazni();
			}
		});
		btnZakljuiDokument.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnZakljuiDokument.setBounds(408, 423, 142, 23);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblPostojeiArtikli);
		frame.getContentPane().add(lblUnesiteKoliinu);
		frame.getContentPane().add(txtKolicina);
		frame.getContentPane().add(btnDodaj);
		frame.getContentPane().add(lblDodaniArtikli);
		frame.getContentPane().add(lblKreiranjeIzlaznogDokumenta);
		frame.getContentPane().add(btnOdustani);
		frame.getContentPane().add(btnZakljuiDokument);
		frame.getContentPane().add(lblKorisnik);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 121, 237, 275);
		frame.getContentPane().add(scrollPane);
		
		tabelaPostojeci = new MojaTabela();
		tabelaPostojeci.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Naziv", "Kolicina na skladistu"
			}
		));
		List<Artikal> artikli=ArtikliKontroler.lista();
		for(Artikal a:artikli){
			String[] red=new String[]{a.getNaziv(), Double.toString(a.getKolicina())};
			tabelaPostojeci.dodajRed(a,	red);
		}
		scrollPane.setViewportView(tabelaPostojeci);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(555, 121, 215, 275);
		frame.getContentPane().add(scrollPane_1);
		
		tabelaDodani = new MojaTabela();
		tabelaDodani.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Naziv", "Kolicina"
			}
		));
		scrollPane_1.setViewportView(tabelaDodani);
		
		JButton btnNewButton = new JButton("Obriši");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int red=tabelaDodani.getSelectedRow();
				tabelaDodani.obrisiRed(red);
				kolicine.remove(red);
			}
		});
		btnNewButton.setBounds(345, 242, 100, 23);
		frame.getContentPane().add(btnNewButton);
		
		txtOpis = new JTextArea();
		txtOpis.setBounds(280, 301, 244, 95);
		frame.getContentPane().add(txtOpis);
		
		JLabel lblOpis = new JLabel("Opis:");
		lblOpis.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpis.setVerticalAlignment(SwingConstants.BOTTOM);
		lblOpis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOpis.setBounds(280, 276, 46, 14);
		frame.getContentPane().add(lblOpis);
		
		JLabel lblVrstaDokumenta = new JLabel("Vrsta dokumenta:");
		lblVrstaDokumenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVrstaDokumenta.setBounds(280, 124, 100, 14);
		frame.getContentPane().add(lblVrstaDokumenta);
		
	    comboVrsta = new JComboBox();
		comboVrsta.setModel(new DefaultComboBoxModel(new String[] {"Izlaz", "Otpis"}));
		comboVrsta.setBounds(389, 121, 135, 20);
		frame.getContentPane().add(comboVrsta);
	}
}
