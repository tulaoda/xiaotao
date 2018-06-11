package com.xt.action;

import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xt.base.BaseAction;
import com.xt.entity.Chat;
import com.xt.entity.User;
import com.xt.entity.Wannas;
import com.xt.service.ChatItemService;
import com.xt.service.UserService;
import com.xt.service.WannasItemService;

@Namespace("/chat")
@ParentPackage("json-default")
@Controller
public class ChatAction extends BaseAction {

	private String code;
	private List<Chat> data;
	private List<Chat> sChat;
	private List<Chat> RChat;
	private int pageSize;
	private int page;
	public Chat chatItem;
	private String s_userid;
	private String r_userid;
	private List<User> users=new ArrayList<User>();
	@Autowired
	private ChatItemService chatItemService;

	@Autowired
	private UserService userService;
	@Action(value = "findAllChat", results = { @Result(name = "success", type = "json") })
	public String findAllChat() {
		data = chatItemService.findAllChat();
		if (data != null) {
			List<User> s_user=new ArrayList<User>();
			List<User> r_user=new ArrayList<User>();
			for(Chat c:data){
				s_user.add(userService.findUserByUserid(c.getS_userid()));
				r_user.add(userService.findUserByUserid(c.getR_userid()));
			}
			s_user.addAll(r_user);
			HashSet<String> hashSet = new HashSet<String>();
			r_user=new ArrayList<User>();
			for(User u:s_user){
			if (hashSet.add(u.getUserid()))
			{
			r_user.add(u);
			}
			}
			s_user.clear();
			s_user.addAll(r_user);
			users=s_user;
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "findAllMyChatItem", results = { @Result(name = "success", type = "json") })
	public String findAllMyChatItem() {
		data = chatItemService.findAllMyChatItem(s_userid, r_userid);
		if (data != null) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "findMyMessageList", results = { @Result(name = "success", type = "json") })
	public String findMyMessageList() {
		sChat = (List<Chat>) chatItemService.findMySMessageList(s_userid);
		RChat = (List<Chat>) chatItemService.findMyRMessageList(s_userid);
		if (sChat != null && RChat!=null) {
			User u=null;
			List<Chat> chats=new ArrayList<Chat>();
			for(int i=0;i<RChat.size();i++){
			for(Chat c:sChat){
				if(c.getId()==RChat.get(i).getId()){
					chats.add(RChat.get(i));
				}
			}
			}
			for(Chat c:chats){
				RChat.remove(c);
			}
			for(Chat c:sChat){
				u=userService.findUserByUserid(c.getR_userid());
				users.add(u);
			}
			sChat.addAll(RChat);
			data=sChat;
			
			for(Chat c:RChat){
				u=userService.findUserByUserid(c.getS_userid());
				users.add(u);
			}
			
			code = "1";
		}else if (sChat != null && RChat==null) {
			User u=null;
			data=sChat;
			for(Chat c:data){
				u=userService.findUserByUserid(c.getR_userid());
				users.add(u);
			}
			
			code = "1";
		}else if (sChat == null && RChat!=null) {
			User u=null;
			data=RChat;
			for(Chat c:data){
				u=userService.findUserByUserid(c.getS_userid());
				users.add(u);
			}
			
			code = "1";
		
		}else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "removeChatItem", results = { @Result(name = "success", type = "json") })
	public String removeChatItem() {
		boolean flag = chatItemService.removeChatItem(chatItem);
		if (flag) {
			code = "1";
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	@Action(value = "addNewChatItem", results = { @Result(name = "success", type = "json") })
	public String addNewChatItem() {
		chatItem.setCreateTime(new Timestamp(System.currentTimeMillis()));
		boolean flag = chatItemService.addNewChatItem(chatItem);
		if (flag) {
			code = "1";
			data = new ArrayList<>();
			data.add(chatItemService.findMaxIdChatItem());
		} else {
			code = "0";
		}
		return SUCCESS;
	}

	/*
	 * @Action(value = "addFileAction",params={"savePath","/upload"},
	 * interceptorRefs
	 * ={@InterceptorRef(value="fileUpload",params={"allowedTypes"
	 * ,"image/pjpeg, image/gif,image/x-png","maximumSize","1024000000"}),
	 * 
	 * @InterceptorRef("defaultStack")},results={
	 * 
	 * @Result(name="success",type="json") }) public String addFile() {
	 * goodsItemService.addNewGoodsItem(goodsItem,file,fileFileName); }
	 */
	public String getCode() {
		return code;
	}

	public List<Chat> getData() {
		return data;
	}

	public void setData(List<Chat> data) {
		this.data = data;
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

	public Chat getChatItem() {
		return chatItem;
	}

	public void setChatItem(Chat chatItem) {
		this.chatItem = chatItem;
	}

	public ChatItemService getChatItemService() {
		return chatItemService;
	}

	public void setChatItemService(ChatItemService chatItemService) {
		this.chatItemService = chatItemService;
	}

	public String getS_userid() {
		return s_userid;
	}

	public void setS_userid(String s_userid) {
		this.s_userid = s_userid;
	}

	public String getR_userid() {
		return r_userid;
	}

	public void setR_userid(String r_userid) {
		this.r_userid = r_userid;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
