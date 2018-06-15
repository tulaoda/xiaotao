package com.xt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xt.entity.Attention;
import com.xt.entity.Collection;
import com.xt.entity.Proxy;
import com.xt.entity.Wannas;


@Repository
public class ProxyDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	public Proxy findProxyById(Long id){
		String hql="from Proxy where id=?";
		return (Proxy) sessionFactory.getCurrentSession().createQuery(hql).setLong(0, id).uniqueResult();
	}
	
	public List<Object> findAllMyProxyForPage(String userid,int pageSize,int page){
		String hql="from Proxy p,Goods g where p.userid=? and p.goodsId=g.id";
		return	sessionFactory.getCurrentSession().createQuery(hql)
		.setString(0, userid)
		.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize).list(); 
		
	}
	
	public void addNewProxy(Proxy p){
		sessionFactory.getCurrentSession().save(p);
	}
	
	public void RemoveProxy(Proxy p){
		sessionFactory.getCurrentSession().save(p);
	}
	public Proxy findMaxIdProxy(){
		String hql = "from Proxy where id=(select max(id) from Proxy)";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Proxy p=(Proxy) query.uniqueResult();
		return p;
	}
	
}
