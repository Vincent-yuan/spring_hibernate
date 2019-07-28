package cn.vincent.dao;

import java.util.List;

import cn.vincent.vo.User;

public interface UserDao {

	public List<User> findAll();
}
