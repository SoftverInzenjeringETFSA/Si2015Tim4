package ba.unsa.etf.si.app.Inventura;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ba.unsa.etf.si.app.Inventura.Kontroleri.*;
import ba.unsa.etf.si.app.Inventura.Model.*;
import junit.framework.TestCase;

public class SkladisteKontrolerTest extends TestCase {
	@Test
	public void testDokumentiInventure() {
		List<Artikal>artikli=SkladisteKontroler.izlistajArtikle();
		Assert.assertEquals(artikli.size(), SkladisteKontroler.izlistajArtikle().size());
	
	}

}
