package com.day20190727.test1;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;

public class Test {

	public static void main(String[] args) {
		try {
			String ip = "125.125.42.74";
			DbConfig config = new DbConfig();
			//��ȡip���λ�ã�����src�£���ֱ��ͨ���������ȡ�ļ�Ip2RegionTestΪ�����ࣩ
	           String dbfile = Test.class.getResource("/ip2region.db").getPath();
	 
	           DbSearcher searcher = new DbSearcher(config, dbfile);
	 
	           //����Btree����
	           DataBlock block = searcher.btreeSearch(ip);
	 
	           //��ӡλ����Ϣ����ʽ������|����|ʡ��|����|��Ӫ�̣�
	           System.out.println(block.getRegion());
	           int id = block.getCityId();
	           System.out.println(id);
	           System.out.println(block.getDataPtr());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
