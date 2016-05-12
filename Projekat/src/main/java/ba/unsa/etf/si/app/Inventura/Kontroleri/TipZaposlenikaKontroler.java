package ba.unsa.etf.si.app.Inventura.Kontroleri;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.Inventura.Model.Artikal;
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
		
	public static Long dodaj(TipZaposlenika a){
		openSession();
		
		Long id= (Long) s.save(a);
		t.commit();
		
		closeSession();
		return id;	
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
		public static TipZaposlenika nadjiID(long id){
			openSession();
			TipZaposlenika tip = (TipZaposlenika) s.get(TipZaposlenika.class, new Long (id));
			t.commit();
			
			closeSession();
			return tip;
		}
		
		public static TipZaposlenika nadjiIme(String ime) throws Exception
		{
			openSession();
			List<Object> temp = s.createCriteria(TipZaposlenika.class).add(Restrictions.like("ime", ime)).list();
			if(temp.size() > 1) {
				throw new Exception();
			}
			TipZaposlenika pronadjeniTip = (TipZaposlenika) temp.get(0);
			return pronadjeniTip;
		}
		
		public static TipZaposlenika nadjiKorisnickoIme(String korisnickoIme) throws Exception
		{
			openSession();
			List<Object> temp = s.createCriteria(TipZaposlenika.class).add(Restrictions.like("korisnickoIme", korisnickoIme)).list();
			if(temp.size() > 1) {
				throw new Exception();
			}
			else if(temp.size()==0){
				return null;
			}
			TipZaposlenika pronadjeniKorisnik = (TipZaposlenika) temp.get(0);
			return pronadjeniKorisnik;
		}
		
		public static TipZaposlenika nadjiId(Long id) throws Exception
		{
			openSession();
			List<Object> zaposlenici = s.createCriteria(TipZaposlenika.class).add(Restrictions.like("id", id)).list();
			if(zaposlenici.size() != 1) {
				throw new Exception();
			}
			TipZaposlenika tipZ = (TipZaposlenika) zaposlenici.get(0);
			return tipZ;
		}
		
		//brise korisnika po ID/u
		public static void izbrisi(long id){
			openSession();
			Object instance = s.load(TipZaposlenika.class, new Long (id));
			if (instance != null)
				s.delete(instance);
			
			t.commit();
			closeSession();
		}
		
		public void brisiJmbg(String jmbg) throws Exception
		{
			openSession();
			Object instance= s.createCriteria(TipZaposlenika.class).add(Restrictions.like("jmbg", jmbg)).list();
			if (instance != null)
				s.delete(instance);
			
			t.commit();
			closeSession();
		}
		
		
		// modifikacija zaposlenika 
		public static TipZaposlenika izmjeni(TipZaposlenika tip) throws Exception{
			openSession();
			
				s.merge(tip);
				t.commit();
			closeSession();
				System.out.print("ne merga");
			return nadjiId(tip.getId());
		}
		
		
		
		public static List<TipZaposlenika> lista(){
			openSession();
			
			List<TipZaposlenika> tipTemp=s.createCriteria(TipZaposlenika.class).list();
			t.commit();
			
			closeSession();
			
			return tipTemp;
		}
			
	}
	

