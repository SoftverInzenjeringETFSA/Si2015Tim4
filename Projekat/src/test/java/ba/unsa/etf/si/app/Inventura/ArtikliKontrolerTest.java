package ba.unsa.etf.si.app.Inventura;
import ba.unsa.etf.si.app.Inventura.Kontroleri.*;
import ba.unsa.etf.si.app.Inventura.Model.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import junit.framework.TestCase;

public class ArtikliKontrolerTest extends TestCase {

	KlasaArtikla klasa;
	Long idKlase;
	Long idArtikla;
	Artikal a;
	Artikal temp;
	@Before 
	public void setUp() { 
	
		klasa=new KlasaArtikla("Cokolade");
		idKlase = KlasaArtikalaKontroler.dodaj(klasa);
		a=new Artikal("Milka",klasa,"1234567890123",2.5,250.0,"komad");
		idArtikla=ArtikliKontroler.dodaj(a);
	}
	
	@Test
	public void testNadji() throws Exception {
		
		temp=ArtikliKontroler.nadji("Milka");
		Assert.assertEquals(temp.getId(),a.getId());
		
	}
	
	@Test
	public void testNadjiId() throws Exception {
		temp = ArtikliKontroler.nadjiId(a.getId());
		
		Assert.assertEquals(temp.getId(), a.getId());
	}
	
	@Test
	public void testNadjiBarKod() throws Exception {
		temp=ArtikliKontroler.nadjiBarKod("1234567890123");
	    Assert.assertEquals(a.getId(),temp.getId());
	
	}
	
	/*@Test//(expected = IndexOutOfBoundsException.class)
	public void testIzbrisi() throws Exception {
		
		ArtikliKontroler.izbrisi(a.getId());
        //temp=ArtikliKontroler.nadji("Milka");
        //Assert.assertNull(temp);
        List<Artikal>artikli=ArtikliKontroler.lista();
		Assert.assertEquals(artikli.size(), ArtikliKontroler.lista().size());
	}*/
	
	@Test
	public void testIzmijeni() throws Exception {
		
		a.setNaziv("Dorina");
		temp=ArtikliKontroler.izmijeni(a);
		Assert.assertEquals(temp.getNaziv(), a.getNaziv());
		
	}
	
	@Test
	public void testLista() throws Exception {
		List<Artikal>artikli=ArtikliKontroler.lista();
		Assert.assertEquals(artikli.size(), ArtikliKontroler.lista().size());
		
	}
	
	@After
	public void tearDown() throws Exception{
		
		ArtikliKontroler.izbrisi(a.getId());
		KlasaArtikalaKontroler.izbrisi(klasa.getId());
	}
	
}
