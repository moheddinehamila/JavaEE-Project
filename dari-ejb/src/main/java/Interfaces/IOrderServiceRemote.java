package Interfaces;

import java.util.ArrayList;
import java.util.List;


import javax.ejb.Remote;

import Entities.Order;
import Entities.PurchaseHistory;

 
@Remote
public interface IOrderServiceRemote {
	
	List<Order> GetAll(   );
	public  List<PurchaseHistory>   getalist(   ); 
}
