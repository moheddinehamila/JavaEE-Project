package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Voted;
 
 

@Remote
public interface IVotedServiceRemote {
	
	List<Voted> GetAll();
	boolean isvoted(int fid );
	void addvote(int fid, int note );


}
