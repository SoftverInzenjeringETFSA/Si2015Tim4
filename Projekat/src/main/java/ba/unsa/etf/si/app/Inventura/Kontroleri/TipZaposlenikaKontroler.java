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
	
	
	public TipZaposlenikaKontroler(){}
		
		public void dodaj(TipZaposlenika tipz){
			openSession();
			//dodajZaposlenikaUBazu
			// OVAJ ID PROVJERITI long id= (long)s.save(tipz);
			t.commit();
			
			closeSession();
			//return id;	
		}
		
		// trazi po imenu i prezimenu korisnika
		public TipZaposlenika nadji(String ime, String prezime){
			openSession();
			TipZaposlenika tip = (TipZaposlenika) s.get(TipZaposlenika.class,new String(ime) + new String(prezime));
			t.commit();
			
			closeSession();
			return tip;
		}
		
		//trazi po id-u
		public TipZaposlenika nadjiID(long id){
			openSession();
			TipZaposlenika tip = (TipZaposlenika) s.get(TipZaposlenika.class, new Long (id));
			t.commit();
			
			closeSession();
			return tip;
		}
		
		//brise korisnika po ID/u
		public void izbrisi(long id){
			openSession();
			Object instance = s.load(TipZaposlenika.class, new Long (id));
			if (instance != null)
				s.delete(instance);
			
			t.commit();
			closeSession();
		}
		
		// modifikacija zaposlenika 
		public void izmjeni(TipZaposlenika stari, TipZaposlenika novi){
			openSession();
			//ovdje treba da nadje starog i zamjeni ga novim
			//	s.merge(a);
			//	t.commit();
				closeSession();
				
			//String ime = a.getIme();	
			//String prezime= a.getPrezime();
			//return nadji(ime,prezime);
		}
		
		public static List<TipZaposlenika> lista(){
			openSession();
			
			List<TipZaposlenika> tipTemp=s.createCriteria(TipZaposlenika.class).list();
			t.commit();
			return tipTemp;
		}
		
	}
	

