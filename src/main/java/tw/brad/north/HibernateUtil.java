package tw.brad.north;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tw.brad.entity.Employee;
import tw.brad.entity.MyTest;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			
			config.addAnnotatedClass(Employee.class);
			config.addAnnotatedClass(MyTest.class);
			
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;
	}
}
