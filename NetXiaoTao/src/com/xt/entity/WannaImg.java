package com.xt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_wanna_img")
public class WannaImg {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "wannaid", length = 11)
  private Long wannaid;
  
  @Column(name = "image", length = 100)
  private String image;

  public WannaImg() {
	super();
}

public WannaImg(Long id, Long wannaid, String image) {
	super();
	this.id = id;
	this.wannaid = wannaid;
	this.image = image;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getWannaid() {
    return wannaid;
  }

  public void setWannaid(Long wannaid) {
    this.wannaid = wannaid;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
