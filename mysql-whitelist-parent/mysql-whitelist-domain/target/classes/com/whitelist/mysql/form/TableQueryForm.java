package com.whitelist.mysql.form;

public class TableQueryForm extends BaseQueryForm{

    private String tableName;

    private String database;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
