package cn.yuan.odps;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ConfigParser {

	public static JSONObject getJsonJobConfig(String jsonFileName) {
		try{
			InputStream ins = ConfigParser.class.getResourceAsStream(jsonFileName);
			InputStreamReader input = new InputStreamReader(ins);
			BufferedReader reader = new BufferedReader(input);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line=reader.readLine())!=null) {
				if (StringUtils.indexOf(line, "#")!=0) {
					sb.append(line);
				}
			}
			return JSON.parseObject(sb.toString());
		}catch(Exception exception){
			System.out.println(exception);
		}
		return null;
	}
	
}
