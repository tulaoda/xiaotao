package com.xt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.dao.CollectionDao;
import com.xt.dao.ProxyDao;
import com.xt.dao.WannasItemDao;
import com.xt.entity.Collection;
import com.xt.entity.Proxy;
import com.xt.entity.WannaImg;
import com.xt.entity.Wannas;



@Transactional
@Service
public class ProxyService {

	@Autowired
	private ProxyDao proxyDao;

	public List<Object> findAllMyProxyForPage(String userid,int pageSize,int page){
		return proxyDao.findAllMyProxyForPage(userid,pageSize,page);
	}
	
	
	public Proxy findProxyById(Long id){
		return proxyDao.findProxyById(id);
	}
	
	public boolean RemoveProxy(Proxy p){
		proxyDao.RemoveProxy(p);
		return true;
	}
	public boolean addNewProxy(Proxy p){
		proxyDao.addNewProxy(p);
		return true;
	}
	
	public Proxy findMaxIdProxy(){
		return proxyDao.findMaxIdProxy();
	}
	
}
