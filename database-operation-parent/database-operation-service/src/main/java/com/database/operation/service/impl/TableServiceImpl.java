package com.database.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.database.operation.domain.Table;
import com.database.operation.mapper.TableMapper;
import com.database.operation.service.TableService;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl extends ServiceImpl<TableMapper, Table> implements TableService {
}
