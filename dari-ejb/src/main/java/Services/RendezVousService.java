package Services;

import java.io.StringReader;
<<<<<<< HEAD
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
=======
>>>>>>> a4eef0d1880b2c595c5cb4728b442fea084fe09e
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import Entities.Furniture;
import Entities.RendezVous;
import Interfaces.IRendezVousServiceLocal;
import Interfaces.IRendezVousServiceRemote;

@Stateful
@LocalBean
public class RendezVousService implements IRendezVousServiceRemote,IRendezVousServiceLocal {

	@Override
	public List<RendezVous> GetAll() {
		// TODO Auto-generated method stub
		List<RendezVous> rdvList = new ArrayList<RendezVous>();		
		Client client = ClientBuilder.newClient();		
		
		
<<<<<<< HEAD
		WebTarget web =client.target("http://192.168.1.212/RendezVous/GetCalendarData");
=======
		WebTarget web =client.target("http://localhost:20281/RendezVous/GetCalendarData");
>>>>>>> a4eef0d1880b2c595c5cb4728b442fea084fe09e
		
		Response response = web.request().get();		
		
		String result = response.readEntity(String.class);		
		
		JsonReader jsonReader = Json.createReader(new StringReader(result));		
		
		JsonArray object = jsonReader.readArray();
		
		for (int i = 0; i < object.size(); i++) {
			RendezVous rdv = new RendezVous();

			rdv.setId(object.getJsonObject(i).getInt("id"));
			rdv.setIdbuyer(object.getJsonObject(i).getString("idbuyer"));
			rdv.setIdseller(object.getJsonObject(i).getString("idseller"));
			rdv.setTitle(object.getJsonObject(i).getString("title"));
			rdv.setColor(object.getJsonObject(i).getString("color"));	 	
			rdv.setStart(object.getJsonObject(i).getString("start"));
			rdv.setEnd( object.getJsonObject(i).getString("end")); 
			rdv.setAllDay(object.getJsonObject(i).getBoolean("allDay",false));			
			rdv.setValidappointment( object.getJsonObject(i).getBoolean("validappointment", false));
			rdv.setDescription(object.getJsonObject(i).getString("description"));
			
																  
			
			rdvList.add(rdv);
		}
		return rdvList;
	}
	//RendezVousService rdv = new RendezVousService();
//	List<RendezVous> lrdv = rdv.GetAll();
		//	JSONArray jsonA = JSONArray.fromObject(lrdv);
	
			
	@Override
	public RendezVous Getbyid(int rdvid) {
		// TODO Auto-generated method stub
			
		RendezVous rd = new RendezVous();
		//JsonReader jsonReader = Json.createReader(new StringReader(result));		
		
for (RendezVous lf: GetAll()) {
	if (lf.getId()==rdvid)
		rd=lf;
}
		
		return rd;
	}


	@Override
	public void addrdv(int id, String title, String start, String end, String color, String idbuyer, String idseller,
			Boolean allDay, Boolean validappointment, String description) {
		// TODO Auto-generated method stub
		
		Client client = ClientBuilder.newClient();
<<<<<<< HEAD
		WebTarget web = client.target("http://192.168.1.212/RendezVous/AddEvent?title="+title+
=======
		WebTarget web = client.target("http://localhost:20281/RendezVous/AddEvent?title="+title+
>>>>>>> a4eef0d1880b2c595c5cb4728b442fea084fe09e
				"&start="+start+
				"&end="+end+
				"&idseller="+idseller+
				"&idbuyer="+idbuyer+
				"&color="+color+
				"&description="+description+
				"&allDay="+allDay+
				"&validappointment"+validappointment);
		Response response = web.request().post(null);
		response.close();
		
	}


	@Override
	public void addrendezvous(RendezVous r) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleterdv(int id) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
<<<<<<< HEAD
		WebTarget web = client.target("http://192.168.1.212/RendezVous/DeleteEvent?id=" + id);
=======
		WebTarget web = client.target("http://localhost:20281/RendezVous/DeleteEvent?id=" + id);
>>>>>>> a4eef0d1880b2c595c5cb4728b442fea084fe09e
		Response response = web.request().post(null);
		response.close();
		
	}


	@Override
	public void update(int id, String title, String start, String end, String color, String idbuyer, String idseller,
			Boolean allDay, Boolean validappointment, String description) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
<<<<<<< HEAD
		WebTarget web = client.target("http://192.168.1.212/RendezVous/UpdateEvent?id=" + id+
=======
		WebTarget web = client.target("http://localhost:20281/RendezVous/UpdateEvent?id=" + id+
>>>>>>> a4eef0d1880b2c595c5cb4728b442fea084fe09e
				"&title="+title+
				"&start="+start+
				"&idbuyer="+idbuyer+
				"&idseller="+idseller+
				"&color="+color+
				"&allDay="+allDay+
				"&description="+description+
				"&validappointment="+validappointment+
				"&end="+end
				);
		Response response = web.request().post(null);
		response.close();
	}


<<<<<<< HEAD


	
	public int day(String start) {
		LocalDateTime today = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String local = today.format(formatter);

		LocalDateTime ldt = LocalDateTime.parse( local , formatter ) ;
		
		
		LocalDateTime startd = LocalDateTime.parse( start , formatter ) ;
		
		//System.out.println(ldt.getDayOfYear());
		Duration diff = Duration.between(ldt, startd);
		return (int)diff.toDays();
	}
	public int hour(String start) {
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		

		
		
		
		LocalDateTime startd = LocalDateTime.parse( start , formatter ) ;
		
		//System.out.println(ldt.getDayOfYear());
		
		return (int)startd.getHour();
	}
	
public int minute(String start) {
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		

		
		
		
		LocalDateTime startd = LocalDateTime.parse( start , formatter ) ;
		
		//System.out.println(ldt.getDayOfYear());
		
		return (int)startd.getMinute();
	}
	
	
	 
	
=======
>>>>>>> a4eef0d1880b2c595c5cb4728b442fea084fe09e
	
}
