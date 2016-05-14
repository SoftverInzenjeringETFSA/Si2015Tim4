package ba.unsa.etf.si.app.Inventura;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import ba.unsa.etf.si.app.Inventura.Kontroleri.IzvjestajKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Izvjestaj;
import junit.framework.Assert;
import junit.framework.TestCase;

public class IzvjestajKontrolerTest extends TestCase {

	@Test
	public void testDodaj() throws Exception {
		Date d = new Date();
		Calendar c=Calendar.getInstance();
		c.set(2016, 05, 13, 12, 20, 55);
		d=c.getTime();
		Izvjestaj i = new Izvjestaj("vrsta", "opis", d, 0.0);
		Long id = IzvjestajKontroler.dodaj(i);
		Izvjestaj i2 = new Izvjestaj();
		i2 = IzvjestajKontroler.nadji(id);
		Assert.assertEquals(i2.getId(), i.getId());
	}
	@Test
	public void testNadji() throws Exception {
		Date d = new Date();
		Calendar c=Calendar.getInstance();
		c.set(2016, 05, 12, 13, 00, 00);
		d=c.getTime();
		Izvjestaj i = new Izvjestaj("vrsta", "opis", d, 0.0);
		Long id = IzvjestajKontroler.dodaj(i);
		Izvjestaj i2 = new Izvjestaj();
		i2 = IzvjestajKontroler.nadji(id);
		Assert.assertEquals(i2.getOpis(), i.getOpis());
		
	}

	public void testIzbrisi() {
		fail("Not yet implemented"); // TODO
	}

	public void testLista() {
		fail("Not yet implemented"); // TODO
	}
}
