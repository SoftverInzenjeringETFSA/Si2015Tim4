package ba.unsa.etf.si.app.Inventura;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ba.unsa.etf.si.app.Inventura.Kontroleri.*;
import ba.unsa.etf.si.app.Inventura.Model.*;
import junit.framework.TestCase;

public class IzvjestajKontrolerTest extends TestCase {
	
	Izvjestaj i,o;
	Izvjestaj temp;
	Long id,id_o;
	
	@Before
	public void setUp(){
		Date d = new Date();
		Calendar c=Calendar.getInstance();
		c.set(2016, 05, 14, 15, 57, 00);
		d=c.getTime();
		i = new Izvjestaj("Izlaz", "Ovo dokument izlaza", d, 250.0);
		o = new Izvjestaj("Otpis", "Ovo dokument izlaza", d, 250.0);
		id = IzvjestajKontroler.dodaj(i);
		//id_o = IzvjestajKontroler.dodaj(o);
	}
	
	@Test
	public void testNadjiIzlaz() throws Exception {
		temp = IzvjestajKontroler.nadji(id);
		Assert.assertEquals(temp.getId(), i.getId());
	}
	
	@Test
	public void testNadji() throws Exception {
		//id=IzvjestajKontroler.dodaj(i);
		Izvjestaj pronadjeni = IzvjestajKontroler.nadji(id);
		Assert.assertEquals(pronadjeni.getOpis(), i.getOpis());
	}
		
	
	@Test
	public void testIzbrisi(){// throws Exception {
	
		id_o = IzvjestajKontroler.dodaj(o);
		IzvjestajKontroler.izbrisi(id_o);
		List<Izvjestaj>izvjestaji=IzvjestajKontroler.lista();
		Assert.assertEquals(izvjestaji.size(), IzvjestajKontroler.lista().size());
		
	}
	@Test
	public void testLista() {

		List<Izvjestaj>izvjestaji=IzvjestajKontroler.lista();
		Assert.assertEquals(izvjestaji.size(), IzvjestajKontroler.lista().size());
	
	}
	
	@After
	public void tearDown() throws Exception{
		
		IzvjestajKontroler.izbrisi(id);
		//IzvjestajKontroler.izbrisi(id_o);
	}
	
}
