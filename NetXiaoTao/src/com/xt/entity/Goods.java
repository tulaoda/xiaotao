package com.xt.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "t_goods")
public class Goods {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "l_class", length = 11)
  private Long l_class;
  
  @Column(name = "content", length = 100)
  private String content;
  
  @Column(name = "price", length = 0)
  private float price;
  
  @Column(name = "userid", length = 45)
  private String userid;
  
  @Column(name = "state", length = 11)
  private Long state;
  
  @Column(name = "proxy", length = 1)
  private Long proxy;
  
  @Column(name = "stock", length = 11)
  private Long stock;
  
  @Column(name = "postage", length = 1)
  private Long postage;

  @OneToMany(targetEntity=GoodsImg.class,cascade=CascadeType.ALL)  
  @Fetch(FetchMode.JOIN)  
  //updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)  
  @JoinColumn(name="goodsid",updatable=false)  
  private List<GoodsImg> goodsImg = new ArrayList<GoodsImg>();  
  public List<GoodsImg> getGoodsImg() {  
  return goodsImg;  
  }  
  public void setGoodsImg(List<GoodsImg> goodsImg) {  
  this.goodsImg = goodsImg;  
  }  
  public Goods() {
	super();
}

public Goods(Long id, Long l_class, String content, float price,
		String userid, Long state, Long proxy, Long stock, Long postage) {
	super();
	this.id = id;
	this.l_class = l_class;
	this.content = content;
	this.price = price;
	this.userid = userid;
	this.state = state;
	this.proxy = proxy;
	this.stock = stock;
	this.postage = postage;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getL_class() {
    return l_class;
  }

  public void setL_class(Long l_class) {
    this.l_class = l_class;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }

  public Long getProxy() {
    return proxy;
  }

  public void setProxy(Long proxy) {
    this.proxy = proxy;
  }

  public Long getStock() {
    return stock;
  }

  public void setStock(Long stock) {
    this.stock = stock;
  }

  public Long getPostage() {
    return postage;
  }

  public void setPostage(Long postage) {
    this.postage = postage;
  }
  
}
