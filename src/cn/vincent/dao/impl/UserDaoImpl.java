package cn.vincent.dao.impl;

import java.util.List;

import org.hibernate.Session;

import cn.vincent.dao.UserDao;
import cn.vincent.util.HibernateUtil;
import cn.vincent.vo.User;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> findAll() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from User").list();
	}

}
