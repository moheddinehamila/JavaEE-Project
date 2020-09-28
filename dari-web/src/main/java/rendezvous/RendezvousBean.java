package rendezvous;


import java.io.Serializable;
<<<<<<< HEAD
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
=======
>>>>>>> a4eef0d1880b2c595c5cb4728b442fea084fe09e
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.google.gson.Gson;


import Services.RendezVousService;
import Entities.RendezVous;

@ManagedBean
@SessionScoped
public class RendezvousBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
<<<<<<< HEAD
	RendezVousService rdvs = new RendezVousService();
=======
	RendezVousService rdvs = new RendezVousService();;
>>>>>>> a4eef0d1880b2c595c5cb4728b442fea084fe09e
	/*********************************************/
	 
	

	/*********************************************/
	
	List <RendezVous> lrdv;
	
	public List<RendezVous> Listrdv(){
		
		lrdv = rdvs.GetAll();
		return lrdv;
	}
	
	List <RendezVous> GetlistRendezVous;
	public List<RendezVous> GetlistRendezVous() {
		 GetlistRendezVous= rdvs.GetAll();
		return GetlistRendezVous;
	}
	
	public String title(int d)
	{
		RendezVous t=rdvs.Getbyid(d);
		String g=t.getTitle();
		return g;
	}

	public void delrdv(int d) {
		rdvs.deleterdv(d);
		//setListc(getListc());
		//return "/dari-web/rendezvous/IndexRdv.xhtml";
	}
	 
	
	 public String getjson() {
		 Gson gson = new Gson();
		 String json = gson.toJson(rdvs.GetAll());
				 return json;
	 }
	 
	 public String addrdvbean() {
		 System.out.println(title);
		// rdvs.addrdv(id, title, start, end, color, idbuyer, idseller, allDay, validappointment, description);	
	 return "IndexRdv.xhtml";
	 }
	 RendezVous r= new RendezVous();
	 public String createRendezvous() {
		    rdvs.addrendezvous(r);
		    //newPerson = new Person();
		   r= new RendezVous();
		    //persons = pDao.selectAll();
		    return "IndexRdv.xhtml";
		}
	 
	 int testVariable ;
	 
	public int getTestVariable() {
		return testVariable;
	}

	public void setTestVariable(int testVariable) {
		this.testVariable = testVariable;
	}
	int id;
	 String idbuyer;
	 String idseller;
	 String title="default";
	 String color;
	 String start;
	 String end;
	 Boolean allDay;
	 Boolean validappointment;
	 String description;
	 
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdbuyer() {
		return idbuyer;
	}

	public void setIdbuyer(String idbuyer) {
		this.idbuyer = idbuyer;
	}

	public String getIdseller() {
		return idseller;
	}

	public void setIdseller(String idseller) {
		this.idseller = idseller;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

<<<<<<< HEAD
	
	
	public String save()   {
		//System.out.println(title);
		rdvs.addrdv(id, title, String.valueOf(start),String.valueOf(end)
				, String.valueOf(color), "1f6fb3f4-a6ab-4818-91ea-16cc9f7b6e91", "445ba7a8-faf1-4990-bdf9-dcef0b1e6e01"
				, false, true, String.valueOf(description));
		
		LocalDateTime today = LocalDateTime.now();
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String local = today.format(formatter);
	
		LocalDateTime ldt = LocalDateTime.parse( local , formatter ) ;
		
		String startdate=String.valueOf(start);
		LocalDateTime startd = LocalDateTime.parse( startdate , formatter ) ;
		
		System.out.println(ldt.getDayOfYear());
		Duration diff = Duration.between(ldt, startd);
		System.out.println("Votre Rendez-Vous est dans "+ 
                diff.toDays()+" jour(s), "+ startd.getHour()+" Heur(s) et "+startd.getMinute()+" minute(s)");
		
		
		return "yourdatewillbe.xhtml?faces-redirect=true";
		
	 }

	public String phrase() {
		LocalDateTime today = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String local = today.format(formatter);
	
		LocalDateTime ldt = LocalDateTime.parse( local , formatter ) ;
		
		String startdate=String.valueOf(start);
		LocalDateTime startd = LocalDateTime.parse( startdate , formatter ) ;
		
		System.out.println(ldt.getDayOfYear());
		Duration diff = Duration.between(ldt, startd);
		System.out.println("Votre Rendez-Vous est dans "+ 
                diff.toDays()+" jour(s), "+ startd.getHour()+" Heur(s) et "+startd.getMinute()+" minute(s)");
		return "Votre Rendez-Vous est dans "+ 
                diff.toDays()+" jour(s), "+ startd.getHour()+" Heur(s) et "+startd.getMinute()+" minute(s)";
	}
	
	
	

	public String calculdate() {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaazzzz");
		return "test.xhtml?faces-redirect=true";
	}
=======
	public String save() {
		System.out.println(title);
		rdvs.addrdv(id, title, String.valueOf(start),String.valueOf(end)
				, String.valueOf(color), "1f6fb3f4-a6ab-4818-91ea-16cc9f7b6e91", "445ba7a8-faf1-4990-bdf9-dcef0b1e6e01"
				, false, true, String.valueOf(description));
		return "IndexRdv.xhtml?faces-redirect=true";
		
	 }
	
	public String test() {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
		return "/dari-web/furniture/FurnitureDetails.xhtml";
	 }

>>>>>>> a4eef0d1880b2c595c5cb4728b442fea084fe09e
			 
}
