package account;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import Entities.User;
import Services.ServiceUser;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

 @EJB
 ServiceUser us =new ServiceUser();
 
	private static final long serialVersionUID = 1L;
	private String login;
	private String Password;
	private String Confirmpassword;
	private String PhoneNumber;

	private Boolean loggedIn;
	private String userId;
	private String Country;
	private String LastName;
	private String FirstName;
	private String Email;
	private String role;

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public void setConfirmpassword(String confirmpassword) {
		Confirmpassword = confirmpassword;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getConfirmpassword() {
		return Confirmpassword;
	}

	public void setConfirmPassword(String confirmpassword) {
		Confirmpassword = confirmpassword;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
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



	User u = new User();
	

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public LoginBean() {
	}

	public String DoLogin() {
		String navigateTo = "null";
		if (Email.contentEquals("")) {
				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("email obligatoire"));

		}
		else {
			if (Password.equals("")) {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("password obligatoire"));

			}
		}
		u  = us.Dologin(Email, Password);
		if  (u==null) 
		 {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("email ou password incorrect"));
			return null ;
		 }
		if(u.getRole().equals("Counselor"))
		{
			loggedIn = true;
			userId=u.getId();
			FirstName= u.getFirstName();
			LastName=u.getLastName();
			Email= u.getEmail();
			PhoneNumber= u.getPhoneNumber();
			Country= u.getCountry();
			navigateTo= "/appointement/add?faces-redirect=true";
			
		
		}
		
		if(u.getRole().equals("Client")) {
			loggedIn = true;
			userId=u.getId();
			FirstName= u.getFirstName();
			LastName=u.getLastName();
			Email= u.getEmail();
			PhoneNumber= u.getPhoneNumber();
			Country= u.getCountry();
			navigateTo="/Counselors/Index?faces-redirect=true";
		}
		
			return navigateTo ;
		}
		

	
	public String DoRegister() {
		String navigateTo = "null"; 

		if (FirstName.contentEquals("")) {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("email obligatoire"));

	}
		if (LastName.contentEquals("")) {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("email obligatoire"));

	}
		if (Email.contentEquals("")) {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("email obligatoire"));

	}
		if (Password.contentEquals("")) {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("email obligatoire"));

	}
		if (Confirmpassword.contentEquals("")) {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("email obligatoire"));

	}
		if (PhoneNumber.contentEquals("")) {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("email obligatoire"));

	}
		if (Country.contentEquals("")) {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("email obligatoire"));

	}
		String r  = us.Register(FirstName, LastName, Email, Password, Confirmpassword, PhoneNumber, Country);
		if  (r==null) 
		 {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("one or multiple entry are invalid"));
			return null ;
		 }
		else
		 if(r=="Success")
		{
			
			
			 navigateTo = "/counselors/Index?faces-redirect=true"; 
 ;
		
		}
		return navigateTo;
		
		
	}
	
	
	
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login/login?faces-redirect=true";
	}
	

}
