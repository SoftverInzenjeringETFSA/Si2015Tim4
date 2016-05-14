package ba.unsa.etf.si.app.Inventura.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.apache.log4j.Logger;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class IzvjestajViska {
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajViska window = new IzvjestajViska();
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
	public IzvjestajViska() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 274, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblIzvjetajVika = new JLabel("Izvještaj viška");
		lblIzvjetajVika.setBounds(80, 30, 94, 19);
		lblIzvjetajVika.setForeground(new Color(0, 128, 0));
		lblIzvjetajVika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JTextArea txtrNaOsnovuIzvrenog = new JTextArea();
		txtrNaOsnovuIzvrenog.setBounds(38, 78, 195, 116);
		txtrNaOsnovuIzvrenog.setRows(5);
		txtrNaOsnovuIzvrenog.setText("Na osnovu izvršenog\r\nobračuna popisa robe,\r\nustanovljen je višak u \r\nodnosu na stanje u\r\nskladištu u iznosu od: ");
		
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
		frame.getContentPane().add(lblIzvjetajVika);
	}
}
