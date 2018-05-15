package com.xt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_goods_img")
public class GoodsImg {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "image", length = 100)
  private String image;
  
  @Column(name = "goodSid", length = 11)
  private Long goodsid;

  public GoodsImg() {
	super();
}

public GoodsImg(Long id, String image, Long goodsid) {
	super();
	this.id = id;
	this.image = image;
	this.goodsid = goodsid;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Long getGoodsid() {
    return goodsid;
  }

  public void setGoodsid(Long goodsid) {
    this.goodsid = goodsid;
  }
}
