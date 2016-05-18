package ba.unsa.etf.si.app.Inventura.Kontroleri;
import ba.unsa.etf.si.app.Inventura.GUI.LogInScreen;
import ba.unsa.etf.si.app.Inventura.Kontroleri.HibernateUtil;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.Inventura.Kontroleri.HibernateUtil;
import ba.unsa.etf.si.app.Inventura.Model.KlasaArtikla;
//import java.util.List;
import javassist.tools.rmi.ObjectNotFoundException;

public final class KlasaArtikalaKontroler {

	private static Transaction t;
	private static Session s;
	final static Logger logger = Logger.getLogger(LogInScreen.class);
	
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
	
	public KlasaArtikalaKontroler(){}
	
	
	public static Long dodaj(KlasaArtikla a){
		openSession();
		
		Long id= (Long) s.save(a);
		t.commit();
		
		closeSession();
		return id;	
	}
	
	public static KlasaArtikla nadji(Long id) throws Exception{
	    
	    openSession();
	    List<KlasaArtikla> klase = null;
	    try{ 
	      klase = s.createCriteria(KlasaArtikla.class).add(Restrictions.like("id", id)).list();
	    }
	    catch(Exception ex){
	    	logger.info(ex);
	    	return null;
	    }
	    if(klase.size() > 1) {
	      throw new Exception();
	    }
	    KlasaArtikla pronadjenaKlasa = (KlasaArtikla) klase.get(0);
	    return pronadjenaKlasa; 
	  }
	
	public static KlasaArtikla nadjiIme(String naziv) throws Exception
	{
		openSession();
		List<Object> klase = s.createCriteria(KlasaArtikla.class).add(Restrictions.like("naziv", naziv)).list();
		if(klase.size()==0) {
			return null;
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
	
	public static KlasaArtikla izmijeni(KlasaArtikla a) throws Exception{
		openSession();
		
			s.merge(a);
			t.commit();
			closeSession();
					
		return nadji(a.getId());
	}
	
	public static List<KlasaArtikla> lista(){
		openSession();
		
		List<KlasaArtikla> klasaArtikalatmp=s.createCriteria(KlasaArtikla.class).list();
		t.commit();
		return klasaArtikalatmp;
	}
	
	}



