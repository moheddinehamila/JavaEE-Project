package rendezvous;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

 
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

	public LoginBean() {
	}

	public String doLogin() {
		String navigateTo = "null";

		if (login.equals("mohamedanouer.bahloul@esprit.tn") && password.equals("anouer")) {
			navigateTo = "/rendezvous/Annonceliste?faces-redirect=true";
			loggedIn = true;
			userid = "1f6fb3f4-a6ab-4818-91ea-16cc9f7b6e91";

			nom = "anouer";
		}

		if (login.equals("bahloul.anwer@gmail.com") && password.equals("anouer")) {
			navigateTo = "/rendezvous/IndexRdv?faces-redirect=true";
			loggedIn = true;
			userid = "445ba7a8-faf1-4990-bdf9-dcef0b1e6e01";

			nom = "seller";
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
