package com.xt.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.util.Utils;
import com.mysql.jdbc.Util;
import com.xt.dao.ChatItemDao;
import com.xt.dao.WannasItemDao;
import com.xt.entity.Chat;
import com.xt.entity.WannaImg;
import com.xt.entity.Wannas;



@Transactional
@Service
public class ChatItemService {

	@Autowired
	private ChatItemDao chatItemDao;

	public List<Chat> findAllMyChatItemForPage(Long s_userid,Long r_userid,int pageSize,int page){
		return chatItemDao.findAllMyChatItemForPage(s_userid,r_userid,pageSize,page);
	}
	
	public boolean removeChatItem(Chat c){
		chatItemDao.removeChatItem(c);
		return true;
	}
	public boolean addNewChatItem(Chat c){
		chatItemDao.addNewChatItem(c);
		return true;
	}
	public Chat findMaxIdChatItem(){
		return chatItemDao.findMaxIdChatItem();
	}
}
