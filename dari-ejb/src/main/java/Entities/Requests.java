package Entities;

import java.io.Serializable;

public class Requests implements Serializable{
	
	public int RequestId;
	private int Budget;
	private String Phone;
	private int TypeCh;
	private int Type;
	private String Description;
	private int Area;
	private String Date;
	private String Title;
	private String CountryIso3;
	private String RegionCode;
	private int Distance;
	private int per;
	private String UserId;

	
	public int getPer() {
		return per;
	}
	public void setPer(int per) {
		this.per = per;
	}
	public int getDistance() {
		return Distance;
	}
	public void setDistance(int distance) {
		Distance = distance;
	}

	public int getRequestId() {
		return RequestId;
	}
	public void setRequestId(int requestId) {
		RequestId = requestId;
	}
	public int getBudget() {
		return Budget;
	}
	public void setBudget(int budget) {
		Budget = budget;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public int getTypeCh() {
		return TypeCh;
	}
	public void setTypeCh(int typeCh) {
		TypeCh = typeCh;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getArea() {
		return Area;
	}
	public void setArea(int area) {
		Area = area;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}

	public String getCountryIso3() {
		return CountryIso3;
	}
	public void setCountryIso3(String countryIso3) {
		CountryIso3 = countryIso3;
	}
	public String getRegionCode() {
		return RegionCode;
	}
	public void setRegionCode(String regionCode) {
		RegionCode = regionCode;
	}


	public Requests(int requestId, int budget, String phone, int typeCh, int type, String description, int area,
			String date, String title, String countryIso3, String regionCode, int distance, int per) {
		super();
		RequestId = requestId;
		Budget = budget;
		Phone = phone;
		TypeCh = typeCh;
		Type = type;
		Description = description;
		Area = area;
		Date = date;
		Title = title;
		CountryIso3 = countryIso3;
		RegionCode = regionCode;
		Distance = distance;
		this.per = per;
	}

	public Requests(int requestId, int budget, String phone, int typeCh, int type, String description, int area,
			String date, String title, String countryIso3, String regionCode) {
		super();
		RequestId = requestId;
		Budget = budget;
		Phone = phone;
		TypeCh = typeCh;
		Type = type;
		Description = description;
		Area = area;
		Date = date;
		Title = title;
		CountryIso3 = countryIso3;
		RegionCode = regionCode;

	
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public Requests(int requestId, int budget, String phone, int typeCh, int type, String description, int area,
			String date, String title, String countryIso3, String regionCode, int distance, int per, String userId) {
		super();
		RequestId = requestId;
		Budget = budget;
		Phone = phone;
		TypeCh = typeCh;
		Type = type;
		Description = description;
		Area = area;
		Date = date;
		Title = title;
		CountryIso3 = countryIso3;
		RegionCode = regionCode;
		Distance = distance;
		this.per = per;
		UserId = userId;
	}
	public Requests(int requestId, int budget, String phone, int typeCh, int type, String description, int area,
			String date, String title, String countryIso3, String regionCode, String userId) {
		super();
		RequestId = requestId;
		Budget = budget;
		Phone = phone;
		TypeCh = typeCh;
		Type = type;
		Description = description;
		Area = area;
		Date = date;
		Title = title;
		CountryIso3 = countryIso3;
		RegionCode = regionCode;
		UserId = userId;
	}
	

	
}
