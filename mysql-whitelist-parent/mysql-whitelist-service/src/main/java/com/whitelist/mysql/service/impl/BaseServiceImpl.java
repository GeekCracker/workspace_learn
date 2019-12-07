package com.whitelist.mysql.service.impl;

import com.whitelist.mysql.annotation.Table;
import com.whitelist.mysql.exception.BizException;
import com.whitelist.mysql.mapper.BaseMapper;
import com.whitelist.mysql.page.PageView;
import com.whitelist.mysql.response.CodeMessage;
import com.whitelist.mysql.service.BaseService;
import com.whitelist.mysql.utils.GenericsUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseMapper<T> getMapper();

    // 定义为抽象的,则必须要子类重写,此方法的功能是定义要查询的字段
    protected abstract String getFields();

    // 获取实体
    protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<T> listAll() {
        return getMapper().listAll();
    }

    @Override
    public List<T> queryData(String wherSQL, List<Object> whereParams) {
        // 第一步、获取要查询的字段
        String queryFields = getFields();
        if (StringUtils.isBlank(queryFields)) {
            throw new BizException(CodeMessage.QUERY_FIELDS_NOT_FOUND);
        }

        // 第二步、获取表名
        String tableName = getTableNameByEntity(this.entityClass);

        // 第三步、获取where条件
        String where = StringUtils.isBlank(wherSQL) ? "" : " where " + wherSQL;
        // 第四步、拼接sql语句
        String selectSQL = " SELECT " + queryFields + " from " + tableName + where;
        // 第五步、设置参数
        selectSQL = setQueryParams(selectSQL, whereParams, null);

        return getMapper().queryData(selectSQL);
    }

    @Override
    public List<T> queryData() {
        return this.queryData(null, null);
    }

    @Override
    public PageView<T> queryPageData(Long currentPageNum, Long pageSize, String whereSQL, List<Object> whereParams, LinkedHashMap<String, String> orderBy) {
        return null;
    }

    @Override
    public PageView<T> queryPageData() {
        return null;
    }


    //================================================================

    // 获取实体所对应的表名
    protected String getTableNameByEntity(Class<T> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        if (table == null || "".equals(table.name().trim())) {
            throw new BizException(CodeMessage.TABLE_ANNOTATION_NOT_FOUND);
        }
        return table.name();
    }

    // 设置参数信息并返回此sql
    protected String setQueryParams(String sql, List<Object> queryParams, PageView<T> pageView) {

        List<Object> allParams = new ArrayList<Object>();
        if (queryParams != null && queryParams.size() > 0) {
            allParams.addAll(queryParams);
        }
        if (sql.contains("limit")) {
            if (pageView != null) {
                allParams.add(pageView.getStartIndex());
                allParams.add(pageView.getPageSize());
            }
        }
        sql = String.format(sql, allParams.toArray());
        return sql;
    }
}
