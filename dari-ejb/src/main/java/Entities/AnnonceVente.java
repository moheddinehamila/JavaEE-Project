package Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


 

@JsonIgnoreProperties(ignoreUnknown = true)

public class AnnonceVente {
	
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty("VenteId")
	 public int VenteId ;
     
	@JsonProperty("UserId")
     public int UserId ;
	@JsonProperty("Name")
     public String Name ;
	@JsonProperty("Image")
     public String Image ;
	@JsonProperty("Adress")
     public String Adress ;
	@JsonProperty("Price")
     public int Price ;
      
	@JsonProperty("Description")
     public String Description ;
	@JsonProperty("Category")
     public String Category ;
	@JsonProperty("Height")
     public double Height ;
	@JsonProperty("Width")
     public double Width ;
	@JsonProperty("Depth")
     public double Depth ;

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

	@Override
	public String toString() {
		return "AnnonceVente [VenteId=" + VenteId + ", UserId=" + UserId + ", Name=" + Name + ", Image=" + Image
				+ ", Adress=" + Adress + ", Price=" + Price + ", Description=" + Description + ", Category=" + Category
				+ ", Height=" + Height + ", Width=" + Width + ", Depth=" + Depth + "]";
	}
     
     
     

}
