package com.jensen.entity;

public class Order {
	
	private int id;
	private String orderId;
	private String userName;
	private String email;
	private String phnoe;
	private String fulladd;
	private String productname;
	private String price;
	
	public Order() {
		super();
		
	}

	public Order(String orderId, String userName, String email, String phnoe, String fulladd, String productname,
			String price) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.email = email;
		this.phnoe = phnoe;
		this.fulladd = fulladd;
		this.productname = productname;
		this.price = price;
	}

	public Order(int id, String orderId, String userName, String email, String phnoe, String fulladd,
			String productname, String price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.userName = userName;
		this.email = email;
		this.phnoe = phnoe;
		this.fulladd = fulladd;
		this.productname = productname;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnoe() {
		return phnoe;
	}

	public void setPhnoe(String phnoe) {
		this.phnoe = phnoe;
	}

	public String getFulladd() {
		return fulladd;
	}

	public void setFulladd(String fulladd) {
		this.fulladd = fulladd;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", userName=" + userName + ", email=" + email + ", phnoe="
				+ phnoe + ", fulladd=" + fulladd + ", productname=" + productname + ", price=" + price + "]";
	}
	
	
}
