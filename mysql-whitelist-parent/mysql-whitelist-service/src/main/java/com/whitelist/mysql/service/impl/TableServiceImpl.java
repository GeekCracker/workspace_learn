package com.whitelist.mysql.service.impl;

import com.whitelist.mysql.domain.Table;
import com.whitelist.mysql.mapper.BaseMapper;
import com.whitelist.mysql.mapper.TableMapper;
import com.whitelist.mysql.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl extends BaseServiceImpl<Table> implements TableService {

    @Autowired
    private TableMapper tableMapper;

    @Override
    protected BaseMapper<Table> getMapper() {
        return tableMapper;
    }

    @Override
    protected String getFields() {
        return "table_name";
    }
}
