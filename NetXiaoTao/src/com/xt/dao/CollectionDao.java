package com.xt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xt.entity.Collection;
import com.xt.entity.Wannas;


@Repository
public class CollectionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Object> findAllMyCollection(String userid){
		String hql="from Collection c,Goods g where c.userid=? and c.goodsId=g.id and g.state=1";
		return sessionFactory.getCurrentSession().createQuery(hql).setString(0, userid).list();
	}
	
	
	public Collection findCollectionById(Long id){
		String hql="from Collection where id=?";
		return (Collection) sessionFactory.getCurrentSession().createQuery(hql).setLong(0, id).uniqueResult();
	}
	
	public Collection findCollectionByGoodsId(Long goodsid){
		String hql="from Collection where goodsid=?";
		return (Collection) sessionFactory.getCurrentSession().createQuery(hql).setLong(0, goodsid).uniqueResult();
	}
	public void removeCollection(Collection c){
		sessionFactory.getCurrentSession().delete(c);
	}
	

	public List<Object> findAllMyCollectionForPage(String userid,int pageSize,int page){
		String hql="from Collection c,Goods g where c.userid=? and c.goodsid=g.id and g.state=1";
		return	sessionFactory.getCurrentSession().createQuery(hql)
		.setString(0, userid)
		.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize).list(); 
		
	}
	
	
	public void addNewCollection(Collection c){
		sessionFactory.getCurrentSession().save(c);
	}
	
	public Collection findMaxIdCollection(){
		String hql = "from Collection where id=(select max(id) from Collection) ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Collection c=(Collection) query.uniqueResult();
		return c;
	}
	
}
