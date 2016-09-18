package cn.yuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication//该 @SpringBootApplication 注解等价于以默认属性使用 @Configuration ， @EnableAutoConfiguration 和 @ComponentScan 。
@ServletComponentScan//必须配此，filter、listener才有用
@ImportResource(value={"applicationContext.xml"})
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)//动态多数据源必配，否则启动报错
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@RequestMapping("/index")
	public ModelAndView home(){
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("hi", "啦啦啦啦");
		return mv;
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Application.class);
	}
}
