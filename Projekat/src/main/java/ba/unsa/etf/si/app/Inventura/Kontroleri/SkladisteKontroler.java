package ba.unsa.etf.si.app.Inventura.Kontroleri;
import ba.unsa.etf.si.app.Inventura.Kontroleri.HibernateUtil;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.Skladiste;

public class SkladisteKontroler {
	private static Transaction t;
	private static Session s;
	
	private static void openSession(){
		if(s!=null){
			s.close();
			s=null;
		}
		s=HibernateUtil.getSessionFactory().openSession();
		t=s.beginTransaction();
	}
	
	private static void closeSession(){
		if(s!=null){
			s.close();
			s=null;
			t=null;
		}	
	}
	
	public SkladisteKontroler(){}
	
	
	public static List<Artikal> izlistajArtikle(){
		openSession();
		List<Artikal> klasaArtikalatmp=s.createCriteria(Artikal.class).list();
		t.commit();
		return klasaArtikalatmp;
	}
	
	public void dodajInfoOSkladistu(Skladiste skl){
		
		//dodavanje u bazu informacija sa forme
		openSession();
		s.save(skl);
		t.commit();
		
		closeSession();
	
		
	}
	
	
	
}
