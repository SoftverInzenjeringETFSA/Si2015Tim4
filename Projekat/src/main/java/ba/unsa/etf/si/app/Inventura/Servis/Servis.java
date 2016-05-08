package ba.unsa.etf.si.app.Inventura.Servis;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.Inventura.Kontroleri.HibernateUtil;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;

public final class Servis {

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
	
	private Servis() {}
	
public static class Artikli{
		
		public static Long dodaj(Artikal a){
			openSession();
			
			Long id= (Long) s.save(a);
			t.commit();
			
			closeSession();
			return id;	
		}
		
		public static Artikal nadji(int id){
			openSession();
			Artikal a = (Artikal) s.get(Artikal.class,new Long(id));
			t.commit();
			
			closeSession();
			return a;
		}
		
		public static void izbrisi(String barkod){
			openSession();
			Object instance = s.load(Artikal.class, new String(barkod));
			if (instance != null)
				s.delete(instance);
			
			t.commit();
			closeSession();
		}
		
		public static Artikal izmijeni(Artikal a){
			openSession();
			
				s.merge(a);
				t.commit();
				closeSession();
				
			long l=a.getId();
			int id=(int) l;
			return nadji(id);
		}
		
		/* public static List<Osoba> lista(){
			openSession();
			List<Osoba> osobe=s.createCriteria(Osoba.class).list();
			t.commit();
			return osobe;
		}
		*/
	
	}
	
}
