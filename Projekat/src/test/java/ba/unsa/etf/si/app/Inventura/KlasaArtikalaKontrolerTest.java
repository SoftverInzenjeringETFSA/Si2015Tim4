package ba.unsa.etf.si.app.Inventura;

import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.app.Inventura.Kontroleri.KlasaArtikalaKontroler;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import junit.framework.Assert;
import junit.framework.TestCase;

public class KlasaArtikalaKontrolerTest extends TestCase {

	@Test
	public void testDodaj() {
		KlasaArtikla klasa = new KlasaArtikla("pice");
		Long id = KlasaArtikalaKontroler.dodaj(klasa);
		KlasaArtikla _k2 = new KlasaArtikla();
		_k2 = KlasaArtikalaKontroler.nadji(id);
		Assert.assertEquals(_k2.getId(), klasa.getId());
	}
	@Test
	public void testNadji() {
		KlasaArtikla klasa = new KlasaArtikla("pice");
		Long id = KlasaArtikalaKontroler.dodaj(klasa);
		KlasaArtikla _k2 = new KlasaArtikla();
		_k2 = KlasaArtikalaKontroler.nadji(id);
		Assert.assertEquals(_k2.getNaziv(), klasa.getNaziv());
	}

	public void testIzbrisi() {
		//bool nePostoji=false;
		KlasaArtikla klasa=new KlasaArtikla("Cokolade");
		Long id=KlasaArtikalaKontroler.dodaj(klasa);
		KlasaArtikalaKontroler.izbrisi(id);
	    List<KlasaArtikla>k=KlasaArtikalaKontroler.lista();
	    for(int i=0;i<k.size();i++)
	     	{ 
	    	//if(k[i].getNaziv()!=klasa.getNaziv()) nePostoji=true;
	     	}
	}

	public void testIzmijeni() {
		fail("Not yet implemented"); // TODO
	}

	public void testLista() {
		fail("Not yet implemented"); // TODO
	}

}
