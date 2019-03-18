package com.zzt.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
public class UserController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;	
	
	@RequestMapping(value="/login.action")
	public String selectUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username!=null&&password!=null) {
			String pswd = customerService.selectUserPassword(username);
			if(pswd!=null&&pswd.equals(password)) {
				return "redirect:/customer/list";
			}
		}
			return "/login.jsp";
	}
	

}
