package cn.yuan.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {
	private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Scheduled(fixedRate = 1000*30)
	public void  reportCurrentTime() {
		logger.info("Scheduling Tasks Example:the time is now "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
	}
	
	@Scheduled(cron = "0 */1 * * * *")
	public void  reportCurrentByCron() {
		logger.info("Scheduling Taskes Examples By Cron:the time is now " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
	}
	
}
