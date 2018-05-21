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
@Table(name = "t_wannas")
public class Wannas {
	@Id
	@Column(name = "id")
	private Long id;
	
	@OneToMany(targetEntity=WannaImg.class,cascade=CascadeType.ALL)  
	  @Fetch(FetchMode.JOIN)  
	  //updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)  
	  @JoinColumn(name="wannaid",updatable=false)  
	  private List<WannaImg> wannaImg = new ArrayList<WannaImg>();
	
	
	public List<WannaImg> getWannaImg() {
		return wannaImg;
	}

	public void setWannaImg(List<WannaImg> wannaImg) {
		this.wannaImg = wannaImg;
	}

	@Column(name = "userid", length = 45)
	private String userid;

	@Column(name = "content", length = 200)
	private String content;

	@Column(name = "price", length = 0)
	private Double price;

	@Column(name = "createtime", length = 0)
	private java.sql.Timestamp createtime;

	public Wannas() {
		super();
	}

	public Wannas(Long id, String userid, String content,
			Double price, Timestamp createtime) {
		super();
		this.id = id;
		this.userid = userid;
		this.content = content;
		this.price = price;
		this.createtime = createtime;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public java.sql.Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.sql.Timestamp createtime) {
		this.createtime = createtime;
	}
}
