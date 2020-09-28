package Services;

import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import Entities.Furniture;
import Interfaces.IFurnitureServiceLocal;
import Interfaces.IFurnitureServiceRemote;

@Stateful
@LocalBean
public class FurnitureService implements IFurnitureServiceRemote, IFurnitureServiceLocal {
	List<Furniture> top8;

	@Override
	public List<Furniture> GetAll() {
		List<Furniture> fList = new ArrayList<Furniture>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("http://192.168.1.111/Furniture_JEE/api_Indexfurniture");

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();
		boolean virgule;

		for (int i = 0; i < object.size(); i++) {
			Furniture f = new Furniture();

			f.setAddress(object.getJsonObject(i).getString("Address"));
			f.setCategory(object.getJsonObject(i).getString("Category"));
			f.setDescription(object.getJsonObject(i).getString("description"));
			f.setType(object.getJsonObject(i).getString("Type"));
			f.setName(object.getJsonObject(i).getString("Name"));
			f.setFurnitureId(object.getJsonObject(i).getInt("FurnitureId"));
			f.setQte(object.getJsonObject(i).getInt("Qte"));
			f.setPrice(Double.parseDouble(object.getJsonObject(i).get("Price").toString()));
			f.setNote(Double.parseDouble(object.getJsonObject(i).get("Note").toString()));
		    int temp = (int)(f.getNote()*100.0);
			f.setNote(  ((double)temp)/100);
			virgule = true;
			if (f.getNote() == (int) f.getNote()) {
				virgule = false;
			}
			f.setVirgule(virgule);
			f.setNbrNote(object.getJsonObject(i).getInt("nbrNote"));
			f.setHeight(object.getJsonObject(i).getInt("Height"));
			f.setWidth(object.getJsonObject(i).getInt("Width"));
			f.setDepth(object.getJsonObject(i).getInt("Depth"));
			f.setUserId(object.getJsonObject(i).getString("UserId"));
			f.setImage(object.getJsonObject(i).getString("Image"));
			fList.add(f);
		}
		return fList;
	}

	@Override
	public List<Furniture> Gettop8Rated() {
		top8 = GetAll();
		Comparator<Furniture> c = (Furniture f1, Furniture f2) -> Double.compare(f1.getNote(), (f2.getNote()));
		Collections.sort(top8, c.reversed());
		return top8.stream().limit(8).collect(Collectors.toList());
	}

	@Override
	public List<Furniture> Gettop8cheapest() {
		top8 = GetAll();
		Comparator<Furniture> c = (Furniture f1, Furniture f2) -> Double.compare(f1.getPrice(), (f2.getPrice()));
		Collections.sort(top8, c);
		return top8.stream().limit(8).collect(Collectors.toList());
	}

	@Override
	public Furniture Getbyid(int fid) {
		Furniture f = new Furniture();

		for (Furniture lf : GetAll()) {
			if (lf.getFurnitureId() == fid)
				f = lf;
		}
		return f;
	}

}
