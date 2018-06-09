package com.xt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_bill")
public class Bill {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "id")
	  private Long id;
	  
	  @Column(name = "userid" ,length=45)
	  private String userid;
	  
	    @Column(name = "price", length = 10)
		private double price;

		@Column(name = "state", length = 1)
		private Long state;

		@Column(name = "createtime", length = 0)
		private java.sql.Timestamp createtime;

		public Bill() {
			super();
		}

		public Bill(Long id, String userid, double price, Long state,
				Timestamp createtime) {
			super();
			this.id = id;
			this.userid = userid;
			this.price = price;
			this.state = state;
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

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public Long getState() {
			return state;
		}

		public void setState(Long state) {
			this.state = state;
		}

		public java.sql.Timestamp getCreatetime() {
			return createtime;
		}

		public void setCreatetime(java.sql.Timestamp createtime) {
			this.createtime = createtime;
		}

}
