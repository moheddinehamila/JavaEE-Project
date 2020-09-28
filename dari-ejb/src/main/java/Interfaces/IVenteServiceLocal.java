package Interfaces;

import java.util.List;

import Entities.AnnonceVente;


public interface IVenteServiceLocal {
	


	List<AnnonceVente> GetAllAnnonceVente();
	AnnonceVente GetReunionPrivetById(int Id) ;
	void DeleteReunionpriveById(int id);
    void AddAnnonceVente(String Name, String Image, String Adress, int Price,
    		String Description, double Height, double Width, double Depth);

}
