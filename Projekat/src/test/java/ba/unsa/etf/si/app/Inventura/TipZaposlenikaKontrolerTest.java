package ba.unsa.etf.si.app.Inventura;

import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TipZaposlenikaKontrolerTest extends TestCase {
	public void testTipZaposlenikaKontroler() {
		fail("Not yet implemented"); // TODO
	}
	TipZaposlenika novi = new TipZaposlenika("Faruk", "Goro", "1307992170016", "nedje dole", "061913117", "rukfas@gmail.com", "SG Severus", "severusmali", "Šef");


	public void testDodaj() {
		Long id = TipZaposlenikaKontroler.dodaj(novi);
		TipZaposlenika novi1 = new TipZaposlenika();
		novi1=TipZaposlenikaKontroler.nadjiID(novi.getId());
		Assert.assertEquals(novi1.getId(), novi.getId());	}

	public void testNadji() throws Exception {
		TipZaposlenika novi1 = new TipZaposlenika();
		novi1=TipZaposlenikaKontroler.nadji("Faruk","Goro");
		Assert.assertEquals(novi1.getIme(), "Faruk"); 
		}
		
	

	public void testNadjiID() {
		TipZaposlenika novi1 = new TipZaposlenika();
		novi1=TipZaposlenikaKontroler.nadjiID(9);
		Assert.assertEquals(novi1.getIme(),"Amra");
		}

	public void testNadjiIme() throws Exception {
		TipZaposlenika novi1 = new TipZaposlenika();
		novi1=TipZaposlenikaKontroler.nadjiIme("Amra");
		Assert.assertEquals(novi1.getIme(), "Amra");	}

	@Test(expected = Exception.class)
	public void testIzbrisi() throws Exception {
		
		TipZaposlenikaKontroler.izbrisi(12);
		TipZaposlenika novi=TipZaposlenikaKontroler.nadjiIme("Faruk");
	
	}
	
	@Test(expected = Exception.class)
	public void testBrisiJmbg() throws Exception {
		Long id = TipZaposlenikaKontroler.dodaj(novi);
		TipZaposlenikaKontroler.brisiJmbg("1307992170016");
		TipZaposlenikaKontroler.nadjiIme("Faruk");
	}

	public void testIzmjeni() throws Exception {
		Long id = TipZaposlenikaKontroler.dodaj(novi);
        TipZaposlenika t=TipZaposlenikaKontroler.izmjeni(novi);
	
	}
    @Test
	public void testLista() {

		List<TipZaposlenika>korisnici=TipZaposlenikaKontroler.lista();
		Assert.assertEquals(korisnici.size(), 3);
	}

	public void testProvjerUserPass() {
		fail("Not yet implemented"); // TODO
	}

}
