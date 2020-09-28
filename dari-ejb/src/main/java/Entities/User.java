package Entities;

public class User {


	private String Id;

	private String FirstName;

	private String LastName;
	private String Email;
	private String PhoneNumber;
	private String Country;
	private String UserName;
	private String Password;
	private String role;

public User() {
	// TODO Auto-generated constructor stub
}

public User(String id, String firstName, String lastName, String email, String phoneNumber, String country,
		String userName,String password) {
	super();
	Id = id;
	FirstName = firstName;
	LastName = lastName;
	Email = email;
	PhoneNumber = phoneNumber;
	Country = country;
	UserName = userName;
	Password = password;
	
}
public User(String id, String firstName, String lastName, String email, String phoneNumber, String country, String role
		) {
	super();
	Id = id;
	FirstName = firstName;
	LastName = lastName;
	Email = email;
	PhoneNumber = phoneNumber;
	Country = country;
	this.role =  role;

}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password= password;
}
public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
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

public String getCountry() {
	return Country;
}

public void setCountry(String country) {
	Country = country;
}

public String getUserName() {
	return UserName;
}

public void setUserName(String userName) {
	UserName = userName;
}
User u ;

public User getUser() {
	return u;
}

public void setUser(User u) {
	this.u = u;
}


	
}
