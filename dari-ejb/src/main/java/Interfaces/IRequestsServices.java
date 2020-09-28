package Interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import Entities.Requests;



@Remote
public interface IRequestsServices {

	public ArrayList<Requests>  fon(String role, String user);
	public void  deleteservice(int idd) ;
	public void  createservice(String UserId,int Budget, String Phone, int TypeCh, int Type, String Description, int Area, String Title, String SelectedCountryIso3,String SelectedRegionCode);
	public void  editservice(int id,int Budget, String Phone, int TypeCh, int Type, String Description, int Area, String Title);
	public ArrayList<Requests>  search(String searchstring, String aa, int min, int max,String role, String user);
	
	
}
