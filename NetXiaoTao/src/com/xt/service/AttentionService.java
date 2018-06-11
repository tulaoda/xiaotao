package com.xt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.dao.AttentionDao;
import com.xt.dao.CollectionDao;
import com.xt.dao.WannasItemDao;
import com.xt.entity.Attention;
import com.xt.entity.Collection;
import com.xt.entity.WannaImg;
import com.xt.entity.Wannas;



@Transactional
@Service
public class AttentionService {

	@Autowired
	private AttentionDao attentionDao;

	public List<Object> findAllMyAttentionForPage(String a_userid,int pageSize,int page){
		return attentionDao.findAllMyAttentionForPage(a_userid,pageSize,page);
	}
	
	public List<Object> findAllOfMyAttentionForPage(String t_userid,int pageSize,int page){
		return attentionDao.findAllOfMyAttentionForPage(t_userid,pageSize,page);
	}
	
	public Attention findAttentionById(Long id){
		return attentionDao.findAttentionById(id);
	}
	
	public Attention findAttentionByTwoId(String a_userid,String t_userid){
		return attentionDao.findAttentionByTwoId(a_userid,t_userid);
	}
	public boolean updateAttentionState(Attention a){
		attentionDao.updateAttentionState(a);
		return true;
	}
	public boolean addNewAttention(Attention a){
		attentionDao.addNewAttention(a);
		return true;
	}
	
	public Attention findMaxIdAttention(){
		return attentionDao.findMaxIdAttention();
	}
	
}
