package tw.brad.north;

import java.util.List;

import org.hibernate.Session;

import tw.brad.entity.Employee;

public class Brad03 {
	public static void main(String[] args) {
		String sql = """
				SELECT * FROM employees 
				ORDER BY Title ASC, LastName DESC
				""";
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			List<Object[]> employees = 
				session.createNativeQuery(sql, Object[].class).getResultList();
			for (Object[] employee : employees) {
				System.out.printf("%d. %s : %s %s\n",
						employee[0],
						employee[1],
						employee[2],
						employee[3]);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}		
	}
}
