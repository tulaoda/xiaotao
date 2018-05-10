package com.xt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_wannas")
public class Wannas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "wannaid", length = 45)
	private String wannaid;

	@Column(name = "userid", length = 45)
	private String userid;

	@Column(name = "content", length = 200)
	private String content;

	@Column(name = "price", length = 0)
	private float price;

	@Column(name = "createtime", length = 0)
	private java.sql.Timestamp createtime;

	public Wannas() {
		super();
	}

	public Wannas(Long id, String wannaid, String userid, String content,
			float price, Timestamp createtime) {
		super();
		this.id = id;
		this.wannaid = wannaid;
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

	public String getWannaid() {
		return wannaid;
	}

	public void setWannaid(String wannaid) {
		this.wannaid = wannaid;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public java.sql.Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.sql.Timestamp createtime) {
		this.createtime = createtime;
	}
}
