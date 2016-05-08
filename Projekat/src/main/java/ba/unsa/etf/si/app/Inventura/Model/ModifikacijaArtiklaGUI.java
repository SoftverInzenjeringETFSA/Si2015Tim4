package ba.unsa.etf.si.app.Inventura.Model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifikacijaArtiklaGUI {

	private JFrame frame;
	private JTextField txtNaziv;
	private JTextField txtBarkod;
	private JTextField txtKolicina;
	private JTextField txtCijena;
	private JComboBox comboKlasa;
	private JComboBox comboMjera;
	private JList listArtikli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifikacijaArtiklaGUI window = new ModifikacijaArtiklaGUI();
					window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	public ModifikacijaArtiklaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 515, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modifikacija artikla");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(24, 30, 183, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblImePrijavljenogKorisnika = new JLabel("ime prijavljenog korisnika");
		lblImePrijavljenogKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImePrijavljenogKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImePrijavljenogKorisnika.setVerticalAlignment(SwingConstants.BOTTOM);
		lblImePrijavljenogKorisnika.setBounds(304, 11, 134, 37);
		frame.getContentPane().add(lblImePrijavljenogKorisnika);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 80, 414, 7);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Postojeći artikli:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setBounds(10, 112, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNazivArtikla = new JLabel("Naziv artikla:");
		lblNazivArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNazivArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivArtikla.setBounds(215, 129, 79, 14);
		frame.getContentPane().add(lblNazivArtikla);
		
		JLabel lblKlasaArtikla = new JLabel("Klasa artikla:");
		lblKlasaArtikla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKlasaArtikla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKlasaArtikla.setBounds(215, 154, 79, 14);
		frame.getContentPane().add(lblKlasaArtikla);
		
		txtNaziv = new JTextField();
		txtNaziv.setColumns(10);
		txtNaziv.setBounds(304, 126, 134, 20);
		frame.getContentPane().add(txtNaziv);
		
		comboKlasa = new JComboBox();
		comboKlasa.setBounds(304, 151, 134, 20);
		frame.getContentPane().add(comboKlasa);
		
		JButton btnSacuvaj = new JButton("Sa\u010Duvaj");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					izmjeniArtikal();
				}
				catch(Exception i){
					JOptionPane.showMessageDialog(frame, i.getMessage());
				}
			}
		});
		btnSacuvaj.setBounds(365, 300, 89, 23);
		frame.getContentPane().add(btnSacuvaj);
		
		JButton btnZavrsi = new JButton("Odustani");
		btnZavrsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnZavrsi.setBounds(221, 300, 89, 23);
		frame.getContentPane().add(btnZavrsi);
		
		JLabel lblBarKod = new JLabel("Bar kod:");
		lblBarKod.setBounds(248, 179, 46, 14);
		frame.getContentPane().add(lblBarKod);
		
		txtBarkod = new JTextField();
		txtBarkod.setBounds(304, 176, 134, 20);
		frame.getContentPane().add(txtBarkod);
		txtBarkod.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Količina:");
		lblNewLabel_2.setBounds(248, 204, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cijena:");
		lblNewLabel_3.setBounds(248, 229, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mjerna jedinica:");
		lblNewLabel_4.setBounds(215, 254, 79, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtKolicina = new JTextField();
		txtKolicina.setBounds(304, 201, 134, 20);
		frame.getContentPane().add(txtKolicina);
		txtKolicina.setColumns(10);
		
		txtCijena = new JTextField();
		txtCijena.setBounds(304, 226, 134, 20);
		frame.getContentPane().add(txtCijena);
		txtCijena.setColumns(10);
		
		comboMjera = new JComboBox();
		comboMjera.setBounds(318, 251, 96, 20);
		frame.getContentPane().add(comboMjera);
		
		listArtikli = new JList();
		listArtikli.setBounds(24, 136, 183, 187);
		frame.getContentPane().add(listArtikli);
	}

	public void izmjeniArtikal() throws Exception {
		Artikal artikal=(Artikal)listArtikli.getSelectedValue();
		
		String naziv=txtNaziv.getText();
		KlasaArtikla klasa=(KlasaArtikla)comboKlasa.getSelectedItem();
		String barkod=txtBarkod.getText();
		Double cijena=Double.parseDouble(txtCijena.getText());
		Double kolicina=Double.parseDouble(txtKolicina.getText());
		String mjera=(String)comboMjera.getSelectedItem();
		
		Artikal novi=new Artikal(naziv, klasa, barkod, cijena, kolicina, mjera);
		
		//artikal.izmjeniArtikal(novi);
		
		// azuriranje liste i baze
	}
}
