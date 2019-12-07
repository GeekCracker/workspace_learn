package com.muck.shardingsphere.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.muck.shardingsphere.domain.GpsData;
import com.muck.shardingsphere.mapper.GpsDataMapper;
import com.muck.shardingsphere.service.GpsDataService;

@Service
public class GpsDataServiceImpl extends BaseServiceImpl<GpsData> implements GpsDataService{

	@Resource
	GpsDataMapper gpsDataMapper;
	
	@Override
	public List<Map<String, Object>> queryByLimitGpsTime(String startTime, String endTime) {
		return gpsDataMapper.queryByLimitGpsTime(startTime, endTime);
	}

	@Override
	public List<Map<String, Object>> queryByGpsTime(String time) {
		return gpsDataMapper.queryByGpsTime(time);
	}
	
}
