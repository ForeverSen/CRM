package com.zzt.crm.Junit_Test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zzt.crm.pojo.BaseDict;
import com.zzt.crm.pojo.Customer;
import com.zzt.crm.service.BaseDictService;
import com.zzt.crm.service.CustomerService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration({ "classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-service.xml" })

public class CustomerControllerTest {
	
	
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	
	private CustomerService customerService;
	@Before
	public void setUp() throws Exception {
		
	}
	
	//查询
	@Test
	public void testList() {
		List<BaseDict> industryType = baseDictService.selectBaseDictListBycode("004");
		for (BaseDict baseDict : industryType) {
			System.out.println(baseDict);
		}
	}
	
	
	//编辑
	@Test
	public void testEdit() {
		Customer customer = customerService.queryCustomerById(1);
		System.out.println(customer);
	}
	
	
	//修改
	@Test
	public void testUpdate() {
		Customer customer = new Customer();	
		customer.setCust_id(40l);
		customer.setCust_name("帅哥");
		customerService.updateCustomer(customer);
	}
	
	//删除
	@Test
	public void testDelete() {
		
		customerService.deleteCustomerById(39);
		
	}

}
