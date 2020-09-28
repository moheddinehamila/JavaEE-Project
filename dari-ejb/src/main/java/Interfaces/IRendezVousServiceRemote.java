package Interfaces;

import javax.ejb.Remote;

import Entities.RendezVous;

import java.util.List;

@Remote
public interface IRendezVousServiceRemote {
	
	List<RendezVous> GetAll();
	
	RendezVous Getbyid(int rdvid);
	
	void addrdv(int id,String title, String start, String end,String color,String idbuyer,String idseller,Boolean allDay
			,Boolean validappointment,String description) ;
//http://localhost:20281/RendezVous/AddEvent?start=06/03/2020 12:12:12&idseller=445ba7a8-faf1-4990-bdf9-dcef0b1e6e01&color=red&description=testwebserver&end=06/03/2020 13:12:12
	//&title=an
	
	void addrendezvous(RendezVous r);
	
	
	void deleterdv(int id) ;
	
	void update(int id,String title, String start, String end,String color,String idbuyer,String idseller,Boolean allDay
			,Boolean validappointment,String description) ;
}
