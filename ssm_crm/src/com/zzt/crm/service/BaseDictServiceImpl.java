package com.zzt.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzt.crm.mapper.BaseDictDao;
import com.zzt.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictDao baseDictDao;
	
	public List<BaseDict> selectBaseDictListBycode(String code){
		return baseDictDao.selectBaseDictListBycode(code);
	}
}
