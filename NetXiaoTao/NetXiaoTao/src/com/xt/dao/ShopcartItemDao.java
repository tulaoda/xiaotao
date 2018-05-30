package com.xt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xt.entity.Cartdet;
import com.xt.entity.Goods;
import com.xt.entity.Shopcart;


@Repository
public class ShopcartItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void removeShopcartItem(Shopcart sc){
		sessionFactory.getCurrentSession().delete(sc);
	}
	
	public List<Object> findShopcartItemByUseridForPage(String userid ,int pageSize,int page){
		String hql="from Shopcart sc,Goods g,User u where sc.userid=? and sc.c.goodsid=g.id and g.userid=u.userid";
		return	sessionFactory.getCurrentSession().createQuery(hql)
		.setString(0, userid)
		.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize).list(); 
		
	}
	public List<Object> findShopcartItemForPage(int pageSize,int page){
		String hql="from Shopcart sc,Goods g,User u where sc.c.goodsid=g.id and g.userid=u.userid";
		return	sessionFactory.getCurrentSession().createQuery(hql)
		.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize).list(); 
		
	}
	
	public void addNewShopcartItem(Shopcart sc){
		sessionFactory.getCurrentSession().save(sc);
	}
	
	public Shopcart findMaxIdShopcartItem(){
		String hql = "from Shopcart where id=(select max(id) from Shopcart) ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Shopcart shopcartItem=(Shopcart) query.uniqueResult();
		return shopcartItem;
	}
	
	public void updateCartdet(Cartdet c){
		sessionFactory.getCurrentSession().update(c);
	}
	public Cartdet findCartdetByGoodsId(String goodsId){
		String hql = "from Cartdet where goodsid=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Cartdet cartdet=(Cartdet) query.setString(0, goodsId).uniqueResult();
		return cartdet;
	}
	
	public Shopcart findShopcartByGoodsId(String goodsId){
		String hql = "from Shopcart sc where sc.c.goodsid=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Shopcart shopcart=(Shopcart) query.setString(0, goodsId).uniqueResult();
		return shopcart;
	}
	public void removeCartdet(Cartdet c){
		sessionFactory.getCurrentSession().delete(c);
	}

}
