package ba.unsa.etf.si.app.Inventura.Kontroleri;
import ba.unsa.etf.si.app.Inventura.Kontroleri.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ba.unsa.etf.si.app.Inventura.Model.Inventura;

public class InventuraKontroler {
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
	
	private InventuraKontroler(){}
	
	
	public static Long dodaj(Inventura i ){
		openSession();
		
		Long id= (Long) s.save(i);
		t.commit();
		
		closeSession();
		return id;	
	}
	
	
	public static Inventura nadji(Long id){
		openSession();
		Inventura a = (Inventura) s.get(Inventura.class,new Long(id));
		t.commit();
		
		//closeSession();
		return a;
	}
	
	public static void izbrisi(Long id){
		openSession();
		Object instance = s.load(Inventura.class, new Long(id));
		if (instance != null)
			s.delete(instance);
		
		t.commit();
		closeSession();
	}
	
	/*
	public static Inventura izmijeni(Inventura a){
		openSession();
		
			s.merge(a);
			t.commit();
			closeSession();
			
		String naziv = a.getNaziv();	
		
		return nadji(naziv);
	}*/
	
	public static List<Inventura> lista(){
		openSession();
		
		List<Inventura> listaInventura=s.createCriteria(Inventura.class).list();
		t.commit();
		return listaInventura;
	}
}





