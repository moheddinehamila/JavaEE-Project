package furniture;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBeans")
@SessionScoped
public class LoginBeans implements Serializable {

 
	private static final long serialVersionUID = 1L;
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

	public LoginBeans() {
	}

	public String doLogin() {
		String navigateTo = "null";

		if (login.equals("moheddine.hamila@esprit.tn") && password.equals("hamila")) {
			navigateTo = "/furniture/FurnitureAccueil?faces-redirect=true";
			loggedIn = true;
			userid = "5802fc60-d45f-4ade-8552-e7c2f6ce3bd2";

			nom = "moheddine";
		}

		if (login.equals("ahmed@esprit.tn") && password.equals("hamila")) {
			navigateTo = "/furniture/FurnitureAccueil?faces-redirect=true";
			loggedIn = true;
			userid = "6035cc13-edae-410b-9519-cf799f71990a";

			nom = "client";
		}

		if (login.equals("mohamed@esprit.tn") && password.equals("hamila")) {
			navigateTo = "/furniture/FurnitureAccueil?faces-redirect=true";
			loggedIn = true;
			userid = "b8c4c47f-4e79-4219-8ca0-3da25f9a101c";

			nom = "n";
		}

		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login/login?faces-redirect=true";
	}

}
