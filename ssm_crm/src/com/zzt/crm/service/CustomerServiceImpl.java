package com.zzt.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzt.common.utils.Page;
import com.zzt.crm.mapper.CustomerDao;
import com.zzt.crm.pojo.Customer;
import com.zzt.crm.pojo.QueryVo;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		
		Page<Customer> page = new Page<Customer>();
		page.setSize(5);//计算总共有多少页
		vo.setSize(10);//显示页面中数据得条数
		if(null!=vo) {
			if(null!=vo.getPage()) {
				
				vo.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
				page.setPage(vo.getPage());//Page类中四个属性都不能少  size  page total rows
			}
			if(null!=vo.getCustName()&& !"".equals(vo.getCustName().trim())) {
				vo.setCustName(vo.getCustName().trim());
				
			}
			if(null!=vo.getCustSource()&&! "".equals(vo.getCustSource().trim())) {
				vo.setCustName(vo.getCustName().trim()); 
				
			}
			if(null!=vo.getCustIndustry()&&! "".equals(vo.getCustIndustry().trim())) {
				vo.setCustIndustry(vo.getCustIndustry().trim());
				
			}
			if(null!=vo.getCustLevel()&&! "".equals(vo.getCustLevel().trim())) {
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			page.setTotal(customerDao.customerCountByQueryVo(vo));//设置总条数
			page.setRows(customerDao.selectCustomerListByQueryVo(vo));//设置结果集
		}
		return page;
	}
	public Customer queryCustomerById(Integer id) {
		return customerDao.queryCustomerById(id);
	}
	
	//修改用户
		public void updateCustomer(Customer customer) {
			 customerDao.updateCustomer(customer);
		}
		
		public void deleteCustomerById(Integer id) {
			 customerDao.deleteCustomerById(id);
		}
		@Override
		public String selectUserPassword(String str) {
			return customerDao.selectUserPassword(str);
		}


}
