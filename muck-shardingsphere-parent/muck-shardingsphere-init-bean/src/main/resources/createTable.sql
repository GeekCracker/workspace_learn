CREATE TABLE if not exists `t_biz_gps_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `vehicle_no` varchar(15) DEFAULT NULL COMMENT '车牌号',
  `vehicle_color` int(11) DEFAULT NULL COMMENT '车牌颜色(1:蓝色,2:黄色,3:白色,4:黑色,9:其他)',
  `longitude` bigint(20) DEFAULT NULL COMMENT '经度，单位10^6',
  `latitude` bigint(20) DEFAULT NULL COMMENT '纬度，单位10^6',
  `location` varchar(127) DEFAULT NULL COMMENT '当前经纬度所对应的位置',
  `speed` double DEFAULT NULL COMMENT '速度,对应到小数点后1位',
  `direction` varchar(31) DEFAULT NULL COMMENT '车辆的方向',
  `mileage` varchar(127) DEFAULT NULL COMMENT '总里程',
  `gps_time` timestamp NULL DEFAULT NULL COMMENT 'GPS时间',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除(1:不删除,0:删除)',
  `created_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `gps_time` (`gps_time`),
  KEY `vehicle_no` (`vehicle_no`),
  KEY `gps_time_vehicle_no_index` (`vehicle_no`,`gps_time`) USING BTREE,
  KEY `latitude` (`latitude`) USING BTREE,
  KEY `latitude_gps_time` (`gps_time`,`latitude`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='这个是业务表,是车辆的GPS数据表';


