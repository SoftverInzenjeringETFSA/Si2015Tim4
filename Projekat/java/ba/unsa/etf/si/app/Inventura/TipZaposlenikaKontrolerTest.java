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
	TipZaposlenika z,z2;
	TipZaposlenika o;
	Long id,id2;
	
	@Before
	public void setUp(){
		
		z = new TipZaposlenika("Ime", "Prezime", "1307992170016", "Adresa", "000111222", "rukfas@gmail.com", "user", "pass", "Šef");
		id = TipZaposlenikaKontroler.dodaj(z);
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

	@Test
	public void testNadjiIme() throws Exception {
		o=TipZaposlenikaKontroler.nadjiIme(z.getIme());
		Assert.assertEquals(o.getIme(), "Ime");
		}
	
	@Test
	public void testBrisiJmbg() throws Exception {
		z2 = new TipZaposlenika("N", "N", "0000000000001", "Adresa", "000111222", "bla@gmail.com", "ok", "ok", "Šef");
		id2 = TipZaposlenikaKontroler.dodaj(z2);
		o=TipZaposlenikaKontroler.nadji("N", "N");
		TipZaposlenikaKontroler.brisiJmbg("0000000000001");
		List<TipZaposlenika>korisnici=TipZaposlenikaKontroler.lista();
		Assert.assertEquals(korisnici.size(), TipZaposlenikaKontroler.lista().size());
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

	@Test
	public void testIzbrisi() throws Exception {
		z2 = new TipZaposlenika("N", "N", "0000000000001", "Adresa", "000111222", "bla@gmail.com", "ok", "ok", "Šef");
		id2 = TipZaposlenikaKontroler.dodaj(z2);
		o=TipZaposlenikaKontroler.nadji("N", "N");
		TipZaposlenikaKontroler.izbrisi(o.getId());
		List<TipZaposlenika>korisnici=TipZaposlenikaKontroler.lista();
		Assert.assertEquals(korisnici.size(), TipZaposlenikaKontroler.lista().size());
	}

    @After
    public void tearDown(){
    	
    	TipZaposlenikaKontroler.izbrisi(z.getId());

    }

    
}