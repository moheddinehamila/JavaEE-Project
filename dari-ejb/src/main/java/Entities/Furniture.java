package Entities;

public class Furniture {
	  
		        public int FurnitureId ;
 
		         public int Qte ;
		        
		        public String Name ;
		        
		        public String Address ;
		     
		        public String Image ;
		        
		        public String Category ;
		     
		        public String Type ;
		        public double Price;
		        public double Note;
		        public int nbrNote;
		        public boolean virgule;
		        
		         

  public boolean isVirgule() {
					return virgule;
				}
				public void setVirgule(boolean virgule) {
					this.virgule = virgule;
				}
public double getNote() {
					return Note;
				}
				public void setNote(double note) {
					Note = note;
				}
				public int getNbrNote() {
					return nbrNote;
				}
				public void setNbrNote(int nbrNote) {
					this.nbrNote = nbrNote;
				}
public String description;
		        
		          public int Height ;

		         public int Width;

		         public int Depth;

		        public String UserId ;
		      
			 
				@Override
				public String toString() {
					return "Furniture [FurnitureId=" + FurnitureId + ", Qte=" + Qte + ", Name=" + Name + ", Address="
							+ Address + ", Image=" + Image + ", Category=" + Category + ", Type=" + Type + ", Price="
							+ Price + ", Note=" + Note + ", nbrNote=" + nbrNote + ", description=" + description
							+ ", Height=" + Height + ", Width=" + Width + ", Depth=" + Depth + ", UserId=" + UserId
							+ "]\n";
				}
				public int getFurnitureId() {
					return FurnitureId;
				}
				public void setFurnitureId(int furnitureId) {
					FurnitureId = furnitureId;
				}
				public int getQte() {
					return Qte;
				}
				public void setQte(int qte) {
					Qte = qte;
				}
				public String getName() {
					return Name;
				}
				public void setName(String name) {
					Name = name;
				}
				public String getAddress() {
					return Address;
				}
				public void setAddress(String address) {
					Address = address;
				}
				public String getImage() {
					return Image;
				}
				public void setImage(String image) {
					Image = image;
				}
				public String getCategory() {
					return Category;
				}
				public void setCategory(String category) {
					Category = category;
				}
				public String getType() {
					return Type;
				}
				public void setType(String type) {
					Type = type;
				}
				public double getPrice() {
					return Price;
				}
				public void setPrice(double price) {
					Price = price;
				}
				public String getDescription() {
					return description;
				}
				public void setDescription(String description) {
					this.description = description;
				}
				public int getHeight() {
					return Height;
				}
				public void setHeight(int height) {
					Height = height;
				}
				public int getWidth() {
					return Width;
				}
				public void setWidth(int width) {
					Width = width;
				}
				public int getDepth() {
					return Depth;
				}
				public void setDepth(int depth) {
					Depth = depth;
				}
				public String getUserId() {
					return UserId;
				}
				public void setUserId(String userId) {
					UserId = userId;
				}
		         
}
