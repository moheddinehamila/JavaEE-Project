package Interfaces;

import java.util.List;

import javax.ejb.Local;

import Entities.RendezVous;

@Local
public interface IRendezVousServiceLocal {
List<RendezVous> GetAll();


RendezVous Getbyid(int rdvid);



void addrdv(int id,String title, String start, String end,String color,String idbuyer,String idseller,Boolean allDay
		,Boolean validappointment,String description) ;

void addrendezvous(RendezVous r);

void deleterdv(int id) ;

void update(int id,String title, String start, String end,String color,String idbuyer,String idseller,Boolean allDay
		,Boolean validappointment,String description) ;
}
