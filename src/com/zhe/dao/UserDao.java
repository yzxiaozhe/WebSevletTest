package com.zhe.dao;

import java.util.List;

import com.zhe.pojo.User;

public interface UserDao {
	/**
	 * �����û����������ѯ�û���Ϣ
	 * @param name
	 * @param pwd
	 * @return ��ѯ�����û���Ϣ
	 */
	User checkUserLoginDao(String uname,String pwd);
	/**
	 * �����û�id�޸�����
	 * @param newPwd
	 * @param uid
	 * @return
	 */
	int userChangePwdDao(String newPwd, int uid);
	/**
	 * ��ȡ�����û���Ϣ
	 * @return
	 */
	List<User> useShowDao();
	/**
	 * ע�ᵥ���û���Ϣ
	 * @return
	 */
	int useRegDao(User u);

	
	
}
