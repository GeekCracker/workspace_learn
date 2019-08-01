package com.database.operation.configuretion;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfigure {

    //@Bean
    public DataSource dataSource(){

        //创建一个dbcp连接的数据源
        BasicDataSource basicDataSource = new BasicDataSource();




        return basicDataSource;
    }
}
