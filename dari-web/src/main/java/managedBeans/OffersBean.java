package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import Entities.Requests;
import Enumerates.Governorateenum;
import Enumerates.Type;
import Enumerates.Typech;
import Services.*;

@SessionScoped
@ManagedBean(name="offersbean", eager = true)
public class OffersBean implements Serializable {
	
	private int Budget;
	private int Area;
    private Typech typechval;
    private Type typeval;
    private Governorateenum Governorateenumval;
	private ArrayList<SelectItem> delegations	=new ArrayList<SelectItem>();
    private String delegationval;
    private ArrayList<Requests> requestslist;
    private Requests request;

    
	@EJB
	OffersServices ds = new OffersServices();
    
	@ManagedProperty(value="#{loginBean}") 
    private LoginBean loginBean;
    
    
    
    
    
    
    
	 public String scan() {
	    	String navigateTo = "null";

		navigateTo = "/offers/Index?faces-redirect=true";

		return navigateTo;
	 }
	
    
    
    
	public int getBudget() {
		return Budget;
	}
	public void setBudget(int budget) {
		Budget = budget;
	}
	public int getArea() {
		return Area;
	}
	public void setArea(int area) {
		Area = area;
	}
	public Typech getTypechval() {
		return typechval;
	}
	public void setTypechval(Typech typechval) {
		this.typechval = typechval;
	}
	public Type getTypeval() {
		return typeval;
	}
	public void setTypeval(Type typeval) {
		this.typeval = typeval;
	}
	public Governorateenum getGovernorateenumval() {
		return Governorateenumval;
	}
	public void setGovernorateenumval(Governorateenum governorateenumval) {
		Governorateenumval = governorateenumval;
	}
	public ArrayList<SelectItem> getDelegations() {
		if (Governorateenumval.BEN.equals(getGovernorateenumval()))
		{
			delegations.clear();
		delegations.add(new SelectItem("2222,Megrine,MG"));
		delegations.add(new SelectItem("5555,Rades,RD"));	
		setDelegations(delegations);

			return delegations;

			}
		if (Governorateenumval.BIZ.equals(getGovernorateenumval()))
		{	
			delegations.clear();

		delegations.add(new SelectItem("1111,zarzoun,za"));
		delegations.add(new SelectItem("1202,B Ville,BV"));
setDelegations(delegations);
			return delegations;
		}
		return null;
			}
	public void setDelegations(ArrayList<SelectItem> delegations) {
		this.delegations = delegations;
	}
	public String getDelegationval() {
		return delegationval;
	}
	public void setDelegationval(String delegationval) {
		this.delegationval = delegationval;
	}




	public ArrayList<Requests> getRequestslist() {
		requestslist=ds.bestoffers(loginBean.getRole(), loginBean.getUserid(), Budget, Area, typechval, typeval, Governorateenumval, delegationval);
		return requestslist;	}




	public void setRequestslist(ArrayList<Requests> requestslist) {
		this.requestslist = requestslist;
	}




	public Requests getRequest() {
		return request;
	}




	public void setRequest(Requests request) {
		this.request = request;
	}




	public LoginBean getLoginBean() {
		return loginBean;
	}




	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
    
    
    
    
    
    
    
    
    
    
    
    

	
	
	
	
	

}
