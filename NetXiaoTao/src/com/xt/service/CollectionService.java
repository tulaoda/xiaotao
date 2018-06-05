package com.xt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.dao.CollectionDao;
import com.xt.dao.WannasItemDao;
import com.xt.entity.Collection;
import com.xt.entity.WannaImg;
import com.xt.entity.Wannas;



@Transactional
@Service
public class CollectionService {

	@Autowired
	private CollectionDao collectionDao;

	public List<Object> findAllMyCollection(String userid){
		return collectionDao.findAllMyCollection(userid);
	}
	
	public List<Object> findAllMyCollectionForPage(String userid,int pageSize,int page){
		return collectionDao.findAllMyCollectionForPage(userid,pageSize,page);
	}
	
	
	public Collection findCollectionById(Long id ){
		return collectionDao.findCollectionById(id);
	}
	
	public boolean removeCollection(Collection c){
		collectionDao.removeCollection(c);
		return true;
	}
	public boolean addNewCollection(Collection c){
		collectionDao.addNewCollection(c);
		return true;
	}
	
	public Collection findMaxIdCollection(){
		return collectionDao.findMaxIdCollection();
	}
	
}
