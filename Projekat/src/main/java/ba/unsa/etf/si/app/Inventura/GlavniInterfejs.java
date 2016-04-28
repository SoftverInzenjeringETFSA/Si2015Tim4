package ba.unsa.etf.si.app.Inventura;

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

public class GlavniInterfejs {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.setBounds(100, 100, 537, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnSistem = new JMenu("Sistem");
		menuBar.add(mnSistem);
		
		JMenu mnNovi = new JMenu("Novi");
		mnSistem.add(mnNovi);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Izlazni dokument");
		mnNovi.add(mntmNewMenuItem_1);
		
		JMenuItem mntmInventura = new JMenuItem("Inventura");
		mnNovi.add(mntmInventura);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Odjava");
		mnSistem.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("Postavke");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Promijeni lozinku");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JLabel lblKorisnikoIme_1 = new JLabel("Korisničko ime");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(431, Short.MAX_VALUE)
					.addComponent(lblKorisnikoIme_1)
					.addGap(44))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblKorisnikoIme_1)
					.addContainerGap(354, Short.MAX_VALUE))
				
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 11, 279, 199);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Naziv proizvoda", "Koli\u010Dina"
			}
		));
		
		
	}
}
