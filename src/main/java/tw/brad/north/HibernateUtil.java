package tw.brad.north;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tw.brad.entity.Customer;
import tw.brad.entity.Employee;
import tw.brad.entity.MyTest;
import tw.brad.entity.Order;
import tw.brad.entity.OrderDetail;
import tw.brad.entity.Product;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			
			config.addAnnotatedClass(Employee.class);
			config.addAnnotatedClass(MyTest.class);
			config.addAnnotatedClass(Customer.class);
			config.addAnnotatedClass(Employee.class);
			config.addAnnotatedClass(Order.class);
			config.addAnnotatedClass(OrderDetail.class);
			config.addAnnotatedClass(Product.class);
			
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;
	}
}
