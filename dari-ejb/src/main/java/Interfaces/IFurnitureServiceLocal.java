package Interfaces;

import java.util.List;

import javax.ejb.Local;

import Entities.Furniture;

 
 

@Local
public interface IFurnitureServiceLocal {

	List<Furniture> GetAll();

	Furniture Getbyid(int fid);

	public List<Furniture> Gettop8cheapest();
	public List<Furniture> Gettop8Rated();

}
