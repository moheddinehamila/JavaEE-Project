package Interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local; 

import Entities.Order;
import Entities.PurchaseHistory;

 

@Local
public interface IOrderServiceLocal {
	
	List<Order> GetAll(   );
	public  List<PurchaseHistory>   getalist(   ); 
}
