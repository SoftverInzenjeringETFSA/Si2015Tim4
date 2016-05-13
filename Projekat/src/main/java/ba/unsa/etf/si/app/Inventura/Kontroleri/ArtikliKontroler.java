package ba.unsa.etf.si.app.Inventura.Kontroleri;

import java.util.List;

//import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.Inventura.Model.Artikal;


public final class ArtikliKontroler{
		
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
	
	private ArtikliKontroler(){}
	
		public static Long dodaj(Artikal a){
			openSession();
			
			Long id= (Long) s.save(a);
			t.commit();
			
			closeSession();
			return id;	
		}
		
		public static Artikal nadji(String naziv) throws Exception{
			openSession();
			List<Object> artikli = s.createCriteria(Artikal.class).add(Restrictions.like("naziv", naziv)).list();
			if(artikli.size() > 1) {
				throw new Exception();
			}
			Artikal pronadjeniArtikal = (Artikal) artikli.get(0);
			return pronadjeniArtikal;
		}
	
		public static Artikal nadjiId(Long id) throws Exception
		{
			openSession();
			List<Object> artikli = s.createCriteria(Artikal.class).add(Restrictions.like("id", id)).list();
			if(artikli.size() > 1) {
				throw new Exception();
			}
			Artikal pronadjeniArtikal = (Artikal) artikli.get(0);
			return pronadjeniArtikal;
		}
		
		public static Artikal nadjiBarKod(String barkod) throws Exception
		{
			openSession();
			List<Object> artikli = s.createCriteria(Artikal.class).add(Restrictions.like("barkod", barkod)).list();
			if(artikli.size() > 1) {
				throw new Exception();
			}
			Artikal pronadjeniArtikal = (Artikal) artikli.get(0);
			return pronadjeniArtikal;
		}
		
		public static void izbrisi(long l){
			openSession();
			Object instance = s.load(Artikal.class, new Long(l));
			if (instance != null)
				s.delete(instance);
			
			t.commit();
			closeSession();
		}
		
		public static Artikal izmijeni(Artikal a) throws Exception{
			openSession();
			
				s.merge(a);
				t.commit();
				closeSession();
				
			String naziv=a.getNaziv();
			
			return nadjiId(a.getId());
		}
		
		public static List<Artikal> lista(){
			openSession();
			List<Artikal> artikaltmp=s.createCriteria(Artikal.class).list();
			t.commit();
			return artikaltmp;
		}
		
	

}
