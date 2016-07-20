package cn.yuan.batch2;

import org.apache.taglibs.standard.extra.spath.Step;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BillBatchConfiguration {

	@Autowired
	private JobBuilderFactory jobs;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job addNewPodcastJob(){
		return jobs.get("addNewPodcastJob").listener(protocolListener()).start(step()).build();
	}
	
	public Step step(){
		return stepBuilderFactory.get("step").chunk(1)
				.reader()
				.processor()
				.writer()
				.listener()
				.faultTolerant()
				.skipLimit(10)
				.skip()
				.build();
	}
	public ProtocolListener protocolListener(){
		return new ProtocolListener();
	}
}
class ProtocolListener extends JobExecutionListenerSupport{
	
}