package ba.unsa.etf.si.app.Inventura.Kontroleri;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.Inventura.Kontroleri.HibernateUtil;
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
	
	public static Inventura nadjiBarKod(String naziv) throws Exception
	{
		openSession();
		List<Object> inventure = s.createCriteria(Inventura.class).add(Restrictions.like("naziv", naziv)).list();
		if(inventure.size() > 1) {
			throw new Exception();
		}
		Inventura pronadjenaInventura = (Inventura) inventure.get(0);
		return pronadjenaInventura;
	}
	
	public static Inventura nadji(String naziv){
		openSession();
		Inventura a = (Inventura) s.get(Inventura.class,new String(naziv));
		t.commit();
		
		closeSession();
		return a;
	}
	
	public static void izbrisi(String naziv){
		openSession();
		Object instance = s.load(Inventura.class, new String(naziv));
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





