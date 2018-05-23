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
		String hql="from Goods";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	public List<Goods> findGoodsItemByL_class(Long l_class){
		String hql="from Goods where l_class=?";
		return sessionFactory.getCurrentSession().createQuery(hql).setLong(0, l_class).list();
	}
	
	public Goods findGoodsItemById(Long id){
		String hql="from Goods where id=?";
		return (Goods) sessionFactory.getCurrentSession().createQuery(hql).setLong(0, id).uniqueResult();
	}
	
	public void removeGoodsItem(Goods goods){
		sessionFactory.getCurrentSession().delete(goods);
	}
	
	public List<Goods> findGoodsItemByL_classForPage(Long l_class ,int pageSize,int page){
		String hql="from Goods where l_class=?";
		return	sessionFactory.getCurrentSession().createQuery(hql)
		.setLong(0, l_class)
		.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize).list(); 
		
	}
	public List<Goods> findGoodsItemForPage(int pageSize,int page){
		String hql="from Goods";
		return	sessionFactory.getCurrentSession().createQuery(hql)
		.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize).list(); 
		
	}
	
	public void addNewGoodsItem(Goods goods){
		sessionFactory.getCurrentSession().save(goods);
	}
	
	public Goods findMaxIdGoodsItem(){
		String hql = "from Goods where id=(select max(id) from Goods) ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Goods goodsItem=(Goods) query.uniqueResult();
		return goodsItem;
	}
	
	public List<Goods> findLikeGoodsItemForPage(String content,int pageSize,int page){
		String hql = "from Goods as g where g.content like :content";  
		return sessionFactory.getCurrentSession().createQuery(hql).setString("content","%"+content+"%")
				.setFirstResult((page-1)*pageSize)
				.setMaxResults(pageSize).list();
		
	}
}
