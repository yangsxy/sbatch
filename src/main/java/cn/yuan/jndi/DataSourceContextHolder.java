package cn.yuan.jndi;

import org.apache.commons.lang3.StringUtils;

public class DataSourceContextHolder {
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
	
	public static void setDSType(String type) {
		String oldType = contextHolder.get();
		if (StringUtils.isBlank(oldType)) {
			contextHolder.set(type);
		}else if (oldType.equals("readDataSource")) {
			contextHolder.set(type);
		}else{
		}
	}
	
	public static String getDSType(){
		if (StringUtils.isBlank(contextHolder.get())) {
			contextHolder.set("writeDataSource");
		}
		return contextHolder.get();
	}
	
	public static void clearDSType(){
		contextHolder.remove();
	}
	
}
