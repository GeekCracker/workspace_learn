package com.database.operation.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.database.operation.domain.Table;
import com.database.operation.query.TableQueryForm;
import com.database.operation.service.TableService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller("AdminTableController")
@RequestMapping("/admin/table")
public class TableController extends BaseController<Table> {

    @Resource
    private TableService tableService;



    @PostMapping("queryPageData")
    @ResponseBody
    public IPage<Table> queryPageData(TableQueryForm form){
        Page<Table> page = new Page<Table>(form.getPageNum(),form.getPageSize());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.last("limit "+page.offset()+","+page.getSize());
        return tableService.pageMaps(page,queryWrapper);
    }

    @Override
    protected IService<Table> getService() {
        return tableService;
    }
}
