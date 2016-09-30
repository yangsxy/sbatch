package cn.yuan.mybatis.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yuan.mybatis.entity.Customer;
import cn.yuan.odps.BaseTest;

public class CustomerServiceTest extends BaseTest{
	
	@Autowired
	private CustomerService customerService;
	
	@Test
	public void testCustomerSelect() throws Exception {
		Customer customer = customerService.selectByPrimaryKey(2000000323L);
		System.out.println(customer.getName()+","+customer.getCustomerid());
	}

}
