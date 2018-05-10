package com.xt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_order_message")
public class OrderMessage {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "orderid")
  private Long orderid;
  
  @Column(name = "express", length = 20)
  private String express;
  
  @Column(name = "expressorder", length = 45)
  private String expressorder;
  
  @Column(name = "receiver", length = 10)
  private String receiver;
  
  @Column(name = "phone", length = 11)
  private String phone;
  
  @Column(name = "area", length = 45)
  private String area;
  
  @Column(name = "address", length = 45)
  private String address;
  
  @Column(name = "postalcode", length = 8)
  private String postalcode;

  public OrderMessage() {
	super();
}

public OrderMessage(Long orderid, String express, String expressorder,
		String receiver, String phone, String area, String address,
		String postalcode) {
	super();
	this.orderid = orderid;
	this.express = express;
	this.expressorder = expressorder;
	this.receiver = receiver;
	this.phone = phone;
	this.area = area;
	this.address = address;
	this.postalcode = postalcode;
}

public Long getOrderid() {
    return orderid;
  }

  public void setOrderid(Long orderid) {
    this.orderid = orderid;
  }

  public String getExpress() {
    return express;
  }

  public void setExpress(String express) {
    this.express = express;
  }

  public String getExpressorder() {
    return expressorder;
  }

  public void setExpressorder(String expressorder) {
    this.expressorder = expressorder;
  }

  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPostalcode() {
    return postalcode;
  }

  public void setPostalcode(String postalcode) {
    this.postalcode = postalcode;
  }
}
