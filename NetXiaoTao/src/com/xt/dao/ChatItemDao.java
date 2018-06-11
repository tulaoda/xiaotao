package com.xt.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xt.entity.Chat;
import com.xt.entity.User;
import com.xt.entity.Wannas;

@Repository
public class ChatItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Chat> findAllChat() {
		String hql = "from Chat";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	public List<Chat> findAllMyChatItem(String s_userid, String r_userid) {
		String hql = "from Chat c where (c.s_userid=? and c.r_userid =?) or (c.s_userid=? and c.r_userid =?) order by c.createTime";
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setString(0, s_userid).setString(1, r_userid)
				.setString(2, r_userid).setString(3, s_userid).list();
	}

	public void removeChatItem(Chat c) {
		sessionFactory.getCurrentSession().delete(c);
	}

	public List<Chat> findAllMyChatItemForPage(Long s_userid, Long r_userid,
			int pageSize, int page) {
		String hql = "from Chat c where c.s_userid=? and c.r_userid =? order by c.createTime";
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setLong(0, r_userid).setLong(1, s_userid)
				.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
				.setMaxResults(pageSize).list();

	}

	public void addNewChatItem(Chat c) {
		sessionFactory.getCurrentSession().save(c);
	}

	public Chat findMaxIdChatItem() {
		String hql = "from Chat where id=(select max(id) from Chat) ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Chat chatItem = (Chat) query.uniqueResult();
		return chatItem;
	}

	/*
	 * 鏌ヨ娑堟伅鍒楄〃
	 */
	public List<Chat> findMySMessageList(String s_userid) {
		String hql = "from Chat where s_userid=? GROUP BY r_userid ORDER BY createTime	 ";
		/*
		 * session.createSQLQuery(sql)杩欏彞璇濇寚鏄庝簡hibernate鐢ㄧ殑鏄師鐢熸�鐨剆ql璇彞
		 */
		return (List<Chat>) sessionFactory.getCurrentSession().createQuery(hql)
				.setString(0, s_userid).list();

	}

	public List<Chat> findMyRMessageList(String r_userid) {
		String hql = "from Chat where r_userid=? GROUP BY r_userid ORDER BY createTime	 ";
		/*
		 * session.createSQLQuery(sql)杩欏彞璇濇寚鏄庝簡hibernate鐢ㄧ殑鏄師鐢熸�鐨剆ql璇彞
		 */
		return (List<Chat>) sessionFactory.getCurrentSession().createQuery(hql)
				.setString(0, r_userid).list();

	}
}
