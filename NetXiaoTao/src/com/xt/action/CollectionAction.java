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
import com.xt.entity.User;
import com.xt.entity.Wannas;
import com.xt.service.CollectionService;
import com.xt.service.WannasItemService;

@Namespace("/collection")
@ParentPackage("json-default")
@Controller
public class CollectionAction extends BaseAction{
	
	private String code;
	private List<Object> data;
	private int pageSize;
	private int page;
	private User user;
	private Goods goodsItem;
	public Collection collection;
	private List<Goods> goods=new ArrayList<Goods>();
	private List<Collection> cs=new ArrayList<Collection>();
	@Autowired
	private CollectionService collectionService;
	
	
	@Action(value="findAllMyCollection",results={
			@Result(name="success",type="json")
	})
	public String findAllMyCollection(){
		data=collectionService.findAllMyCollectionForPage(user.getUserid(),pageSize,page);
		if(data!=null){
			Iterator it=data.iterator();
			while(it.hasNext()){
			Object[]obj=(Object[])it.next();
			cs.add((Collection) obj[0]);
			goods.add((Goods) obj[1]);
			}
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="findCollectionById",results={
			@Result(name="success",type="json")
	})
	
	public String findCollectionById(){
		collection=collectionService.findCollectionById(collection.getId());
		if(collection!=null){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="removeCollection",results={
			@Result(name="success",type="json")
	})
	public String removeCollection(){
//		collection=collectionService.findCollectionByGoodsIdAndUserid(goodsItem.getId(),user.getUserid());
		boolean flag=collectionService.removeCollection(collection);
		if(flag){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="addNewCollection",results={
			@Result(name="success",type="json")
	})
	public String addNewCollection(){
		boolean flag=collectionService.addNewCollection(collection);
		if(flag){
			code="1";
			data=new ArrayList<>();
			data.add(collectionService.findMaxIdCollection());
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

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public List<Collection> getCs() {
		return cs;
	}

	public void setCs(List<Collection> cs) {
		this.cs = cs;
	}

	public Goods getGoodsItem() {
		return goodsItem;
	}

	public void setGoodsItem(Goods goodsItem) {
		this.goodsItem = goodsItem;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/*@Action(value = "addFileAction",params={"savePath","/upload"},
			interceptorRefs={@InterceptorRef(value="fileUpload",params={"allowedTypes","image/pjpeg, image/gif,image/x-png","maximumSize","1024000000"}),
			@InterceptorRef("defaultStack")},results={
			@Result(name="success",type="json") 
	})
	public String addFile() {
		goodsItemService.addNewGoodsItem(goodsItem,file,fileFileName);
	}*/
	
}
