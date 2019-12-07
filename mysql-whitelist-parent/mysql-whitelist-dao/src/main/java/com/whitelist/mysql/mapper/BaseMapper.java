package com.whitelist.mysql.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BaseMapper<T> {

    @Select("use ${database};")
    void useDatabase(@Param("database") String database);

    @Select("flush privileges;")
    void flushPrivileges();

    List<T> listAll();

    @Select("${sql}")
    List<T> queryData(@Param("sql")String sql);

}
