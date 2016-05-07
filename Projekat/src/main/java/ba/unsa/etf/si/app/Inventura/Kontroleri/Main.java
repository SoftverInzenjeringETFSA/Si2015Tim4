 
package ba.unsa.etf.si.app.Inventura.Kontroleri;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.Inventura.Model.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("Test.");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t=session.beginTransaction();
		Artikal a = new Artikal();
		KlasaArtikla k = new KlasaArtikla();
		TipZaposlenika zaposlenik = new TipZaposlenika();
		Sef sef = new Sef();
		Skladistar skladistar = new Skladistar();
		ArrayList<Skladistar> skladistari= new ArrayList<Skladistar>();
		skladistari.add(skladistar);
		Skladiste s = new Skladiste();
		s.setSef(sef);
		s.setSkladistari(skladistari);
		a.setKlasaArtikla(k);
		session.save(k);
		session.save(zaposlenik);
		session.save(sef);

		session.save(s);
		//session.save(a);
		session.save(zaposlenik);
		
		Inventura i = new Inventura();
		i.setSkladistar(skladistar);
		Izvjestaj iz = new Izvjestaj();
		StanjeInventure stanje = new StanjeInventure();
		stanje.setInventura(i);
		stanje.setIzvjestaj(iz);
		
		session.save(i);
		session.save(iz);
		session.save(stanje);
		t.commit();
		session.close();

	}

}
