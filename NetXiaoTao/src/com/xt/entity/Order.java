package com.xt.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "t_order")
public class Order {
  @Id
  @Column(name = "id")
  private Long id;
  
  @Column(name = "userid", length = 45)
  private String userid;
  
  @Column(name = "createtime", length = 0)
  private java.sql.Timestamp createtime;
  
  @Column(name = "proxyid", length = 11)
  private Long proxyid;
  
  @OneToMany(targetEntity=OrderMessage.class,cascade=CascadeType.ALL)  
  @Fetch(FetchMode.JOIN)  
  //updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)  
  @JoinColumn(name="orderId",updatable=false)  
  private List<OrderMessage> orderMessage = new ArrayList<OrderMessage>(); 
  
  
  public List<OrderMessage> getOrderMessage() {
	return orderMessage;
}

public void setOrderMessage(List<OrderMessage> orderMessage) {
	this.orderMessage = orderMessage;
}

public Order() {
	super();
}

public Order(Long id, String userid,
		Timestamp createtime, Long proxyid) {
	super();
	this.id = id;
	this.userid = userid;
	this.createtime = createtime;
	this.proxyid = proxyid;
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



public java.sql.Timestamp getCreatetime() {
	return createtime;
}

public void setCreatetime(java.sql.Timestamp createtime) {
	this.createtime = createtime;
}

public Long getProxyid() {
	return proxyid;
}

public void setProxyid(Long proxyid) {
	this.proxyid = proxyid;
}


}
