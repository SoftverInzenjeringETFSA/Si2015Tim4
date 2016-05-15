package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.app.Inventura.Kontroleri.FormaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

import javax.swing.JSeparator;

public class IzvjestajGUI {

	private JFrame frame;
	
	private JFrame frameRoditelj;
	private TipZaposlenika korisnik;
	private JLabel lblKorisnik;
	
	private JTable tabelaManjka;
	private JLabel lblIzvjestaj;
	private JScrollPane scrollPane_1;
	private JTable tabelaViska;
	private JLabel lblManjak;
	private JLabel lblVisak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajGUI window = new IzvjestajGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void pokreni(final JFrame _frameRoditelj, final TipZaposlenika _korisnik, 
							   final Date _datum, final List<Artikal> _artikliManjka, final List<Artikal> _artikliViska) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajGUI window = new IzvjestajGUI();
					
					window.frameRoditelj=_frameRoditelj;
					window.korisnik=_korisnik;
					window.lblKorisnik.setText(window.korisnik.getIme().toUpperCase());
					
					FormaKontroler.postaviFormu(window.frameRoditelj, window.frame, false);
					window.postaviParametre(_datum, _artikliManjka, _artikliViska);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IzvjestajGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Prikaz izvještaja");
		frame.setBounds(100, 100, 572, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblIzvjestaj = new JLabel("Izvještaj");
		lblIzvjestaj.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIzvjestaj.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzvjestaj.setForeground(new Color(0, 128, 0));
		lblIzvjestaj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIzvjestaj.setBounds(10, 11, 379, 41);
		frame.getContentPane().add(lblIzvjestaj);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 260, 185);
		frame.getContentPane().add(scrollPane);
		
		tabelaManjka = new JTable();
		tabelaManjka.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Naziv artikla", "Količina"
			}
		));
		scrollPane.setViewportView(tabelaManjka);
		
		lblKorisnik = new JLabel("korisnik");
		lblKorisnik.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnik.setBounds(346, 11, 197, 41);
		frame.getContentPane().add(lblKorisnik);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 63, 533, 8);
		frame.getContentPane().add(separator);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(283, 124, 260, 185);
		frame.getContentPane().add(scrollPane_1);
		
		tabelaViska = new JTable();
		tabelaViska.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Naziv artikla", "Količina"
			}
		));
		scrollPane_1.setViewportView(tabelaViska);
		
		lblManjak = new JLabel("Manjak:");
		lblManjak.setVerticalAlignment(SwingConstants.BOTTOM);
		lblManjak.setHorizontalAlignment(SwingConstants.LEFT);
		lblManjak.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManjak.setBounds(10, 99, 106, 14);
		frame.getContentPane().add(lblManjak);
		
		lblVisak = new JLabel("Višak:");
		lblVisak.setVerticalAlignment(SwingConstants.BOTTOM);
		lblVisak.setHorizontalAlignment(SwingConstants.LEFT);
		lblVisak.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVisak.setBounds(283, 99, 106, 14);
		frame.getContentPane().add(lblVisak);
	}
	
	private void postaviParametre(Date datum, List<Artikal> artikliManjka, List<Artikal> artikliViska){
		lblIzvjestaj.setText("Izvještaj: "+datum.toString());
		
		DefaultTableModel modelManjka=(DefaultTableModel)tabelaManjka.getModel();
		for(Artikal a:artikliManjka){
			String[] red=new String[]{a.getNaziv(), a.getKolicina().toString()};
			modelManjka.addRow(red);
		}
		
		DefaultTableModel modelViska=(DefaultTableModel)tabelaViska.getModel();
		for(Artikal a:artikliViska){
			String[] red=new String[]{a.getNaziv(), a.getKolicina().toString()};
			modelViska.addRow(red);
		}
	}
}
