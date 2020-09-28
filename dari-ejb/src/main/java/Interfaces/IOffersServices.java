package Interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import Entities.Requests;
import Enumerates.Governorateenum;
import Enumerates.Type;
import Enumerates.Typech;

@Remote
public interface IOffersServices {
	public ArrayList<Requests>  bestoffers(String role, String user,int budget,int area, Typech typechval,Type typeval,Governorateenum Governorateenumval,String delegationval) ;


}
