package ba.unsa.etf.si.app.Inventura;

import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import junit.framework.Assert;
import junit.framework.TestCase;

public class KlasaArtikalaKontrolerTest extends TestCase {

	@Test
	public void testDodaj() throws Exception {
		KlasaArtikla klasa = new KlasaArtikla("pice");
		Long id = KlasaArtikalaKontroler.dodaj(klasa);
		KlasaArtikla _k2 = new KlasaArtikla();
		_k2 = KlasaArtikalaKontroler.nadji(id);
		Assert.assertEquals(_k2.getId(), klasa.getId());
	}
	@Test
	public void testNadji() throws Exception {
		KlasaArtikla klasa = new KlasaArtikla("pice");
		Long id = KlasaArtikalaKontroler.dodaj(klasa);
		KlasaArtikla _k2 = new KlasaArtikla();
		_k2 = KlasaArtikalaKontroler.nadji(id);
		Assert.assertEquals(_k2.getNaziv(), klasa.getNaziv());
	}
	@Test
	public void testIzbrisi() throws Exception {
		KlasaArtikla klasa=new KlasaArtikla("Cokolade");
		Long id=KlasaArtikalaKontroler.dodaj(klasa);
		KlasaArtikalaKontroler.izbrisi(id);
		List<KlasaArtikla> klase=KlasaArtikalaKontroler.lista();
		Assert.assertEquals(klase.size(), 31);
	}

	public void testLista() {

		List<KlasaArtikla> klase=KlasaArtikalaKontroler.lista();
		Assert.assertEquals(klase.size(), 31);
	
	}

}
