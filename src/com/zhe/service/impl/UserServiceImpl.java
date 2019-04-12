package com.zhe.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.zhe.dao.UserDao;
import com.zhe.dao.impl.UserDaoImpl;
import com.zhe.pojo.User;
import com.zhe.service.UserService;

public class UserServiceImpl implements UserService{
	//������־����
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	//����dao����Ϣ
	UserDao ud=new UserDaoImpl();
	//�û���½
	public User checkUserLoginService(String uname, String pwd) {
		//��ӡ��־
		logger.debug(uname+"�����½����");
		User u=ud.checkUserLoginDao(uname, pwd);
		//�ж�
		if(u!=null){
			logger.debug(uname+"��½�ɹ�");
		}else{
			logger.debug(uname+"��½ʧ��");
		}
		return u;
	}
	//�޸�����
	public int userChangePwdService(String newPwd, int uid) {
		//��ӡ��־
		logger.debug(uid+":�����޸���������");
		int index= ud.userChangePwdDao(newPwd,uid);
		if(index>0){
			logger.debug(uid+":�����޸ĳɹ�");
		}else{
			logger.debug(uid+":�����޸�ʧ��");
		}
		return index;
	}
	//��ȡ�����û���Ϣ
	public List<User> userShowService() {
		List<User> lu=ud.useShowDao();
		//��ӡ��־
		logger.debug("��ʾ�����û���Ϣ��"+lu);
		return lu;
	}
	//ע���û���Ϣ
	public int userRegService(User u) {
		// TODO Auto-generated method stub
		return ud.useRegDao(u);
	}

}
