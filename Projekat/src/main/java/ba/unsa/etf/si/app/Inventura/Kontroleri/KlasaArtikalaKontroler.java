package ba.unsa.etf.si.app.Inventura.Kontroleri;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.Inventura.Kontroleri.HibernateUtil;
import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
//import java.util.List;

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
	
	public static KlasaArtikla nadji(Long id){
		openSession();
		KlasaArtikla a = (KlasaArtikla) s.get(KlasaArtikla.class,new Long(id));
		t.commit();
		
		closeSession();
		return a;
	}
	
	public static KlasaArtikla nadjiIme(String naziv) throws Exception
	{
		openSession();
		List<Object> klase = s.createCriteria(KlasaArtikla.class).add(Restrictions.like("naziv", naziv)).list();
		if(klase.size() > 1) {
			throw new Exception();
		}
		KlasaArtikla pronadjenaKlasa = (KlasaArtikla) klase.get(0);
		return pronadjenaKlasa;
	}
	
	public static void izbrisi(Long id){
		openSession();
		Object instance = s.load(KlasaArtikla.class, new Long(id));
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
		
		return nadji(a.getId());
	}
	
	public static List<KlasaArtikla> lista(){
		openSession();
		
		List<KlasaArtikla> klasaArtikalatmp=s.createCriteria(KlasaArtikla.class).list();
		t.commit();
		return klasaArtikalatmp;
	}
	
	}



