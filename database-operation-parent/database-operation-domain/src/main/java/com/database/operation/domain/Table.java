package com.database.operation.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value="TABLES")
public class Table extends BaseEntity {

    @TableField(value = "TABLE_NAME")
    private String tableName;

}
