package com.xt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xt.entity.Wannas;


@Repository
public class WannasItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Wannas> findAllWannasItem(){
		String hql="from Wannas";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	
	public Wannas findWannasItemById(Long id){
		String hql="from Wannas where id=?";
		return (Wannas) sessionFactory.getCurrentSession().createQuery(hql).setLong(0, id).uniqueResult();
	}
	
	public void removeWannasItem(Wannas wannas){
		sessionFactory.getCurrentSession().delete(wannas);
	}
	

	public List<Wannas> findWannasItemForPage(int pageSize,int page){
		String hql="from Wannas";
		return	sessionFactory.getCurrentSession().createQuery(hql)
		.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize)
		.setMaxResults(pageSize).list(); 
		
	}
	
	public void addNewWannasItem(Wannas wannas){
		sessionFactory.getCurrentSession().save(wannas);
	}
	
	public Wannas findMaxIdWannasItem(){
		String hql = "from Wannas where id=(select max(id) from Wannas) ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Wannas wannasItem=(Wannas) query.uniqueResult();
		return wannasItem;
	}
	
}
