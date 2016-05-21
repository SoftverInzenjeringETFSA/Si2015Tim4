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

public class InventuraKontrolerTest extends TestCase {
	TipZaposlenika z;
	Long id_z;
	Inventura i,temp;
	Long id_i;
	
	@Before
	public void setUp(){
		Date d = new Date();
		Calendar c=Calendar.getInstance();
		c.set(2016, 05, 14, 15, 57, 00);
		d=c.getTime();
		z=new TipZaposlenika("Ime", "Prezime", "0000000000000", "Adresa", "061111222", "email@gmail.com", "ime", "password", "Skladistar");
		id_z = TipZaposlenikaKontroler.dodaj(z);
		i=new Inventura(d,"Inventura za 2015. godinu",155.0,z);
		id_i = InventuraKontroler.dodaj(i);
	}
	
	@Test
	public void testDodaj() throws Exception {
		
	    temp=InventuraKontroler.nadji(id_i);
	    Assert.assertEquals(temp.gettrenutnoStanje(), i.gettrenutnoStanje());
	    
	}
	@Test
	public void testNadji() throws Exception {

	    temp=InventuraKontroler.nadji(id_i);
	    Assert.assertEquals(temp.getId(),i.getId());

	}
    
    @Test
	public void testLista() {

		List<Inventura>inventure=InventuraKontroler.lista();
		Assert.assertEquals(inventure.size(), InventuraKontroler.lista().size());
	}
    
    @After
	public void tearDown() throws Exception{
		//Ne moze se brisati zbog foreign key-eva
		//InventuraKontroler.izbrisi(id_i);
		//TipZaposlenikaKontroler.izbrisi(id_z);
	}

}
