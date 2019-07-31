package com.day20190727.test1;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;

public class Test {

	public static void main(String[] args) {
		try {
			String ip = "125.125.42.74";
			DbConfig config = new DbConfig();
			//获取ip库的位置（放在src下）（直接通过测试类获取文件Ip2RegionTest为测试类）
	           String dbfile = Test.class.getResource("/ip2region.db").getPath();
	 
	           DbSearcher searcher = new DbSearcher(config, dbfile);
	 
	           //采用Btree搜索
	           DataBlock block = searcher.btreeSearch(ip);
	 
	           //打印位置信息（格式：国家|大区|省份|城市|运营商）
	           System.out.println(block.getRegion());
	           int id = block.getCityId();
	           System.out.println(id);
	           System.out.println(block.getDataPtr());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
