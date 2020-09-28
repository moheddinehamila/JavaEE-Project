package furniture;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import Entities.*;
import Services.*;

@ManagedBean(name = "furnitureBean")
@SessionScoped
public class FurnitureBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	FurnitureService furnitureservice = new FurnitureService();
	Furniture furnitureSelected = new Furniture();
	CommentService cs = new CommentService();
	VotedService vs = new VotedService();
	List<Furniture> listf = furnitureservice.GetAll();













	List<Furniture> top8cheapest = furnitureservice.Gettop8cheapest();
	List<Furniture> top8Rated = furnitureservice.Gettop8Rated();
	List<Comment> listc = cs.Getbyid(furnitureSelected.getFurnitureId());
	boolean voted = false;
	int nbrcmnt;
	String message;

	public String delcomment(int cid) {
		cs.delcomment(cid);
		listf = furnitureservice.GetAll();
		
		top8cheapest = furnitureservice.Gettop8cheapest();
		top8Rated = furnitureservice.Gettop8Rated();
		setFurnitureSelected(furnitureservice.Getbyid(getFurnitureSelected().getFurnitureId()));
		isVoted();
		setListc(getListc());
		return "/dari-web/furniture/FurnitureDetails.xhtml";
	}

	public String addcomment() {
listf = furnitureservice.GetAll();
		
		top8cheapest = furnitureservice.Gettop8cheapest();
		top8Rated = furnitureservice.Gettop8Rated();
		setFurnitureSelected(furnitureservice.Getbyid(getFurnitureSelected().getFurnitureId()));
		isVoted();
		cs.addcomment(furnitureSelected.getFurnitureId(), message);
		vs.isvoted(furnitureSelected.getFurnitureId());
		return "/dari-web/furniture/FurnitureDetails.xhtml";
	}

	public String gotofurniture() { 
		listf = furnitureservice.GetAll();
		
		top8cheapest = furnitureservice.Gettop8cheapest();
		top8Rated = furnitureservice.Gettop8Rated();
		setFurnitureSelected(furnitureservice.Getbyid(getFurnitureSelected().getFurnitureId()));
		isVoted();
		return "FurnitureDetails.jsf?faces-redirect=true";
	}

	public String addvote(int i) {
		vs.addvote(furnitureSelected.getFurnitureId(), i);
		listf = furnitureservice.GetAll();
		
		top8cheapest = furnitureservice.Gettop8cheapest();
		top8Rated = furnitureservice.Gettop8Rated();
		setFurnitureSelected(furnitureservice.Getbyid(getFurnitureSelected().getFurnitureId()));
		isVoted();
		return "/dari-web/furniture/FurnitureDetails.xhtml";

	}

	boolean verif;

	public boolean mycomment(int cid) {
		verif = false;
		for (Comment comment : listc) {
			if ((comment.getCommentId() == cid) && (comment.getUserId().equals("6035cc13-edae-410b-9519-cf799f71990a")))
				verif = true;

			return verif;
		}

		return vs.isvoted(furnitureSelected.getFurnitureId());
	}

	public List<Furniture> getTop8cheapest() {
listf = furnitureservice.GetAll();
		
		top8cheapest = furnitureservice.Gettop8cheapest();
		top8Rated = furnitureservice.Gettop8Rated();
		setFurnitureSelected(furnitureservice.Getbyid(getFurnitureSelected().getFurnitureId()));
		isVoted();
		return top8cheapest;
	}

	public int getNbrcmnt() {
		return getListc().size();
	}

	public boolean isVoted() {
		return vs.isvoted(furnitureSelected.getFurnitureId());
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

	public void setListc(List<Comment> listc) {
		this.listc = listc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Comment> getListc() {
		return cs.Getbyid(furnitureSelected.getFurnitureId());
	}

	public List<Furniture> getTop8Rated() {
listf = furnitureservice.GetAll();
		
		top8cheapest = furnitureservice.Gettop8cheapest();
		top8Rated = furnitureservice.Gettop8Rated();
		setFurnitureSelected(furnitureservice.Getbyid(getFurnitureSelected().getFurnitureId()));
		isVoted();
		return top8Rated;
	}

	public Furniture getFurnitureSelected() {
 
		return furnitureSelected;
	}

	public void setFurnitureSelected(Furniture furnitureSelected) {
		this.furnitureSelected = furnitureSelected;
	}

	public List<Furniture> getallFurnitures() {
listf = furnitureservice.GetAll();
		
		top8cheapest = furnitureservice.Gettop8cheapest();
		top8Rated = furnitureservice.Gettop8Rated();
		setFurnitureSelected(furnitureservice.Getbyid(getFurnitureSelected().getFurnitureId()));
		isVoted();
		return listf;
	}

}