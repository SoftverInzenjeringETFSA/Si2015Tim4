package ba.unsa.etf.si.app.Inventura;

import ba.unsa.etf.si.app.Inventura.Kontroleri.ArtikliKontroler;
import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import junit.framework.Assert;
import junit.framework.TestCase;

public class ArtikliKontrolerTest extends TestCase {

	public void testArtikliKontroler() {
		fail("Not yet implemented"); // TODO
	}

	public void testDodaj() throws Exception {
		KlasaArtikla a1=new KlasaArtikla("Bla");
		Long id=KlasaArtikalaKontroler.dodaj(a1);
		KlasaArtikla a2=KlasaArtikalaKontroler.nadji(id);
		Artikal artikal=new Artikal("Ime",a2,"123456789000",3.0,18.0,"komad");
		Long id2=ArtikliKontroler.dodaj(artikal);
		Artikal b=new Artikal();
		b=ArtikliKontroler.nadjiId(artikal.getId());
		Assert.assertEquals(b.getId(), artikal.getId());
		
	}

	public void testNadji() {
		fail("Not yet implemented"); // TODO
	}

	public void testNadjiId() {
		fail("Not yet implemented"); // TODO
	}

	public void testNadjiBarKod() {
		fail("Not yet implemented"); // TODO
	}

	public void testIzbrisi() {
		fail("Not yet implemented"); // TODO
	}

	public void testIzmijeni() {
		fail("Not yet implemented"); // TODO
	}

	public void testLista() {
		fail("Not yet implemented"); // TODO
	}

}
