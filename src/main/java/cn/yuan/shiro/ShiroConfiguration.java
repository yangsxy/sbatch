package cn.yuan.shiro;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);
	
	public EhCacheManager getEhCacheManager(){
		EhCacheManager em = new EhCacheManager();
		logger.info("");
		em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
		return em;
	}

	
}
