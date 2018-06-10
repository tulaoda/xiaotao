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
import com.xt.entity.Bill;
import com.xt.entity.Goods;
import com.xt.entity.Order;
import com.xt.entity.OrderMessage;
import com.xt.entity.Shopcart;
import com.xt.entity.User;
import com.xt.service.GoodsItemService;
import com.xt.service.OrderItemService;
import com.xt.service.ShopcartItemService;
import com.xt.service.UserService;

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
	private List<OrderMessage> ordermessages=new ArrayList<OrderMessage>();
	private User user;
	private Order orderItem;
	private OrderMessage orderMessage;
	private String goodsids;
	private String counts;
	private long goodsid;
	private long count;
	private long state;
	private double allprice;
	private String expressnumber;
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private GoodsItemService goodsItemService;
	
	@Autowired
	private ShopcartItemService shopcartItemService;
	
	@Autowired
	private UserService userService;
	@Action(value="addNewOrderByShopCart",results={
			@Result(name="success",type="json")
	})
	public String addNewOrderByShopCart(){
		Order order=new Order();
		List<OrderMessage> list=new ArrayList<OrderMessage>();
		OrderMessage orderMessage=null;
		String[] goodsIds = goodsids.split(","); 
		String[] Counts = counts.split(",");
		if(orderItemService.findMaxIdOrderItem()==null){
			order.setId((long) 1);
		}else{
		order.setId(orderItemService.findMaxIdOrderItem().getId()+1);
		}
		order.setUserid(user.getUserid());
		order.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		for (int i = 0; i < goodsIds.length; i++) { 
			orderMessage=new OrderMessage();
			orderMessage.setOrderId(order.getId());
			orderMessage.setGoodsId(goodsIds[i]);
			orderMessage.setCount( Long.parseLong(Counts[i]));
			orderMessage.setState((long) 0);
			User u=userService.findUserByUserid(user.getUserid());
			orderMessage.setReceiver(u.getAddress().getReceiver());
			orderMessage.setPhone(u.getAddress().getPhone());
			orderMessage.setArea(u.getAddress().getArea());
			orderMessage.setAddress(u.getAddress().getAddress());
			orderMessage.setPostalcode(u.getAddress().getPostalcode());
			list.add(orderMessage);
		}
		order.setOrderMessage(list);
		boolean flag=orderItemService.addNewOrderByShopCart(order);
		if(flag){
			code="1";
			for (int i = 0; i < goodsIds.length; i++) { 
				shopcartItemService.removeShopcartItem(shopcartItemService.findShopcartByGoodsId(goodsIds[i])) ;
			}
			data=new ArrayList<>();
			data.add(orderItemService.findMaxIdOrderItem());
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
		order.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderMessage=new OrderMessage();
			orderMessage.setOrderId(order.getId());
			orderMessage.setGoodsId(String.valueOf(goodsid));
			orderMessage.setCount(count);
			orderMessage.setState((long) 0);
			User u=userService.findUserByUserid(user.getUserid());
			orderMessage.setReceiver(u.getAddress().getReceiver());
			orderMessage.setPhone(u.getAddress().getPhone());
			orderMessage.setArea(u.getAddress().getArea());
			orderMessage.setAddress(u.getAddress().getAddress());
			orderMessage.setPostalcode(u.getAddress().getPostalcode());
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

	@Action(value="UpdateOrderState",results={
			@Result(name="success",type="json")
	})
	public String updateOrderState(){
		List<OrderMessage> list=new ArrayList<OrderMessage>();
		if(orderItemService.findOrderMessageByOrderidAndGoodsid(orderItem.getId(), String.valueOf(goodsid)).get(0)==null){
		list=orderItemService.findOrderMessageByOrderid(orderItem.getId());
		}else{
		list=orderItemService.findOrderMessageByOrderidAndGoodsid(orderItem.getId(), String.valueOf(goodsid));
		}
		OrderMessage orderMessage=null;
		boolean flag1=true;
		for(OrderMessage om:list){
			if(om.getState()==0){
			Goods g=goodsItemService.findGoodsItemById(Long.parseLong(om.getGoodsId()));
			if(flag1){
			if(g.getStock()-om.getCount()<0){
				flag1=false;
			}
			}
			}
		}
		if(flag1){
			double allprice=0.0;
			for(OrderMessage om:list){
				if(state==1){
				om.setState(state);
				om.setPay_time(new Timestamp(System.currentTimeMillis()));
				Goods g=goodsItemService.findGoodsItemById(Long.parseLong(om.getGoodsId()));
				g.setStock(g.getStock()-om.getCount());
				goodsItemService.updateGoodsItem(g);
				user.setBalance(userService.findUserByUserid(user.getUserid()).getBalance()-om.getCount()*goodsItemService.findGoodsItemById(Long.parseLong(om.getGoodsId())).getPrice());
				userService.modifyBalance(user);
			    User u=userService.findUserByUserid(goodsItemService.findGoodsItemById(Long.parseLong(om.getGoodsId())).getUserid());
			    u.setBalance(u.getBalance()+om.getCount()*goodsItemService.findGoodsItemById(Long.parseLong(om.getGoodsId())).getPrice());
				userService.modifyBalance(u);
				allprice+=om.getCount()*goodsItemService.findGoodsItemById(Long.parseLong(om.getGoodsId())).getPrice();
				Bill bill=new Bill();
				bill.setPrice(allprice);
				bill.setState((long) 0);
				bill.setCreatetime(new Timestamp(System.currentTimeMillis()));
				bill.setUserid(u.getUserid());
				userService.addBill(bill);
				}
				orderItemService.updateOrderItemState(om);
				
			}
			Bill b=new Bill();
			b.setCreatetime(new Timestamp(System.currentTimeMillis()));
			b.setPrice(-allprice);
			b.setState((long) 1);
			b.setUserid(user.getUserid());
			userService.addBill(b);
			for(OrderMessage om:list){
		    if(state==2){
			om.setState(state);
			om.setExpressnumber(expressnumber);
		    }else if(state>2){
				om.setState(state);
			}
		    orderItemService.updateOrderItemState(om);
			}
			code="1";
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
			ordermessages.add((OrderMessage) obj[3]);
			}
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	
	@Action(value="findAllMyOrderByState",results={
			@Result(name="success",type="json")
	})
	public String findAllMyOrderByState(){
		data=orderItemService.findAllMyOrderByStateForPage(user.getUserid(),state,pageSize, page);
		if(data!=null){
			Iterator it=data.iterator();
			while(it.hasNext()){
			Object[]obj=(Object[])it.next();
			orders.add((Order) obj[0]);
			goods.add((Goods) obj[1]);
			users.add((User) obj[2]);
			ordermessages.add((OrderMessage) obj[3]);
			}
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	@Action(value="findMyOrderByState",results={
			@Result(name="success",type="json")
	})
	public String findMyOrderByState(){
		data=orderItemService.findMyOrderByStateForPage(user.getUserid(),state,pageSize, page);
		if(data!=null){
			Iterator it=data.iterator();
			while(it.hasNext()){
			Object[]obj=(Object[])it.next();
			orders.add((Order) obj[0]);
			goods.add((Goods) obj[1]);
			users.add((User) obj[2]);
			ordermessages.add((OrderMessage) obj[3]);
			}
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
	@Action(value="findAllMyOrderByOMID",results={
			@Result(name="success",type="json")
	})
	public String findAllMyOrderByOMID(){
		data=orderItemService.findAllMyOrderByOMID(orderMessage.getId());
		if(data!=null){
			Iterator it=data.iterator();
			while(it.hasNext()){
			Object[]obj=(Object[])it.next();
			orders.add((Order) obj[0]);
			goods.add((Goods) obj[1]);
			users.add((User) obj[2]);
			ordermessages.add((OrderMessage) obj[3]);
			}
			code="1";
		}else{
			code="0";
		}
		return SUCCESS;
	}
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

	public String getExpressnumber() {
		return expressnumber;
	}

	public void setExpressnumber(String expressnumber) {
		this.expressnumber = expressnumber;
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

	public Order getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Order orderItem) {
		this.orderItem = orderItem;
	}

	public long getState() {
		return state;
	}

	public void setState(long state) {
		this.state = state;
	}

	public List<OrderMessage> getOrdermessages() {
		return ordermessages;
	}

	public void setOrdermessages(List<OrderMessage> ordermessages) {
		this.ordermessages = ordermessages;
	}

	public GoodsItemService getGoodsItemService() {
		return goodsItemService;
	}

	public void setGoodsItemService(GoodsItemService goodsItemService) {
		this.goodsItemService = goodsItemService;
	}

	public ShopcartItemService getShopcartItemService() {
		return shopcartItemService;
	}

	public void setShopcartItemService(ShopcartItemService shopcartItemService) {
		this.shopcartItemService = shopcartItemService;
	}

	public double getAllprice() {
		return allprice;
	}

	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}

	public OrderMessage getOrderMessage() {
		return orderMessage;
	}

	public void setOrderMessage(OrderMessage orderMessage) {
		this.orderMessage = orderMessage;
	}

	
}
