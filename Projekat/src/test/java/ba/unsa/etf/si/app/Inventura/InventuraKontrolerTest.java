package ba.unsa.etf.si.app.Inventura;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ba.unsa.etf.si.app.Inventura.Kontroleri.*;
import ba.unsa.etf.si.app.Inventura.Model.*;
import junit.framework.TestCase;

public class InventuraKontrolerTest extends TestCase {
	
	@Test
	public void testDodaj() throws Exception {
		Date d = new Date();
		Calendar c=Calendar.getInstance();
		c.set(2016, 05, 14, 15, 57, 00);
		d=c.getTime();
		TipZaposlenika novi = new TipZaposlenika("Ime", "Prezime", "0000000000000", "Adresa", "061913117", "rukfas@gmail.com", "ime", "password", "Skladistar");
		Long id2=TipZaposlenikaKontroler.dodaj(novi);
		Inventura i=new Inventura(d,"Inventura za 2015. godinu",155.0,novi);
	    Long idDodane=InventuraKontroler.dodaj(i);
	    
	    Inventura pronadjena=InventuraKontroler.nadji(idDodane);
	    Assert.assertEquals(pronadjena.gettrenutnoStanje(), i.gettrenutnoStanje());
	    
	}
	@Test
	public void testNadji() throws Exception {
		Date d = new Date();
		Calendar c=Calendar.getInstance();
		c.set(2014, 05, 14, 15, 57, 00);
		d=c.getTime();
		TipZaposlenika novi = new TipZaposlenika("Ime2", "Prezime2", "0000000000002", "Adresa", "061913117", "rukfas@gmail.com", "ime2", "password2", "Skladistar");
		Long id2=TipZaposlenikaKontroler.dodaj(novi);
		Inventura i=new Inventura(d,"Inventura za 2014. godinu",2658.0,novi);
	    Long id=InventuraKontroler.dodaj(i);
	    Inventura a=InventuraKontroler.nadji(id);
	    Assert.assertEquals(a.getId(),i.getId());
	
	
	}
    @Test
	public void testIzbrisi() throws Exception {

		Date d = new Date();
		Calendar c=Calendar.getInstance();
		c.set(2013, 05, 10, 15, 57, 00);
		d=c.getTime();
		TipZaposlenika novi = new TipZaposlenika("Neko", "Nekic", "0000000000000", "Adresa", "061913117", "rukfas@gmail.com", "ime", "password", "Skladistar");
		Long id2=TipZaposlenikaKontroler.dodaj(novi);
		Inventura i=new Inventura(d,"Inventura za 2013. godinu",155.0,novi);
	    Long id=InventuraKontroler.dodaj(i);
	    InventuraKontroler.izbrisi(id);
	    List<Inventura>inventure=InventuraKontroler.lista();
		Assert.assertEquals(inventure.size(), 7);
	
	}
    @Test
	public void testLista() {

		List<Inventura>inventure=InventuraKontroler.lista();
		Assert.assertEquals(inventure.size(), 7);
	}

}
