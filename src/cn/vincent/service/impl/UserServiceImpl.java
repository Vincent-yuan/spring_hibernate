package cn.vincent.service.impl;

import java.util.List;

import cn.vincent.dao.UserDao;
import cn.vincent.service.UserService;
import cn.vincent.vo.User;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	@Override
	public List<User> findAll() {
		return 	userDao.findAll();
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
