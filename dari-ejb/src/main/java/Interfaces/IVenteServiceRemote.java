package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.AnnonceVente;

@Remote
public interface IVenteServiceRemote {
	

	List<AnnonceVente> GetAllAnnonceVente();
	AnnonceVente GetAnnonceVenteById(int Id) ;
	void DeleteAnnonceVenteId(int id);
    void AddAnnonceVente(String Name, String Image, String Adress, int Price,
    		String Description, double Height, double Width, double Depth);
	

}
