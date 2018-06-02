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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "s_userid", length = 45)
	private String s_userid;

	@Column(name = "content", length = 200)
	private String content;

	@Column(name = "createTime", length = 11)
	private java.sql.Timestamp createTime;

	@Column(name = "r_userid", length = 45)
	private String r_userid;

	public Chat() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getS_userid() {
		return s_userid;
	}

	public void setS_userid(String s_userid) {
		this.s_userid = s_userid;
	}

	public String getR_userid() {
		return r_userid;
	}

	public void setR_userid(String r_userid) {
		this.r_userid = r_userid;
	}

}
