package com.xt.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xt.base.BaseAction;
import com.xt.dao.GoodsItemDao;
import com.xt.entity.Goods;
import com.xt.entity.Order;
import com.xt.entity.OrderMessage;
import com.xt.entity.Shopcart;
import com.xt.entity.User;
import com.xt.service.GoodsItemService;
import com.xt.service.OrderItemService;
import com.xt.service.ShopcartItemService;

@Namespace("/order")
@ParentPackage("json-default")
@Controller
public class OrderAction extends BaseAction{
	
	private String code;
	private int pageSize;
	private int page;
	private List<Object> data;
	private List<User> users=new ArrayList<User>();
	private List<Goods> goods=new ArrayList<Goods>();
	private List<Order> orders=new ArrayList<Order>();
	private User user;
	private String goodsids;
	private String counts;
	private long goodsid;
	private long count;
	private String receiver;
	private String phone;
	private String area;
	private String address;
	private String postalcode;
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private GoodsItemService goodsItemService;
	
	@Autowired
	private ShopcartItemService shopcartItemService;
	@Action(value="addNewOrderByShopCart",results={
			@Result(name="success",type="json")
	})
	public String addNewOrderByShopCart(){
		Order order=new Order();
		List<OrderMessage> list=new ArrayList<OrderMessage>();
		OrderMessage orderMessage=null;
		String[] goodsIds = goodsids.split(","); 
		String[] Counts = counts.split(",");
		boolean flag1=true;
		for (int i = 0; i < goodsIds.length; i++) { 
		Goods g=goodsItemService.findGoodsItemById(Long.parseLong(goodsIds[i]));
		if(flag1){
		if(g.getStock()-Long.parseLong(Counts[i])<0){
			flag1=false;
		}
		}
		}
		if(flag1){
		if(orderItemService.findMaxIdOrderItem()==null){
			order.setId((long) 1);
		}else{
		order.setId(orderItemService.findMaxIdOrderItem().getId()+1);
		}
		order.setUserid(user.getUserid());
		order.setState((long) 0);
		order.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		for (int i = 0; i < goodsIds.length; i++) { 
			orderMessage=new OrderMessage();
			orderMessage.setOrderId(order.getId());
			orderMessage.setGoodsId(goodsIds[i]);
			orderMessage.setCount( Long.parseLong(Counts[i]));
			orderMessage.setReceiver(receiver);
			orderMessage.setPhone(phone);
			orderMessage.setArea(area);
			orderMessage.setAddress(address);
			orderMessage.setPostalcode(postalcode);
			list.add(orderMessage);
		}
		order.setOrderMessage(list);
		boolean flag=orderItemService.addNewOrderByShopCart(order);
		if(flag){
			code="1";
			for (int i = 0; i < goodsIds.length; i++) { 
				Goods g=goodsItemService.findGoodsItemById(Long.parseLong(goodsIds[i]));
				g.setStock(g.getStock()-Long.parseLong(Counts[i]));
				goodsItemService.updateGoodsItem(g);
				shopcartItemService.removeCartdet(shopcartItemService.findCartdetByGoodsId(goodsIds[i])) ;
			}
			
			data=new ArrayList<>();
			data.add(orderItemService.findMaxIdOrderItem());
		}else{
			code="0";
		}
		}else{
			code="0";
		}
			
		return SUCCESS;
	}
	
	@Action(value="addNewOrder",results={
			@Result(name="success",type="json")
	})
	public String addNewOrder(){
		Order order=new Order();
		List<OrderMessage> list=new ArrayList<OrderMessage>();
		OrderMessage orderMessage=null;
		boolean flag1=true;
		Goods g=goodsItemService.findGoodsItemById(goodsid);
		if(g.getStock()-count<0){
			flag1=false;
		}
		if(flag1){
		if(orderItemService.findMaxIdOrderItem()==null){
			order.setId((long) 1);
		}else{
		order.setId(orderItemService.findMaxIdOrderItem().getId()+1);
		}
		order.setUserid(user.getUserid());
		order.setState((long) 0);
		order.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderMessage=new OrderMessage();
			orderMessage.setOrderId(order.getId());
			orderMessage.setGoodsId(String.valueOf(goodsid));
			orderMessage.setCount(count);
			orderMessage.setReceiver(receiver);
			orderMessage.setPhone(phone);
			orderMessage.setArea(area);
			orderMessage.setAddress(address);
			orderMessage.setPostalcode(postalcode);
			list.add(orderMessage);
		order.setOrderMessage(list);
		boolean flag=orderItemService.addNewOrderByShopCart(order);
		if(flag){
			code="1";
				g=goodsItemService.findGoodsItemById(goodsid);
				g.setStock(g.getStock()-count);
				goodsItemService.updateGoodsItem(g);
			data=new ArrayList<>();
			data.add(orderItemService.findMaxIdOrderItem());
		}else{
			code="0";
		}
		}else{
			code="0";
		}
			
		return SUCCESS;
	}

	
	@Action(value="findAllMyOrder",results={
			@Result(name="success",type="json")
	})
	public String findAllMyOrder(){
		data=orderItemService.findAllMyOrderForPage(user.getUserid(), pageSize, page);
		if(data!=null){
			Iterator it=data.iterator();
			while(it.hasNext()){
			Object[]obj=(Object[])it.next();
			orders.add((Order) obj[0]);
			goods.add((Goods) obj[1]);
			users.add((User) obj[2]);
			}
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	/*@Action(value="findAllOrder",results={
			@Result(name="success",type="json")
	})
	public String findAllOrder(){
		data=orderItemService.findAllOrder(pageSize,page);
		if(data!=null){
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}*/

	
	public String getCode() {
		return code;
	}


	public List<Object> getData() {
		return data;
	}


	public void setData(List<Object> data) {
		this.data = data;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Goods> getGoods() {
		return goods;
	}


	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}



	public String getGoodsids() {
		return goodsids;
	}



	public void setGoodsids(String goodsids) {
		this.goodsids = goodsids;
	}



	public String getCounts() {
		return counts;
	}



	public void setCounts(String counts) {
		this.counts = counts;
	}



	public String getReceiver() {
		return receiver;
	}



	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPostalcode() {
		return postalcode;
	}



	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}



	public OrderItemService getOrderItemService() {
		return orderItemService;
	}



	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	public long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(long goodsid) {
		this.goodsid = goodsid;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

}
