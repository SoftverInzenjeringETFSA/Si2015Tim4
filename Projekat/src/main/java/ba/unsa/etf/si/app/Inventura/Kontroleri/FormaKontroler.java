package ba.unsa.etf.si.app.Inventura.Kontroleri;

import javax.swing.JFrame;

public final class FormaKontroler {
	@SuppressWarnings("deprecation")
	public static void postaviFormu(final JFrame frameRoditelj, final JFrame frame, final boolean prijava){
		if(prijava){
			frameRoditelj.setVisible(false);
		}
		else{
			frameRoditelj.disable();
		}
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				zatvoriFormu(frameRoditelj, frame, prijava);
		    }
		});
		
		frame.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public static void zatvoriFormu(JFrame frameRoditelj, JFrame frame, boolean odjava){
		if(frameRoditelj!=null){
			if(odjava){
				frameRoditelj.setVisible(true);
			}
			else{
				frameRoditelj.enable();
			}
		}
		
		frame.dispose();
	}
}
