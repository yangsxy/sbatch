package cn.yuan.event;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/eventer")
public class EventMainTestController {
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
}
