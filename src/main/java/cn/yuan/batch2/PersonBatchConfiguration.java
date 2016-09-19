package cn.yuan.batch2;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//@Configuration
//@EnableBatchProcessing
public class PersonBatchConfiguration {
	
	private static final String PERSON_INSERT = "insert into Person (personName,personAge,personSex)values(:personName,:personAge,:personSex)";
	
	@Autowired
	private StepBuilderFactory steps;
	//1：读数据
	@Bean
	public ItemReader<Person> reader(DataSource dataSource){
		JdbcCursorItemReader<Person> reader = new JdbcCursorItemReader<>();
		reader.setDataSource(dataSource);
		reader.setSql("select * from person limit 1");
		reader.setRowMapper(new RowMapper<Person>() {
			
			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person p = new Person();
				p.setPersonId(rs.getLong("personId"));
				p.setPersonName(rs.getString("personName"));
				p.setPersonAge(rs.getInt("personAge"));
				p.setPersonSex(rs.getString("personSex"));
				return p;
			}
		});
        return reader;  
	}
	//2：处理数据
	@Bean
	public PersonItemProcessor processor(){
		return new PersonItemProcessor();
	}
	//3：写数据
	@Bean
	public ItemWriter<Person> writer(DataSource dataSource){
		JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();  
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());  
        writer.setSql(PERSON_INSERT);  
        writer.setDataSource(dataSource);  
        return writer; 
	}
	@Bean  
    public Job importUserJob(JobBuilderFactory jobs, @Qualifier("step1")Step s1,JobExecutionListener listener) {  
        return jobs.get("importUserJob")  
                .incrementer(new RunIdIncrementer())  
                .listener(listener)  
                .flow(s1)  
                .end()  
                .build();  
    }  
  
    @Bean  
    public Step step1(ItemReader<Person> reader, ItemProcessor<Person, Person> processor ,ItemWriter<Person> writer ) {  
        return steps.get("step1")  
                .<Person, Person> chunk(10)  
                .reader(reader)  
                .processor(processor)  
                .writer(writer)  
                .build();  
    }  
  
    @Bean  
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {  
        return new JdbcTemplate(dataSource);  
    }  
}
