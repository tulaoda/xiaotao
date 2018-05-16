package com.xt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User {
	@Id
	@Column(name = "userid")
	private String userid;

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

	@Column(name = "receiver", length = 10)
	private String receiver;

	@Column(name = "phone", length = 11)
	private String phone;

	@Column(name = "area", length = 45)
	private String area;

	@Column(name = "address", length = 45)
	private String address;

	@Column(name = "postalcode", length = 8)
	private String postalcode;

	@Column(name = "userstate", length = 45)
	private String userstate;

	public User() {
		super();
	}

	public User(String userid, String nickname, String passwd, String school,
			String photo, Long credits, Long auth, Long bond,
			Timestamp bondtime, Double balance, String receiver, String phone,
			String area, String address, String postalcode, String userstate) {
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
		this.receiver = receiver;
		this.phone = phone;
		this.area = area;
		this.address = address;
		this.postalcode = postalcode;
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

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getUserstate() {
		return userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

}
