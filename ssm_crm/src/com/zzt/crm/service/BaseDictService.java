package com.zzt.crm.service;

import java.util.List;

import com.zzt.crm.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> selectBaseDictListBycode(String code);
}
