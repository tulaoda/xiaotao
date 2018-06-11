package com.xt.action;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xt.base.BaseAction;
import com.xt.entity.Attention;
import com.xt.entity.Collection;
import com.xt.entity.Goods;
import com.xt.entity.User;
import com.xt.entity.Wannas;
import com.xt.service.AttentionService;
import com.xt.service.CollectionService;
import com.xt.service.WannasItemService;

@Namespace("/attention")
@ParentPackage("json-default")
@Controller
public class AttentionAction extends BaseAction{
	
	private String code;
	private List<Object> data;
	private int pageSize;
	private int page;
	private User user;
	public Attention attention;
	private List<Goods> goods=new ArrayList<Goods>();
	private List<Attention> as=new ArrayList<Attention>();
	private List<User> us=new ArrayList<User>();
	@Autowired
	private AttentionService attentionService;
	
	
	@Action(value="findAllMyAttentionForPage",results={
			@Result(name="success",type="json")
	})
	public String findAllMyAttentionForPage(){
		data=attentionService.findAllMyAttentionForPage(user.getUserid(),pageSize,page);
		if(data!=null){
			Iterator it=data.iterator();
			while(it.hasNext()){
			Object[]obj=(Object[])it.next();
			as.add((Attention) obj[0]);
			us.add((User) obj[1]);
			}
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="findAttentionById",results={
			@Result(name="success",type="json")
	})
	
	public String findAttentionById(){
		attention=attentionService.findAttentionById(attention.getId());
		if(attention!=null){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="addNewAttentionorUpdateState",results={
			@Result(name="success",type="json")
	})
	public String addNewAttentionorUpdateState(){
		Attention a=attentionService.findAttentionByTwoId(attention.getA_userid(),attention.getT_userid());
		if(a!=null){
			if(a.getState()==0){
			a.setState((long) 1);
			}else{
			a.setState((long) 0);	
			}
			boolean flag1=attentionService.updateAttentionState(attention);
			if(flag1){
				code="1";
			}else{
				code="0";
		}
		}
		attention.setState((long) 1);
		boolean flag=attentionService.addNewAttention(attention);
		if(flag){
			code="1";
			data=new ArrayList<>();
			data.add(attentionService.findMaxIdAttention());
		}else{
			code="0";
		}
		return SUCCESS;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Attention getAttention() {
		return attention;
	}

	public void setAttention(Attention attention) {
		this.attention = attention;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public List<Attention> getAs() {
		return as;
	}

	public void setAs(List<Attention> as) {
		this.as = as;
	}

	public List<User> getUs() {
		return us;
	}

	public void setUs(List<User> us) {
		this.us = us;
	}

	
}
