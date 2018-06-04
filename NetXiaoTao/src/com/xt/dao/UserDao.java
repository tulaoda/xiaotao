package com.xt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xt.entity.Address;
import com.xt.entity.Chat;
import com.xt.entity.Goods;
import com.xt.entity.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public User login(User user) {
		return (User)sessionFactory.getCurrentSession()
									.createQuery("from User where nickname=? and passwd=?")	
									.setString(0, user.getNickname())
									.setString(1, user.getPasswd())	
									.uniqueResult();	
	}
	
	public void addNewUser(User user){
		sessionFactory.getCurrentSession().save(user);
	}
	
	public int modifyPasswd(User user){
		String hql="update User u set u.passwd =? where userid=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getPasswd());
		query.setString(1, user.getUserid());
		return query.executeUpdate();
	}
	
	public int modifyBalance(User user){
		String hql="update User u set u.balance =? where userid=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setDouble(0, user.getBalance());
		query.setString(1, user.getUserid());
		return query.executeUpdate();
	}
	public int modifyUserBaseInfo(User user){
		String hql="update User u set u.nickname =? u.school=? u.photo=? where userid=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getNickname());
		query.setString(1, user.getSchool());
		query.setString(2, user.getPhoto());
		query.setString(3, user.getUserid());
		return query.executeUpdate();
	}
	
	
	public boolean exits(User user){
		User u=(User) sessionFactory.getCurrentSession()
		.createQuery("from User where nickname=? ")	
		.setString(0, user.getNickname())
		.uniqueResult();	
		return u!=null?true:false;
	}
	
	public User validateNickname(User user){
		return (User)sessionFactory.getCurrentSession()
		.createQuery("from User where nickname=? ")	
		.setString(0, user.getNickname())
		.uniqueResult();	
	}
	
	public List<Object> findUserAndGoods(int pageSize,int page){
		String hql="from User u,Goods g where u.userid=g.userid";
		return	sessionFactory.getCurrentSession().createQuery(hql)
				.setFirstResult((page-1)*pageSize)
				.setMaxResults(pageSize).list(); 
		
	}
	
	public User findUserByUserid(String userid){
		String hql="from User where userid=?";
		return	(User) sessionFactory.getCurrentSession().createQuery(hql)
				.setString(0, userid).uniqueResult(); 
		
	}
	
	public boolean updateAddress(User user){
		sessionFactory.getCurrentSession().update(user);
		return true;
	}
	
	public Address findAddressById(Long id){
		String hql="from Address where id=?";
		return	(Address) sessionFactory.getCurrentSession().createQuery(hql)
				.setLong(0, id).uniqueResult(); 
	}
	
	public void removeAddress(Address a){
		sessionFactory.getCurrentSession().delete(a);
	}
}
