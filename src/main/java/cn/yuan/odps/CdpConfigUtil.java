package cn.yuan.odps;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;


public class CdpConfigUtil {
	
	private static Map<String, String> propertiesMap;
	
	static{
		initProperty();
	}
	private static void initProperty(){
		
		if (propertiesMap!=null) {
			return;
		}
		InputStream ins = null;
		Properties properties = new Properties();
		try {
			ins = CdpConfigUtil.class.getResourceAsStream("/cdpConfig.properties");
			properties.load(ins);
			propertiesMap = new HashMap<>();
			
			Set<Entry<Object,Object>> entrySet = properties.entrySet();
			for (Entry<Object, Object> entry : entrySet) {
				propertiesMap.put((String)entry.getKey(),((String)entry.getValue()).trim());
			}
		} catch (Exception e) {
		}
	}
	
	public static String getString(String key){
		return propertiesMap.get(key);
	}
}
