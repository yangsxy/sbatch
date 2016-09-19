package cn.yuan.batch.readtext;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * Created by yuandg on 2016/5/4.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext c =
                new ClassPathXmlApplicationContext("message_job.xml");
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository((JobRepository) c.getBean("jobRepository"));
        launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        try {
            launcher.run((Job) c.getBean("messageJob"), new JobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.close();
    }
}
