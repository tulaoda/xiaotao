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
import com.xt.entity.Collection;
import com.xt.entity.Goods;
import com.xt.entity.Proxy;
import com.xt.entity.User;
import com.xt.entity.Wannas;
import com.xt.service.CollectionService;
import com.xt.service.ProxyService;
import com.xt.service.WannasItemService;

@Namespace("/proxy")
@ParentPackage("json-default")
@Controller
public class ProxyAction extends BaseAction{
	
	private String code;
	private List<Object> data;
	private int pageSize;
	private int page;
	private User user;
	public Proxy proxy;
	private List<Goods> goods=new ArrayList<Goods>();
	private List<Proxy> ps=new ArrayList<Proxy>();
	@Autowired
	private ProxyService proxyService;
	
	
	@Action(value="findAllMyProxy",results={
			@Result(name="success",type="json")
	})
	public String findAllMyProxy(){
		data=proxyService.findAllMyProxyForPage(user.getUserid(),pageSize,page);
		if(data!=null){
			Iterator it=data.iterator();
			while(it.hasNext()){
			Object[]obj=(Object[])it.next();
			ps.add((Proxy) obj[0]);
			goods.add((Goods) obj[1]);
			}
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="findProxyById",results={
			@Result(name="success",type="json")
	})
	
	public String findProxyById(){
		proxy=proxyService.findProxyById(proxy.getId());
		if(proxy!=null){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="removeProxy",results={
			@Result(name="success",type="json")
	})
	public String removeProxy(){
		boolean flag=proxyService.RemoveProxy(proxy);
		if(flag){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="addNewProxy",results={
			@Result(name="success",type="json")
	})
	public String addNewProxy(){
		boolean flag=proxyService.addNewProxy(proxy);
		if(flag){
			code="1";
			data=new ArrayList<>();
			data.add(proxyService.findMaxIdProxy());
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

	public Proxy getProxy() {
		return proxy;
	}

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public List<Proxy> getPs() {
		return ps;
	}

	public void setPs(List<Proxy> ps) {
		this.ps = ps;
	}

}
