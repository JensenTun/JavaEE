package com.jensen.entity;

public class Cart {

	private int cid;
	private int pid;
	private int userId;
	private String productName;
	private Double price;
	private Double totalPrice;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cid, int pid, int userId, String productName, Double price, Double totalPrice) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.userId = userId;
		this.productName = productName;
		this.price = price;
		this.totalPrice = totalPrice;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", pid=" + pid + ", userId=" + userId + ", productName=" + productName + ", price="
				+ price + ", totalPrice=" + totalPrice + "]";
	}
}
