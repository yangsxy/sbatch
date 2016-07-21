package cn.yuan.batch2;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Configuration
@EnableBatchProcessing
public class PersonBatchConfiguration {
	
	private static final String PERSON_INSERT = "insert into Person (personName,personAge,personSex)values(:personName,:personAge,:personSex)";
	
	@Autowired
	private JobBuilderFactory jobs;
	@Autowired
	private StepBuilderFactory steps;
	@Bean
	public ItemReader<Person> reader(DataSource dataSource){
//		FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
//		reader.setResource(new ClassPathResource("sample-data.csv"));
//		reader.setLineMapper(new DefaultLineMapper<Person>() {{  
//            setLineTokenizer(new DelimitedLineTokenizer() {{  
//                setNames(new String[] { "personName","personAge","personSex" });  
//            }});  
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{  
//                setTargetType(Person.class);  
//            }});  
//        }});  
		JdbcCursorItemReader<Person> reader = new JdbcCursorItemReader<>();
		reader.setDataSource(dataSource);
		reader.setSql("select o from Person o");
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
	@Bean
	public ItemWriter<Person> writer(DataSource dataSource){
		JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();  
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());  
        writer.setSql(PERSON_INSERT);  
        writer.setDataSource(dataSource);  
        return writer; 
	}
	@Bean  
    public Job importUserJob(@Qualifier("step1")Step s1) {  
        return jobs.get("importUserJob")  
//                .incrementer(new RunIdIncrementer())  
//                .listener(listener)  
                .start(s1)
//                .flow(s1)  
//                .end()  
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
