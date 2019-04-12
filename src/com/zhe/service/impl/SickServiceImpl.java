package com.zhe.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.zhe.dao.SickDao;
import com.zhe.dao.UserDao;
import com.zhe.dao.impl.SickDaoImpl;
import com.zhe.dao.impl.UserDaoImpl;
import com.zhe.pojo.Sick;
import com.zhe.pojo.User;
import com.zhe.service.SickService;

public class SickServiceImpl implements SickService {
	//声明日志对象
	Logger logger=Logger.getLogger(SickServiceImpl.class);
	//声明dao层信息
	SickDao sd=new SickDaoImpl();
	
	//获取所有高血压信息
	public List<Sick> sickShowService() {
		List<Sick> gao=sd.gaoShowDao();
		logger.debug("显示高血压病人信息："+gao);
		return gao;
	}

	public List<Sick> tangShowService() {
		List<Sick> tang=sd.tangShowDao();
		logger.debug("显示糖尿病病人信息："+tang);
		return tang;
	}

	public List<Sick> weiShowService() {
		List<Sick> wei=sd.weiShowDao();
		logger.debug("显示胃病病人信息："+wei);
		return wei;
	}

	public int weiAddService(Sick s) {
		// TODO Auto-generated method stub
		return sd.weiAddDao(s);
	}

	public int tangAddService(Sick s) {
		// TODO Auto-generated method stub
		return sd.tangAddDao(s);
	}

	public int gaoAddService(Sick s) {
		// TODO Auto-generated method stub
		return sd.gaoAddDao(s);
	}

	public int weiDelService(int id) {
		// TODO Auto-generated method stub
		return sd.weiDelDao(id);
	}
	
	
	

}
