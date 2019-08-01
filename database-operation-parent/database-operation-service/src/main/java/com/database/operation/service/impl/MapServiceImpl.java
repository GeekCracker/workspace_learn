package com.database.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.database.operation.mapper.MapMapper;
import com.database.operation.service.MapService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MapServiceImpl extends ServiceImpl<MapMapper, Map<String,Object>> implements MapService {
}
