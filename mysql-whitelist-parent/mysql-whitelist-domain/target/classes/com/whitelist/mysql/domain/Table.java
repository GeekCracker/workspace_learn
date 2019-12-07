package com.whitelist.mysql.domain;

@com.whitelist.mysql.annotation.Table(name = "information_schema.tables")
public class Table extends BaseEntity{

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
