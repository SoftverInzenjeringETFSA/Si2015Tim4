package ba.unsa.etf.si.app.Inventura;

import javax.swing.JTable;

import org.junit.Assert;

import ba.unsa.etf.si.app.Inventura.Kontroleri.PostaviListBox;
import junit.framework.TestCase;

public class PostaviListBoxTest extends TestCase {
	
	public void testDokumentiViska() {

		JTable t=new JTable();
		PostaviListBox.dokumentiViska(t);
		//t.getRowCount()
		//List<Izvjestaj>i=IzvjestajKontroler.lista();
		Assert.assertEquals(t.getRowCount(), 0);
	}

	public void testDokumentiManjka() {

		JTable t=new JTable();
		PostaviListBox.dokumentiManjka(t);
		Assert.assertEquals(t.getRowCount(),0);
	}

	public void testDokumentiOtpisa() {
		
		JTable t=new JTable();
		PostaviListBox.dokumentiOtpisa(t);
		Assert.assertEquals(t.getRowCount(),1);
		
	}

	public void testDokumentiIzlaza() {
		JTable t=new JTable();
		PostaviListBox.dokumentiIzlaza(t);
		Assert.assertEquals(t.getRowCount(),2);
		}

	public void testArtikliNaSkladistu() {
		JTable t=new JTable();
		PostaviListBox.artikliNaSkladistu(t);
		Assert.assertEquals(t.getRowCount(),9);	}
	
	
	public void testPrikaziZaposlenike() {
		JTable t=new JTable();
		PostaviListBox.prikaziZaposlenike(t);
		Assert.assertEquals(t.getRowCount(),9);	}
	
	
	
	
	

}
