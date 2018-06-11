package com.xt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  
@Table(name = "t_proxy")
public class Proxy {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "goodsid", length = 11)
  private Long goodsid;
  
  @Column(name = "userid", length = 45)
  private String userid;
  
  public Proxy() {
	super();
}

  @OneToOne
  @JoinColumn(name="gid",insertable=false,updatable=false)
  private Goods goods;
  
public Goods getGoods() {
	return goods;
}

public void setGoods(Goods goods) {
	this.goods = goods;
}

public Proxy(Long id, Long goodsid, String userid) {
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
