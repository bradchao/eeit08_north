package tw.brad.north;

import java.util.List;

import org.hibernate.Session;

public class Brad11 {
	/*
	 * SELECT ......
	 * FROM order o
	 * JOIN employees e ON e.EmployeeID = o.EmployeeID
	 * JOIN customers c ON c.CustomerID = o.CustomerID
	 * JOIN orderdetails od ON o.OrderID = od.OrderID
	 * JOIN products p ON od.ProductID = p.ProductID 
	 */
	public static void main(String[] args) {
		String hql = """
				 SELECT 
				 	o.employee.lastName,
				 	o.customer.companyName,
				 	p.productName,
				 	d.unitPrice,
				 	d.quantity 
				 FROM Order o
				 JOIN o.orderDetails d
				 JOIN d.product p
				 WHERE o.orderId = :orderId
				""";
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			List<Object[]> result = session.createQuery(hql, Object[].class)
					.setParameter("orderId", 10248)
					.getResultList();
			
			for (Object[] row : result) {
				System.out.println("Employee:" + row[0]);
				System.out.println("Company:" + row[1]);
				System.out.println("Product:" + row[2] + ":" + row[3] + ":" + row[4]);
				System.out.println("------------");
			}
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
