package ba.unsa.etf.si.app.Inventura;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import org.junit.Assert;
import org.junit.Test;

import ba.unsa.etf.si.app.Inventura.Kontroleri.*;
import ba.unsa.etf.si.app.Inventura.Model.*;
import junit.framework.TestCase;

public class PostaviListBoxTest extends TestCase {
	@Test
	public void testDokumentiViska() {

		JTable t=new JTable();
		PostaviListBox.dokumentiViska(t);
		List<Izvjestaj>izvjestaji=IzvjestajKontroler.lista();
		List<Izvjestaj>viskovi = new ArrayList<Izvjestaj>();
		for(Izvjestaj i:izvjestaji){
			if(i.getVrsta().equals("Visak")){
				viskovi.add(i);
			}
		}
		Assert.assertEquals(t.getRowCount(),viskovi.size());
	}
	@Test
	public void testDokumentiManjka() {

		JTable t=new JTable();
		PostaviListBox.dokumentiManjka(t);
		List<Izvjestaj>izvjestaji=IzvjestajKontroler.lista();
		List<Izvjestaj>manjci = new ArrayList<Izvjestaj>();
		for(Izvjestaj i:izvjestaji){
			if(i.getVrsta().equals("Manjak")){
				manjci.add(i);
			}
		}
		Assert.assertEquals(t.getRowCount(),manjci.size());	}
	@Test
	public void testDokumentiOtpisa() {
		
		JTable t=new JTable();
		PostaviListBox.dokumentiOtpisa(t);
		List<Izvjestaj>izvjestaji=IzvjestajKontroler.lista();
		List<Izvjestaj>otpisi = new ArrayList<Izvjestaj>();
		for(Izvjestaj i:izvjestaji){
			if(i.getVrsta().equals("Otpis")){
				otpisi.add(i);
			}
		}
		Assert.assertEquals(t.getRowCount(),otpisi.size());
		
	}
	@Test
	public void testDokumentiIzlaza() {
		JTable t=new JTable();
		PostaviListBox.dokumentiIzlaza(t);
		List<Izvjestaj>izvjestaji=IzvjestajKontroler.lista();
		List<Izvjestaj>izlazi = new ArrayList<Izvjestaj>();
		for(Izvjestaj i:izvjestaji){
			if(i.getVrsta().equals("Izlaz")){
				izlazi.add(i);
			}
		}
		Assert.assertEquals(t.getRowCount(),izlazi.size());		}
	@Test
	public void testArtikliNaSkladistu() {
		JTable t=new JTable();
		PostaviListBox.artikliNaSkladistu(t);
		List<Artikal>artikli=ArtikliKontroler.lista();
		Assert.assertEquals(t.getRowCount(),artikli.size());
	}
	@Test
	public void testPrikaziZaposlenike() {
		JTable t=new JTable();
		PostaviListBox.prikaziZaposlenike(t);
		List<TipZaposlenika>zaposlenici=TipZaposlenikaKontroler.lista();
		Assert.assertEquals(t.getRowCount(),zaposlenici.size());
		}
	
	
	
	
	

}
