package ba.unsa.etf.si.app.Inventura.Kontroleri;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.Inventura.Model.Izvjestaj;

public class IzvjestajKontroler {
	
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
	
	private IzvjestajKontroler(){}
	
	
	public static Long dodaj(Izvjestaj i ){
		openSession();
		
		Long id= (Long) s.save(i);
		t.commit();
		
		closeSession();
		return id;	
	}

	
	public static Izvjestaj nadji(Long id){
		openSession();
		Izvjestaj i = (Izvjestaj) s.get(Izvjestaj.class,new Long(id));
		t.commit();
		
		closeSession();
		return i;
	}
	
	public static void izbrisi(Long id){
		openSession();
		Object instance = s.load(Izvjestaj.class, new Long(id));
		if (instance != null)
			s.delete(instance);
		
		t.commit();
		closeSession();
	}
	
	public static List<Izvjestaj> lista(){
		openSession();
		
		List<Izvjestaj> listaIzvjestaja=s.createCriteria(Izvjestaj.class).list();
		t.commit();
		return listaIzvjestaja;
	}
	
}
