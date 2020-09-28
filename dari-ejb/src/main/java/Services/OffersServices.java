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

import Entities.Requests;
import Enumerates.Governorateenum;
import Enumerates.Type;
import Enumerates.Typech;
import Interfaces.IOffersServices;
import Interfaces.IRequestsServices;

@Stateless
@LocalBean

public class OffersServices  implements IOffersServices{

	public ArrayList<Requests>  bestoffers(String role, String user,int budget,int area, Typech typechval,Type typeval,Governorateenum Governorateenumval,String delegationval) {
		  String endpoint = "http://192.168.1.111/Request/Index_WS?role="+role+"&user="+user;

		//  String endpoint = "http://localhost:10522/Request/Index_WS?role="+role+"&user="+user;
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
	              //  String UserId = ((JSONObject) responsearray.get(i)).getString("UserId");

	                
	                
	            	int a=0,b=0;
	            	if(typechval.toString().equals("Buy"))
	            	{
	            		a=0;
	            	}	if(typechval.toString().equals("Rent"))
	            	{
	            		a=1;
	            	}
	            	if(typeval.toString().equals("S_0"))
	            	{
	            		b=0;
	            	}
	            	if(typeval.toString().equals("S_1"))
	            	{
	            		b=1;
	            	}
	            	if(typeval.toString().equals("S_2"))
	            	{
	            		b=2;
	            	}
	              	if(typeval.toString().equals("S_3"))
	            	{
	            		b=3;
	            	}
	              	if(typeval.toString().equals("S_4"))
	            	{
	            		b=4;
	            	}
	              	if(typeval.toString().equals("S_Plus"))
	            	{
	            		b=5;
	            	}
	              	if(typeval.toString().equals("Villa"))
	            	{
	            		b=6;
	            	}
	              	if(typeval.toString().equals("Fond_De_Commerce"))
	            	{
	            		b=7;
	            	}
	              	if(typeval.toString().equals("Terrain"))
	            	{
	            		b=8;
	            	}
	              	if(typeval.toString().equals("Local"))
	            	{
	            		b=9;
	            	}
	      
                	int Distance=0;

	                int min=budget-((budget*10)/100);
	                int max=budget+((budget*10)/100);
	                int per=0;
	                
	                if (a==TypeCh && b==Type && Governorateenumval.toString().equals(CountryIso3) && Budget>=min && Budget<=max )
	                {
	                	
	                		per=((Budget-budget)*100)/budget;
	                	
	                	
	                	
	                	if(delegationval.equals(RegionCode))
	                	
	                	{
	                		Distance=0;
	                	}
	                 	if((delegationval.equals("1111,zarzoun,za") && RegionCode.equals("1202,B Ville,BV")) || (RegionCode.equals("1111,zarzoun,za") && delegationval.equals("1202,B Ville,BV"))    )
		                	
	                	{
	                		Distance=15;
	                	}
	                	
	                 	if((delegationval.equals("2222,Megrine,MG") && RegionCode.equals("5555,Rades,RD")) || (RegionCode.equals("2222,Megrine,MG") && delegationval.equals("5555,Rades,RD"))    )
		                	
	                	{
	                		Distance=20;
	                	}
	                	
	                	
	                	
	                	
	                 	Requests c=  new Requests(RequestId, Budget, Phone, TypeCh, Type, Description, Area, Date, Title, CountryIso3, RegionCode,Distance,per);
	                 	  
	                 	requestlist.add(c);          	
	                }
	                



	            }
	            
		           } catch (IOException e) {
	    			//e.printStackTrace();
	    		}
	     return    requestlist;
	}
	
	
	
	
	
}
