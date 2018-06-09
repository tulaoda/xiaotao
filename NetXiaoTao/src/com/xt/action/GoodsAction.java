package com.xt.action;

import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
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
import com.xt.entity.Goods;
import com.xt.entity.User;
import com.xt.entity.Wannas;
import com.xt.service.GoodsItemService;

@Namespace("/goods")
@ParentPackage("json-default")
@Controller
public class GoodsAction extends BaseAction {

	private List<File> file;
	private List<String> fileFileName;
	private String code;
	private List<Goods> data;
	private int count;
	private int pageSize;
	private int page;
	public Goods goodsItem;
	private Long state;
	@Autowired
	private GoodsItemService goodsItemService;
	private List<Object> datas;
	private List<User> users = new ArrayList<User>();
	private List<Goods> goods = new ArrayList<Goods>();

	@Action(value = "findAllGoodsItem", results = { @Result(name = "success", type = "json") })
	public String findAllGoodsItem() {
		data = goodsItemService.findGoodsItemForPage(pageSize, page);
		if (data != null) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "findAllGoodsItemByL_class", results = { @Result(name = "success", type = "json") })
	public String findAllGoodsItemByL_class() {
		data = goodsItemService.findGoodsItemByL_classForPage(
				goodsItem.getL_class(), pageSize, page);
		if (data != null) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "findGoodsItemByUseridForPage", results = { @Result(name = "success", type = "json") })
	public String findGoodsItemByUseridForPage() {
		datas = goodsItemService.findGoodsItemByUseridForPage(
				goodsItem.getUserid(), pageSize, page);
		if (datas != null) {
			Iterator it = datas.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				goods.add((Goods) obj[0]);
				users.add((User) obj[1]);
			}
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "findLikeGoodsItem", results = { @Result(name = "success", type = "json") })
	public String findLikeGoodsItem() throws UnsupportedEncodingException {
		data = goodsItemService.findLikeGoodsItemForPage(
				goodsItem.getContent(), pageSize, page);
		if (data != null) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "findGoodsItemById", results = { @Result(name = "success", type = "json") })
	public String findGoodsItemById() {
		goodsItem = goodsItemService.findGoodsItemById(goodsItem.getId());
		if (goodsItem != null) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}


	@Action(value = "removeGoodsItem", results = { @Result(name = "success", type = "json") })
	public String removeGoodsItem() {
		boolean flag = goodsItemService.removeGoodsItem(goodsItemService.findGoodsItemById(goodsItem.getId()));
		if (flag) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}
	@Action(value = "modifyStock", results = { @Result(name = "success", type = "json")})
	public String modifyStock() {
		goodsItem.setStock(goodsItemService.findGoodsItemById(goodsItem.getId()).getStock()+count);
		if (goodsItemService.updateGoodsItem(goodsItem)) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}
	
	@Action(value = "modifyGoodsItemState", results = { @Result(name = "success", type = "json")})
	public String modifyGoodsItemState() {
		goodsItem = goodsItemService.findGoodsItemById(goodsItem.getId());
		goodsItem.setState(state);
		if (goodsItemService.updateGoodsItem(goodsItem)) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}
	@Action(value = "addNewGoodsItem", results = { @Result(name = "success", type = "json") })
	public String addNewGoodsItem() {
		boolean flag = goodsItemService.addNewGoodsItem(goodsItem, file,
				fileFileName);
		if (flag) {
			code = "1";
			data = new ArrayList<>();
			data.add(goodsItemService.findMaxIdGoodsItem());
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	/*
	 * @Action(value = "addFileAction",params={"savePath","/upload"},
	 * interceptorRefs
	 * ={@InterceptorRef(value="fileUpload",params={"allowedTypes"
	 * ,"image/pjpeg, image/gif,image/x-png","maximumSize","1024000000"}),
	 * 
	 * @InterceptorRef("defaultStack")},results={
	 * 
	 * @Result(name="success",type="json") }) public String addFile() {
	 * goodsItemService.addNewGoodsItem(goodsItem,file,fileFileName); }
	 */
	public String getCode() {
		return code;
	}

	public List<Goods> getData() {
		return data;
	}

	public void setGoodsItem(Goods goodsItem) {
		this.goodsItem = goodsItem;
	}

	public GoodsItemService getGoodsItemService() {
		return goodsItemService;
	}

	public void setGoodsItemService(GoodsItemService goodsItemService) {
		this.goodsItemService = goodsItemService;
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

	public void setData(List<Goods> data) {
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

	public List<Object> getDatas() {
		return datas;
	}

	public void setDatas(List<Object> datas) {
		this.datas = datas;
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

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

}
