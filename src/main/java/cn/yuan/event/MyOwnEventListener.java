package cn.yuan.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
/**
 * 监听指定事件
 * @author Administrator
 *
 */
public class MyOwnEventListener implements ApplicationListener<MyOwnApplicationEvent> {


	@Override
	public void onApplicationEvent(MyOwnApplicationEvent event) {
		System.out.println(event.getClass().getSimpleName()+"!!!!!!!!!!!!!!!!!");
	}

}
