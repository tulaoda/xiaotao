package com.xt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.dao.ChatItemDao;
import com.xt.entity.Chat;

@Transactional
@Service
public class ChatItemService {

	@Autowired
	private ChatItemDao chatItemDao;

	public List<Chat> findAllMyChatItem(String s_userid, String r_userid) {
		return chatItemDao.findAllMyChatItem(s_userid, r_userid);
	}

	public boolean removeChatItem(Chat c) {
		chatItemDao.removeChatItem(c);
		return true;
	}

	public boolean addNewChatItem(Chat c) {
		chatItemDao.addNewChatItem(c);
		return true;
	}

	public Chat findMaxIdChatItem() {
		return chatItemDao.findMaxIdChatItem();
	}

	public List<Chat> findMyMessageList(String s_userid) {
		return chatItemDao.findMyMessageList(s_userid);
	}
}
