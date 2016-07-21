package cn.yuan.batch2;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/job")
public class JobLauncherController {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	
	@RequestMapping("/person")
	public void personJob() throws Exception{
		jobLauncher.run(job, new JobParameters());
	}
}
