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
		frame.setBounds(100, 100, 419, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 72, 361, 2);
		frame.getContentPane().add(separator);
		
		JLabel label = new JLabel("ime prijavljenog korisnika");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(260, 11, 122, 20);
		frame.getContentPane().add(label);
		
		JList list = new JList();
		list.setBounds(21, 97, 361, 235);
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
			new UnosSkladistaGUI();
			UnosSkladistaGUI.pokreni();
			}
		});
		mnSkladite.add(mntmUnosSkladita);
		
		JMenu mnDokumenti = new JMenu("Dokumenti");
		menuBar.add(mnDokumenti);
		
		JMenuItem mntmKreirajIzlazniDokument_1 = new JMenuItem("Kreiraj izlazni dokument");
		mntmKreirajIzlazniDokument_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new izlazniDokument();
			izlazniDokument.pokreni();
			}
		});
		mnDokumenti.add(mntmKreirajIzlazniDokument_1);
		
		JMenuItem mntmKreiraj = new JMenuItem("Kreiraj dokument otpisa");
		mntmKreiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new OtpisDokument();
			OtpisDokument.pokreni();
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
			new DodavanjeKlaseArtiklaGUI();
			DodavanjeKlaseArtiklaGUI.pokreni();
			}
		});
		mnKlaseArtikala.add(mntmUnos_2);
		
		JMenuItem mntmModifikacija_2 = new JMenuItem("Modifikacija");
		mntmModifikacija_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new ModifikacijaKlaseArtiklaGUI();
			ModifikacijaKlaseArtiklaGUI.pokreni();
			}
		});
		mnKlaseArtikala.add(mntmModifikacija_2);
		
		JMenuItem mntmBrisanje_2 = new JMenuItem("Brisanje");
		mntmBrisanje_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new BrisanjeKlaseArtikalGUI();
			BrisanjeKlaseArtikalGUI.pokreni();
			}
		});
		mnKlaseArtikala.add(mntmBrisanje_2);
		
		JMenu mnArtikli = new JMenu("Artikli");
		mnAdministracija.add(mnArtikli);
		
		JMenuItem mntmUnos = new JMenuItem("Unos");
		mntmUnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new DodavanjeArtikla();
			DodavanjeArtikla.pokreni();
			}
		});
		mnArtikli.add(mntmUnos);
		
		JMenuItem mntmModifikacija = new JMenuItem("Modifikacija");
		mntmModifikacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ModifikacijaArtiklaGUI();
				ModifikacijaArtiklaGUI.pokreni();

			}
		});
		mnArtikli.add(mntmModifikacija);
		
		JMenuItem mntmBrisanje = new JMenuItem("Brisanje");
		mntmBrisanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new BrisanjeArtikla();
			BrisanjeArtikla.pokreni();
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
			new RegistracijaNovogKorisnika();
			RegistracijaNovogKorisnika.pokreni();
			}
		});
		mnKorisnici.add(mntmUnos_1);
		
		JMenuItem mntmModifikacija_1 = new JMenuItem("Modifikacija");
		mntmModifikacija_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new ModifikacijaKorisnika();
			ModifikacijaKorisnika.pokreni();
			}
		});
		mnKorisnici.add(mntmModifikacija_1);
		
		JMenuItem mntmBrisanje_1 = new JMenuItem("Brisanje");
		mntmBrisanje_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UklanjanjeKorisnika();
				UklanjanjeKorisnika.pokreni();
			}
		});
		mnKorisnici.add(mntmBrisanje_1);
		
		JMenu mnNewMenu = new JMenu("Postavke");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Promijeni lozinku");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new PromjenaLozinke();
			PromjenaLozinke.pokreni();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnSistem = new JMenu("Sistem");
		menuBar.add(mnSistem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Odjava");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnSistem.add(mntmNewMenuItem);
		
	}
}
