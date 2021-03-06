package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

import javax.swing.JLabel;
import javax.swing.WindowConstants;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.PostaviListBox;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.apache.log4j.Logger;

public class GlavniInterfejs {

	private JFrame frame;
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JMenu mnKorisnik;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GlavniInterfejs window = new GlavniInterfejs();
					
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
			@Override
			public void run() {
				try {
					GlavniInterfejs window = new GlavniInterfejs();
					
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
		frame.setResizable(false);
		frame.setBounds(100, 100, 414, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 383, 213);
		frame.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		scrollPane.setViewportView(tabela);
		
		JMenu mnInventura = new JMenu("Inventura");
		menuBar.add(mnInventura);
		
		JMenuItem mntmZaponiNovu = new JMenuItem("Započni novu");
		mntmZaponiNovu.addActionListener(new ActionListener() {
			@Override
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
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PostaviListBox.dokumentiInventure(tabela);
			}
		});
		mnInventura.add(mntmPregledZavrenih);
		
		JMenu mnSkladite = new JMenu("Skladište");
		menuBar.add(mnSkladite);
		
		JMenuItem mntmPregledStanjaNa = new JMenuItem("Pregled stanja na skadištu");
		mntmPregledStanjaNa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				PostaviListBox.artikliNaSkladistu(tabela);
			}
		});
		mnSkladite.add(mntmPregledStanjaNa);
		
		JMenu mnDokumenti = new JMenu("Dokumenti");
		menuBar.add(mnDokumenti);
		
		JMenuItem mntmKreirajIzlazniDokument_1 = new JMenuItem("Kreiraj dokument");
		mntmKreirajIzlazniDokument_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				izlazniDokument.pokreni(frame, korisnik);
			}
		});
		mnDokumenti.add(mntmKreirajIzlazniDokument_1);
		
		JMenuItem mntmPregledKreiranihDokumenata = new JMenuItem("Pregled dokumenata viška");
		mntmPregledKreiranihDokumenata.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PostaviListBox.dokumentiViska(tabela);
			}
		});
		mnDokumenti.add(mntmPregledKreiranihDokumenata);
		
		JMenuItem mntmPregledDokumenataManjka = new JMenuItem("Pregled dokumenata manjka");
		mntmPregledDokumenataManjka.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PostaviListBox.dokumentiManjka(tabela);
			}
		});
		mnDokumenti.add(mntmPregledDokumenataManjka);
		
		JMenuItem mntmPregledDokumenataOtpisa = new JMenuItem("Pregled dokumenata otpisa");
		mntmPregledDokumenataOtpisa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PostaviListBox.dokumentiOtpisa(tabela);
			}
		});
		mnDokumenti.add(mntmPregledDokumenataOtpisa);
		
		JMenuItem mntmPregledIzlaznihDokumenata = new JMenuItem("Pregled izlaznih dokumenata");
		mntmPregledIzlaznihDokumenata.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PostaviListBox.dokumentiIzlaza(tabela);
			}
		});
		mnDokumenti.add(mntmPregledIzlaznihDokumenata);
		
		JMenu mnNewMenu = new JMenu("Postavke");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Promijeni lozinku");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PromjenaLozinke.pokreni(frame, korisnik);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnKorisnik = new JMenu("Korisnik");
		menuBar.add(mnKorisnik);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Odjava");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, true);
				JOptionPane.showMessageDialog(null, "Uspjesno ste se odjavili sa sistema!");
			}
		});
		mnKorisnik.add(mntmNewMenuItem);
		frame.getContentPane().setLayout(null);
		
		JMenu mnPomo = new JMenu("Pomoć");
		menuBar.add(mnPomo);
		
		JMenuItem mntmOAplikaciji = new JMenuItem("O aplikaciji");
		
		mntmOAplikaciji.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String help = "<html><body width=300'" +
		                    "'><h1>Pomoć</h1>" +
		                    "<p> Da biste pristupili korištenju funkcionalnosti, potrebno je u glavnom meniju aplikacije pronaći željenu funkcionalnost. Klikom na nju otvorit će se opcije poput pregleda dokumenata, unosa, modifikacije artikala i korisnika isl. Klikom na opcije sa nazivom pregleda, željene informacije će se ispisati na istom prozoru. Za sve ostale odabrane stavke, otvara se nova forma. Korisnički interfejsi su intuitivni i jednostavni za korištenje.  <br><br>" +
		                    "<p> Ukoliko se želite odjaviti sa sistema, potrebno je kliknuti na svoje ime, te na ponuđenu opciju Odjava." +
		                    "<p> Za sve ostale informacije kontaktirajte nas putem email-a:" +
		                    "<p> deltadevelopment@gmail.com <br><br>" +
		                    "";

                JOptionPane.showMessageDialog(null, help);
			}
		});
		mnPomo.add(mntmOAplikaciji);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	
}
