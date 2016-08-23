package cn.yuan.odps;


import org.junit.Test;

import com.alibaba.cdp.sdk.model.Job;
import com.alibaba.cdp.sdk.model.JobStatus;
import com.alibaba.cdp.sdk.model.Pipeline;
import com.alibaba.cdp.sdk.model.Session;
import com.alibaba.fastjson.JSONObject;

import cn.yuan.thread.ExecutorHelper;

public class JoeExample extends BaseTest {
	@Test
	public void testCdp(){
		
		
		Session session = new Session("http://cdp.aliyun.com/api", "SxagsMTJqHdl0vvX", "symUVH5e3uq8Ef0xQJePiBKQWiIzAs");
		JSONObject jobConfig = ConfigParser.getJsonJobConfig("/yuan.json");
		Pipeline pipeline = new Pipeline();
		pipeline.setName("yuan_project");
		pipeline.setDescription("my first cdp test.");
		
		pipeline = session.createPipeline(pipeline);
		Job job = new Job();
		job.setTraceId("yuan_job_trace");
		job.setContext(jobConfig.toJSONString());
		
		final Job starter = pipeline.start(job);
		ExecutorHelper.excution(new Runnable() {
			@Override
			public void run() {
				JobStatus status;
				do {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
					status = starter.status();
					System.out.println(status);
				} while (status.isJobAlive());
			}
		});
	}
}
