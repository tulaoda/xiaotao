package com.xt.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<Wannas> findWannasItemForPage(int pageSize,int page){
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
			FileUtils.copyFile(f, new File("D://thunderDownload",fileFileName.get(i)));
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
			}else{
			wannaImg.setWannaid(wannasItemDao.findMaxIdWannasItem().getId()+1);
			}
			WannaImgs.add(wannaImg);
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
