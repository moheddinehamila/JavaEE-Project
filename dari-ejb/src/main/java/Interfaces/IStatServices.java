package Interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import Entities.AnnonceVente;

@Remote
public interface IStatServices {
	
	
	
	public ArrayList<AnnonceVente>  suggestion(String country);
	public int  stat_all();
	public int  stat_country_all(String country);
	public int  stat_typech_all(String country);
	public int  stat_user(String usr) ;
	public int  stat_country_user(String ch, String usr);
	public int  stat_typech_user(String ch, String usr) ;
	
}
