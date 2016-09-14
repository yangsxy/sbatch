package cn.yuan.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.yuan.web.util.LogMessageUtils;

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {
	private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Scheduled(fixedRate = 1000*30)
	public void  reportCurrentTime() {
		//手动设置日志埋点
		String uuid=LogMessageUtils.getMessagePoint();
		LogMessageUtils.setMessagePoint(uuid);
		logger.info("Scheduling Tasks Example:the time is now "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
		LogMessageUtils.removeMessagePoint();
	}
	
	@Scheduled(cron = "0 */2 * * * *")
	public void  reportCurrentByCron() {
		//手动设置日志埋点
		LogMessageUtils.setMessagePoint();
		logger.info("Scheduling Taskes Examples By Cron:the time is now " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
		LogMessageUtils.removeMessagePoint();
	}
	
}
