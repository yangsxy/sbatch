package cn.yuan.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yuan.mybatis.service.CustomerService;

@Controller
@RequestMapping("/crm")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/getById")
	@ResponseBody
	public Object getCustomerById() {
		return customerService.selectByPrimaryKey(2000000323L);
	}
	
}
