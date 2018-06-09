package com.xt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xt.entity.Goods;


@Repository
public class GoodsItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Goods> findAllGoodsItem(){
		String hql="from Goods where state=1";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	public List<Goods> findGoodsItemByL_class(Long l_class){
		String hql="from Goods where l_class=? and state=1";
		return sessionFactory.getCurrentSession().createQuery(hql).setLong(0, l_class).list();
	}
	
	public Goods findGoodsItemById(Long id){
		String hql="from Goods where id=? and state=1";
		return (Goods) sessionFactory.getCurrentSession().createQuery(hql).setLong(0, id).uniqueResult();
	}
	
	public void removeGoodsItem(Goods goods){
		sessionFactory.getCurrentSession().delete(goods);
	}
	public void updateGoodsItem(Goods goods){
		sessionFactory.getCurrentSession().update(goods);
	}
	@SuppressWarnings("unchecked")
	public List<Goods> findGoodsItemByL_classForPage(Long l_class ,int pageSize,int page){
		String hql="from Goods where l_class=? and state=1";
		return	sessionFactory.getCurrentSession().createQuery(hql)
		.setLong(0, l_class)
		.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize).list(); 
		
	}
	public List<Object> findGoodsItemByUseridForPage(String userid ,int pageSize,int page){
		String hql="from Goods g,User u where g.userid=u.userid and u.userid=? and g.state=1";
		return	sessionFactory.getCurrentSession().createQuery(hql)
		.setString(0, userid)
		.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize).list(); 
		
	}
	public List<Goods> findGoodsItemForPage(int pageSize,int page){
		String hql="from Goods where state=1";
		return	sessionFactory.getCurrentSession().createQuery(hql)
		.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize).list(); 
		
	}
	
	public void addNewGoodsItem(Goods goods){
		sessionFactory.getCurrentSession().save(goods);
	}
	
	public Goods findMaxIdGoodsItem(){
		String hql = "from Goods where id=(select max(id) from Goods where state=1) ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Goods goodsItem=(Goods) query.uniqueResult();
		return goodsItem;
	}
	
	public List<Goods> findLikeGoodsItemForPage(String content,int pageSize,int page){
		String hql = "from Goods as g where g.content like :content and g.state=1";  
		return sessionFactory.getCurrentSession().createQuery(hql).setString("content","%"+content+"%")
				.setFirstResult((page-1)*pageSize)
				.setMaxResults(pageSize).list();
		
	}
}
