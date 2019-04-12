package com.zhe.service;

import java.util.List;

import com.zhe.pojo.Sick;
import com.zhe.pojo.User;

public interface UserService {
	/**
	 * 校验用户登陆信息
	 * @param name
	 * @param pwd
	 * @return
	 */
	User checkUserLoginService(String uname,String pwd);
	/**
	 * 修改用户密码
	 * @param newPwd
	 * @param uid
	 * @return
	 */
	int userChangePwdService(String newPwd, int uid);
	/**
	 * 获取所有的用户信息
	 * @return
	 */
	List<User> userShowService();
	/**
	 * 对用户信息进行注册
	 * @param u
	 * @return
	 */
	int userRegService(User u);
	
}
