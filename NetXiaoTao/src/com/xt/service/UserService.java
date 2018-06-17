package com.xt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.dao.UserDao;
import com.xt.entity.Address;
import com.xt.entity.Bill;
import com.xt.entity.Chat;
import com.xt.entity.Goods;
import com.xt.entity.RechargeOrder;
import com.xt.entity.User;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User login(User user) {
		return userDao.login(user);
	}

	public boolean register(User user) {
		if (!userDao.exits(user)) {
			userDao.addNewUser(user);
			return true;
		} else {
			return false;
		}
	}

	public User validateNickname(User user) {
		return userDao.validateNickname(user);
	}

	public boolean modifyPasswd(User user) {
		return userDao.modifyPasswd(user) > 0 ? true : false;
	}

	public List<Object> findUserAndGoods(int pageSize,int page){
		return userDao.findUserAndGoods(pageSize,page);
	}

	public boolean modifyBalance(User user) {
		return userDao.modifyBalance(user) > 0 ? true : false;
	}
	
	public boolean modifyUserBaseInfo(User user) {
		userDao.modifyUserBaseInfo(user) ;
		return  true;
	}
	public User findUserByUserid(String userid){
		return userDao.findUserByUserid(userid);
	}
	public boolean updateAddress(User user){
		return userDao.updateAddress(user);
	}
	
	public Address findAddressById(Long id){
		return userDao.findAddressById(id);
	}
	
	public boolean removeAddress(Address a){
		userDao.removeAddress(a);
		return true;
	}
	
	public boolean addBill(Bill b){
		userDao.addBill(b);;
		return true;
	}
	
	public List<Bill> findBillByUseridForPage(String userid,int pageSize,int page){
		return userDao.findBillByUseridForPage(userid,pageSize,page);
	}
}

