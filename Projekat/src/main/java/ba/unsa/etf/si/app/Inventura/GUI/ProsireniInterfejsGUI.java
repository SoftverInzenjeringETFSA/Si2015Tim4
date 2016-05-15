package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import org.apache.log4j.Logger;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.PostaviListBox;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

//import javax.swing.JTextField;
//import javax.swing.JComboBox;
//import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//import javax.swing.JTextArea;
//import javax.swing.JButton;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import java.awt.Color;

public class ProsireniInterfejsGUI {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JMenu mnKorisnik;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProsireniInterfejsGUI window = new ProsireniInterfejsGUI();
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
					ProsireniInterfejsGUI window = new ProsireniInterfejsGUI();
					
					window.frameRoditelj=_frameRoditelj;
					window.korisnik=_korisnik;
					window.mnKorisnik.setText(window.korisnik.getIme().toUpperCase());
					
					FormaKontroler.postaviFormu(window.frameRoditelj, window.frame, true);
				} catch (Exception e) {
					logger.info(e);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProsireniInterfejsGUI window = new ProsireniInterfejsGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.info(e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProsireniInterfejsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 419, 321);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 383, 213);
		frame.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		scrollPane.setViewportView(tabela);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnSkladite = new JMenu("Skladište");
		menuBar.add(mnSkladite);
		
		JMenuItem mntmPregledStanjaNa = new JMenuItem("Pregled stanja na skadištu");
		mntmPregledStanjaNa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostaviListBox.artikliNaSkladistu(tabela);
			}
		});
		mnSkladite.add(mntmPregledStanjaNa);
		
		JMenuItem mntmUnosSkladita = new JMenuItem("Unos skladišta");
		mntmUnosSkladita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnosSkladistaGUI.pokreni(frame, korisnik);
			}
		});
		mnSkladite.add(mntmUnosSkladita);
		
		JMenu mnDokumenti = new JMenu("Dokumenti");
		menuBar.add(mnDokumenti);
		
		JMenuItem mntmKreirajIzlazniDokument_1 = new JMenuItem("Kreiraj dokument");
		mntmKreirajIzlazniDokument_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izlazniDokument.pokreni(frame, korisnik);
			}
		});
		mnDokumenti.add(mntmKreirajIzlazniDokument_1);
		
		JMenuItem mntmPregledKreiranihDokumenata = new JMenuItem("Pregled dokumenata viška");
		mntmPregledKreiranihDokumenata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostaviListBox.dokumentiViska(tabela);
			}
		});
		mnDokumenti.add(mntmPregledKreiranihDokumenata);
		
		JMenuItem mntmPregledDokumenataManjka = new JMenuItem("Pregled dokumenata manjka");
		mntmPregledDokumenataManjka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostaviListBox.dokumentiManjka(tabela);
			}
		});
		mnDokumenti.add(mntmPregledDokumenataManjka);
		
		JMenuItem mntmPregledDokumenataOtpisa = new JMenuItem("Pregled dokumenata otpisa");
		mntmPregledDokumenataOtpisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostaviListBox.dokumentiOtpisa(tabela);
			}
		});
		mnDokumenti.add(mntmPregledDokumenataOtpisa);
		
		JMenuItem mntmPregledIzlaznihDokumenata = new JMenuItem("Pregled izlaznih dokumenata");
		mntmPregledIzlaznihDokumenata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostaviListBox.dokumentiIzlaza(tabela);
			}
		});
		mnDokumenti.add(mntmPregledIzlaznihDokumenata);
		
		JMenuItem mntmPregledZaposlenika = new JMenuItem("Pregled zaposlenika");
		mntmPregledZaposlenika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostaviListBox.prikaziZaposlenike(tabela);
			}
		});
		mnDokumenti.add(mntmPregledZaposlenika);
		
		JMenu mnAdministracija = new JMenu("Administracija");
		menuBar.add(mnAdministracija);
		
		JMenu mnKlaseArtikala = new JMenu("Klase artikala");
		mnAdministracija.add(mnKlaseArtikala);
		
		JMenuItem mntmUnos_2 = new JMenuItem("Unos");
		mntmUnos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodavanjeKlaseArtiklaGUI.pokreni(frame, korisnik);
			}
		});
		mnKlaseArtikala.add(mntmUnos_2);
		
		JMenuItem mntmModifikacija_2 = new JMenuItem("Modifikacija");
		mntmModifikacija_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifikacijaKlaseArtiklaGUI.pokreni(frame, korisnik);
			}
		});
		mnKlaseArtikala.add(mntmModifikacija_2);
		
		JMenuItem mntmBrisanje_2 = new JMenuItem("Brisanje");
		mntmBrisanje_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrisanjeKlaseArtikalGUI.pokreni(frame, korisnik);
			}
		});
		mnKlaseArtikala.add(mntmBrisanje_2);
		
		JMenu mnArtikli = new JMenu("Artikli");
		mnAdministracija.add(mnArtikli);
		
		JMenuItem mntmUnos = new JMenuItem("Unos");
		mntmUnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodavanjeArtikla.pokreni(frame, korisnik);
			}
		});
		mnArtikli.add(mntmUnos);
		
		JMenuItem mntmModifikacija = new JMenuItem("Modifikacija");
		mntmModifikacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifikacijaArtiklaGUI.pokreni(frame, korisnik);
			}
		});
		mnArtikli.add(mntmModifikacija);
		
		JMenuItem mntmBrisanje = new JMenuItem("Brisanje");
		mntmBrisanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrisanjeArtikla.pokreni(frame, korisnik);
			}
		});
		mnArtikli.add(mntmBrisanje);
		
		JMenuBar menuBar_4 = new JMenuBar();
		mnArtikli.add(menuBar_4);
		
		JMenu mnKorisnici = new JMenu("Korisnici");
		mnAdministracija.add(mnKorisnici);
		
		JMenuItem mntmUnos_1 = new JMenuItem("Unos");
		mntmUnos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistracijaNovogKorisnika.pokreni(frame, korisnik);
			}
		});
		mnKorisnici.add(mntmUnos_1);
		
		JMenuItem mntmModifikacija_1 = new JMenuItem("Modifikacija");
		mntmModifikacija_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifikacijaKorisnika.pokreni(frame, korisnik);
			}
		});
		mnKorisnici.add(mntmModifikacija_1);
		
		JMenuItem mntmBrisanje_1 = new JMenuItem("Brisanje");
		mntmBrisanje_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UklanjanjeKorisnika.pokreni(frame, korisnik);
			}
		});
		mnKorisnici.add(mntmBrisanje_1);
		
		JMenu mnNewMenu = new JMenu("Postavke");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Promijeni lozinku");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromjenaLozinke.pokreni(frame, korisnik);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnKorisnik = new JMenu("Korisnik");
		menuBar.add(mnKorisnik);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Odjava");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, true);
			}
		});
		mnKorisnik.add(mntmNewMenuItem);
		
	}
}
