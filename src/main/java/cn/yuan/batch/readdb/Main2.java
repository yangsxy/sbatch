package cn.yuan.batch.readdb;

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
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SyncTaskExecutor;

/**
 * Created by yuandg on 2016/5/4.
 */
public class Main2 {
    public static final String RUN_MONTH_KEY = "run.month";
    static Logger logger = LoggerFactory.getLogger(Main2.class);
    /**
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
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
        }
        c.close();
    }
}
