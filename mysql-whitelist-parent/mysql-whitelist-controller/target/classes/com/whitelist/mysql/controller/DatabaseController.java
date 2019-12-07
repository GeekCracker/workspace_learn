package com.whitelist.mysql.controller;

import com.whitelist.mysql.domain.Database;
import com.whitelist.mysql.service.BaseService;
import com.whitelist.mysql.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("DatabaseController")
@RequestMapping("/database")
public class DatabaseController extends BaseController<Database> {

    @Autowired
    private DatabaseService databaseService;

    @Override
    protected BaseService<Database> getService() {
        return databaseService;
    }
}
