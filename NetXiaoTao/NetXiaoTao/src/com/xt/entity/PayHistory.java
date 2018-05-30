package com.xt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_pay_history")
public class PayHistory {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "userid", length = 45)
  private String userid;
  
  @Column(name = "type", length = 11)
  private Long type;
  
  @Column(name = "content", length = 20)
  private String content;
  
  @Column(name = "cratetime", length = 0)
  private java.sql.Timestamp cratetime;
  
  @Column(name = "charge", length = 0)
  private Double charge;

  public PayHistory() {
	super();
}

public PayHistory(Long id, String userid, Long type, String content,
		Timestamp cratetime, Double charge) {
	super();
	this.id = id;
	this.userid = userid;
	this.type = type;
	this.content = content;
	this.cratetime = cratetime;
	this.charge = charge;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public java.sql.Timestamp getCratetime() {
    return cratetime;
  }

  public void setCratetime(java.sql.Timestamp cratetime) {
    this.cratetime = cratetime;
  }

  public Double getCharge() {
    return charge;
  }

  public void setCharge(Double charge) {
    this.charge = charge;
  }
}
