package Vente;

import java.io.FileOutputStream;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.*;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import Entities.AnnonceVente;
import Entities.Furniture;
import Services.VenteService;







@ManagedBean(name = "VenteBean", eager = true)
@SessionScoped


public class VenteBean {
	

	
	String skills="";
	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
	List<AnnonceVente> mstCode;
	List<AnnonceVente> Listpr;
	
	 
	String search ;
	String searchdate ;
	AnnonceVente VenteV1;
	AnnonceVente VenteV2;
	AnnonceVente VenteV3;
	
   
	
	 
  int VenteId ;
     
     int UserId ;
    
     
     String Name ;
    
     String Image ;
     
     String Adress ;
     
     int Price ;
      
     
      String Description ;
     
       String Category ;
     
       double Height ;

       double Width ;

       double Depth ;
	public List<AnnonceVente> getMstCode() {
		return mstCode;
	}

	public void setMstCode(List<AnnonceVente> mstCode) {
		this.mstCode = mstCode;
	}

	public List<AnnonceVente> getListpr() {
		return Listpr;
	}

	public void setListpr(List<AnnonceVente> listpr) {
		Listpr = listpr;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearchdate() {
		return searchdate;
	}

	public void setSearchdate(String searchdate) {
		this.searchdate = searchdate;
	}

	public AnnonceVente getVenteV1() {
		return VenteV1;
	}

	public void setVenteV1(AnnonceVente venteV1) {
		VenteV1 = venteV1;
	}

	public AnnonceVente getVenteV2() {
		return VenteV2;
	}

	public void setVenteV2(AnnonceVente venteV2) {
		VenteV2 = venteV2;
	}

	public AnnonceVente getVenteV3() {
		return VenteV3;
	}

	public void setVenteV3(AnnonceVente venteV3) {
		VenteV3 = venteV3;
	}

	public int getVenteId() {
		return VenteId;
	}

	public void setVenteId(int venteId) {
		VenteId = venteId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public double getHeight() {
		return Height;
	}

	public void setHeight(double height) {
		Height = height;
	}

	public double getWidth() {
		return Width;
	}

	public void setWidth(double width) {
		Width = width;
	}

	public double getDepth() {
		return Depth;
	}

	public void setDepth(double depth) {
		Depth = depth;
	}
       
	 
	
	
	
	@EJB
	VenteService AnnonceV;
	
	//AnnonceVente VenteSelected = new AnnonceVente();
	
	public List<AnnonceVente> GetAll() {
		System.out.println(AnnonceV.GetAllAnnonceVente());

		return AnnonceV.GetAllAnnonceVente();
	}

	//List<AnnonceVente> listf = AnnonceV.GetAllAnnonceVente();
	
	
	
	
	
	
	public String IndexGetAllAnnonceVente() {
		return "ListReunionprive.xhtml?faces-redirect=true";
	}
	public String RedirectSearchAnnonceVente() {
		return "ReunionPriveRecherche.xhtml?faces-redirect=true";
	}
	public String RedirectAjoutAnnonceVente() {
		
		System.out.print("zzzzzza");
	//	return "/dari-web/Vente/AjoutV.xhtml";
		
		return "AjoutV.xhtml?faces-redirect=true";
	}
	
	
	
	
	 public String AjoutAnnonceVente(){
		    
	    	AnnonceVente rp = new AnnonceVente();
	    	
	    	
	   // ajout.setId(id);
	    	
	    	rp.setName(Name);
	  
	    
	    	rp.setImage(Image);

	    rp.setAdress(Adress);
	    rp.setDescription(Description);
	    rp.setPrice(Price);
	    rp.setHeight(Height);
	    rp.setDepth(Depth);
	    rp.setWidth(Width);
	    
	    
	     AnnonceV.AddAnnonceVente(rp);
	     
	  // 	return "/dari-web/Vente/Vente.xhtml";
	   	return "Vente.xhtml?faces-redirect=true";
	   
	    	// TODO Auto-generated catch block
	    	

	    }

	 

	    public String DeleteReunionprive(int id) {
			System.out.println("delete is here !");
			AnnonceV.DeleteAnnonceById(id);
			
			 
			return "/dari-web/Vente/Vente.xhtml";
			}
	 
	
	 
	 
	 
	
	 public String redirectUpdate(int id )
		{
		 VenteV1 = AnnonceV.GetAnnonceVenteById(id);
	        setVenteId(VenteV1.getVenteId());	
	        setUserId(VenteV1.getUserId());

 
			 
	        setName(VenteV1.getName());
	        setImage(VenteV1.getImage());
	        setAdress(VenteV1.getAdress());
	        setPrice(VenteV1.getPrice());
	        
	        setDescription(VenteV1.getDescription());
	        setCategory(VenteV1.getCategory());
	        setDepth(VenteV1.getDepth());
	        setHeight(VenteV1.getHeight());
	        setWidth(VenteV1.getWidth());
			return "UpdateV.xhtml?faces-redirect=true";
		}
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	    public String UpdateAnnonceVente(int Id) {

	    	AnnonceVente R = new AnnonceVente();
	    	R.setVenteId(VenteId);
	    	R.setUserId(UserId);
	    	R.setName(Name);
			    
			 
			 
			    
			 
			   R.setName(Name);
			   R.setImage(Image);
			   R.setAdress(Adress);
			   R.setPrice(Price);
			   
			   R.setDescription(Description);
			   R.setCategory(Category);
			
			  
			   R.setDepth(Depth);
			   R.setHeight(Height);
			   R.setWidth(Width);
			   
			  
			   
			 
			    AnnonceV.EditAnnonceVenteById(Id, R);
			   
			return "Vente.xhtml?faces-redirect=true";
			
			
		}
	    
	    
	    
		public String Get() {	
	   		
	   		mstCode = GetAll();
	   		System.out.println("-----------------------------------------------");
	   		System.out.println(search);
	   		Listpr = new ArrayList<AnnonceVente>();
	   		for (AnnonceVente pr: mstCode) {
	   	
			if ((pr.getName().toString().equals(search))){
				AnnonceVente pr1 = pr;
				    System.out.println("afficheeeee wa7da" + pr1);
				    Listpr.add(pr1); 
			}
	   		
	   		}	
	   		return "ResultatDeRecherche.xhtml?faces-redirect=true";
	   	
	    
	    
	   	}
	    
		
		

 
	    
	

	
	
	
	
	

}
