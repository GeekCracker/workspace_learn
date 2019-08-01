package com.database.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.database.operation.domain.TableField;
import com.database.operation.mapper.TableFieldMapper;
import com.database.operation.service.TableFieldService;
import org.springframework.stereotype.Service;

@Service
public class TableFieldServiceImpl extends ServiceImpl<TableFieldMapper, TableField> implements TableFieldService {
}
