package counselors;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Appointment;
import Entities.Counselor;
import Services.AppointmentService;
import Services.CounserlorService;
@SessionScoped
@ManagedBean(name="counselorBean")
public class counselorBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	CounserlorService cs = new CounserlorService();
	@EJB
	AppointmentService as = new AppointmentService();
	
	 private String Id ;

	 private String cin;
    
	 private String address ;
     
	 private String City ;
private String DateSelected;

	
	private ArrayList<Counselor> Counselorslist;
	private ArrayList<Appointment> applist;
	private String Country ;
	private String image ;

	private String FirstName ;

	private String LastName ;

	private String Email ;
     
	private String PhoneNumber ;

	private String userId ;

	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public counselorBean() {
	}
	public counselorBean(String id, String cin, String address, String city, String country, String image,
			String firstName, String lastName, String email, String phoneNumber, String userId) {
		super();
		Id = id;
		this.cin = cin;
		this.address = address;
		City = city;
		Country = country;
		this.image = image;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		PhoneNumber = phoneNumber;
		this.userId = userId;
	}
   Counselor c ;




	public Counselor getC() {
		return c;
	}
	public void setC(Counselor c) {
		this.c = c;
	}
    public ArrayList<Counselor> getCounselorslist() {
    	
    	Counselorslist=cs.fon();
		return Counselorslist;
	}
	public void setCounselorslist(ArrayList<Counselor> counselorslist) {
		Counselorslist = counselorslist;
	}
	public ArrayList<Appointment> getApplist() {
		applist=as.GetAllById(userId);
		return applist;
	}
	public void setApplist(ArrayList<Appointment> applist) {
		this.applist = applist;
	}
	
	
	
	public String getDateSelected() {
		return DateSelected;
	}
	public void setDateSelected(String dateSelected) {
		DateSelected = dateSelected;
	}
	public String  displayRequests(Counselor counselors) {
		this.image=counselors.getImage();
		this.FirstName=counselors.getFirstName();
		this.LastName=counselors.getLastName();
		this.PhoneNumber=counselors.getPhoneNumber();
		this.address=counselors.getAddress();
		this.City=counselors.getCity();
		this.Country=counselors.getCountry();
		
		this.Id=counselors.getUserId();

		String navigateTo = "null"; 
		navigateTo = "/Counselors/Details?faces-redirect=true";

		return navigateTo;
		

	}
	

}
