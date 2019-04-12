package com.zhe.service;

import java.util.List;

import com.zhe.pojo.Sick;
import com.zhe.pojo.User;

public interface UserService {
	/**
	 * У���û���½��Ϣ
	 * @param name
	 * @param pwd
	 * @return
	 */
	User checkUserLoginService(String uname,String pwd);
	/**
	 * �޸��û�����
	 * @param newPwd
	 * @param uid
	 * @return
	 */
	int userChangePwdService(String newPwd, int uid);
	/**
	 * ��ȡ���е��û���Ϣ
	 * @return
	 */
	List<User> userShowService();
	/**
	 * ���û���Ϣ����ע��
	 * @param u
	 * @return
	 */
	int userRegService(User u);
	
}
