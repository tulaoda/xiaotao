
package com.xt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_log") 
public class Log {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "type", length = 45)
  private String type;
  
  @Column(name = "cratetime", length = 0)
  private java.sql.Timestamp cratetime;
  
  @Column(name = "info", length = 45)
  private String info;
  
  @Column(name = "detail", length = 45)
  private String detail;

  public Log() {
	super();
}

public Log(Long id, String type, Timestamp cratetime, String info, String detail) {
	super();
	this.id = id;
	this.type = type;
	this.cratetime = cratetime;
	this.info = info;
	this.detail = detail;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public java.sql.Timestamp getCratetime() {
    return cratetime;
  }

  public void setCratetime(java.sql.Timestamp cratetime) {
    this.cratetime = cratetime;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}
