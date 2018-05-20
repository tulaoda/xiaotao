package com.xt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_cartdet")  
public class Cartdet {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "goodsid", length = 11)
  private Long goodsid;
  
  @Column(name = "cartid", length = 45)
  private Long cartid;
  
  @Column(name = "num", length = 11)
  private Long num;

  public Cartdet() {
	super();
}

public Cartdet(Long id, Long goodsid,Long cartid, Long num) {
	super();
	this.id = id;
	this.goodsid = goodsid;
	this.cartid = cartid;
	this.num = num;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getGoodsid() {
    return goodsid;
  }

  public void setGoodsid(Long goodsid) {
    this.goodsid = goodsid;
  }

  public Long getCartid() {
    return cartid;
  }

  public void setCartid(Long cartid) {
    this.cartid = cartid;
  }

  public Long getNum() {
    return num;
  }

  public void setNum(Long num) {
    this.num = num;
  }
}
