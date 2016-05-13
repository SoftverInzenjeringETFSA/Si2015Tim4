package ba.unsa.etf.si.app.Inventura;

import org.junit.Before;
import org.junit.Test;

import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.TipZaposlenikaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;
import junit.framework.Assert;
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
	@Test(expected=Exception.class)
	public void testIzbrisi() throws Exception {
		KlasaArtikla klasa=new KlasaArtikla("Cokolade");
		Long id = KlasaArtikalaKontroler.dodaj(klasa);
		Artikal a=new Artikal("Milka",klasa,"1234567890123",2.5,250.0,"komad");
		Long id2=ArtikliKontroler.dodaj(a);
		ArtikliKontroler.izbrisi(id2);
        ArtikliKontroler.nadji("Milka");		
	}
	@Test
	public void testIzmijeni() throws Exception {
		
		
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
