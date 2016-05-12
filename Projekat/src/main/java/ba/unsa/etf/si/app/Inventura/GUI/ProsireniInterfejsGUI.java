package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.ListSelectionModel;
//import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
//import java.awt.SystemColor;
//import java.awt.Window;
import java.awt.Font;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.JSeparator;
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
//import javax.swing.JFrame;
//import javax.swing.JFrame;
import javax.swing.JList;
//import java.awt.Color;

public class ProsireniInterfejsGUI {

	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JMenu mnKorisnik;

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
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void pokreni(JFrame _frameRoditelj, TipZaposlenika _korisnik) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProsireniInterfejsGUI window = new ProsireniInterfejsGUI();
					
					window.frameRoditelj=_frameRoditelj;
					window.korisnik=_korisnik;
					window.mnKorisnik.setText(window.korisnik.getIme().toUpperCase());
					
					FormaKontroler.postaviFormu(window.frameRoditelj, window.frame, true);
				} catch (Exception e) {
					e.printStackTrace();
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
					e.printStackTrace();
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
		
		JList list = new JList();
		list.setBounds(21, 23, 361, 215);
		frame.getContentPane().add(list);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnSkladite = new JMenu("Skladište");
		menuBar.add(mnSkladite);
		
		JMenuItem mntmPregledStanjaNa = new JMenuItem("Pregled stanja na skadištu");
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
		
		JMenuItem mntmKreirajIzlazniDokument_1 = new JMenuItem("Kreiraj izlazni dokument");
		mntmKreirajIzlazniDokument_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izlazniDokument.pokreni(frame, korisnik);
			}
		});
		mnDokumenti.add(mntmKreirajIzlazniDokument_1);
		
		JMenuItem mntmKreiraj = new JMenuItem("Kreiraj dokument otpisa");
		mntmKreiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OtpisDokument.pokreni(frame, korisnik);
			}
		});
		mnDokumenti.add(mntmKreiraj);
		
		JMenuItem mntmPregledKreiranihDokumenata = new JMenuItem("Pregled dokumenata viška");
		mnDokumenti.add(mntmPregledKreiranihDokumenata);
		
		JMenuItem mntmPregledDokumenataManjka = new JMenuItem("Pregled dokumenata manjka");
		mnDokumenti.add(mntmPregledDokumenataManjka);
		
		JMenuItem mntmPregledDokumenataOtpisa = new JMenuItem("Pregled dokumenata otpisa");
		mnDokumenti.add(mntmPregledDokumenataOtpisa);
		
		JMenuItem mntmPregledIzlaznihDokumenata = new JMenuItem("Pregled izlaznih dokumenata");
		mnDokumenti.add(mntmPregledIzlaznihDokumenata);
		
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
