package Services;

import java.io.StringReader; 
import java.util.ArrayList; 
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader; 
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder; 
import javax.ws.rs.client.WebTarget; 
import javax.ws.rs.core.Response;

import Entities.Voted;
import Interfaces.IVotedServiceLocal;
import Interfaces.IVotedServiceRemote; 

@Stateful
@LocalBean
public class VotedService implements IVotedServiceRemote,IVotedServiceLocal{

	@Override
	public List<Voted> GetAll() {
		List<Voted> vList = new ArrayList<Voted>();
		Client client = ClientBuilder.newClient(); 
		WebTarget web = client.target("http://192.168.1.111//Furniture_JEE/Api_voted");

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {
			Voted v = new Voted();

			v.setVotedId(object.getJsonObject(i).getInt("VotedId"));
			v.setUserId(object.getJsonObject(i).getString("UserId"));
			v.setNote(object.getJsonObject(i).getInt("note"));
			v.setFurnitureId(object.getJsonObject(i).getInt("FurnitureId"));
			vList.add(v);
		} 
		return vList;
	}
 boolean exist=false;
  @Override
	public boolean isvoted(int fid)
	{exist=false;
		for (Voted v : GetAll()) {
			if (v.getFurnitureId()==fid)
				exist=true;
		}
		return exist;
	}
@Override
public void addvote(int fid, int note) {

	Client client = ClientBuilder.newClient();

	WebTarget web = client.target("http://192.168.1.111/Furniture_JEE/rate?fid="+fid+"&note="+note);

	Response response = web.request().post(null);
	response.close();
	
	
	
}

  
   
  
}
