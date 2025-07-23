package tw.brad.north;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import tw.brad.entity.Employee;

public class Brad02 {

	public static void main(String[] args) {
		try {
			Class<?> cla =  Class.forName("tw.brad.north.Brad021");
			//Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			Object obj = cla.getDeclaredConstructor().newInstance();
			
			Method[] ms = cla.getMethods();
			for (Method mm : ms) {
				System.out.println(mm.getName()); 
			}
			
			Method method1 = cla.getMethod("m1");
			method1.invoke(obj);
			
			Field field = cla.getDeclaredField("a");
			field.setAccessible(true);
			field.set(obj, 100);
			
			method1.invoke(obj);
			System.out.println("----");
			
			Employee e = createObject(Employee.class);
			e.setTitle("brad");
			System.out.println(e.getTitle());
			
			Brad021 bb = createObject(Brad021.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static <T> T createObject(Class<T> cla) throws Exception {
		return cla.getDeclaredConstructor().newInstance(); 
	}
	static Employee setEmployee(Employee e, String sql) {
		
		return e;
	}

}

class Brad021 {
	private int a;
	public void m1() {
		a++;
		System.out.println("Brad021:m1():" + a);
	}
	private void m2() {
		System.out.println("Brad021:m2()");
	}
}
