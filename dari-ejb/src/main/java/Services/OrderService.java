package Services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
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
import Entities.Furniture;
import Entities.Order;
import Entities.PurchaseHistory;
import Interfaces.IOrderServiceLocal;
import Interfaces.IOrderServiceRemote;

@Stateful
@LocalBean
public class OrderService implements IOrderServiceRemote, IOrderServiceLocal {

	@Override
	public List<Order> GetAll(   ) {
		List<Order> oList = new ArrayList<Order>();
		Client client = ClientBuilder.newClient();
		WebTarget web = client.target("http://192.168.1.111/Furniture_JEE/Api_Order"  );
		Response response = web.request().get();
		String result = response.readEntity(String.class);
		JsonReader jsonReader = Json.createReader(new StringReader(result));
		JsonArray object = jsonReader.readArray();

		for (int i = 0; i < object.size(); i++) {

			Order o = new Order();
			o.setBillId(object.getJsonObject(i).getInt("BillId"));
			o.setfPrice(Double.parseDouble(object.getJsonObject(i).get("FinalPrice").toString()));
			o.settPrice(Double.parseDouble(object.getJsonObject(i).get("TotalPrice").toString()));
			o.setUserId(object.getJsonObject(i).getString("UserId"));
			o.setOrderId(object.getJsonObject(i).getInt("OrderId"));
			o.setQte(object.getJsonObject(i).getInt("Qte"));
			o.setFurnitureId(object.getJsonObject(i).getInt("FurnitureId"));
			String jsonDate = object.getJsonObject(i).getString("Date");
			jsonDate = jsonDate.replace("/Date(", "");
			jsonDate = jsonDate.replace(")/", "");
			Date time = new Date(Long.parseLong(jsonDate));
			o.setDate(time);

			oList.add(o);
		}

		return oList;
	}

	List<Furniture> fuList = new ArrayList<>();

	public List<Furniture> fl(int billid ) {
		List<Order> oList = GetAll( );
		FurnitureService fs = new FurnitureService();
		fuList = new ArrayList<>();
		for (Order order : oList) {

			if (billid == order.getBillId())
				fuList.add(fs.Getbyid(order.getFurnitureId()));
		}
		return fuList;
	}

	List<PurchaseHistory> phlist;

	@Override
	public List<PurchaseHistory> getalist( ) {
		List<Order> oList = GetAll( );
		phlist = new ArrayList<>();
		PurchaseHistory p;
		boolean exist = false;
		p = new PurchaseHistory();
		p.setFurniturelist(new ArrayList<>());
		p.setDate(oList.get(0).getDate());
		p.setFinalprice(oList.get(0).getfPrice());
		p.setPurchaseHistoryId(oList.get(0).getBillId());
		p.setFurniturelist(fl(oList.get(0).getBillId() ));
		p.setUserId(oList.get(0).getUserId());
		phlist.add(p);
		for (Order order : oList) {
			exist = false;
			for (PurchaseHistory ph : phlist) {
				if (order.getBillId() == ph.getPurchaseHistoryId())
					exist = true;
			}
			if (!exist) {
				p = new PurchaseHistory();
				p.setFurniturelist(new ArrayList<>());
				p.setDate(order.getDate());
				p.setFinalprice(order.getfPrice());
				p.setPurchaseHistoryId(order.getBillId());
				p.setFurniturelist(fl(order.getBillId() ));
				p.setUserId(order.getUserId());
				phlist.add(p);
			}
		}
		return phlist;
	}

}
