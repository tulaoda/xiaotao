package com.xt.action;

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
import com.xt.entity.Goods;
import com.xt.entity.User;
import com.xt.entity.Wannas;
import com.xt.service.UserService;

@Namespace("/user")
@ParentPackage("json-default")
@Controller
public class UserAction extends BaseAction {

	public User user;

	@Autowired
	private UserService userService;

	private String code;
	private User loginedUser;
    private List<Object> list;
    private int pageSize;
	private int page;
	private List<User> users=new ArrayList<User>();;
	private List<Goods> goods=new ArrayList<Goods>();;
	@Action(value = "login", results = { @Result(name = "success", type = "json") })
	public String login() {
		loginedUser = userService.login(user);
		if (loginedUser != null) {
			session.put("userid", user.getUserid());
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "validateNickname", results = { @Result(name = "success", type = "json") })
	public String validateNickname() {
		loginedUser = userService.validateNickname(user);
		if (loginedUser == null) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "register", results = { @Result(name = "success", type = "json") })
	public String register() {
		String userid = java.util.UUID.randomUUID().toString().replace("-", "");
		user.setUserid(userid);
		if (userService.register(user)) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "modifyPass", results = { @Result(name = "success", type = "json") })
	public String modifyPass() {
		if (userService.modifyPass(user)) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "modifyAddress", results = { @Result(name = "success", type = "json") })
	public String modifyAddress() {
		if (userService.modifyAddress(user)) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "modifyName", results = { @Result(name = "success", type = "json") })
	public String modifyName() {
		if (userService.modifyName(user)) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "findUserAndGoods", results = { @Result(name = "success", type = "json") })
	public String findUserAndGoods() {
		list=userService.findUserAndGoods(pageSize,page);
		if (list.size()!=0) {
			Iterator it=list.iterator();
			while(it.hasNext()){
			Object[]obj=(Object[])it.next();
			users.add((User) obj[0]);
			goods.add((Goods) obj[1]);
			}
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public User getLoginedUser() {
		return loginedUser;
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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
