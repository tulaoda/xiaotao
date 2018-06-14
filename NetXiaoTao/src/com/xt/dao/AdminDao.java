package com.xt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xt.entity.Address;
import com.xt.entity.Admin;
import com.xt.entity.Bill;
import com.xt.entity.Chat;
import com.xt.entity.Goods;
import com.xt.entity.RechargeOrder;
import com.xt.entity.User;

@Repository
public class AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Admin login(Admin admin) {
		return (Admin)sessionFactory.getCurrentSession()
									.createQuery("from Admin where username=? and password=?")	
									.setString(0, admin.getUsername())
									.setString(1, admin.getPassword())	
									.uniqueResult();	
	}
	
	public void addNewAdmin(Admin admin){
		sessionFactory.getCurrentSession().save(admin);
	}
	
	public int modifyPasswd(Admin admin){
		String hql="update Admin a set a.password =? where username=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, admin.getPassword());
		query.setString(1, admin.getUsername());
		return query.executeUpdate();
	}
	
	
	public boolean exits(Admin admin){
		User u=(User) sessionFactory.getCurrentSession()
		.createQuery("from Admin where username=? ")	
		.setString(0, admin.getUsername())
		.uniqueResult();	
		return u!=null?true:false;
	}
	
	public Admin validateNickname(Admin admin){
		return (Admin)sessionFactory.getCurrentSession()
		.createQuery("from Admin where username=? ")	
		.setString(0, admin.getUsername())
		.uniqueResult();	
	}
	
	public List<User> findAllUser(int pageSize,int page){
		return (List<User>)sessionFactory.getCurrentSession()
		.createQuery("from User").setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize).list();	
	}
}
