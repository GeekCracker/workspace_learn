package com.muck.shardingsphere.service;

import java.util.List;
import java.util.Map;

import com.muck.shardingsphere.domain.GpsData;

public interface GpsDataService extends BaseService<GpsData>{
	
	public List<Map<String,Object>> queryByLimitGpsTime(String startTime,String endTime);
	
	public List<Map<String,Object>> queryByGpsTime(String time);
}
