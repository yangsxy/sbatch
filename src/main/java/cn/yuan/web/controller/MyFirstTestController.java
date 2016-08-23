package cn.yuan.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yuan.mybatis.dao.CdpJobConfigMapper;
import cn.yuan.mybatis.dao.UserMapper;
import cn.yuan.mybatis.entity.CdpJobConfig;
import cn.yuan.mybatis.entity.User;

@Controller
@RequestMapping("/first")
public class MyFirstTestController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CdpJobConfigMapper cdpJobConfigMapper;
	
	private Logger logger = LoggerFactory.getLogger(MySecondTestController.class);
	
	@RequestMapping("/one")
	@ResponseBody
	public void myFirstTest(){
		logger.info("this is my first test");
		System.out.println("******this is my first test*****");
		
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user);
		CdpJobConfig jobConfig = cdpJobConfigMapper.selectByCode("yuan");
		System.out.println(jobConfig.getJobContent());
		System.out.println(jobConfig.getCode());
	}
}
