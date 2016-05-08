package ba.unsa.etf.si.app.Inventura.Kontroleri;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.Inventura.Kontroleri.HibernateUtil;

import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
import java.util.List;

public final class KlasaArtikalaKontroler {

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
	
	private KlasaArtikalaKontroler(){}
	
	
	public static Long dodaj(KlasaArtikla a){
		openSession();
		
		Long id= (Long) s.save(a);
		t.commit();
		
		closeSession();
		return id;	
	}
	
	public static KlasaArtikla nadji(String naziv){
		openSession();
		KlasaArtikla a = (KlasaArtikla) s.get(KlasaArtikla.class,new String(naziv));
		t.commit();
		
		closeSession();
		return a;
	}
	
	public static void izbrisi(String naziv){
		openSession();
		Object instance = s.load(KlasaArtikla.class, new String(naziv));
		if (instance != null)
			s.delete(instance);
		
		t.commit();
		closeSession();
	}
	
	public static KlasaArtikla izmijeni(KlasaArtikla a){
		openSession();
		
			s.merge(a);
			t.commit();
			closeSession();
			
		String naziv = a.getNaziv();	
		
		return nadji(naziv);
	}
	
	public static List<KlasaArtikla> lista(){
		openSession();
		
		List<KlasaArtikla> klasaArtikalatmp=s.createCriteria(KlasaArtikla.class).list();
		t.commit();
		return klasaArtikalatmp;
	}
	
	}


