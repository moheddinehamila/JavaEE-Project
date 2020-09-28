package Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import Entities.Requests;
import Interfaces.IRequestsServices;



@Stateless
@LocalBean

public class RequestsServices implements IRequestsServices{

	
	
	

	public ArrayList<Requests>  fon(String role, String user) {
		
		   String endpoint = "http://http://192.168.1.111//Request/Index_WS?role="+role+"&user="+user;

		//   String endpoint = "http://localhost:10522/Request/Index_WS?role="+role+"&user="+user;
		   ArrayList<Requests> requestlist = new ArrayList<Requests>();
		
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
	               
	                int RequestId = jo.getInt("RequestId");
	                int Budget = jo.getInt("Budget");
	                String Phone = jo.getString("Phone");
	                int TypeCh = jo.getInt("TypeCh");
	                int Type = jo.getInt("Type");
	                String Description = jo.getString("Description");
	                int Area = jo.getInt("Area");
	                String Date = jo.getString("Date");
	             
	                String Title = jo.getString("Title");
	                String CountryIso3 = jo.getString("CountryIso3");
	                String RegionCode = jo.getString("RegionCode");	
	                String UserId = ((JSONObject) responsearray.get(i)).getString("UserId");
	                
	    			System.out.println("RequestId : " + RequestId);
	    			System.out.println("\n Budget : " + Budget);
	    			System.out.println("\n Phone : " + Phone);
	    			System.out.println("\n TypeCh : " + TypeCh);

	    			System.out.println("\n Type : " + Type);

	    			System.out.println("\n Description : " + Description);
	    			System.out.println("\n Area : " + Area);
	    			System.out.println("\n Date : " + Date);
	    	
	    			System.out.println("\n Title : " + Title);
	    			System.out.println("\n CountryIso3 : " + CountryIso3);
	    			System.out.println("\n RegionCode : " + RegionCode);

Requests c=	         new Requests(RequestId, Budget, Phone, TypeCh, Type, Description, Area, Date, Title, CountryIso3, RegionCode,UserId);
   
requestlist.add(c);
	            }
	            
		           } catch (IOException e) {
	    			//e.printStackTrace();
	    		}
	     return    requestlist;

		
		
		}
	
	
	////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	public void  deleteservice(int idd) {
		
		   String endpoint = "http://192.168.1.111/Request/Delete_Request_WS?id="+idd;

		//   String endpoint = "http://localhost:10522/Request/Delete_Request_WS?id="+idd;
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		
		try {
			HttpResponse response = client.execute(request);
			
	            }
	            
		            catch (IOException e) {
	    			//e.printStackTrace();
	    		}
	   

		
		
		}
	
	////////////////////////////////////////////////////////////////////////////
	
	
	public void  createservice(String UserId,int Budget, String Phone, int TypeCh, int Type, String Description, int Area, String Title, String SelectedCountryIso3,String SelectedRegionCode)
			{
		   String endpoint = "http://192.168.1.111/Request/Create_Request_WS?userid="+UserId+"&Budget="+Budget+"&Phone="+Phone+"&TypeCh="+TypeCh+"&Type="+Type+"&Description="+Description+"&Area="+Area+"&Title="+Title+"&SelectedCountryIso3="+SelectedCountryIso3+"&SelectedRegionCode="+SelectedRegionCode;

		
		//   String endpoint = "http://localhost:10522/Request/Create_Request_WS?userid="+UserId+"&Budget="+Budget+"&Phone="+Phone+"&TypeCh="+TypeCh+"&Type="+Type+"&Description="+Description+"&Area="+Area+"&Title="+Title+"&SelectedCountryIso3="+SelectedCountryIso3+"&SelectedRegionCode="+SelectedRegionCode;
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		
		try {
			HttpResponse response = client.execute(request);
			
	            }
	            
		            catch (IOException e) {
	    			//e.printStackTrace();
	    		}
	   

		
		
		}
	
	/////////////////////////////////////////////////////////////////////
	public void  editservice(int id,int Budget, String Phone, int TypeCh, int Type, String Description, int Area, String Title)
	{

		   String endpoint = "http://192.168.1.111/Request/Edit_Request_WS?id="+id+"&Budget="+Budget+"&Phone="+Phone+"&TypeCh="+TypeCh+"&Type="+Type+"&Description="+Description+"&Area="+Area+"&Title="+Title;

  // String endpoint = "http://localhost:10522/Request/Edit_Request_WS?id="+id+"&Budget="+Budget+"&Phone="+Phone+"&TypeCh="+TypeCh+"&Type="+Type+"&Description="+Description+"&Area="+Area+"&Title="+Title;

HttpClient client = new DefaultHttpClient();
HttpGet request = new HttpGet(endpoint);

try {
	HttpResponse response = client.execute(request);
	
        }
        
            catch (IOException e) {
			//e.printStackTrace();
		}




}
	
	////////////////////////////////////////////////////////////////////////////////
	
	
	
	public ArrayList<Requests>  search(String searchstring, String aa, int min, int max,String role, String user) {
		
		   String endpoint = "http://192.168.1.111/Request/Index_Request_WS?searchstring="+searchstring+"&aa="+aa+"&min="+min+"&max="+max+"&role="+role+"&user="+user;

		  // String endpoint = "http://localhost:10522/Request/Index_Request_WS?searchstring="+searchstring+"&aa="+aa+"&min="+min+"&max="+max+"&role="+role+"&user="+user;
		   ArrayList<Requests> requestlist = new ArrayList<Requests>();
		
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
	               
	                int RequestId = jo.getInt("RequestId");
	                int Budget = jo.getInt("Budget");
	                String Phone = jo.getString("Phone");
	                int TypeCh = jo.getInt("TypeCh");
	                int Type = jo.getInt("Type");
	                String Description = jo.getString("Description");
	                int Area = jo.getInt("Area");
	                String Date = jo.getString("Date");
	             
	                String Title = jo.getString("Title");
	                String CountryIso3 = jo.getString("CountryIso3");
	                String RegionCode = jo.getString("RegionCode");
	                String UserId = ((JSONObject) responsearray.get(i)).getString("UserId");
	                
	                
	    			System.out.println("RequestId : " + RequestId);
	    			System.out.println("\n Budget : " + Budget);
	    			System.out.println("\n Phone : " + Phone);
	    			System.out.println("\n TypeCh : " + TypeCh);

	    			System.out.println("\n Type : " + Type);

	    			System.out.println("\n Description : " + Description);
	    			System.out.println("\n Area : " + Area);
	    			System.out.println("\n Date : " + Date);
	    	
	    			System.out.println("\n Title : " + Title);
	    			System.out.println("\n CountryIso3 : " + CountryIso3);
	    			System.out.println("\n RegionCode : " + RegionCode);

Requests c=	         new Requests(RequestId, Budget, Phone, TypeCh, Type, Description, Area, Date, Title, CountryIso3, RegionCode,UserId);

requestlist.add(c);
	            }
	            
		           } catch (IOException e) {
	    			//e.printStackTrace();
	    		}
	     return    requestlist;

		
		
		}
	
	////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
