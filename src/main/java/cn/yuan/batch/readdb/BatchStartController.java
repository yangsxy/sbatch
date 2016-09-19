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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuandg on 2016/5/4.
 */
@Controller
@RequestMapping("/batch")
public class BatchStartController {
    public static final String RUN_TIME_KEY = "run.time";
    static Logger logger = LoggerFactory.getLogger(BatchStartController.class);
    
    @Autowired
    private Job billingJob;
    @Autowired
    JobRepository jobRepository;
    
    /**
     * @param args
     */
    @RequestMapping("/billing")
    @ResponseBody
    public Object executeBatch(){
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository(jobRepository);
        launcher.setTaskExecutor(new SyncTaskExecutor());
        Date startTime = new Date();
        try {
            Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();
            parameters.put(RUN_TIME_KEY, new JobParameter(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
            
            JobExecution je = launcher.run(billingJob,new JobParameters(parameters));
            System.out.println(".......start at:"+startTime+",end at:"+new Date()+"...............");
            System.out.println(je);
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map ;
    }
}
