package com.zzt.crm.mapper;

import java.util.List;

import com.zzt.crm.pojo.BaseDict;

public interface BaseDictDao {
	
	
	public List<BaseDict> selectBaseDictListBycode(String code);
}
