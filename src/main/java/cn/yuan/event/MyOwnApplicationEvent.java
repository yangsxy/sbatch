package cn.yuan.event;

import org.springframework.context.ApplicationEvent;

public class MyOwnApplicationEvent extends ApplicationEvent{

	private static final long serialVersionUID = 918933119736432565L;

	public MyOwnApplicationEvent(Object source) {
		super(source);
	}

}
