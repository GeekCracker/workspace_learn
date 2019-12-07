package com.whitelist.mysql.mapper;

import com.whitelist.mysql.domain.Database;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface DatabaseMapper extends BaseMapper<Database> {

    @Select("show databases;")
    @Results(id="databaseResultMap",value = {
            @Result(column ="database" ,property = "database" ,jdbcType = JdbcType.VARCHAR)
    })
    List<Database> listAll();
}
