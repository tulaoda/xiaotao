package com.xt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_chat")  
public class Chat {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "s_userid", length = 11)
  private Long s_userid;
  
  @Column(name = "content", length = 200)
  private String content;
  
  @Column(name = "createTime", length = 11)
  private java.sql.Timestamp createTime;

  @Column(name = "r_userid", length = 11)
  private Long r_userid;

public Chat() {
	super();
}

public Chat(Long id, Long s_userid, String content, Timestamp createTime,
		Long r_userid) {
	super();
	this.id = id;
	this.s_userid = s_userid;
	this.content = content;
	this.createTime = createTime;
	this.r_userid = r_userid;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getS_userid() {
	return s_userid;
}

public void setS_userid(Long s_userid) {
	this.s_userid = s_userid;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public java.sql.Timestamp getCreateTime() {
	return createTime;
}

public void setCreateTime(java.sql.Timestamp createTime) {
	this.createTime = createTime;
}

public Long getR_userid() {
	return r_userid;
}

public void setR_userid(Long r_userid) {
	this.r_userid = r_userid;
}
 
  
}
