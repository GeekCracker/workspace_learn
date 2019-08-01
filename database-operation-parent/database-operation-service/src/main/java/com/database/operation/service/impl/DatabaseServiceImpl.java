package com.database.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.database.operation.domain.Database;
import com.database.operation.mapper.DatabaseMapper;
import com.database.operation.service.DatabaseService;
import org.springframework.stereotype.Service;

@Service
public class DatabaseServiceImpl extends ServiceImpl<DatabaseMapper, Database> implements DatabaseService {
}
