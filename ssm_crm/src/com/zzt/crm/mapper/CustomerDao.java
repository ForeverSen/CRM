package com.zzt.crm.mapper;

import java.util.List;

import com.zzt.crm.pojo.Customer;
import com.zzt.crm.pojo.QueryVo;

public interface CustomerDao {
	
	//总条数
	public Integer customerCountByQueryVo(QueryVo vo);
	//结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	//根据id查用户
	public Customer queryCustomerById(Integer id);
	
	//修改用户
	public void updateCustomer(Customer customer);
	
	//删除用户
	public void deleteCustomerById(Integer id);
	
	//登陆页面查用户密码
	public String selectUserPassword(String str);
}
