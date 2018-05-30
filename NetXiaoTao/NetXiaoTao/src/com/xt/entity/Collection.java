package com.xt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_collection")  
public class Collection {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "goodsid", length = 11)
  private Long goodsid;
  
  @Column(name = "userid", length = 45)
  private String userid;

  public Collection() {
	super();
}

public Collection(Long id, Long goodsid, String userid) {
	super();
	this.id = id;
	this.goodsid = goodsid;
	this.userid = userid;
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

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }
}
