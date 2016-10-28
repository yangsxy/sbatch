package cn.yuan.event;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/eventer")
public class EventMainTestController implements CommandLineRunner,Ordered {
	@Resource
	private MyOwnEventPublisher myOwnEventPublisher;
	@RequestMapping("/test")
	public void myOwnEventTest() {
		Map<String, Object>param = new HashMap<>();
		param.put("name", "yuanjiu9");
		MyOwnApplicationEvent event = new MyOwnApplicationEvent(param);
		myOwnEventPublisher.publishEvent(event);
		System.out.println("-----啦啦啦，事件发生了");
	}
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("~~~~I'm first,commandLineRunner,order :15~~~~~~~~");
	}
}
