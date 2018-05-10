package com.xt.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xt.base.BaseAction;
import com.xt.entity.User;
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
	
	@Action(value="login",results={
			@Result(name="success",type="json")
	})
	public String login() {
		loginedUser=userService.login(user);
		if(loginedUser!=null){
			session.put("user", loginedUser);
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="register",results={
			@Result(name="success",type="json")
	})
	public String register() {
		if(userService.register(user)){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="modifyPass",results={
			@Result(name="success",type="json")
	})
	public String modifyPass() {
		if(userService.modifyPass(user)){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="modifyAddress",results={
			@Result(name="success",type="json")
	})
	public String modifyAddress() {
		if(userService.modifyAddress(user)){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="modifyName",results={
			@Result(name="success",type="json")
	})
	public String modifyName() {
		if(userService.modifyName(user)){
			code="1";
		}else{
			code="0";
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

	
	
}
