package cn.yuan.jndi;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yuan.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class DataSourceTest {
//	@Autowired
//    @Qualifier("primaryJdbcTemplate")
//    protected JdbcTemplate jdbcTemplate1;
//
//    @Autowired
//    @Qualifier("secondaryJdbcTemplate")
//    protected JdbcTemplate jdbcTemplate2;
//    
//    @Test
//	public void testName() throws Exception {
//		
//    	User forObject = jdbcTemplate1.queryForObject("select * from user limit 1", User.class);
//    	System.out.println(forObject);
//    	User object2 = jdbcTemplate2.queryForObject("select * from user limit 1", User.class);
//    	System.out.println(object2);
//    	
//	}
}
