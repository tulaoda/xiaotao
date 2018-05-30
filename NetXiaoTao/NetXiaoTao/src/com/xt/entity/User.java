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
@Table(name = "t_user")
public class User {
	@Id
	@Column(name = "userid")
	private String userid;

	@OneToMany(targetEntity=Address.class,cascade=CascadeType.ALL)  
	  @Fetch(FetchMode.JOIN)  
	  //updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)  
	  @JoinColumn(name="userid",updatable=false)  
	private List<Address> addresss = new ArrayList<Address>();
	
	public List<Address> getAddresss() {
		return addresss;
	}

	public void setAddresss(List<Address> addresss) {
		this.addresss = addresss;
	}

	@Column(name = "nickname", length = 20)
	private String nickname;

	@Column(name = "passwd", length = 20)
	private String passwd;

	@Column(name = "school", length = 45)
	private String school;

	@Column(name = "photo", length = 200)
	private String photo;

	@Column(name = "credits", length = 11)
	private Long credits;

	@Column(name = "auth", length = 1)
	private Long auth;

	@Column(name = "bond", length = 11)
	private Long bond;

	@Column(name = "bondtime", length = 0)
	private java.sql.Timestamp bondtime;

	@Column(name = "balance", length = 10)
	private Double balance;

	
	@Column(name = "userstate", length = 45)
	private String userstate;

	public User() {
		super();
	}

	public User(String userid, String nickname, String passwd, String school,
			String photo, Long credits, Long auth, Long bond,
			Timestamp bondtime, Double balance, String userstate) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.passwd = passwd;
		this.school = school;
		this.photo = photo;
		this.credits = credits;
		this.auth = auth;
		this.bond = bond;
		this.bondtime = bondtime;
		this.balance = balance;
		this.userstate = userstate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Long getCredits() {
		return credits;
	}

	public void setCredits(Long credits) {
		this.credits = credits;
	}

	public Long getAuth() {
		return auth;
	}

	public void setAuth(Long auth) {
		this.auth = auth;
	}

	public Long getBond() {
		return bond;
	}

	public void setBond(Long bond) {
		this.bond = bond;
	}

	public java.sql.Timestamp getBondtime() {
		return bondtime;
	}

	public void setBondtime(java.sql.Timestamp bondtime) {
		this.bondtime = bondtime;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getUserstate() {
		return userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

	
}
