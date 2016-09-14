package cn.yuan.jndi;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceGlobalConfig {
	
	
	@Bean(name="primaryDataSource")
	@Primary
	@ConfigurationProperties(prefix="datasource.primary")
	public DataSource primaryDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="secondDataSource")
	@ConfigurationProperties(prefix="datasource.second")
	public DataSource secondDataSource(){
		return DataSourceBuilder.create().build();
	}
}
