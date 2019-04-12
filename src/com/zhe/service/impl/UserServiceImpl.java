package com.zhe.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.zhe.dao.UserDao;
import com.zhe.dao.impl.UserDaoImpl;
import com.zhe.pojo.User;
import com.zhe.service.UserService;

public class UserServiceImpl implements UserService{
	//声明日志对象
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	//声明dao层信息
	UserDao ud=new UserDaoImpl();
	//用户登陆
	public User checkUserLoginService(String uname, String pwd) {
		//打印日志
		logger.debug(uname+"发起登陆请求");
		User u=ud.checkUserLoginDao(uname, pwd);
		//判断
		if(u!=null){
			logger.debug(uname+"登陆成功");
		}else{
			logger.debug(uname+"登陆失败");
		}
		return u;
	}
	//修改密码
	public int userChangePwdService(String newPwd, int uid) {
		//打印日志
		logger.debug(uid+":发起修改密码请求");
		int index= ud.userChangePwdDao(newPwd,uid);
		if(index>0){
			logger.debug(uid+":密码修改成功");
		}else{
			logger.debug(uid+":密码修改失败");
		}
		return index;
	}
	//获取所有用户信息
	public List<User> userShowService() {
		List<User> lu=ud.useShowDao();
		//打印日志
		logger.debug("显示所有用户信息："+lu);
		return lu;
	}
	//注册用户信息
	public int userRegService(User u) {
		// TODO Auto-generated method stub
		return ud.useRegDao(u);
	}

}
