package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JMenuBar;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
import javax.swing.JLabel;
//import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
//import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.Box;
//import javax.swing.JSplitPane;
import javax.swing.JList;
//import javax.swing.JTextPane;
//import javax.swing.JSpinner;
//import java.awt.Component;
//import javax.swing.AbstractListModel;
//import javax.swing.table.DefaultTableModel;
import javax.swing.JMenu;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Inventura;
//import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

//import javax.swing.ListSelectionModel;
//import javax.swing.JScrollPane;
import javax.swing.JSeparator;
//import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class InventuraGUI {
	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	int brojac=1;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JComboBox<String> comboMjera;
	
	private List<String> _mjera = Arrays.asList("kom", "kg", "g", "l", "dl");

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventuraGUI window = new InventuraGUI();
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
					InventuraGUI window = new InventuraGUI();
					
					window.frameRoditelj=_frameRoditelj;
					window.korisnik=_korisnik;
					window.lblKorisnik.setText(window.korisnik.getIme().toUpperCase());
					
					FormaKontroler.postaviFormu(window.frameRoditelj, window.frame, false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventuraGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 698, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novi popis robe");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(332, 25, 178, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Unesite bar kod artikla:");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(264, 104, 143, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNazivArtikla = new JLabel("Izbrojana količina:");
		lblNazivArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNazivArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivArtikla.setBounds(295, 139, 112, 21);
		frame.getContentPane().add(lblNazivArtikla);
		
		textField_1 = new JTextField();
		textField_1.setBounds(418, 108, 203, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(332, 71, 289, 2);
		frame.getContentPane().add(separator);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(417, 143, 102, 20);
		frame.getContentPane().add(textField_2);
		
		
		comboMjera = new JComboBox<String>();
		if(_mjera.size() != 0) {
			for(String m : _mjera) {
				if(m != null) {
					comboMjera.addItem(m);
				}
			}
		}
		comboMjera.setBounds(528, 140, 93, 27);
		frame.getContentPane().add(comboMjera);
		
		JButton btnDodajArtikal = new JButton("Dodaj artikal");
		btnDodajArtikal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnDodajArtikal.setBounds(393, 198, 122, 23);
		frame.getContentPane().add(btnDodajArtikal);
		
		JButton btnZakljuiIObraunaj = new JButton("Zaključi i obračunaj");
		btnZakljuiIObraunaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventura i = null;
				Date d=new Date();
				try{
					//i=new Inventura(brojac,d,"Opis",1200,"Amra");
				}
				catch(Exception e1){
					
				}
				i.iskoristiInventuru(i);
				brojac++;
			}
		});
		
		btnZakljuiIObraunaj.setBounds(484, 246, 143, 23);
		frame.getContentPane().add(btnZakljuiIObraunaj);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKorisnik.setBounds(528, 20, 93, 28);
		frame.getContentPane().add(lblKorisnik);
		
		JList list = new JList();
		list.setBounds(23, 51, 231, 251);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Popisani artikli:");
		lblNewLabel_2.setBounds(23, 25, 143, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Odustani");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaKontroler.zatvoriFormu(frameRoditelj, frame, false);
			}
		});
		btnNewButton.setBounds(311, 246, 140, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
