package com.zhe.service;

import java.util.List;

import com.zhe.pojo.Sick;
import com.zhe.pojo.User;

public interface SickService {
	/**
	 * 获取所有的高血压病人信息
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
