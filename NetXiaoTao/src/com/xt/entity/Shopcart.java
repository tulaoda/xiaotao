package com.xt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_shopcart")
public class Shopcart {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "userid", length = 45)
  private String userid;
  
  @Column(name = "cartid", length = 45)
  private String cartid;

  public Shopcart() {
	super();
}

public Shopcart(Long id, String userid, String cartid) {
	super();
	this.id = id;
	this.userid = userid;
	this.cartid = cartid;
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

  public String getCartid() {
    return cartid;
  }

  public void setCartid(String cartid) {
    this.cartid = cartid;
  }
}
