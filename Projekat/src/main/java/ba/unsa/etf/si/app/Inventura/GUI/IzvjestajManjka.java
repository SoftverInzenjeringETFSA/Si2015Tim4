package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import org.apache.log4j.Logger;

public class IzvjestajManjka {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void pokreni() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					IzvjestajManjka window = new IzvjestajManjka();
					window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.info(e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IzvjestajManjka() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 284, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblIzvjetajManjka = new JLabel("Izvještaj manjka");
		lblIzvjetajManjka.setBounds(80, 30, 110, 19);
		lblIzvjetajManjka.setForeground(new Color(0, 128, 0));
		lblIzvjetajManjka.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JTextArea txtrNaOsnovuIzvrenog = new JTextArea();
		txtrNaOsnovuIzvrenog.setBounds(38, 78, 195, 116);
		txtrNaOsnovuIzvrenog.setRows(5);
		txtrNaOsnovuIzvrenog.setText("Na osnovu izvršenog\r\nobračuna popisa robe,\r\nustanovljen je manjak u \r\nodnosu na stanje u\r\nskladištu u iznosu od: ");
		
		JLabel lblNewLabel = new JLabel("-iznos-");
		lblNewLabel.setBounds(97, 212, 48, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("KM");
		lblNewLabel_1.setBounds(155, 212, 28, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(txtrNaOsnovuIzvrenog);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblIzvjetajManjka);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
