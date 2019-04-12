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
	//������־����
	Logger logger=Logger.getLogger(SickServiceImpl.class);
	//����dao����Ϣ
	SickDao sd=new SickDaoImpl();
	
	//��ȡ���и�Ѫѹ��Ϣ
	public List<Sick> sickShowService() {
		List<Sick> gao=sd.gaoShowDao();
		logger.debug("��ʾ��Ѫѹ������Ϣ��"+gao);
		return gao;
	}

	public List<Sick> tangShowService() {
		List<Sick> tang=sd.tangShowDao();
		logger.debug("��ʾ���򲡲�����Ϣ��"+tang);
		return tang;
	}

	public List<Sick> weiShowService() {
		List<Sick> wei=sd.weiShowDao();
		logger.debug("��ʾθ��������Ϣ��"+wei);
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
