package com.whitelist.mysql.service;

import com.whitelist.mysql.page.PageView;

import java.util.LinkedHashMap;
import java.util.List;

public interface BaseService<T> {

    /**
     * 获取所有的记录
     * @return  返回所有的记录
     */
    List<T> listAll();

    /**
     * @Description: 根据条件查询数据
     * @param: wherSQL
     *             传入查询的sql语句
     * @param: whereParams
     *             传入查询的条件
     * @return: List<T> 返回数据列表
     */
    List<T> queryData(String whereSQL, List<Object> whereParams);

    /**
     * @Description: 查询所有的数据
     * @return: List<T> 返回所有的数据列表
     */
    List<T> queryData();

    public PageView<T> queryPageData(Long currentPageNum, Long pageSize, String whereSQL, List<Object> whereParams,
                                     LinkedHashMap<String, String> orderBy);

    public PageView<T> queryPageData();
}
