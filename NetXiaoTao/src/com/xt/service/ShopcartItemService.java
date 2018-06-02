package com.xt.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.dao.GoodsItemDao;
import com.xt.dao.ShopcartItemDao;
import com.xt.entity.Cartdet;
import com.xt.entity.Goods;
import com.xt.entity.GoodsImg;
import com.xt.entity.Shopcart;



@Transactional
@Service
public class ShopcartItemService {

	@Autowired
	private ShopcartItemDao shopcartItemDao;

	
	public List<Object> findShopcartItemForPage(int pageSize,int page){
		return shopcartItemDao.findShopcartItemForPage(pageSize,page);
	}
	
	public List<Object> findShopcartItemByUseridForPage(String userid ,int pageSize,int page){
		return shopcartItemDao.findShopcartItemByUseridForPage(userid,pageSize,page);
	}
	
	/*public Goods findGoodsItemById(Long id){
		return goodsItemDao.findGoodsItemById(id);
	}*/
	public boolean removeShopcartItem(Shopcart sc){
		shopcartItemDao.removeShopcartItem(sc);
		return true;
	}
	public boolean addNewShopcartItem(Shopcart sc){
		if(shopcartItemDao.findMaxIdShopcartItem()==null){
			sc.getC().setCartid((long)1);
			sc.setId((long)1);
		}else{
		sc.setId(shopcartItemDao.findMaxIdShopcartItem().getId()+1);
		sc.getC().setCartid(shopcartItemDao.findMaxIdShopcartItem().getId()+1);
}
		shopcartItemDao.addNewShopcartItem(sc);
		return true;
	}
	
	public Shopcart findMaxIdShopcartItem(){
		return shopcartItemDao.findMaxIdShopcartItem();
	}
	
	public boolean updateCartdet(Cartdet c){
		shopcartItemDao.updateCartdet(c);
		return true;
	}
	
	public Cartdet findCartdetByGoodsId(String goodsId){
		return shopcartItemDao.findCartdetByGoodsId(goodsId);
	}
	
	public Shopcart findShopcartByGoodsId(String goodsId){
		return shopcartItemDao.findShopcartByGoodsId(goodsId);
	}
	
	public boolean removeCartdet(Cartdet c){
		shopcartItemDao.removeCartdet(c);
		return true;
	}
}
