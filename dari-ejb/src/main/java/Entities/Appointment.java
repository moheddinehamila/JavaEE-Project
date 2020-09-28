package Entities;

import java.sql.Date;

public class Appointment {
	private int Id;
	private String CounselorId;
	private String userId;
	private String CounselorEmail;
	private String cf;
	private String cl;
	private String cp;
	private String UserEmail;
	private String Date;
	private String Confirm;
	private String avai;

	
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getCl() {
		return cl;
	}
	public void setCl(String cl) {
		this.cl = cl;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getAvai() {
		return avai;
	}
	public void setAvai(String avai) {
		this.avai = avai;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCounselorId() {
		return CounselorId;
	}
	public void setCounselorId(String counselorId) {
		CounselorId = counselorId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCounselorEmail() {
		return CounselorEmail;
	}
	public void setCounselorEmail(String counselorEmail) {
		CounselorEmail = counselorEmail;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	
	public String getConfirm() {
		return Confirm;
	}
	public void setConfirm(String confirm) {
		Confirm = confirm;
	}
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Appointment(int id, String counselorId, String userId, String cf, String cl, String counselorEmail, String cp,
			String date, String confirm ,String avai) {
		super();
		Id = id;
		CounselorId = counselorId;
		this.userId = userId;
		this.cf= cf;
		this.cl=cl;	
		CounselorEmail = counselorEmail;
		this.cp = cp;
		Date = date;
		Confirm = confirm;
		this.avai= avai;
	}
	public Appointment() {
		
	}
public Appointment(int id, String counselorId, String userId, String counselorEmail,
		String date, String confirm ,String avai) {
		
	}
public Appointment(String date) {
	this.Date= date;
}
public Appointment(int id, String counselorId, String userId, String counselorEmail, String cf, String cl,
		String cp, String date) {
	Id = id;
	CounselorId = counselorId;
	this.userId = userId;
	this.cf= cf;
	this.cl=cl;	
	CounselorEmail = counselorEmail;
	this.cp = cp;
	Date = date;
	this.Confirm = Confirm;
	this.avai= avai;
}

}
