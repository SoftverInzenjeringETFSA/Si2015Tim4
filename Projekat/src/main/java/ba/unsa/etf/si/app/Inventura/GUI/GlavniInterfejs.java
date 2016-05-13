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
import ba.unsa.etf.si.app.Inventura.Kontroleri.PostaviListBox;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GlavniInterfejs {

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
		mntmPregledZavrenih.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostaviListBox.dokumentiInventure(tabela);
			}
		});
		mnInventura.add(mntmPregledZavrenih);
		
		JMenu mnSkladite = new JMenu("Skladište");
		menuBar.add(mnSkladite);
		
		JMenuItem mntmPregledStanjaNa = new JMenuItem("Pregled stanja na skadištu");
		mntmPregledStanjaNa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostaviListBox.artikliNaSkladistu(tabela);
			}
		});
		mnSkladite.add(mntmPregledStanjaNa);
		
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
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 370, 202);
		frame.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		scrollPane.setViewportView(tabela);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}
