package cn.yuan.batch2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class PersonItemProcessor implements ItemProcessor<Person, Person>{

	private static final String GET_PERSON = "select * from Person where personName = ?";
	
	private final Logger logger = LoggerFactory.getLogger(PersonItemProcessor.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Person process(final Person person) throws Exception {
		List<Person> list = jdbcTemplate.query(GET_PERSON, new Object[]{person.getPersonName()},new RowMapper<Person>(){
			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person p = new Person();
				p.setPersonName(rs.getString("personName"));
				p.setPersonSex(rs.getString("personSex"));
				p.setPersonAge(rs.getInt("personAge"));
				return p;
			}
			
		});
		if (list.size()>0) {
			logger.info("该数据已录入");
		}
		String sex = null;
		if (person.getPersonSex().equals("0")) {
			sex = "男";
		}else{
			sex = "女";
		}
		logger.info("转换（性别："+person.getPersonSex()+")为("+sex +")");
		final Person endPerson = new Person(person.getPersonName(), person.getPersonAge(), sex);
		logger.info("转换("+person+")为("+endPerson+")");
		
		return endPerson;
	}
	
	
}
