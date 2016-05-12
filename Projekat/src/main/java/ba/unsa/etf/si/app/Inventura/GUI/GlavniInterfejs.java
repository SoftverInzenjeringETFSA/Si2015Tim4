package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JInternalFrame;
//import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
import javax.swing.JMenu;
//import java.awt.Color;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
//import java.awt.Component;
//import javax.swing.Box;
//import javax.swing.JTable;
//import javax.swing.ListSelectionModel;
//import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniInterfejs {

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
					GlavniInterfejs window = new GlavniInterfejs();
					
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
					GlavniInterfejs window = new GlavniInterfejs();
					
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
	
	/**
	 * Create the application.
	 */
	public GlavniInterfejs() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 406, 283);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnInventura = new JMenu("Inventura");
		menuBar.add(mnInventura);
		
		JMenuItem mntmZaponiNovu = new JMenuItem("Započni novu");
		mntmZaponiNovu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InventuraGUI.pokreni(frame, korisnik);
			}
		});
		mnInventura.add(mntmZaponiNovu);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    
		    	frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		    	}
		});
		
		
		JMenuItem mntmPregledZavrenih = new JMenuItem("Pregled završenih");
		mnInventura.add(mntmPregledZavrenih);
		
		JMenu mnSkladite = new JMenu("Skladište");
		menuBar.add(mnSkladite);
		
		JMenuItem mntmPregledStanjaNa = new JMenuItem("Pregled stanja na skadištu");
		mnSkladite.add(mntmPregledStanjaNa);
		
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
		mntmPregledDokumenataManjka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//	IzvjestajManjka nw = new IzvjestajManjka();
			IzvjestajManjka.pokreni();
			}
		});
		mnDokumenti.add(mntmPregledDokumenataManjka);
		
		JMenuItem mntmPregledDokumenataOtpisa = new JMenuItem("Pregled dokumenata otpisa");
		mnDokumenti.add(mntmPregledDokumenataOtpisa);
		
		JMenuItem mntmPregledIzlaznihDokumenata = new JMenuItem("Pregled izlaznih dokumenata");
		mnDokumenti.add(mntmPregledIzlaznihDokumenata);
		
		JMenu mnNewMenu = new JMenu("Postavke");
		menuBar.add(mnNewMenu);
		
		JMenuBar menuBar_2 = new JMenuBar();
		mnNewMenu.add(menuBar_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Promijeni lozinku");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromjenaLozinke.pokreni(frame, korisnik);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnNewMenu.add(menuBar_1);
		
		mnKorisnik = new JMenu("Korisnik");
		menuBar.add(mnKorisnik);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Odjava");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, true);
			}
		});
		mnKorisnik.add(mntmNewMenuItem);
		
		JList list = new JList();
		list.setBounds(52, 207, 1, 1);
		
		JList list_1 = new JList();
		list_1.setBounds(10, 11, 370, 197);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(list);
		frame.getContentPane().add(list_1);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime");
		
		
	}
}
