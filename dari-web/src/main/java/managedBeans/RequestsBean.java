package managedBeans;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.xml.ws.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

import Entities.Requests;
import Enumerates.*;
import Services.RequestsServices;



@SessionScoped
@ManagedBean(name="requestsbean", eager = true)
public class RequestsBean implements Serializable {
	private int RequestId;
	private int Budget;
	private String Phone;
	private int TypeCh;
	private int Type;
	private String Description;
	private int Area;
	private String Date;
	private String Title;
	private String CountryIso3;
	private String RegionCode;
    private ArrayList<Requests> requestslist;
    private Requests request;
    private Typech typechval;
    private Type typeval;
    private Governorateenum Governorateenumval;
	private ArrayList<SelectItem> delegations	=new ArrayList<SelectItem>();
    private String delegationval;
    private String radioval;
    private String Titles;
    private int Mins;
    private int Maxs;
    private ArrayList<Requests> requestslist2;
    private String id;
    private int ver;


   
    public int getVer() {
		return ver;
	}



	public void setVer(int ver) {
		this.ver = ver;
	}




	@ManagedProperty(value="#{loginBean}") 
    private LoginBean loginBean;


	public LoginBean getLoginBean() {
		return loginBean;
	}



	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}






	public ArrayList<Requests> getRequestslist2() {

		requestslist2=ds.search(Titles, radioval, Mins, Maxs,loginBean.getRole(),loginBean.getUserid());
		return requestslist2;
	}

	public void setRequestslist2(ArrayList<Requests> requestslist2) {
		this.requestslist2 = requestslist2;
	}




	@EJB
	RequestsServices ds = new RequestsServices();

	 public String searchRequest() {
	    	String navigateTo = "null";
	    //	id=loginBean.getUserid();
	    	//requestslist=null;
	    	this.setRequestslist(null);
	    //	setRequestslist(null);
		navigateTo = "/requests/Search?faces-redirect=true";

		return navigateTo;
	 }
	
    public String editRequest() {
    	int a=0,b=0;
    	if(typechval.toString().equals("Buy"))
    	{
    		a=0;
    	}	if(typechval.toString().equals("Rent"))
    	{
    		a=1;
    	}
    	if(typeval.toString().equals("S_0"))
    	{
    		b=0;
    	}
    	if(typeval.toString().equals("S_1"))
    	{
    		b=1;
    	}
    	if(typeval.toString().equals("S_2"))
    	{
    		b=2;
    	}
      	if(typeval.toString().equals("S_3"))
    	{
    		b=3;
    	}
      	if(typeval.toString().equals("S_4"))
    	{
    		b=4;
    	}
      	if(typeval.toString().equals("S_Plus"))
    	{
    		b=5;
    	}
      	if(typeval.toString().equals("Villa"))
    	{
    		b=6;
    	}
      	if(typeval.toString().equals("Fond_De_Commerce"))
    	{
    		b=7;
    	}
      	if(typeval.toString().equals("Terrain"))
    	{
    		b=8;
    	}
      	if(typeval.toString().equals("Local"))
    	{
    		b=9;
    	}
    	String navigateTo = "null";
    	
    	ds.editservice(RequestId, Budget, Phone, a, b, Description,Area , Title);
    	FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Request edit!"));
	
	navigateTo = "/requests/Index?faces-redirect=true";

	return navigateTo;

}
	
	
	
	
    public String addRequest()  {
    	
    	int a=0,b=0;
    	if(typechval.toString().equals("Buy"))
    	{
    		a=0;
    	}	if(typechval.toString().equals("Rent"))
    	{
    		a=1;
    	}
    	if(typeval.toString().equals("S_0"))
    	{
    		b=0;
    	}
    	if(typeval.toString().equals("S_1"))
    	{
    		b=1;
    	}
    	if(typeval.toString().equals("S_2"))
    	{
    		b=2;
    	}
      	if(typeval.toString().equals("S_3"))
    	{
    		b=3;
    	}
      	if(typeval.toString().equals("S_4"))
    	{
    		b=4;
    	}
      	if(typeval.toString().equals("S_Plus"))
    	{
    		b=5;
    	}
      	if(typeval.toString().equals("Villa"))
    	{
    		b=6;
    	}
      	if(typeval.toString().equals("Fond_De_Commerce"))
    	{
    		b=7;
    	}
      	if(typeval.toString().equals("Terrain"))
    	{
    		b=8;
    	}
      	if(typeval.toString().equals("Local"))
    	{
    		b=9;
    	}
    	String navigateTo = "null";
    	
    	ds.createservice(loginBean.getUserid(), Budget, Phone, a, b, Description,Area , Title, Governorateenumval.toString(), delegationval);
    	FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Request Added!"));
	
	navigateTo = "/requests/Index?faces-redirect=true";

	return navigateTo;

}
	
	
	public String  displayRequests(Requests requests) {
		this.Title=requests.getTitle();
		this.Area=requests.getArea();
		this.Budget=requests.getBudget();
		this.CountryIso3=requests.getCountryIso3();
		this.Date=requests.getDate();
		this.Description=requests.getDescription();
		this.Phone=requests.getPhone();
		this.Type=requests.getType();
		this.TypeCh=requests.getTypeCh();
		this.RegionCode=requests.getRegionCode();
		this.RequestId=requests.getRequestId();
		this.id=requests.getUserId();

		String navigateTo = "null"; 
		navigateTo = "/requests/Details?faces-redirect=true";
		
		
		if(this.id.equals(loginBean.getUserid()))
		{
			this.ver=1;
		}
		else {
			this.ver=0;
		}
		
		
		
		return navigateTo;
		

	}
	
	public String  deleteRequest(int id) {

		ds.deleteservice(id);
		String navigateTo = "null"; 
		navigateTo = "/requests/Index?faces-redirect=true";
		return navigateTo;
		

	}
	

	
	
	public int getRequestId() {
		return RequestId;
	}
	public void setRequestId(int requestId) {
		RequestId = requestId;
	}
	public int getBudget() {
		return Budget;
	}
	public void setBudget(int budget) {
		Budget = budget;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public int getTypeCh() {
		return TypeCh;
	}
	public void setTypeCh(int typeCh) {
		TypeCh = typeCh;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getArea() {
		return Area;
	}
	public void setArea(int area) {
		Area = area;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}

	public String getCountryIso3() {
		return CountryIso3;
	}
	public void setCountryIso3(String countryIso3) {
		CountryIso3 = countryIso3;
	}
	public String getRegionCode() {
		return RegionCode;
	}
	public void setRegionCode(String regionCode) {
		RegionCode = regionCode;
	}
	public ArrayList<Requests> getRequestslist() {
	

		
		requestslist=ds.fon(loginBean.getRole(),loginBean.getUserid());
		return requestslist;
	}
	public void setRequestslist(ArrayList<Requests> requestslist) {
		this.requestslist = requestslist;
	}
	public Requests getRequest() {
		return request;
	}
	public void setRequest(Requests request) {
		this.request = request;
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

	public String getTitles() {
		return Titles;
	}




	public void setTitles(String titles) {
		Titles = titles;
	}




	


	public String getRadioval() {
		return radioval;
	}




	public void setRadioval(String radioval) {
		this.radioval = radioval;
	}




	public int getMins() {
		return Mins;
	}




	public void setMins(int mins) {
		Mins = mins;
	}




	public int getMaxs() {
		return Maxs;
	}




	public void setMaxs(int maxs) {
		Maxs = maxs;
	}










	
}
