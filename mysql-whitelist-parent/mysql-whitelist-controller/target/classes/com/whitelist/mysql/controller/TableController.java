package com.whitelist.mysql.controller;

import com.whitelist.mysql.domain.Table;
import com.whitelist.mysql.form.TableQueryForm;
import com.whitelist.mysql.helper.QueryHelper;
import com.whitelist.mysql.response.ResponseResult;
import com.whitelist.mysql.service.BaseService;
import com.whitelist.mysql.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("TableController")
@RequestMapping("/table")
public class TableController extends BaseController<Table> {

    @Autowired
    private TableService tableService;

    @RequestMapping("queryData")
    public ResponseResult queryData(TableQueryForm form){
        QueryHelper queryHelper = new QueryHelper();
        queryHelper.addCondition(form.getDatabase(),"table_schema = '%s'",false);
        return ResponseResult.ok(tableService.queryData(queryHelper.getWhereSQL(),queryHelper.getWhereParams()));
    }

    @Override
    protected BaseService<Table> getService() {
        return tableService;
    }
}
