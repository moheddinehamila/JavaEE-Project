package Interfaces;

import java.util.List;

import javax.ejb.Local; 
import Entities.Voted;
 
 

@Local
public interface IVotedServiceLocal {
	
	List<Voted> GetAll();
	boolean isvoted(int fid);
	void addvote(int fid, int note );


}
