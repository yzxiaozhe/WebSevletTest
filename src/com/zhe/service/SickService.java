package com.zhe.service;

import java.util.List;

import com.zhe.pojo.Sick;
import com.zhe.pojo.User;

public interface SickService {
	/**
	 * ��ȡ���еĸ�Ѫѹ������Ϣ
	 * @return
	 */
	List<Sick> sickShowService();

	List<Sick> tangShowService();

	List<Sick> weiShowService();
	
	int weiAddService(Sick s);

	int tangAddService(Sick s);

	int gaoAddService(Sick s);

	int weiDelService(int id);
}
