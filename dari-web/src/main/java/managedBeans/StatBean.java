package managedBeans;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

import Entities.AnnonceVente;
import Entities.Requests;
import Services.RequestsServices;
import Services.StatServices;

@SessionScoped
@ManagedBean(name="statbean", eager = true)
public class StatBean {

	private int all; 
	private int country_all1; 
	private int country_all2; 

	private int typech_all1;
	private int typech_all2; 

	private int usr; 
	private int country_usr1; 
	private int country_usr2; 

	private int typech_usr1; 
	private int typech_usr2; 


	
	private int per_country_all1; 
	private int per_country_all2; 
	private int per_typech_all1;
	private int per_typech_all2; 

	private int per_country_usr1; 
	private int per_country_usr2; 
	private int per_typech_usr1; 
	private int per_typech_usr2; 

	

	

	

	public int getPer_country_all1() {
		per_country_all1=(getCountry_all1()*100)/getAll();
		return per_country_all1;
	}

	public void setPer_country_all1(int per_country_all1) {
		this.per_country_all1 = per_country_all1;
	}

	public int getPer_country_all2() {
		per_country_all2=(getCountry_all2()*100)/getAll();

		return per_country_all2;
	}

	public void setPer_country_all2(int per_country_all2) {
		this.per_country_all2 = per_country_all2;
	}

	public int getPer_typech_all1() {
		per_typech_all1=(getTypech_all1()*100)/getAll();

		return per_typech_all1;
	}

	public void setPer_typech_all1(int per_typech_all1) {
		this.per_typech_all1 = per_typech_all1;
	}

	public int getPer_typech_all2() {
		per_typech_all2=(getTypech_all2()*100)/getAll();

		return per_typech_all2;
	}

	public void setPer_typech_all2(int per_typech_all2) {
		this.per_typech_all2 = per_typech_all2;
	}

	public int getPer_country_usr1() {
		per_country_usr1=(getCountry_usr1()*100)/getUsr();

		return per_country_usr1;
	}

	public void setPer_country_usr1(int per_country_usr1) {
		this.per_country_usr1 = per_country_usr1;
	}

	public int getPer_country_usr2() {
		per_country_usr2=(getCountry_usr2()*100)/getUsr();

		return per_country_usr2;
	}

	public void setPer_country_usr2(int per_country_usr2) {
		this.per_country_usr2 = per_country_usr2;
	}

	public int getPer_typech_usr1() {
		per_typech_usr1=(getTypech_usr1()*100)/getUsr();

		return per_typech_usr1;
	}

	public void setPer_typech_usr1(int per_typech_usr1) {
		this.per_typech_usr1 = per_typech_usr1;
	}

	public int getPer_typech_usr2() {
		per_typech_usr2=(getTypech_usr2()*100)/getUsr();

		return per_typech_usr2;
	}

	public void setPer_typech_usr2(int per_typech_usr2) {
		this.per_typech_usr2 = per_typech_usr2;
	}

	public int getAll() {
		all=ds.stat_all();
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public int getCountry_all1() {
		country_all1=ds.stat_country_all("BIZ");
		return country_all1;
	}

	public void setCountry_all1(int country_all1) {
		this.country_all1 = country_all1;
	}

	public int getCountry_all2() {
		country_all2=ds.stat_country_all("BEN");

		return country_all2;
	}

	public void setCountry_all2(int country_all2) {
		this.country_all2 = country_all2;
	}

	public int getTypech_all1() {
		typech_all1=ds.stat_typech_all("BUY");
		return typech_all1;
	}

	public void setTypech_all1(int typech_all1) {
		this.typech_all1 = typech_all1;
	}

	public int getTypech_all2() {
		typech_all2=ds.stat_typech_all("RENT");

		return typech_all2;
	}

	public void setTypech_all2(int typech_all2) {
		this.typech_all2 = typech_all2;
	}

	public int getUsr() {
		usr=ds.stat_user(loginBean.getUserid());
		return usr;
	}

	public void setUsr(int usr) {
		this.usr = usr;
	}

	public int getCountry_usr1() {
		country_usr1=ds.stat_country_user("BIZ", loginBean.getUserid());

		return country_usr1;
	}

	public void setCountry_usr1(int country_usr1) {
		this.country_usr1 = country_usr1;
	}

	public int getCountry_usr2() {
		country_usr2=ds.stat_country_user("BEN", loginBean.getUserid());

		return country_usr2;
	}

	public void setCountry_usr2(int country_usr2) {
		this.country_usr2 = country_usr2;
	}

	public int getTypech_usr1() {
		typech_usr1=ds.stat_typech_user("BUY", loginBean.getUserid());

		return typech_usr1;
	}

	public void setTypech_usr1(int typech_usr1) {
		this.typech_usr1 = typech_usr1;
	}

	public int getTypech_usr2() {
		typech_usr2=ds.stat_typech_user("RENT", loginBean.getUserid());

		return typech_usr2;
	}

	public void setTypech_usr2(int typech_usr2) {
		this.typech_usr2 = typech_usr2;
	}

	@ManagedProperty(value="#{loginBean}") 
    private LoginBean loginBean;

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	@EJB
	StatServices ds = new StatServices();
	
	
	 public StatServices getDs() {
		return ds;
	}

	public void setDs(StatServices ds) {
		this.ds = ds;
	}

	public String sendsms() 
	 {
		     
		
	 
	     String na = null;
	     ArrayList<AnnonceVente> annoncelist=new  ArrayList<AnnonceVente>();
	     annoncelist= ds.suggestion(loginBean.getCountry());

	     int a=annoncelist.size();

String ss="Mr "+loginBean.getNom()+"\n You have "+a+" Properties in your City ="+loginBean.getCountry();


	for (AnnonceVente aa : annoncelist) {
		 System.out.println(aa.getName());
		System.out.println(aa.getCategory());
	    
	   ss=ss+" \n Name="+aa.getName()+" Type="+aa.getName();
		
	}

	
	
	
	/* NexmoClient client = new NexmoClient.Builder()
			  .apiKey("8321e546")
			  .apiSecret("7Cr00PW5EdAbpiHp")
			  .build();

			String messageText = ss;
			TextMessage message = new TextMessage("Dari", "21624253872", messageText);

			try {
				SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
			} catch (NexmoClientException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
*/
	
   			String navigateTo = "null";
   	    	
   	    
   		navigateTo = "/stat/Index?faces-redirect=true";

   		return navigateTo;
   			
   			
	 }

	public StatBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
