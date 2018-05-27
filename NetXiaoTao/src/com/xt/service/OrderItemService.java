package com.xt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.dao.OrderItemDao;
import com.xt.entity.Goods;
import com.xt.entity.Order;

@Transactional
@Service
public class OrderItemService {
	@Autowired
	private OrderItemDao orderItemDao;

	public boolean addNewOrderByShopCart(Order orderItem) {
		orderItemDao.addNewOrderByShopCart(orderItem);
		return true;
	}

	public List<Object> findAllMyOrderForPage(String userid,int pageSize,int page) {
		return orderItemDao.findAllMyOrderForPage(userid,pageSize,page);

	}
	public Order findMaxIdOrderItem(){
		return orderItemDao.findMaxIdOrderItem();
	}
	
}
