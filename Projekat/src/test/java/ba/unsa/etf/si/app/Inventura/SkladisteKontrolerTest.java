package ba.unsa.etf.si.app.Inventura;

import java.util.List;

import org.junit.Assert;

import ba.unsa.etf.si.app.Inventura.Kontroleri.SkladisteKontroler;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import junit.framework.TestCase;

public class SkladisteKontrolerTest extends TestCase {

	public void testDokumentiInventure() {
		List<Artikal>artikli=SkladisteKontroler.izlistajArtikle();
		Assert.assertEquals(artikli.size(), 12);
	
	}

}
