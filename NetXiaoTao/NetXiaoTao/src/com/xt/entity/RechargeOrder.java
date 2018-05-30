package com.xt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_recharge_order")
public class RechargeOrder {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "price", length = 11)
  private Long price;
  
  @Column(name = "state", length = 11)
  private Long state;
  
  @Column(name = "cratetime", length = 0)
  private java.sql.Timestamp cratetime;
  
  @Column(name = "transaction_id", length = 45)
  private String transaction_id;
  
  @Column(name = "userid", length = 45)
  private String userid;

  public RechargeOrder() {
	super();
}

public RechargeOrder(Long id, Long price, Long state, Timestamp cratetime,
		String transaction_id, String userid) {
	super();
	this.id = id;
	this.price = price;
	this.state = state;
	this.cratetime = cratetime;
	this.transaction_id = transaction_id;
	this.userid = userid;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }

  public java.sql.Timestamp getCratetime() {
    return cratetime;
  }

  public void setCratetime(java.sql.Timestamp cratetime) {
    this.cratetime = cratetime;
  }

  public String getTransaction_id() {
    return transaction_id;
  }

  public void setTransaction_id(String transaction_id) {
    this.transaction_id = transaction_id;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }
}
