package tw.brad.north;

import org.hibernate.Session;

public class Brad01 {
	public static void main(String[] args) {
		String sl = """
				SELECT * FROM employees ORDER BY Title ASC, LastName DESC
				""";
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}
}
