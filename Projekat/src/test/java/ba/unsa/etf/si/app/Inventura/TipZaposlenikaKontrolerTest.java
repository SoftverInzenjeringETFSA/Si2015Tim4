package ba.unsa.etf.si.app.Inventura;

import org.junit.After;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ba.unsa.etf.si.app.Inventura.Kontroleri.*;
import ba.unsa.etf.si.app.Inventura.Model.*;
import junit.framework.TestCase;

public class TipZaposlenikaKontrolerTest extends TestCase {
	TipZaposlenika z;
	TipZaposlenika o;
	Long id;
	@Before
	public void setUp(){
		
		z = new TipZaposlenika("Ime", "Prezime", "1307992170016", "Adresa", "000111222", "rukfas@gmail.com", "user", "pass", "Šef");

	}

   @Test 
	public void testDodaj() {
		id = TipZaposlenikaKontroler.dodaj(z);
		o = TipZaposlenikaKontroler.nadjiID(id);
		Assert.assertEquals(o.getId(), z.getId());
		}

   @Test
	public void testNadji() throws Exception {
	    o = TipZaposlenikaKontroler.nadji("Ime","Prezime");
		Assert.assertEquals(o.getIme(), "Ime"); 
		
		}
	@Test
	public void testNadjiID() {
	
		o=TipZaposlenikaKontroler.nadjiID(z.getId());
		Assert.assertEquals(o.getId(),z.getId());
		}

	public void testNadjiIme() throws Exception {
		o=TipZaposlenikaKontroler.nadjiIme(z.getIme());
		Assert.assertEquals(o.getIme(), "Ime");
		}
	
	@Test(expected = Exception.class)
	public void testBrisiJmbg() throws Exception {
		TipZaposlenikaKontroler.brisiJmbg("1307992170016");
		TipZaposlenikaKontroler.nadjiIme("Ime");
	}
	
	@Test
	public void testIzmjeni() throws Exception {
		z.setBrojtel("111222333");
        o=TipZaposlenikaKontroler.izmjeni(z);
        Assert.assertEquals(o.getBrojtel(), z.getBrojtel());
        
	
	}
	
    @Test
	public void testLista() {

		List<TipZaposlenika>korisnici=TipZaposlenikaKontroler.lista();
		Assert.assertEquals(korisnici.size(), TipZaposlenikaKontroler.lista().size());
	}

	@Test(expected = Exception.class)
	public void testIzbrisi() throws Exception {
		o=TipZaposlenikaKontroler.nadji("Ime", "Prezime");
		TipZaposlenikaKontroler.izbrisi(o.getId());
		o=TipZaposlenikaKontroler.nadji("Ime", "Prezime");
	
	}

    @After
    public void tearDown(){
    	
    	TipZaposlenikaKontroler.izbrisi(z.getId());

    }

    
}
