package com.whitelist.mysql.service.impl;

import com.whitelist.mysql.domain.Database;
import com.whitelist.mysql.mapper.BaseMapper;
import com.whitelist.mysql.mapper.DatabaseMapper;
import com.whitelist.mysql.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseServiceImpl extends BaseServiceImpl<Database> implements DatabaseService {

    @Autowired
    private DatabaseMapper databaseMapper;

    @Override
    protected BaseMapper<Database> getMapper() {
        return databaseMapper;
    }

    @Override
    protected String getFields() {
        return "database";
    }
}
