package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JInternalFrame;
//import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
//import java.awt.Color;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
//import java.awt.Component;
//import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniInterfejs {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniInterfejs window = new GlavniInterfejs();
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
			InventuraGUI nw = new InventuraGUI();
			nw.pokreni();
			}
		});
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
		mntmKreirajIzlazniDokument_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			izlazniDokument nw = new izlazniDokument();
			nw.pokreni();
			}
		});
		mnDokumenti.add(mntmKreirajIzlazniDokument_1);
		
		JMenuItem mntmKreiraj = new JMenuItem("Kreiraj dokument otpisa");
		mntmKreiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			OtpisDokument nw = new OtpisDokument();
			nw.pokreni();
			}
		});
		mnDokumenti.add(mntmKreiraj);
		
		JMenuItem mntmPregledKreiranihDokumenata = new JMenuItem("Pregled dokumenata viška");
		mnDokumenti.add(mntmPregledKreiranihDokumenata);
		
		JMenuItem mntmPregledDokumenataManjka = new JMenuItem("Pregled dokumenata manjka");
		mntmPregledDokumenataManjka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			IzvjestajManjka nw = new IzvjestajManjka();
			nw.pokreni();
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
			PromjenaLozinke nw = new PromjenaLozinke();
			nw.pokreni();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnNewMenu.add(menuBar_1);
		
		JMenu mnSistem = new JMenu("Sistem");
		menuBar.add(mnSistem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Odjava");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			}
		});
		mnSistem.add(mntmNewMenuItem);
		
		JLabel lblKorisnikoIme_1 = new JLabel("Korisničko ime");
		
		JList list = new JList();
		
		JList list_1 = new JList();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(280, Short.MAX_VALUE)
					.addComponent(lblKorisnikoIme_1)
					.addGap(44))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(337, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblKorisnikoIme_1)
					.addGap(31)
					.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime");
		
		
	}
}
