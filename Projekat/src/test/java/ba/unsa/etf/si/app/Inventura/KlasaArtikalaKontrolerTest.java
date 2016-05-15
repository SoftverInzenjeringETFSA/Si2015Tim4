package ba.unsa.etf.si.app.Inventura;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ba.unsa.etf.si.app.Inventura.Kontroleri.*;
import ba.unsa.etf.si.app.Inventura.Model.*;
import junit.framework.TestCase;

public class KlasaArtikalaKontrolerTest extends TestCase {

	KlasaArtikla klasa;
	KlasaArtikla temp;
	Long id;
	
	@Before
	public void setUp(){
		
		klasa=new KlasaArtikla("Pice");
		id = KlasaArtikalaKontroler.dodaj(klasa);
	}
	
	
	@Test
	public void testNadji() throws Exception {
		
		temp= KlasaArtikalaKontroler.nadji(klasa.getId());
		Assert.assertEquals(temp.getNaziv(), klasa.getNaziv());
	}
	
	@Test
	public void testIzbrisi() throws Exception {
		
		KlasaArtikalaKontroler.izbrisi(klasa.getId());
		temp=KlasaArtikalaKontroler.nadji(klasa.getId());
		Assert.assertNull(temp);
	}
	@Test
	public void testLista() {

		List<KlasaArtikla> klase=KlasaArtikalaKontroler.lista();
		Assert.assertEquals(klase.size(), KlasaArtikalaKontroler.lista().size());
	
	}
	@After
	public void tearDown(){
		
		KlasaArtikalaKontroler.izbrisi(klasa.getId());
		
	}
	

}
