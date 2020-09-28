package Interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import Entities.Counselor;


@Remote
public interface ICounselorService {

	
	public ArrayList<Counselor>  fon();

	
}
