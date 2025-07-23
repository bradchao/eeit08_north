package tw.brad.north;

import java.util.List;

import org.hibernate.Session;

import tw.brad.entity.Employee;

public class Brad04 {

	public static void main(String[] args) {
		String hql = """
				SELECT e.employeeId, e.title, e.lastName, e.firstName
				FROM Employee e 
				ORDER BY e.title ASC, e.lastName DESC
				""";
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			List<Employee> employees = 
					session.createQuery(hql, Employee.class).getResultList();
			for (Employee employee : employees) {
				System.out.printf("%d. %s : %s %s\n",
						employee.getEmployeeId(),
						employee.getTitle(),
						employee.getLastName(),
						employee.getFirstName());
			}			
		}catch(Exception e) {
			System.out.println(e);
		}		

	}

}
