package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Furniture;

 
 

@Remote
public interface IFurnitureServiceRemote {

	List<Furniture> GetAll();

	Furniture Getbyid(int fid);
	public List<Furniture> Gettop8cheapest();
	public List<Furniture> Gettop8Rated();

}
