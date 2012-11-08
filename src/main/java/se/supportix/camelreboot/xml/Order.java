package se.supportix.camelreboot.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Order {

	//<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	//<order>
	//<customerEmail>asdasd</customerEmail>
	//<customerName>adas</customerName>
	//<id>2</id>
	//<price>0.0</price>
	//<productId>2</productId>
	//<qty>55</qty>
	//</order>
	
	private String customerEmail;
	private String customerName;
	private int id;
	private long price;
	private int productId;
	private int qty;
	
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	@XmlElement
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerName() {
		return customerName;
	}
	
	@XmlElement
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getId() {
		return id;
	}
	
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	public long getPrice() {
		return price;
	}
	
	@XmlElement
	public void setPrice(long price) {
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	
	@XmlElement
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQty() {
		return qty;
	}
	
	@XmlElement
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
