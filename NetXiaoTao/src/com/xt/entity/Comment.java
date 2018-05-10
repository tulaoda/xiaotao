package com.xt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_comment")  
public class Comment {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "userid", length = 45)
  private String userid;
  
  @Column(name = "c_userid", length = 45)
  private String c_userid;
  
  @Column(name = "content", length = 200)
  private String content;

  public Comment() {
	super();
}

public Comment(Long id, String userid, String c_userid, String content) {
	super();
	this.id = id;
	this.userid = userid;
	this.c_userid = c_userid;
	this.content = content;
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

  public String getC_userid() {
    return c_userid;
  }

  public void setC_userid(String c_userid) {
    this.c_userid = c_userid;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
