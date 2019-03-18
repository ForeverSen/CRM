package com.zzt.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzt.common.utils.Page;
import com.zzt.crm.pojo.BaseDict;
import com.zzt.crm.pojo.Customer;
import com.zzt.crm.pojo.QueryVo;
import com.zzt.crm.service.BaseDictService;
import com.zzt.crm.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;	
	
	// 客户来源 从env.properties读取，解决硬编码问题
		@Value("${CUSTOMER_FROM_TYPE}")
		private String CUSTOMER_FROM_TYPE;
		// 客户行业
		@Value("${CUSTOMER_INDUSTRY_TYPE}")
		private String CUSTOMER_INDUSTRY_TYPE;
		// 客户级别
		@Value("${CUSTOMER_LEVEL_TYPE}")
		private String CUSTOMER_LEVEL_TYPE;

	
	@RequestMapping(value="/customer/list")
	public String list(Model model,QueryVo vo) {
		
		List<BaseDict> fromType = baseDictService.selectBaseDictListBycode(CUSTOMER_FROM_TYPE);
		List<BaseDict> industryType = baseDictService.selectBaseDictListBycode(CUSTOMER_INDUSTRY_TYPE);
		List<BaseDict> levelType = baseDictService.selectBaseDictListBycode(CUSTOMER_LEVEL_TYPE);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
			
		//通过四个条件 查询分页对象
		Page<Customer> page =customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
	
		
		return "/WEB-INF/jsp/customer.jsp";
	}
	@RequestMapping(value="/customer/edit.action")
	@ResponseBody 
	public Customer edit(Integer id) {
		return customerService.queryCustomerById(id);
	}
	
	@RequestMapping(value="/customer/update.action")
	@ResponseBody 
	public String update(Customer customer) {
		customerService.updateCustomer(customer);
		return "OK";
	}
	
	@RequestMapping(value="/customer/delete.action")
	@ResponseBody 
	public String delete(Integer id) {
		customerService.deleteCustomerById(id);
		return "OK";
	}
}
