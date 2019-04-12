package com.zhe.dao;

import java.util.List;

import com.zhe.pojo.User;

public interface UserDao {
	/**
	 * 根据用户名和密码查询用户信息
	 * @param name
	 * @param pwd
	 * @return 查询到的用户信息
	 */
	User checkUserLoginDao(String uname,String pwd);
	/**
	 * 根据用户id修改密码
	 * @param newPwd
	 * @param uid
	 * @return
	 */
	int userChangePwdDao(String newPwd, int uid);
	/**
	 * 获取所有用户信息
	 * @return
	 */
	List<User> useShowDao();
	/**
	 * 注册单个用户信息
	 * @return
	 */
	int useRegDao(User u);

	
	
}
