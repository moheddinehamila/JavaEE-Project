package Entities;

import java.util.Date;

public class Order {

	public int OrderId;
	public int BillId;
	public int FurnitureId;   
 

	public int Qte;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date date;
	public double fPrice;
	public double tPrice;
	public String UserId;

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public int getBillId() {
		return BillId;
	}

	public void setBillId(int billId) {
		BillId = billId;
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

	public double getfPrice() {
		return fPrice;
	}

	public void setfPrice(double fPrice) {
		this.fPrice = fPrice;
	}

	public double gettPrice() {
		return tPrice;
	}

	public void settPrice(double tPrice) {
		this.tPrice = tPrice;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", BillId=" + BillId + ", FurnitureId=" + FurnitureId + ", Qte=" + Qte
				+ ", date=" + date + ", fPrice=" + fPrice + ", tPrice=" + tPrice + ", UserId=" + UserId + "]\n";
	}

	 

}
