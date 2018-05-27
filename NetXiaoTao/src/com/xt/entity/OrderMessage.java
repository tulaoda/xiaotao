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
  @Column(name = "id")
  private Long id;
  
  @Column(name = "orderId", length = 11)
  private Long orderId;
  
  @Column(name = "goodsId", length = 20)
  private String goodsId;
  
  @Column(name = "count", length = 10)
  private Long count;
  
  @Column(name = "expressnumber", length = 45)
  private String expressnumber;
  
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

public OrderMessage(Long id, Long orderId, String goodsId, Long count,
		String expressnumber, String receiver, String phone, String area,
		String address, String postalcode) {
	super();
	this.id = id;
	this.orderId = orderId;
	this.goodsId = goodsId;
	this.count = count;
	this.expressnumber = expressnumber;
	this.receiver = receiver;
	this.phone = phone;
	this.area = area;
	this.address = address;
	this.postalcode = postalcode;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getOrderId() {
	return orderId;
}

public void setOrderId(Long orderId) {
	this.orderId = orderId;
}

public String getGoodsId() {
	return goodsId;
}

public void setGoodsId(String goodsId) {
	this.goodsId = goodsId;
}

public Long getCount() {
	return count;
}

public void setCount(Long count) {
	this.count = count;
}

public String getExpressnumber() {
	return expressnumber;
}

public void setExpressnumber(String expressnumber) {
	this.expressnumber = expressnumber;
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
