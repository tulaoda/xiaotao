package com.xt.action;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xt.base.BaseAction;
import com.xt.entity.Wannas;
import com.xt.service.WannasItemService;

@Namespace("/wannas")
@ParentPackage("json-default")
@Controller
public class WannasAction extends BaseAction{
	
	private List<File> file;
	private List<String> fileFileName;
	private String code;
	private List<Wannas> data;
	private int pageSize;
	private int page;
	public Wannas wannasItem;
	@Autowired
	private WannasItemService wannasItemService;
	
	
	@Action(value="findAllWannasItem",results={
			@Result(name="success",type="json")
	})
	public String findAllWannasItem(){
		data=wannasItemService.findWannasItemForPage(pageSize,page);
		if(data!=null){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="findWannasItemById",results={
			@Result(name="success",type="json")
	})
	
	public String findWannasItemById(){
		wannasItem=wannasItemService.findWannasItemById(wannasItem.getId());
		if(wannasItem!=null){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="removeWannasItem",results={
			@Result(name="success",type="json")
	})
	public String removeGoodsItem(){
		boolean flag=wannasItemService.removeWannasItem(wannasItem);
		if(flag){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="addNewWannasItem",results={
			@Result(name="success",type="json")
	})
	public String addNewWannasItem(){
		boolean flag=wannasItemService.addNewWannasItem(wannasItem,file,fileFileName);
		if(flag){
			code="1";
			data=new ArrayList<>();
			data.add(wannasItemService.findMaxIdWannasItem());
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


	public List<Wannas> getData() {
		return data;
	}

	public void setWannasItem(Wannas wannasItem) {
		this.wannasItem = wannasItem;
	}

	
	public WannasItemService getWannasItemService() {
		return wannasItemService;
	}

	public void setWannasItemService(WannasItemService wannasItemService) {
		this.wannasItemService = wannasItemService;
	}

	public Wannas getWannasItem() {
		return wannasItem;
	}

	public void setData(List<Wannas> data) {
		this.data = data;
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
	
	
}
