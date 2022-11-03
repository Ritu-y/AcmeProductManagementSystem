package com.pms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {

	@Id
	long pId;
	String pName;
	String price;
	public Products() {
		super();
	}
	public Products(long pId, String pName, String price) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
	}
	public long getpId() {
		return pId;
	}
	public void setpId(long pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [pId=" + pId + ", pName=" + pName + ", price=" + price + "]";
	}
}
