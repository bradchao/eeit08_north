package tw.brad.north;

import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Brad09 {

	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap<>();
		person.put("name", "Brad");
		person.put("age", 18);
		person.put("gender", false);
		person.put("weight", 80.5);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(person);
			System.out.println(json);
			
			System.out.println("-----");
			
			HashMap<String, Object> brad;
			brad = mapper.readValue(json, 
					new TypeReference<HashMap<String, Object>>() {});
			
			System.out.println(brad.get("name"));
			System.out.println(brad.get("age"));
			System.out.println(brad.get("gender"));
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

}
