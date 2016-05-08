package ba.unsa.etf.si.app.Inventura.Kontroleri;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

public class TipZaposlenikaKontroler {

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
	
	
	private TipZaposlenikaKontroler(){}
		
		public static long dodaj(TipZaposlenika tip){
			openSession();
			
			long id= (long) s.save(tip);
			t.commit();
			
			closeSession();
			return id;	
		}
		
		// trazi po imenu i prezimenu korisnika
		public static TipZaposlenika nadji(String ime, String prezime){
			openSession();
			TipZaposlenika tip = (TipZaposlenika) s.get(TipZaposlenika.class,new String(ime) + new String(prezime));
			t.commit();
			
			closeSession();
			return tip;
		}
		
		//trazi po id-u
		public static TipZaposlenika nadjiID(long id){
			openSession();
			TipZaposlenika tip = (TipZaposlenika) s.get(TipZaposlenika.class, new Long (id));
			t.commit();
			
			closeSession();
			return tip;
		}
		
		//brise korisnika po ID/u
		public static void izbrisi(long id){
			openSession();
			Object instance = s.load(TipZaposlenika.class, new Long (id));
			if (instance != null)
				s.delete(instance);
			
			t.commit();
			closeSession();
		}
		
		// modifikacija zaposlenika 
		public static TipZaposlenika izmijeni(TipZaposlenika a){
			openSession();
			
				s.merge(a);
				t.commit();
				closeSession();
				
			String ime = a.getIme();	
			String prezime= a.getPrezime();
			return nadji(ime,prezime);
		}
		
		public static List<TipZaposlenika> lista(){
			openSession();
			
			List<TipZaposlenika> tipTemp=s.createCriteria(TipZaposlenika.class).list();
			t.commit();
			return tipTemp;
		}
		
	}
	

