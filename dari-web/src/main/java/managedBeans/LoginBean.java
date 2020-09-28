package managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Services.RequestsServices;



@ManagedBean(name = "loginBean") 
@SessionScoped
public class LoginBean implements Serializable {

	
	private String login; 
	private String password; 
	private Boolean loggedIn;
	private String userid;
	private String country;
	private String nom;
	private String prenom;
	private String role;
	
	
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LoginBean() {} 

	

	public String doLogin()
	{
		String navigateTo = "null"; 

		
		if (login.equals("houssem.rdissi@gmail.fr") && password.equals("123Az!") ) {
			navigateTo = "/requests/Index?faces-redirect=true";
			loggedIn = true; 
			userid="c3fbb575-12fc-4565-9510-410fc9e7cc95";
			role="owner";
			country="BIZ";
			nom="Houssem";

		}
		if (login.equals("med.rdissi@gmail.com") && password.equals("123Az!") ) {
			navigateTo = "/requests/Index?faces-redirect=true";
			loggedIn = true; 
			userid="7ce67eeb-b494-4f78-9053-c370a34583a5";
			role="client";
			country="BEN";
			nom="Mohamed";

		}
		else 
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo; 
	}

	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login/login?faces-redirect=true";
	}
 
	
	
	
	
	
	
}
