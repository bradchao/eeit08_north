package tw.brad.north;

import java.util.List;

import org.hibernate.Session;

import tw.brad.entity.Employee;

public class Brad05 {

	public static void main(String[] args) {
		String hql = """
				SELECT e.employeeId, e.title, e.lastName, e.firstName
				FROM Employee e 
				ORDER BY e.title ASC, e.lastName DESC
				""";
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			List<Object[]> employees = 
					session.createQuery(hql, Object[].class).getResultList();
			for (Object[] employee : employees) {
				Object obj = employee[0];
				if (obj instanceof Integer) {
					System.out.println("OK");
				}
				
				
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
