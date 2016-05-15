package ba.unsa.etf.si.app.Inventura;
import ba.unsa.etf.si.app.Inventura.Kontroleri.*;
import ba.unsa.etf.si.app.Inventura.Model.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import junit.framework.TestCase;

public class ArtikliKontrolerTest extends TestCase {

	KlasaArtikla klasa;
	Long id;
	Artikal a;
	@Before 
	public void postavi() { 
	
	}
	
	public void testDodaj() throws Exception {
		klasa=new KlasaArtikla("Cokolade");
		id = KlasaArtikalaKontroler.dodaj(klasa);
		Artikal a=new Artikal("Milka",klasa,"1234567890123",2.5,250.0,"komad");
		Long id=ArtikliKontroler.dodaj(a);
		Assert.assertNotNull(Long.toString(id));
	}
	@Test
	public void testNadji() throws Exception {
		
		Artikal a=ArtikliKontroler.nadji("vato");
		Assert.assertEquals(a.getMjera(),"komad" );
		
	}
	@Test
	public void testNadjiId() throws Exception {
		klasa=new KlasaArtikla("Cokolade");
		id = KlasaArtikalaKontroler.dodaj(klasa);
		Artikal a=new Artikal("Milka",klasa,"1234567890123",2.5,250.0,"komad");
		Long id=ArtikliKontroler.dodaj(a);
		Artikal b = new Artikal();
		b = ArtikliKontroler.nadjiId(a.getId());
		Assert.assertEquals(b.getId(), a.getId());
	}
	@Test
	public void testNadjiBarKod() throws Exception {
		KlasaArtikla klasa=new KlasaArtikla("Cokolade");
		Long id = KlasaArtikalaKontroler.dodaj(klasa);
		Artikal a=new Artikal("Milka",klasa,"1234567890123",2.5,250.0,"komad");
	    Artikal pronadjeni=ArtikliKontroler.nadjiBarKod("1234567890123");
	    Assert.assertEquals(a.getCijena(), pronadjeni.getCijena());
	
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIzbrisi() throws Exception {
		KlasaArtikla klasa=new KlasaArtikla("Voce");
		Long id = KlasaArtikalaKontroler.dodaj(klasa);
		Artikal a=new Artikal("Jabuka",klasa,"1234567890124",2.0,300.0,"kg");
		Long id2=ArtikliKontroler.dodaj(a);
		ArtikliKontroler.izbrisi(id2);
        ArtikliKontroler.nadji("Jabuka");		
	}
	@Test
	public void testIzmijeni() throws Exception {
		
		Artikal b=ArtikliKontroler.nadji("vato");
		//Long id2=ArtikliKontroler.dodaj(a);
		b.setNaziv("noviNaziv");
		Artikal novi=ArtikliKontroler.izmijeni(b);
		Assert.assertEquals("noviNaziv", novi.getNaziv());
		
	}

	public void testLista() throws Exception {
		KlasaArtikla _k = new KlasaArtikla("brb");
		Long id = KlasaArtikalaKontroler.dodaj(_k);
		KlasaArtikla a2=KlasaArtikalaKontroler.nadji(id);
		Artikal artikal=new Artikal("Ime",a2,"123456789000",3.0,18.0,"komad");
		Long id2=ArtikliKontroler.dodaj(artikal);
		Artikal b = new Artikal();
		//b = ArtikliKontroler.lista()
	//	Assert.assertEquals(b.getNaziv(), artikal.getNaziv());
		
	}
}
