package furniture;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import Entities.*;
import Services.*;

@ManagedBean(name = "orderBean")
@SessionScoped
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	OrderService os = new OrderService();
 
	List<PurchaseHistory> listorder = os.getalist( );

	public List<PurchaseHistory> getallOrders() {
 













		return os.getalist( );
	}
	
	
 

}
