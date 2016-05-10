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
		
		
		
		KlasaArtikla k = new KlasaArtikla();
		TipZaposlenika zaposlenik = new TipZaposlenika();
		TipZaposlenika sef = new TipZaposlenika();
		TipZaposlenika skladistar = new TipZaposlenika();
		ArrayList<TipZaposlenika> skladistari = new ArrayList<TipZaposlenika>();
		Skladiste s = new Skladiste();
		s.setSef(sef);
		s.setSkladistari(skladistari);
		//a.setKlasaArtikla(k);
		
		session.save(k);
		session.save(zaposlenik);
		session.save(sef);
		session.save(skladistar);
		
		session.save(s);
		//session.save(a);
		session.save(zaposlenik);
		
		Inventura i = new Inventura();
		Izvjestaj iz = new Izvjestaj();
		StanjeInventure stanje = new StanjeInventure();
		
		stanje.setInventura(i);
		stanje.setIzvjestaj(iz);
		
		session.save(i);
		session.save(iz);
		session.save(stanje);
		
		t.commit();
		
		session.close();
		System.out.println("mali musa");
	}

}
