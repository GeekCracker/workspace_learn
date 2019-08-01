package com.database.operation.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.database.operation.query.TableQueryForm;
import com.database.operation.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller("AdminMapController")
@RequestMapping("/admin/map")
public class MapController extends BaseController<Map<String,Object>> {

    @Autowired
    private MapService mapService;


    @PostMapping("queryPageData")
    @ResponseBody
    public IPage<Map<String,Object>> queryPageData(TableQueryForm form){
        Page<Map<String,Object>> page = new Page<Map<String,Object>>(form.getPageNum(),form.getPageSize());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.last("limit "+page.offset()+","+page.getSize());
        return mapService.pageMaps(page,queryWrapper);
    }
    @Override
    protected IService<Map<String, Object>> getService() {
        return mapService;
    }
}
