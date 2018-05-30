package com.xt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_message")  
public class Message {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "mes_id")
  private Long mes_id;
  
  @Column(name = "from_userid", length = 45)
  private String from_userid;
  
  @Column(name = "to_userid", length = 45)
  private String to_userid;
  
  @Column(name = "content", length = 200)
  private String content;
  
  @Column(name = "cratetime", length = 0)
  private java.sql.Timestamp cratetime;
  
  @Column(name = "read_state", length = 1)
  private Long read_state;

  public Message() {
	super();
}

public Message(Long mes_id, String from_userid, String to_userid,
		String content, Timestamp cratetime, Long read_state) {
	super();
	this.mes_id = mes_id;
	this.from_userid = from_userid;
	this.to_userid = to_userid;
	this.content = content;
	this.cratetime = cratetime;
	this.read_state = read_state;
}

public Long getMes_id() {
    return mes_id;
  }

  public void setMes_id(Long mes_id) {
    this.mes_id = mes_id;
  }

  public String getFrom_userid() {
    return from_userid;
  }

  public void setFrom_userid(String from_userid) {
    this.from_userid = from_userid;
  }

  public String getTo_userid() {
    return to_userid;
  }

  public void setTo_userid(String to_userid) {
    this.to_userid = to_userid;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public java.sql.Timestamp getCratetime() {
    return cratetime;
  }

  public void setCratetime(java.sql.Timestamp cratetime) {
    this.cratetime = cratetime;
  }

  public Long getRead_state() {
    return read_state;
  }

  public void setRead_state(Long read_state) {
    this.read_state = read_state;
  }
}
