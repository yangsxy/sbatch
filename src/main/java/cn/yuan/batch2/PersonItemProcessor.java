package cn.yuan.batch2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


public class PersonItemProcessor implements ItemProcessor<Person, Person>{

	private final Logger logger = LoggerFactory.getLogger(PersonItemProcessor.class);
	
	@Override
	public Person process(final Person person) throws Exception {
		System.out.println("-----------------"+person);
		String sex = null;
		if (person.getPersonSex().equals("1")) {
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
