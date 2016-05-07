
package ba.unsa.etf.si.app.Inventura.Kontroleri;


import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.Inventura.Model.Izvjestaj;

public class Main {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Izvjestaj i = new Izvjestaj();
		Transaction t = session.beginTransaction();
		session.save(i);
		t.commit();

	}

}
