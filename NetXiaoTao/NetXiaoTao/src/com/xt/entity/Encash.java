package com.xt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_encash")  
public class Encash {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "price", length = 11)
  private Long price;
  
  @Column(name = "applytime", length = 0)
  private java.sql.Timestamp applytime;
  
  @Column(name = "updatetime", length = 0)
  private java.sql.Timestamp updatetime;
  
  @Column(name = "state", length = 11)
  private Long state;
  
  @Column(name = "userid", length = 45)
  private String userid;
  
  @Column(name = "account", length = 45)
  private String account;
  
  @Column(name = "username", length = 45)
  private String username;
  
  @Column(name = "zhifubaoid", length = 45)
  private String zhifubaoid;

  public Encash() {
	super();
}

public Encash(Long id, Long price, Timestamp applytime, Timestamp updatetime,
		Long state, String userid, String account, String username,
		String zhifubaoid) {
	super();
	this.id = id;
	this.price = price;
	this.applytime = applytime;
	this.updatetime = updatetime;
	this.state = state;
	this.userid = userid;
	this.account = account;
	this.username = username;
	this.zhifubaoid = zhifubaoid;
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

  public java.sql.Timestamp getApplytime() {
    return applytime;
  }

  public void setApplytime(java.sql.Timestamp applytime) {
    this.applytime = applytime;
  }

  public java.sql.Timestamp getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(java.sql.Timestamp updatetime) {
    this.updatetime = updatetime;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getZhifubaoid() {
    return zhifubaoid;
  }

  public void setZhifubaoid(String zhifubaoid) {
    this.zhifubaoid = zhifubaoid;
  }
}
