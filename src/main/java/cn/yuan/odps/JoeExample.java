package cn.yuan.odps;


import org.junit.Test;

import com.alibaba.cdp.sdk.model.Job;
import com.alibaba.cdp.sdk.model.JobStatus;
import com.alibaba.cdp.sdk.model.Pipeline;
import com.alibaba.cdp.sdk.model.Session;
import com.alibaba.fastjson.JSONObject;

public class JoeExample extends BaseTest {
	@Test
	public void testCdp(){
		
		
		Session session = new Session("http://cdp.aliyun.com/api", "SxagsMTJqHdl0vvX", "symUVH5e3uq8Ef0xQJePiBKQWiIzAs");
		JSONObject jobConfig = ConfigParser.getJsonJobConfig("/yuan.json");
				
		Pipeline pipeline = session.getPipeline("yuan_project");
		if (pipeline==null) {
			
			throw new RuntimeException();
			
//			pipeline = new Pipeline();
//			pipeline.setName("yuan_project");
//			pipeline.setDescription("my first cdp test.");
//			pipeline = session.createPipeline(pipeline);
		}
		
		Job job = new Job();
		job.setTraceId("yuan_job_trace");
		job.setContext(jobConfig.toJSONString());
		final Job starter = pipeline.start(job);

		JobStatus status;
		do {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("error:"+e);
			}
			status= starter.status();
		} while (status.isJobAlive());
		
		starter.stop();
		
	}
}
