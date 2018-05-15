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
import com.xt.entity.Goods;
import com.xt.entity.GoodsImg;



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
	public boolean addNewGoodsItem(Goods goods,List<File> file,List<String> fileFileName){
		try {
			System.out.println(file.size());
			System.out.println(fileFileName.size());
			int i=0;
			for(File f:file){
			FileUtils.copyFile(f, new File("D://thunderDownload",fileFileName.get(i)));
			i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
		List <GoodsImg>GoodsImgs=new ArrayList<GoodsImg>();
		for(String fn:fileFileName){
			GoodsImg goodsImg=new GoodsImg();
			goodsImg.setImage("http://192.168.0.16:8080/thunderDownload/"+fn);
			goodsImg.setGoodsid(goodsItemDao.findMaxIdGoodsItem().getId()+1);
			GoodsImgs.add(goodsImg);
			/*if(goodsItemDao.findMaxIdGoodsItem()==null){
				goods.setId((long) 1);
			}
			goods.setId(goodsItemDao.findMaxIdGoodsItem().getId()+1);*/
		    goods.setGoodsImg(GoodsImgs);
		}
		}
		goodsItemDao.addNewGoodsItem(goods);
		return true;
	}
	
	public Goods findMaxIdGoodsItem(){
		return goodsItemDao.findMaxIdGoodsItem();
	}
	
}
