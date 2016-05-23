package ba.unsa.etf.si.app.Inventura.Kontroleri;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ba.unsa.etf.si.app.Inventura.GUI.LogInScreen;




 
public class HibernateUtil {
    public static final SessionFactory sessionFactory=buildSessionFactory();
    private static final Logger logger = Logger.getLogger(LogInScreen.class);
    private static SessionFactory buildSessionFactory(){
             try { 
            	 java.util.Properties properties = new Properties();
            	 properties.load(new FileInputStream("db.properties"));
            	 return new Configuration().addProperties(properties).configure().buildSessionFactory();
             }
 
            catch (Exception ex) {
                logger.info(ex);
                throw new ExceptionInInitializerError(ex);
            }
    }
        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
}