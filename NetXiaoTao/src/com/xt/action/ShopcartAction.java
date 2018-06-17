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
import com.xt.entity.Cartdet;
import com.xt.entity.Goods;
import com.xt.entity.Shopcart;
import com.xt.entity.User;
import com.xt.service.GoodsItemService;
import com.xt.service.ShopcartItemService;

@Namespace("/shopcart")
@ParentPackage("json-default")
@Controller
public class ShopcartAction extends BaseAction{
	
	private List<File> file;
	private List<String> fileFileName;
	private String code;
	private List<Object> data;
	private int pageSize;
	private int page;
	private User user;
	private Shopcart shopcartItem;
	private Goods goodsItem;
	private List<User> users=new ArrayList<User>();
	private List<Goods> goods=new ArrayList<Goods>();
	private List<Shopcart> shopcarts=new ArrayList<Shopcart>();
	@Autowired
	private ShopcartItemService shopcartItemService;
	
	
	@Action(value="findAllShopcartItem",results={
			@Result(name="success",type="json")
	})
	public String findAllShopcartItem(){
		data=shopcartItemService.findShopcartItemForPage(pageSize,page);
		if(data!=null){
			Iterator it=data.iterator();
			while(it.hasNext()){
			Object[]obj=(Object[])it.next();
			shopcarts.add((Shopcart) obj[0]);
			goods.add((Goods) obj[1]);
			users.add((User) obj[2]);
			}
			code="1";
		}else{
			code="0";	
		}
		return SUCCESS;
	}
	@Action(value="findAllShopcartItemByUserid",results={
			@Result(name="success",type="json")
	})
	
	public String findAllShopcartItemByUserid(){
		data=shopcartItemService.findShopcartItemByUseridForPage(user.getUserid(),pageSize,page);
		if(data!=null){
			Iterator it=data.iterator();
			while(it.hasNext()){
			Object[]obj=(Object[])it.next();
			shopcarts.add((Shopcart) obj[0]);
			goods.add((Goods) obj[1]);
			users.add((User) obj[2]);
			}
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	/*@Action(value="findGoodsItemById",results={
			@Result(name="success",type="json")
	})
	
	public String findGoodsItemById(){
		goodsItem=goodsItemService.findGoodsItemById(goodsItem.getId());
		if(goodsItem!=null){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	*/
	@Action(value="addNewShopcartItem",results={
			@Result(name="success",type="json")
	})
	public String addNewShopcartItem(){
		Shopcart SC=shopcartItemService.findShopcartByGoodsIdAndUserid(shopcartItem.getC().getGoodsid().toString(),shopcartItem.getUserid());
		//Cartdet cc=shopcartItemService.findCartdetByGoodsId(shopcartItem.getC().getGoodsid().toString() );
		if(SC==null){
		boolean flag=shopcartItemService.addNewShopcartItem(shopcartItem);
		if(flag){
			code="1";
			data=new ArrayList<>();
			data.add(shopcartItem);
		}else{
			code="0";
		}
		}else{
			SC.getC().setNum(SC.getC().getNum()+shopcartItem.getC().getNum());
			boolean flag=shopcartItemService.updateCartdet(SC.getC());
			if(flag){
				code="1";
				data=new ArrayList<>();
				data.add(shopcartItem);
			}else{
				code="0";
			}
		}
		return SUCCESS;
	}
	@Action(value="removeShopcartItem",results={
			@Result(name="success",type="json")
	})
	public String removeShopcartItem(){
		boolean flag=shopcartItemService.removeShopcartItem(shopcartItemService.findShopcartByGoodsIdAndUserid(String.valueOf(goodsItem.getId()),user.getUserid()));
		if(flag){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	/*@Action(value = "addFileAction",params={"savePath","/upload"},
			interceptorRefs={@InterceptorRef(value="fileUpload",params={"allowedTypes","image/pjpeg, image/gif,image/x-png","maximumSize","1024000000"}),
			@InterceptorRef("defaultStack")},results={
			@Result(name="success",type="json") 
	})
	public String addFile() {
		goodsItemService.addNewGoodsItem(goodsItem,file,fileFileName);
	}*/
	public String getCode() {
		return code;
	}


	public List<Object> getData() {
		return data;
	}

	public void setGoodsItem(Goods goodsItem) {
		this.goodsItem = goodsItem;
	}

	public List<File> getFile() {
		return file;
	}
	public void setFile(List<File> file) {
		this.file = file;
	}
	public List<String> getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}
	public Goods getGoodsItem() {
		return goodsItem;
	}
	public void setCode(String code) {
		this.code = code;
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
	public Shopcart getShopcartItem() {
		return shopcartItem;
	}
	public void setShopcartItem(Shopcart shopcartItem) {
		this.shopcartItem = shopcartItem;
	}
	public ShopcartItemService getShopcartItemService() {
		return shopcartItemService;
	}
	public void setShopcartItemService(ShopcartItemService shopcartItemService) {
		this.shopcartItemService = shopcartItemService;
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
	public List<Shopcart> getShopcarts() {
		return shopcarts;
	}
	public void setShopcarts(List<Shopcart> shopcarts) {
		this.shopcarts = shopcarts;
	}
	
	
}
