package ba.unsa.etf.si.app.Inventura;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ba.unsa.etf.si.app.Inventura.Kontroleri.IzvjestajKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Izvjestaj;
import junit.framework.TestCase;

public class IzvjestajKontrolerTest extends TestCase {

	@Test
	public void testDodajIzlaz() throws Exception {
		Date d = new Date();
		Calendar c=Calendar.getInstance();
		c.set(2016, 05, 14, 15, 57, 00);
		d=c.getTime();
		Izvjestaj i = new Izvjestaj("Izlaz", "Ovo dokument izlaza", d, 250.0);
		Long id = IzvjestajKontroler.dodaj(i);
		Izvjestaj i2 = new Izvjestaj();
		i2 = IzvjestajKontroler.nadji(id);
		Assert.assertEquals(i2.getId(), i.getId());
	}
	@Test
	public void testDodajOtpis() throws Exception {
		Date d = new Date();
		Calendar c=Calendar.getInstance();
		c.set(2016, 05, 11, 11, 50, 00);
		d=c.getTime();
		Izvjestaj i = new Izvjestaj("Otpis", "Ovo dokument otpisa", d, 12.0);
		Long id = IzvjestajKontroler.dodaj(i);
		
		Izvjestaj i2 = new Izvjestaj();
		i2 = IzvjestajKontroler.nadji(id);
		Assert.assertEquals(i2.getId(), i.getId());
	}
	@Test
	public void testNadji() throws Exception {
		Date d = new Date();
		Calendar c=Calendar.getInstance();
		c.set(2016, 05, 14, 15, 57, 00);
		d=c.getTime();
		Izvjestaj i = new Izvjestaj("Izlaz", "Jos jedan dokument", d, 250.0);
		Long id=IzvjestajKontroler.dodaj(i);
		Izvjestaj pronadjeni = IzvjestajKontroler.nadji(id);
		Assert.assertEquals(pronadjeni.getOpis(), i.getOpis());
	}
		
	
	@Test//(expected = Exception.class)
	public void testIzbrisi(){// throws Exception {
		Date d = new Date();
		Calendar c=Calendar.getInstance();
		c.set(2016, 05, 14, 15, 57, 00);
		d=c.getTime();
		Izvjestaj i = new Izvjestaj("Otpis", "Otpisujem jabuke iz  nekog razloga", d, 250.0);
		Long id=IzvjestajKontroler.dodaj(i);
		IzvjestajKontroler.izbrisi(id);
		//IzvjestajKontroler.nadji(id);
		List<Izvjestaj>izvjestaji=IzvjestajKontroler.lista();
		Assert.assertEquals(izvjestaji.size(), 5);
		
	}

	public void testLista() {

		List<Izvjestaj>izvjestaji=IzvjestajKontroler.lista();
		Assert.assertEquals(izvjestaji.size(), 4);
	
	}
}
