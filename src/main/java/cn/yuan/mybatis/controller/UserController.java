package cn.yuan.mybatis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yuan.jndi.DataSource;
import cn.yuan.mybatis.dao.UserMapper;
import cn.yuan.mybatis.entity.User;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/get")
	@ResponseBody
	@DataSource("readDataSource")
	public Object getUser(){
		logger.info("I'm in the userController.");
		return userMapper.selectByPrimaryKey(2);
	}
	@RequestMapping("/getById")
	@ResponseBody
	public Object getUserById(){
		logger.info("I'm in the userController.");
		return userMapper.selectByPrimaryKey(2);
	}
	@RequestMapping("/insert")
	@ResponseBody
	@DataSource("writeDataSource")
	public Object writeAUser(){
		logger.info("I'll write a user into db");
		User user = new User();
		user.setAge("26");
		user.setName("何淑星");
		user.setBalance(100.0);
		userMapper.insert(user);
		return userMapper.selectUserByName(user.getName());
	}
}
