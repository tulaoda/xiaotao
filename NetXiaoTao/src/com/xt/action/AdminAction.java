package com.xt.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xt.base.BaseAction;
import com.xt.entity.Address;
import com.xt.entity.Admin;
import com.xt.entity.Bill;
import com.xt.entity.Goods;
import com.xt.entity.User;
import com.xt.entity.Wannas;
import com.xt.service.AdminService;
import com.xt.service.UserService;

@Namespace("/admin")
@ParentPackage("json-default")
@Controller
public class AdminAction extends BaseAction {

	public Admin admin;
	@Autowired
	private AdminService adminService;

	private String code;
	private Admin loginedAdmin;
    private List<Object> list;
    private int pageSize;
	private int page;
	private double recharge_amount;
	private Address address;
	private List<User> users=new ArrayList<User>();
	private List<Goods> goods=new ArrayList<Goods>();
	
	@Action(value = "login", results = { @Result(name = "success", type = "json") })
	public String login() {
		loginedAdmin = adminService.login(admin);
		if (loginedAdmin != null) {
			session.put("username", admin.getUsername());
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "validateNickname", results = { @Result(name = "success", type = "json") })
	public String validateNickname() {
		loginedAdmin = adminService.validateNickname(admin);
		if (loginedAdmin == null) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "register", results = { @Result(name = "success", type = "json") })
	public String register() {
		if (adminService.register(admin)) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "modifyPasswd", results = { @Result(name = "success", type = "json") })
	public String modifyPass() {
		if (adminService.modifyPasswd(admin)) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "findAllUser", results = { @Result(name = "success", type = "json") })
	public String findAllUser() {
		users=adminService.findAllUser(pageSize,page);
		if (users!=null) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Admin getLoginedAdmin() {
		return loginedAdmin;
	}

	public void setLoginedAdmin(Admin loginedAdmin) {
		this.loginedAdmin = loginedAdmin;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	
}
