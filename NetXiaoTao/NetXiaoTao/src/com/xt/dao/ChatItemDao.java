package com.xt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xt.entity.Chat;
import com.xt.entity.Wannas;


@Repository
public class ChatItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Chat> findAllMyChatItem(Long s_userid,Long r_userid){
		String hql="from Chat c where c.r_userid=? and c.r_userid in(select r_userid from t_chat where s_userid=?)";
		return sessionFactory.getCurrentSession().createQuery(hql).setLong(0, r_userid).setLong(1, s_userid).list();
	}
	
	public void removeWannasItem(Wannas wannas){
		sessionFactory.getCurrentSession().delete(wannas);
	}
	

	public List<Chat> findAllMyChatItemForPage(Long s_userid,Long r_userid,int pageSize,int page){
		String hql="from Chat c where c.r_userid=? and c.r_userid in(select r_userid from t_chat where s_userid=?)";
		return	sessionFactory.getCurrentSession().createQuery(hql).setLong(0, r_userid).setLong(1, s_userid)
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
