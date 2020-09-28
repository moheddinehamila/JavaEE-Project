package Entities;

public class Counselor {
	 public int Id ;

     public String cin;
    
     public String address ;
     
     public String City ;
    
     public String Country ;
     public String image ;

     public String FirstName ;

     public String LastName ;

     public String Email ;
     
     public String PhoneNumber ;

     public String userId ;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
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
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
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
	
	public Counselor(int id, String cin, String address, String city, String country, String image, String firstName,
			String lastName, String email, String phoneNumber, String userId) {
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
	public Counselor() {
		// TODO Auto-generated constructor stub
	}



}
