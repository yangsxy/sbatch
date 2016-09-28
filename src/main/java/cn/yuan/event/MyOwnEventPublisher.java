package cn.yuan.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
@Component
public class MyOwnEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationPublisher;
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationPublisher=applicationEventPublisher;
		System.err.println("----------初始化aware-------"+this.applicationPublisher);
	}
	
	public void publishEvent(ApplicationEvent event){
		applicationPublisher.publishEvent(event);
	}
}
