package com.xt.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.util.Utils;
import com.mysql.jdbc.Util;
import com.xt.dao.WannasItemDao;
import com.xt.entity.WannaImg;
import com.xt.entity.Wannas;



@Transactional
@Service
public class WannasItemService {

	@Autowired
	private WannasItemDao wannasItemDao;

	public List<Wannas> findAllWannasItem(){
		return wannasItemDao.findAllWannasItem();
	}
	
	public List<Object> findWannasItemForPage(int pageSize,int page){
		return wannasItemDao.findWannasItemForPage(pageSize,page);
	}
	
	
	public Wannas findWannasItemById(Long id ){
		return wannasItemDao.findWannasItemById(id);
	}
	
	public boolean removeWannasItem(Wannas wannas){
		wannasItemDao.removeWannasItem(wannas);
		return true;
	}
	public boolean addNewWannasItem(Wannas wannas,List<File> file,List<String> fileFileName){
		try {
			int i=0;
			for(File f:file){
			FileUtils.copyFile(f, new File("/home/wwwroot/default/web/imgSource",fileFileName.get(i)));
			i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
		List <WannaImg>WannaImgs=new ArrayList<WannaImg>();
		for(String fn:fileFileName){
			WannaImg wannaImg=new WannaImg();
			wannaImg.setImage("http://192.168.0.16:8080/thunderDownload/"+fn);
			if(wannasItemDao.findMaxIdWannasItem()==null){
				wannaImg.setWannaid((long) 1);
				wannas.setId((long) 1);
			}else{
			wannaImg.setWannaid(wannasItemDao.findMaxIdWannasItem().getId()+1);
			wannas.setId(wannasItemDao.findMaxIdWannasItem().getId()+1);
			}
			WannaImgs.add(wannaImg);
			wannas.setCreatetime(new Timestamp(System.currentTimeMillis()));
		    wannas.setWannaImg(WannaImgs);
		}
		}
		wannasItemDao.addNewWannasItem(wannas);
		return true;
	}
	
	public Wannas findMaxIdWannasItem(){
		return wannasItemDao.findMaxIdWannasItem();
	}
	
}
