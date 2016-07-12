package cn.yuan.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/first")
public class MyFirstTestController {

	private Logger logger = LoggerFactory.getLogger(MySecondTestController.class);
	
	@RequestMapping("/one")
	@ResponseBody
	public void myFirstTest(){
		logger.info("this is my first test");
		System.out.println("******this is my first test*****");
	}
}
