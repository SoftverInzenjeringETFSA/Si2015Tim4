package ba.unsa.etf.si.app.Inventura.Kontroleri;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.Inventura.Model.Artikal;
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

	
	public static Izvjestaj nadji(Long id) throws Exception{
		openSession();
		List<Object> izvjestaji = s.createCriteria(Izvjestaj.class).add(Restrictions.like("id", id)).list();
		if(izvjestaji.size() != 1) {
			throw new Exception();
		}
		Izvjestaj pronadjeniIzvjestaj = (Izvjestaj) izvjestaji.get(0);
		return pronadjeniIzvjestaj;
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
		closeSession();
		return listaIzvjestaja;
	}
	
}
