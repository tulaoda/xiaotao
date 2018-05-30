package com.xt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity  
@Table(name = "t_auth") 
public class Auth {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "userid")
  private String userid;
  
  @Column(name = "name", length = 10)
  private String name;
  
  @Column(name = "phone", length = 11)
  private String phone;
  
  @Column(name = "service", length = 45)
  private String service;
  
  @Column(name = "company", length = 45)
  private String company;
  
  @Column(name = "license1", length = 100)
  private String license1;
  
  @Column(name = "license2", length = 100)
  private String license2;
  
  @Column(name = "license3", length = 100)
  private String license3;
  
  @Column(name = "state", length = 11)
  private Long state;

  public Auth() {
	super();
}

public Auth(String userid, String name, String phone, String service,
		String company, String license1, String license2, String license3,
		Long state) {
	super();
	this.userid = userid;
	this.name = name;
	this.phone = phone;
	this.service = service;
	this.company = company;
	this.license1 = license1;
	this.license2 = license2;
	this.license3 = license3;
	this.state = state;
}

public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getLicense1() {
    return license1;
  }

  public void setLicense1(String license1) {
    this.license1 = license1;
  }

  public String getLicense2() {
    return license2;
  }

  public void setLicense2(String license2) {
    this.license2 = license2;
  }

  public String getLicense3() {
    return license3;
  }

  public void setLicense3(String license3) {
    this.license3 = license3;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }
}
