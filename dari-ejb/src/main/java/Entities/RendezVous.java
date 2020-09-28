package Entities;

public class RendezVous {
	
	public RendezVous() {
		super();
	}
	public int id;
	public RendezVous(int id, String idbuyer, String idseller, String title, String color, String start, String end,
			Boolean allDay, Boolean validappointment, String description) {
		super();
		this.id = id;
		this.idbuyer = idbuyer;
		this.idseller = idseller;
		this.title = title;
		this.color = color;
		this.start = start;
		this.end = end;
		this.allDay = allDay;
		this.validappointment = validappointment;
		this.description = description;
	}
	public String idbuyer;
	public String idseller;
	public String title;
	public String color;
	public String start;
	public String end;
	public Boolean allDay;
	public Boolean validappointment;
	public String description;
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
	public Boolean getAllDay() {
		return allDay;
	}
	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}
	public Boolean getValidappointment() {
		return validappointment;
	}
	public void setValidappointment(Boolean validappointment) {
		this.validappointment = validappointment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "RendezVous [id=" + id + ", idbuyer=" + idbuyer + ", idseller=" + idseller + ", title=" + title
				+ ", color=" + color + ", start=" + start + ", end=" + end + ", allDay=" + allDay
				+ ", validappointment=" + validappointment + ", description=" + description + "]";
	}
	
	
	

}
