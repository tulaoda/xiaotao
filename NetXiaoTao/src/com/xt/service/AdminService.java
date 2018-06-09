package com.xt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.dao.AdminDao;
import com.xt.dao.UserDao;
import com.xt.entity.Address;
import com.xt.entity.Admin;
import com.xt.entity.Bill;
import com.xt.entity.Chat;
import com.xt.entity.Goods;
import com.xt.entity.RechargeOrder;
import com.xt.entity.User;

@Transactional
@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public Admin login(Admin admin) {
		return adminDao.login(admin);
	}

	public boolean register(Admin admin) {
		if (!adminDao.exits(admin)) {
			adminDao.addNewAdmin(admin);
			return true;
		} else {
			return false;
		}
	}

	public Admin validateNickname(Admin admin) {
		return adminDao.validateNickname(admin);
	}

	public boolean modifyPasswd(Admin admin) {
		return adminDao.modifyPasswd(admin) > 0 ? true : false;
	}
	
	public List<User> findAllUser(int pageSize,int page){
		return adminDao.findAllUser(pageSize,page);
	}
	
}

