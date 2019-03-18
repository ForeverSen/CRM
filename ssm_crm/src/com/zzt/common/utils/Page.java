package com.zzt.common.utils;

import java.util.List;

public class Page<T> {
	
	//下面这四个属性都不能少
	private int total;//查询总的数据条数
	private int page; //当前页
	private int size; //计算总共有多少页
    private List<T> rows; //数据的结果集
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
	
    
}
