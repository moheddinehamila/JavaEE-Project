package Services;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import Entities.Appointment;
import Entities.Counselor;
import Entities.Furniture;
import Interfaces.IAppointmentService;

@LocalBean
@Stateless
public class AppointmentService implements IAppointmentService {

	
	public String AddApp(String CounselorId,String cf,String cl,String CounselorEmail,String cp, String date)  {
		String Res ="";
		try {
		URL obj = new URL("http://localhost:7448/api/Appointements");
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    con.setDoOutput(true);
	    con.setDoInput(true);
	    con.setRequestMethod("POST");
	    con.setRequestProperty("Content-Type", "application/json");

	    String jsonString = new JSONObject()
				.put("CounselorId",CounselorId )
				.put("userId","0" )
				.put("CounselorEmail",CounselorEmail)
				.put("cf",cf )
				.put("cl",cl )
				.put("cp",cp )
				.put("date",date.toString())
				.put("avai","1")
				.put("Confirm","0")
			
				.toString();

		System.out.println(jsonString);

	    OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
	    wr.write(jsonString);
	    wr.flush();
	   
	    int httpResult = con.getResponseCode();
	  if (httpResult == 200) {
		  Res="Success";
		  return Res ;
	  }
		}catch (Exception e) {
			// TODO: handle exception
		}
	    
		return null;
	}
	public ArrayList<Appointment>  GetAll() {
		
		
		   String endpoint = "http://192.168.1.111/api/appointements";
		   ArrayList<Appointment> requestlist = new ArrayList<Appointment>();
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
	    		
Appointment 			d=	 new Appointment(Id, CounselorId, userId, cf, cl, cp, CounselorEmail, date, avai, Confirm);

requestlist.add(d);

	            }
	            
		           } catch (IOException e) {
	    			
	    		}
	     return    requestlist;

		
		
		}
	
	public  ArrayList<Appointment> Getbyid(String id) {
		  ArrayList<Appointment> applist = new ArrayList<Appointment>();
		Appointment f = new Appointment();

		for (Appointment lf : GetAll()) {
			if (lf.getCounselorId() == id && lf.getAvai()=="1") {
				
				f=	 new Appointment(lf.getDate());

				applist.add(f);
				
			}
				
		}
		return applist;
	}
	public String TakeApp(int id, String userId,String avai)  {
		String Res ="";
		try {
		URL obj = new URL("http://192.168.1.111/api/appointements?id="+id);
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    con.setDoOutput(true);
	    con.setDoInput(true);
	    con.setRequestMethod("PUT");
	    con.setRequestProperty("Content-Type", "application/json");

	    String jsonString = new JSONObject()
	    		.put("appId",id )
				.put("userId",userId)
				.put("avai","0" )
			
				.toString();

		System.out.println(jsonString);

	    OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
	    wr.write(jsonString);
	    wr.flush();
	   
	    int httpResult = con.getResponseCode();
	  if (httpResult == 200) {
		  Res="Success";
		  return Res ;
	  }
		}catch (Exception e) {
			// TODO: handle exception
		}
	    
		return null;
			
			
		}
	public ArrayList<Appointment>  GetAllById(String id) {
		
		
		   String endpoint = "http://192.168.1.111/api/appointements?id="+id;
		   ArrayList<Appointment> requestlist = new ArrayList<Appointment>();
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		
		try {
			HttpResponse response = client.execute(request);
			String jsonResponse = EntityUtils.toString(response.getEntity());
			System.out.println("Response at : " + jsonResponse);
			
				
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
	    		
Appointment 			d=	 new Appointment(Id,CounselorId,userId,CounselorEmail,cf,cl,cp,date);

requestlist.add(d);

	            }
	            
		           } catch (IOException e) {
	    			
	    		}
	     return    requestlist;

		
		
		}
	
}
