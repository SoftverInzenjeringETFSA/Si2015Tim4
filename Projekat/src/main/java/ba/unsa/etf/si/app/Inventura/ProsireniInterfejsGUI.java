package ba.unsa.etf.si.app.Inventura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Color;

public class ProsireniInterfejsGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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
		
		JMenu mnInventura = new JMenu("Inventura");
		menuBar.add(mnInventura);
		
		JMenuItem mntmZaponiNovu = new JMenuItem("Započni novu");
		mnInventura.add(mntmZaponiNovu);
		
		JMenuItem mntmPregledZavrenih = new JMenuItem("Pregled završenih");
		mnInventura.add(mntmPregledZavrenih);
		
		JMenu mnSkladite = new JMenu("Skladište");
		menuBar.add(mnSkladite);
		
		JMenuItem mntmPregledStanjaNa = new JMenuItem("Pregled stanja na skadištu");
		mnSkladite.add(mntmPregledStanjaNa);
		
		JMenu mnDokumenti = new JMenu("Dokumenti");
		menuBar.add(mnDokumenti);
		
		JMenuItem mntmKreirajIzlazniDokument_1 = new JMenuItem("Kreiraj izlazni dokument");
		mnDokumenti.add(mntmKreirajIzlazniDokument_1);
		
		JMenuItem mntmKreiraj = new JMenuItem("Kreiraj dokument otpisa");
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
		
		JMenu mnArtikli = new JMenu("Artikli");
		mnAdministracija.add(mnArtikli);
		
		JMenuItem mntmUnos = new JMenuItem("Unos");
		mnArtikli.add(mntmUnos);
		
		JMenuItem mntmModifikacija = new JMenuItem("Modifikacija");
		mntmModifikacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifikacijaArtiklaGUI forma=new ModifikacijaArtiklaGUI();
				forma.main(null);
			}
		});
		mnArtikli.add(mntmModifikacija);
		
		JMenuItem mntmBrisanje = new JMenuItem("Brisanje");
		mnArtikli.add(mntmBrisanje);
		
		JMenuBar menuBar_4 = new JMenuBar();
		mnArtikli.add(menuBar_4);
		
		JMenu mnKorisnici = new JMenu("Korisnici");
		mnAdministracija.add(mnKorisnici);
		
		JMenuItem mntmUnos_1 = new JMenuItem("Unos");
		mnKorisnici.add(mntmUnos_1);
		
		JMenuItem mntmModifikacija_1 = new JMenuItem("Modifikacija");
		mnKorisnici.add(mntmModifikacija_1);
		
		JMenuItem mntmBrisanje_1 = new JMenuItem("Brisanje");
		mnKorisnici.add(mntmBrisanje_1);
		
		JMenu mnNewMenu = new JMenu("Postavke");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Promijeni lozinku");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnSistem = new JMenu("Sistem");
		menuBar.add(mnSistem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Odjava");
		mnSistem.add(mntmNewMenuItem);
		
	}
}
