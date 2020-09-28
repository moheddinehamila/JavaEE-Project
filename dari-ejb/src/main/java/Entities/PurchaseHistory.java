package Entities;

import java.util.Date;
import java.util.List;

public class PurchaseHistory {

	public int purchaseHistoryId; 
	public List<Furniture> furniturelist ;
	public String UserId; 
	public double finalprice; 
	public Date date;
	
	public PurchaseHistory(List<Furniture> furniturelist) {
		super();
		this.furniturelist = furniturelist;
	}
	public PurchaseHistory() {
	}
	public int getPurchaseHistoryId() {
		return purchaseHistoryId;
	}
	public void setPurchaseHistoryId(int purchaseHistoryId) {
		this.purchaseHistoryId = purchaseHistoryId;
	}
 
	public List<Furniture> getFurniturelist() {
		return furniturelist;
	}
	public void setFurniturelist(List<Furniture> furniturelist) {
		this.furniturelist = furniturelist;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public double getFinalprice() {
		return finalprice;
	}
	public void setFinalprice(double finalprice) {
		this.finalprice = finalprice;
	}
 
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "PurchaseHistory [purchaseHistoryId=" + purchaseHistoryId + ", Furniturelist="
				+ furniturelist.toString() + ", UserId=" + UserId + ", finalprice=" + finalprice 
				+ ", date=" + date + "]\n";
	}
 
	
	
	
}
