package cn.yuan.batch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuandg on 2016/5/4.
 */
@Controller
@RequestMapping("/batch")
@ConfigurationProperties(locations="classpath:application.properties")
public class BatchStartController {
    public static final String RUN_MONTH_KEY = "run.month";
    static Logger logger = LoggerFactory.getLogger(BatchStartController.class);
    /**
     * @param args
     */
    @RequestMapping("/billing")
    @ResponseBody
    public Object executeBatch(){
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext(
                "application-batch.xml");
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository((JobRepository) c.getBean("jobRepository"));
        launcher.setTaskExecutor(new SyncTaskExecutor());
        try {
            Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();
            parameters.put("run.time", new JobParameter(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
            JobExecution je = launcher.run((Job) c.getBean("billingJob"),
                    new JobParameters(parameters));
            logger.debug("**********spring batch logger**********");
            System.out.println("......................");
            System.out.println(je);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	c.close();
		}
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map ;
    }
}
