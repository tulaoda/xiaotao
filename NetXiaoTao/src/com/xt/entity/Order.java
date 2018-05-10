package com.xt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_order")
public class Order {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "userid", length = 45)
  private String userid;
  
  @Column(name = "goodsid", length = 11)
  private Long goodsid;
  
  @Column(name = "pay_price", length = 0)
  private Double pay_price;
  
  @Column(name = "is_ship", length = 1)
  private Long is_ship;
  
  @Column(name = "is_pay", length = 1)
  private Long is_pay;
  
  @Column(name = "pay_time", length = 0)
  private java.sql.Timestamp pay_time;
  
  @Column(name = "is_receipt", length = 1)
  private Long is_receipt;
  
  @Column(name = "ship_number", length = 100)
  private String ship_number;
  
  @Column(name = "createtime", length = 0)
  private java.sql.Timestamp createtime;
  
  @Column(name = "updatetime", length = 0)
  private java.sql.Timestamp updatetime;
  
  @Column(name = "proxyid", length = 11)
  private Long proxyid;

  public Order() {
	super();
}

public Order(Long id, String userid, Long goodsid, Double pay_price,
		Long is_ship, Long is_pay, Timestamp pay_time, Long is_receipt,
		String ship_number, Timestamp createtime, Timestamp updatetime,
		Long proxyid) {
	super();
	this.id = id;
	this.userid = userid;
	this.goodsid = goodsid;
	this.pay_price = pay_price;
	this.is_ship = is_ship;
	this.is_pay = is_pay;
	this.pay_time = pay_time;
	this.is_receipt = is_receipt;
	this.ship_number = ship_number;
	this.createtime = createtime;
	this.updatetime = updatetime;
	this.proxyid = proxyid;
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

  public Long getGoodsid() {
    return goodsid;
  }

  public void setGoodsid(Long goodsid) {
    this.goodsid = goodsid;
  }

  public Double getPay_price() {
    return pay_price;
  }

  public void setPay_price(Double pay_price) {
    this.pay_price = pay_price;
  }

  public Long getIs_ship() {
    return is_ship;
  }

  public void setIs_ship(Long is_ship) {
    this.is_ship = is_ship;
  }

  public Long getIs_pay() {
    return is_pay;
  }

  public void setIs_pay(Long is_pay) {
    this.is_pay = is_pay;
  }

  public java.sql.Timestamp getPay_time() {
    return pay_time;
  }

  public void setPay_time(java.sql.Timestamp pay_time) {
    this.pay_time = pay_time;
  }

  public Long getIs_receipt() {
    return is_receipt;
  }

  public void setIs_receipt(Long is_receipt) {
    this.is_receipt = is_receipt;
  }

  public String getShip_number() {
    return ship_number;
  }

  public void setShip_number(String ship_number) {
    this.ship_number = ship_number;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }

  public java.sql.Timestamp getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(java.sql.Timestamp updatetime) {
    this.updatetime = updatetime;
  }

  public Long getProxyid() {
    return proxyid;
  }

  public void setProxyid(Long proxyid) {
    this.proxyid = proxyid;
  }
}
