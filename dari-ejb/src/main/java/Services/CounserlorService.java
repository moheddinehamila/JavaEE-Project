package Services;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import Entities.Counselor;
import Interfaces.ICounselorService;

@Stateless
@LocalBean
public class CounserlorService implements ICounselorService {
	
	
	
	public ArrayList<Counselor>  fon() {
		
		
		   String endpoint = "http://192.168.1.111/api/counselors";
		   ArrayList<Counselor> requestlist = new ArrayList<Counselor>();
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		
		try {
			HttpResponse response = client.execute(request);
			String jsonResponse = EntityUtils.toString(response.getEntity());
			System.out.println("Response as String : " + jsonResponse);
			
				
			JSONArray responsearray = new JSONArray(jsonResponse);
			  int n = responsearray.length();
	            for (int i = 0; i < n; i++) {
	                // GET INDIVIDUAL JSON OBJECT FROM JSON ARRAY
	                JSONObject jo = responsearray.getJSONObject(i);

	                // RETRIEVE EACH JSON OBJECT'S FIELDS
	               
	                int Id = jo.getInt("Id");
	                String UserId = jo.getString("userId");
	                String phoneNumber = jo.getString("PhoneNumber");
	                String cin = jo.getString("cin");
	                String firstName = jo.getString("FirstName");
	                String lastName = jo.getString("LastName");
	                String email = jo.getString("Email");
	                String country = jo.getString("Country");
	                String address = jo.getString("address");
	                String City = jo.getString("City");


	             
	                String image = jo.getString("image");
	            
	               
	    			System.out.println("Id : " + Id);
	    			System.out.println("\n UserId : " + UserId);
	    			System.out.println("\n PhoneNumber : " + phoneNumber);
	    			System.out.println("\n cin : " + cin);

	    			System.out.println("\n FirstName : " + firstName);

	    			System.out.println("\n LastName : " + lastName);
	    			System.out.println("\n Email : " + email);
	    			System.out.println("\n Country : " + country);
	    	
	    			System.out.println("\n image : " + image);
	    		
Counselor 			c=	 new Counselor(Id, cin, address, City, country, image, firstName, lastName, email, phoneNumber,UserId);

requestlist.add(c);

	            }
	            
		           } catch (IOException e) {
	    			//e.printStackTrace();
	    		}
	     return    requestlist;

		
		
		}

}
