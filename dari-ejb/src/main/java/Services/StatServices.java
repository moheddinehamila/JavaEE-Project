package Services;

import java.io.IOException;
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

import Entities.AnnonceVente;
import Entities.Requests;
import Interfaces.IRequestsServices;
import Interfaces.IStatServices;

@Stateless
@LocalBean
public class StatServices  implements IStatServices{

	
	public ArrayList<AnnonceVente>  suggestion(String country) {
		
		   String endpoint = "http://192.168.1.111/Request/Suggestion_WS?ch="+country;

		  // String endpoint = "http://localhost:10522/Request/Suggestion_WS?ch="+country;
		   ArrayList<AnnonceVente> requestlist = new ArrayList<AnnonceVente>();
		
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
	               
	         
	                String Name = jo.getString("Name");
	                String Category = jo.getString("Category");

	             
	                
	    		

AnnonceVente c=	         new AnnonceVente(Name,Category);

requestlist.add(c);
	            }
	            
		           } catch (IOException e) {
	    			//e.printStackTrace();
	    		}
	     return    requestlist;

		
		
		}
	////////////////////////////////////////////////////////////////////////////////////////////
public int  stat_all() {
		
		int n=0;
		   String endpoint = "http://192.168.1.111/Request/Stat_all_WS";

		  // String endpoint = "http://localhost:10522/Request/Stat_all_WS";
		   ArrayList<AnnonceVente> requestlist = new ArrayList<AnnonceVente>();
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		
		try {
			HttpResponse response = client.execute(request);
			String jsonResponse = EntityUtils.toString(response.getEntity());
			System.out.println("Response as String : " + jsonResponse);
			
				
			JSONArray responsearray = new JSONArray(jsonResponse);
			   n = responsearray.length();
			     return    n;

	            
		           } catch (IOException e) {
	    			//e.printStackTrace();
	    		}
	     return    n;

		
		
		}
	////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public int  stat_country_all(String country) {
		
		int n=0;
		   String endpoint = "http://192.168.1.111/Request/Stat_country_all_WS?ch="+country;

		 //  String endpoint = "http://localhost:10522/Request/Stat_country_all_WS?ch="+country;
		   ArrayList<AnnonceVente> requestlist = new ArrayList<AnnonceVente>();
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		
		try {
			HttpResponse response = client.execute(request);
			String jsonResponse = EntityUtils.toString(response.getEntity());
			System.out.println("Response as String : " + jsonResponse);
			
				
			JSONArray responsearray = new JSONArray(jsonResponse);
			   n = responsearray.length();
			     return    n;

	            
		           } catch (IOException e) {
	    			//e.printStackTrace();
	    		}
	     return    n;

		
		
		}
	//////////////////////////////////////////////////////////////////////////////////////////////
public int  stat_typech_all(String country) {
		
		int n=0;
		   String endpoint = "http://192.168.1.111/Request/Stat_typech_all_WS?ch="+country;

		   //String endpoint = "http://localhost:10522/Request/Stat_typech_all_WS?ch="+country;
		   ArrayList<AnnonceVente> requestlist = new ArrayList<AnnonceVente>();
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		
		try {
			HttpResponse response = client.execute(request);
			String jsonResponse = EntityUtils.toString(response.getEntity());
			System.out.println("Response as String : " + jsonResponse);
			
				
			JSONArray responsearray = new JSONArray(jsonResponse);
			   n = responsearray.length();
			     return    n;

	            
		           } catch (IOException e) {
	    			//e.printStackTrace();
	    		}
	     return    n;

		
		
		}

///////////////////////////////////////////////////////////////
public int  stat_user(String usr) {
	
	int n=0;
	   String endpoint = "http://192.168.1.111/Request/Stat_user_WS?usr="+usr;

	//   String endpoint = "http://localhost:10522/Request/Stat_user_WS?usr="+usr;
	   ArrayList<AnnonceVente> requestlist = new ArrayList<AnnonceVente>();
	
	HttpClient client = new DefaultHttpClient();
	HttpGet request = new HttpGet(endpoint);
	
	try {
		HttpResponse response = client.execute(request);
		String jsonResponse = EntityUtils.toString(response.getEntity());
		System.out.println("Response as String : " + jsonResponse);
		
			
		JSONArray responsearray = new JSONArray(jsonResponse);
		   n = responsearray.length();
		     return    n;

            
	           } catch (IOException e) {
    			//e.printStackTrace();
    		}
     return    n;

	
	
	}
	
	//////////////////////////////////////////////////////////////////
public int  stat_country_user(String ch, String usr) {
	
	int n=0;
	   String endpoint = "http://192.168.1.111/Request/Stat_country_user_WS?ch="+ch+"&usr="+usr;

	  // String endpoint = "http://localhost:10522/Request/Stat_country_user_WS?ch="+ch+"&usr="+usr;
	   ArrayList<AnnonceVente> requestlist = new ArrayList<AnnonceVente>();
	
	HttpClient client = new DefaultHttpClient();
	HttpGet request = new HttpGet(endpoint);
	
	try {
		HttpResponse response = client.execute(request);
		String jsonResponse = EntityUtils.toString(response.getEntity());
		System.out.println("Response as String : " + jsonResponse);
		
			
		JSONArray responsearray = new JSONArray(jsonResponse);
		   n = responsearray.length();
		     return    n;

            
	           } catch (IOException e) {
    			//e.printStackTrace();
    		}
     return    n;

	
	
	}
	
	//////////////////////////////////////////////////////////////
public int  stat_typech_user(String ch, String usr) {
	
	int n=0;
	   String endpoint = "http://192.168.1.111/Request/Stat_typech_user_WS?ch="+ch+"&usr="+usr;

	  // String endpoint = "http://localhost:10522/Request/Stat_typech_user_WS?ch="+ch+"&usr="+usr;
	   ArrayList<AnnonceVente> requestlist = new ArrayList<AnnonceVente>();
	
	HttpClient client = new DefaultHttpClient();
	HttpGet request = new HttpGet(endpoint);
	
	try {
		HttpResponse response = client.execute(request);
		String jsonResponse = EntityUtils.toString(response.getEntity());
		System.out.println("Response as String : " + jsonResponse);
		
			
		JSONArray responsearray = new JSONArray(jsonResponse);
		   n = responsearray.length();
		     return    n;

            
	           } catch (IOException e) {
    			//e.printStackTrace();
    		}
     return    n;

	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
