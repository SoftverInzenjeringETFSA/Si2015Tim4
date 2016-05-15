package ba.unsa.etf.si.app.Inventura.Kontroleri;
import ba.unsa.etf.si.app.Inventura.Kontroleri.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
import ba.unsa.etf.si.app.Inventura.GUI.LogInScreen;
 
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(LogInScreen.class);
    static{
             try {  
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
 
            catch (Exception ex) {
                // logger.info(ex);
                throw new ExceptionInInitializerError(ex);
            }
    }
        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
}