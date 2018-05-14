package com.xt.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.dao.GoodsItemDao;
import com.xt.entity.Goods;



@Transactional
@Service
public class GoodsItemService {

	@Autowired
	private GoodsItemDao goodsItemDao;

	public List<Goods> findAllGoodsItem(){
		return goodsItemDao.findAllGoodsItem();
	}
	
	public List<Goods> findAllGoodsItemByL_class(Long l_class){
		return goodsItemDao.findGoodsItemByL_class(l_class);
	}
	public List<Goods> findGoodsItemForPage(int pageSize,int page){
		return goodsItemDao.findGoodsItemForPage(pageSize,page);
	}
	
	public List<Goods> findGoodsItemByL_classForPage(Long l_class ,int pageSize,int page){
		return goodsItemDao.findGoodsItemByL_classForPage(l_class,pageSize,page);
	}
	
	public boolean removeGoodsItem(Goods goods){
		goodsItemDao.removeGoodsItem(goods);
		return true;
	}
	/*
	public boolean addNewGoodsItem(Goods goods,File file,String fileFileName){
		try {
			FileUtils.copyFile(file, new File("D://thunderDownload",fileFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		goods.setImg("http://192.168.43.129:8080/thunderDownload/"+fileFileName);
		goodsItemDao.addNewGoodsItem(goods);
		return true;
	}
	*/
	public Goods findMaxIdGoodsItem(){
		return goodsItemDao.findMaxIdGoodsItem();
	}
	
}
