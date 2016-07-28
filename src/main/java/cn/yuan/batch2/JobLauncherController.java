package cn.yuan.batch2;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/job")
public class JobLauncherController {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	
	@RequestMapping("/person")
	@ResponseBody
	public Object personJob() throws Exception{
		Map<String,JobParameter> parameters = new HashMap<>();
		parameters.put("executionDate", new JobParameter(new Date()));
		jobLauncher.run(job, new JobParameters(parameters));
		Map<Object,Object> map = new HashMap<>();
		map.put("success", true);
		return map;
	}
}
