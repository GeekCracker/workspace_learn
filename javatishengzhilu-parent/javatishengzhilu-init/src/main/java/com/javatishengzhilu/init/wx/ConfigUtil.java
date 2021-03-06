package com.javatishengzhilu.init.wx;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 	配置文件工具类
 */
public class ConfigUtil {
	
	private static Properties props = new Properties();

	static {
		try {
			props.load(ConfigUtil.class.getClassLoader().getResourceAsStream("wechat.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return props.getProperty(key);
	}

	public static void setProps(Properties p) {
		props = p;
	}
}
