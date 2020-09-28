package Services;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import Entities.RendezVous;


@Stateless
@LocalBean
public class RendezVousServiceAWS  {

	public static final String endpoint = "http://192.168.1.77/RendezVous/GetCalendarData";
	
	
	
	public String GetAll() throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		String id = null;
		try {
		
			HttpResponse response = client.execute(request);
			String jsonResponse = EntityUtils.toString(response.getEntity());
			System.out.println(jsonResponse);
			int i = jsonResponse.indexOf("{");
			jsonResponse = jsonResponse.substring(i);
			
			JSONObject responseObj = new JSONObject(jsonResponse);
			
			id = responseObj.getString("description");
	} catch (IOException e) {
		e.printStackTrace();
	}
			return String.valueOf(id);	
		

	}
	
	
	//List<RendezVous> participantJsonList = mapper.readValue(jsonString, new TypeReference<List<RendezVous>>(){});
	
	
	public List<RendezVous> Myrdv(){
		
		
		
		return null;
		
	}
	


	public RendezVous Getbyid(int rdvid) {
		// TODO Auto-generated method stub
		return null;
	}

}
