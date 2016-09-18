package cn.yuan.jndi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DataSourceAspect {

	@Around("@annotation(ds)")
	public Object execute(ProceedingJoinPoint joinPoint,DataSource ds) throws Throwable{
		DataSourceContextHolder.setDSType(ds.value());
		return joinPoint.proceed();
	}
}
