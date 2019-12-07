package com.muck.shardingsphere.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muck.shardingsphere.service.GpsDataService;

@RestController("AdminGpsDataController")
@RequestMapping("/admin/gpsData")
public class GpsDataController {

	@Autowired
	private GpsDataService gpsDataService;
	
	@RequestMapping("queryByLimitGpsTime.action")
	public Map<String,Object> queryByLimitGpsTime(String startTime,String endTime){
		long start = System.currentTimeMillis();
		List<Map<String,Object>> list = gpsDataService.queryByLimitGpsTime(startTime+" 00:00:00", endTime+" 23:59:59");
		start = (long)(System.currentTimeMillis()-start);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code","200");
		map.put("msg","操作成功");
		map.put("查询出数据条数：",list.size());
		map.put("耗时：",start+"毫秒");
		return map;
	}
	@RequestMapping("queryByGpsTime.action")
	public Map<String,Object> queryByGpsTime(String time){
		long start = System.currentTimeMillis();
		List<Map<String,Object>> list = gpsDataService.queryByGpsTime(time);
		start = (long)(System.currentTimeMillis()-start);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code","200");
		map.put("msg","操作成功");
		map.put("查询出数据条数：",list.size());
		map.put("耗时：",start+"毫秒");
		return map;
	}
}
