package cn.yuan.mybatis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yuan.mybatis.dao.UserMapper;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/get")
	@ResponseBody
	public Object getUser(){
		logger.info("I'm in the userController.");
		return userMapper.selectUserByName("U1");
	}
	@RequestMapping("/getById")
	@ResponseBody
	public Object getUserById(){
		logger.info("I'm in the userController.");
		return userMapper.selectByPrimaryKey(2);
	}
}
