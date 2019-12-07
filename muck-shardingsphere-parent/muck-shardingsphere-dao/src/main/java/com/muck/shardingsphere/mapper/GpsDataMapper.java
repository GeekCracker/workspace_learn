package com.muck.shardingsphere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GpsDataMapper {

	@Select("select * from t_biz_gps_data where gps_time between  #{startTime} and #{endTime};")
	public List<Map<String,Object>> queryByLimitGpsTime(@Param("startTime")String startTime,@Param("endTime")String endTime);
	
	@Select("select * from t_biz_gps_data where gps_time = #{time};")
	public List<Map<String,Object>> queryByGpsTime(@Param("time")String time);
}
