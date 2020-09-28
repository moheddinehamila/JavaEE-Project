package appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.Appointment;
import Entities.Counselor;
import Services.AppointmentService;
import account.LoginBean;
import counselors.counselorBean;

@SessionScoped
@ManagedBean(name="appBean")
public class AppointmentBean {
	
	@EJB
	AppointmentService as = new AppointmentService();	
	
	private int Id;
	private String CounselorId;
	private String userId;
	private String PhoneNumber;
	private String UserPhone;
	private String Date;
	private String Confirm;
	private String avai;




	private ArrayList<Appointment> applist;

	
	@ManagedProperty(value="#{loginBean}") 
    private LoginBean loginBean;


	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}


	public String getCounselorId() {
		return CounselorId;
	}


	public void setCounselorId(String counselorId) {
		CounselorId = counselorId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPhoneNumber() {
		return PhoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}


	public String getUserPhone() {
		return UserPhone;
	}


	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}


	public String getConfirm() {
		return Confirm;
	}


	public void setConfirm(String confirm) {
		Confirm = confirm;
	}


	public String getAvai() {
		return avai;
	}


	public void setAvai(String avai) {
		this.avai = avai;
	}


	


	public void setApplist(ArrayList<Appointment> applist) {
		this.applist = applist;
	}


	public LoginBean getLoginBean() {
		return loginBean;
	}


	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	


	public String addApp () throws Exception {
    	
    	
    	String navigateTo = "null";
    	
    	as.AddApp(loginBean.getUserId(), loginBean.getFirstName(),loginBean.getLastName(),loginBean.getEmail(),loginBean.getPhoneNumber(), Date);	
    
    	
    	FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Appointement Date Added"));
	
	navigateTo = "/counselors/Index?faces-redirect=true";




	return navigateTo;
    }
	
	

}



