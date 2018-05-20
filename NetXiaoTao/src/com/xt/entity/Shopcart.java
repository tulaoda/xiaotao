package com.xt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity  
@Table(name = "t_shopcart")
public class Shopcart {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "userid", length = 45)
  private String userid;
  
  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="cartid",unique=true)
  
  private Cartdet c;
  
  public Shopcart() {
	super();
}

public Shopcart( Long id,String userid) {
	super();
	this.id = id;
	this.userid = userid;
}

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

public Cartdet getC() {
	return c;
}

public void setC(Cartdet c) {
	this.c = c;
}
  
}
