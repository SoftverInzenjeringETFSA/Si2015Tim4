package ba.unsa.etf.si.app.Inventura;

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

	public void testArtikliKontroler() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	public void testDodaj() throws Exception {
		
		
	}
	@Test
	public void testNadji() throws Exception {
		
	}
	@Test
	public void testNadjiId() throws Exception {
		KlasaArtikla _k = new KlasaArtikla("brb");
		Long id = KlasaArtikalaKontroler.dodaj(_k);
		KlasaArtikla a2=KlasaArtikalaKontroler.nadji(id);
		Artikal artikal=new Artikal("Ime",a2,"123456789000",3.0,18.0,"komad");
		Artikal b = new Artikal();
		b = ArtikliKontroler.nadjiId(artikal.getId());
		Assert.assertEquals(b.getId(), artikal.getId());
	}
	@Test
	public void testNadjiBarKod() throws Exception {
		KlasaArtikla _k = new KlasaArtikla("brb");
		Long id = KlasaArtikalaKontroler.dodaj(_k);
		KlasaArtikla a2=KlasaArtikalaKontroler.nadji(id);
		Artikal artikal=new Artikal("Ime",a2,"123456789000",3.0,18.0,"komad");
		Artikal b = new Artikal();
		b = ArtikliKontroler.nadjiBarKod(artikal.getBarkod());
		Assert.assertEquals(b.getBarkod(), artikal.getBarkod());
	}
	@Test
	public void testIzbrisi() {
		KlasaArtikla _k = new KlasaArtikla("brb");
		Long id = KlasaArtikalaKontroler.dodaj(_k);
		KlasaArtikla a2=KlasaArtikalaKontroler.nadji(id);
		Artikal artikal=new Artikal("Ime",a2,"123456789000",3.0,18.0,"komad");
		Artikal b = new Artikal();
	//	b = ArtikliKontroler.izbrisi(b.getId());
		
	}
	@Test
	public void testIzmijeni() throws Exception {
		KlasaArtikla _k = new KlasaArtikla("brb");
		Long id = KlasaArtikalaKontroler.dodaj(_k);
		KlasaArtikla a2=KlasaArtikalaKontroler.nadji(id);
		Artikal artikal=new Artikal("Ime",a2,"123456789000",3.0,18.0,"komad");
		Artikal b = new Artikal();
		b = ArtikliKontroler.izmijeni(artikal);
		Assert.assertEquals(b.getNaziv(), artikal.getNaziv());
		
	}

	public void testLista() {
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
