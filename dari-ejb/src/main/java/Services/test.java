package Services;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import Entities.Appointment;
import Entities.Counselor;
import Entities.User;

public class test {

	public static void main(String[] args) throws IOException, IOException {

		
		
	
		
		 String endpoint = "http://localhost:7448/api/appointements?id=10c3719d-60c1-471f-b453-91d66b8696f8";
		   ArrayList<Appointment> requestlist = new ArrayList<Appointment>();
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		
	
			HttpResponse response = client.execute(request);
			String jsonResponse = EntityUtils.toString(response.getEntity());
			System.out.println("Response as String : " + jsonResponse);
			
				
			JSONArray responsearray = new JSONArray(jsonResponse);
			  int n = responsearray.length();
	            for (int i = 0; i < n; i++) {
	                // GET INDIVIDUAL JSON OBJECT FROM JSON ARRAY
	                JSONObject jo = responsearray.getJSONObject(i);

	                // RETRIEVE EACH JSON OBJECT'S FIELDS
	               
	                int Id = jo.getInt("appId");
	                String CounselorId = jo.getString("CounselorId");
	                String userId = jo.getString("userId");
	                String CounselorEmail = jo.getString("CounselorEmail");
	                String cf = jo.getString("Cf");
	                String cl = jo.getString("cl");
	                String cp = jo.getString("cp");
	                String date = jo.getString("date");
	                String avai = jo.getString("avai");
	                String Confirm = jo.getString("Confirm");
	              
	               
	    			System.out.println("Id : " + Id);
	    			System.out.println("\n UserId : " + userId);
	    			System.out.println("\n CounselorId : " + CounselorId);
	    			

	    			System.out.println("\n CounselorEmail : " + CounselorEmail);

	    			System.out.println("\n date : " + date);
	    			System.out.println("\n Email : " + CounselorEmail);
	    			System.out.println("\n avai : " + avai);
	    			System.out.println("\n Confirm : " + Confirm);
	    			


	

		}
	}
}
		
	

