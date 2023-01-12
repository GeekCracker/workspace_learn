package com.springboot.learn.domain;

import lombok.Data;

import java.util.Date;

/**
 * @description: 商品信息DTO
 * @author: 朱俊亮
 * @time: 2020/3/16 14:30
 */
@Data
public class ItemDto extends BaseEntity{

    /**商品ID*/
    private Long itemId;
    /**商品编号*/
    private String code;
    /**商品标题*/
    private String title;
    /**二级标题*/
    private String subTitle;
    /**一级类目ID*/
    private Long firstId;
    /**二级类目ID*/
    private Long secondId;
    /**主图*/
    private String mainImage;
    /**系列ID*/
    private Long seriesId;
    /**品牌ID*/
    private Long brandId;
    /**年份*/
    private Integer year;
    /**季节*/
    private String season;
    /**性别*/
    private String sex;
    /**批次*/
    private String batch;
    /**波段*/
    private String part;
    /**一级类目名称*/
    private String firstName;
    /**二级类目名称*/
    private String secondName;
    /**系列名称*/
    private String seriesName;
    /**品牌名称*/
    private String brandName;
    /**创建时间*/
    private Date created;
}
