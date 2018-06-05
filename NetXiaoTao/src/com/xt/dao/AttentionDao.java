package com.xt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xt.entity.Attention;
import com.xt.entity.Collection;
import com.xt.entity.Wannas;


@Repository
public class AttentionDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	public Attention findAttentionById(Long id){
		String hql="from Attention where id=? and state=1";
		return (Attention) sessionFactory.getCurrentSession().createQuery(hql).setLong(0, id).uniqueResult();
	}
	
	public Attention findAttentionByTwoId(String a_userid,String t_userid){
		String hql="from Attention where a_userid=? and String t_userid";
		return (Attention) sessionFactory.getCurrentSession().createQuery(hql).setString(0, a_userid).setString(1, t_userid).uniqueResult();
	}
	public void cancelAttention(Attention a){
		sessionFactory.getCurrentSession().update(a);
	}
	

	public List<Object> findAllMyAttentionForPage(String t_userid,int pageSize,int page){
		String hql="from Attention a,User u where a.t_userid=? and a.a_userid=u.userid and state=1";
		return	sessionFactory.getCurrentSession().createQuery(hql)
		.setString(0, t_userid)
		.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize).list(); 
		
	}
	
	public void addNewAttention(Attention a){
		sessionFactory.getCurrentSession().save(a);
	}
	
	public Attention findMaxIdAttention(){
		String hql = "from Attention where id=(select max(id) from Attention where state=1) and state=1";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Attention a=(Attention) query.uniqueResult();
		return a;
	}
	
}
