package Services;

import java.io.StringReader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import Entities.Comment;

import Interfaces.*;

@Stateful
@LocalBean
public class CommentService implements ICommentServiceRemote, ICommentServiceLocal {

	@Override
	public void addcomment(int fid, String msg) {
		Client client = ClientBuilder.newClient();

		WebTarget web = client
				.target("http://192.168.1.111/Furniture_JEE/addcomment?fid=" + fid + "&msg=" + msg);

		Response response = web.request().post(null);
		response.close();

	}

	Date cDate;

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	@Override
	public List<Comment> Getbyid(int fid) {
		List<Comment> cList = new ArrayList<Comment>();
		Client client = ClientBuilder.newClient();

		WebTarget web = client.target("http://192.168.1.111/Furniture_JEE/comments?fid=" + fid);

		Response response = web.request().get();

		String result = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {
			Comment c = new Comment();

			c.setCommentId(object.getJsonObject(i).getInt("CommentId"));
			c.setMessage(object.getJsonObject(i).getString("Message"));
			c.setUserId(object.getJsonObject(i).getString("UserId"));
			c.setFurnitureId(object.getJsonObject(i).getInt("FurnitureId"));
			String jsonDate = object.getJsonObject(i).getString("Date");
			jsonDate = jsonDate.replace("/Date(", "");
			jsonDate = jsonDate.replace(")/", "");
			Date time = new Date(Long.parseLong(jsonDate));
			c.setDate(time);

			cList.add(c);
		}
		return cList;
	}

	@Override
	public void delcomment(int cid) {
		Client client = ClientBuilder.newClient();
		WebTarget web = client.target("http://192.168.1.111/Furniture_JEE/delcomment?cid=" + cid);
		Response response = web.request().post(null);
		response.close();
	}
}
