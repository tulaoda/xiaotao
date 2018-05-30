package com.xt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_address")
public class Address {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "id")
	  private Long id;
	  
	  @Column(name = "userid")
	  private String userid;
	  
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

		public Address() {
			super();
		}

		public Address(Long id, String userid, String receiver, String phone,
				String area, String address, String postalcode) {
			super();
			this.id = id;
			this.userid = userid;
			this.receiver = receiver;
			this.phone = phone;
			this.area = area;
			this.address = address;
			this.postalcode = postalcode;
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

		
}
