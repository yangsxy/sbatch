package cn.yuan.odps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;

import cn.yuan.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class BaseTest {
	@Test
	public void testConfig(){
		JSONObject jobConfig = ConfigParser.getJsonJobConfig("/yuan.json");
		System.out.println(jobConfig);
	}
}
