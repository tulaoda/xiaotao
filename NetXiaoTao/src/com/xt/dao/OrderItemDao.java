package com.xt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xt.entity.Cartdet;
import com.xt.entity.Order;
import com.xt.entity.OrderMessage;
import com.xt.entity.Shopcart;


@Repository
public class OrderItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addNewOrderByShopCart(Order orderItem){
		sessionFactory.getCurrentSession().save(orderItem);
	}
	
	public List<Object> findAllMyOrderForPage(String userid,int pageSize,int page){
		String hql="from Order o,Goods g,User u,OrderMessage om where o.userid=? and  o.id=om.orderId and om.goodsId=g.id and g.userid=u.userid";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userid).setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize);
		return query.list();
	}

	/*public List findAllOrder() {
		String hql="from OrderItem o,GoodsItem g where o.goods_id=g.id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}*/
	
	public Order findMaxIdOrderItem(){
		String hql = "from Order where id=(select max(id) from Order) ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Order orderItem=(Order) query.uniqueResult();
		return orderItem;
	}
	
}
