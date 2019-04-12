package com.zhe.dao;

import java.util.List;

import com.zhe.pojo.Sick;

public interface SickDao {

	

	int weiAddDao(Sick s);

	List<Sick> gaoShowDao();

	List<Sick> tangShowDao();

	List<Sick> weiShowDao();

	int tangAddDao(Sick s);

	int gaoAddDao(Sick s);

	int weiDelDao(int id);

}
