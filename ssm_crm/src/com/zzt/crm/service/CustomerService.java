package com.zzt.crm.service;

import com.zzt.common.utils.Page;
import com.zzt.crm.pojo.Customer;
import com.zzt.crm.pojo.QueryVo;

public interface CustomerService {
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	
	public Customer queryCustomerById(Integer id);
	
	//修改用户
		public void updateCustomer(Customer customer);
		
		public void deleteCustomerById(Integer id);
		
		
		
		//登陆页面查用户密码
		public String selectUserPassword(String str);
}
