package tw.brad.north;

import java.util.List;

import org.hibernate.Session;

import tw.brad.entity.Employee;
import tw.brad.entity.MyTest;

public class Brad06 {

	public static void main(String[] args) {
		// Criteria
		String hql = """
				SELECT m.id, m.fname
				FROM MyTest m 
				""";
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			List<MyTest> employees = 
					session.createQuery(hql, MyTest.class).getResultList();
			for (MyTest employee : employees) {
				System.out.printf("%d. %s\n",
						employee.getId(),
						employee.getFname());
			}			
		}catch(Exception e) {
			System.out.println(e);
		}		

	}

}
