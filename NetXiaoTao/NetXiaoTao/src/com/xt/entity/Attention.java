package com.xt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_attention")
public class Attention {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "a_userid", length = 45)
	private String a_userid;

	@Column(name = "t_userid", length = 45)
	private String t_userid;

	@Column(name = "state", length = 2)
	private Long state;

	public Attention() {
		super();
	}

	public Attention(Long id, String a_userid, String t_userid, Long state) {
		super();
		this.id = id;
		this.a_userid = a_userid;
		this.t_userid = t_userid;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getA_userid() {
		return a_userid;
	}

	public void setA_userid(String a_userid) {
		this.a_userid = a_userid;
	}

	public String getT_userid() {
		return t_userid;
	}

	public void setT_userid(String t_userid) {
		this.t_userid = t_userid;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}
}
