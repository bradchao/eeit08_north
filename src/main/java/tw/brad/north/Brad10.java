package tw.brad.north;

import com.fasterxml.jackson.databind.ObjectMapper;

import tw.brad.entity.Phone;
import tw.brad.entity.User;

public class Brad10 {

	public static void main(String[] args) {
		String json = """
					{
						"name" : "Brad",
						"age": 18,
						"address": {
							"city": "台中市",
							"town": "南屯區",
							"addr": "公益路100號"
						},
						"phones": [
							{
								"type": "CHT",
								"number": "0912-123456"
							},
							{
								"type": "ABC",
								"number": "0912-765432"
							}
						]
					}				
				""";
		ObjectMapper mapper = new ObjectMapper();
		try {
			User user = mapper.readValue(json, User.class);
			System.out.println(user.getName());
			System.out.println(user.getAddress().getCity());
			for (Phone phone: user.getPhones()) {
				System.out.println(phone.getNumber());
			}
			//----------------------
			String json2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
			System.out.println(json2);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
