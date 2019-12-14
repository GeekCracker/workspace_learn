package com.redis.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.redis.handler.IdTypeHandler;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基类，实现了ID加密
 */
public class BaseEntity implements Serializable {

    /**主键ID*/
    @TableField(exist = false)
    private String id;

    // 定义一个idRaw的字段
    @TableId(value = "id", type = IdType.AUTO)
    @JsonIgnore
    private Long idRaw;

    /**创建人*/
    private String createBy;

    /**创建时间(自动填充，无需手动维护)*/
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**修改人*/
    private String updateBy;

    /**修改时间(自动填充，无需手动维护)*/
    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public String getId() {
        if (id == null && idRaw != null && idRaw > 0) {
            id = IdTypeHandler.encode(idRaw);
        }
        if (id != null && "".equals(id.replaceAll(" ", ""))) {
            id = null;
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIdRaw() {
        if(id != null && !"".equals(id.replaceAll(" ",""))){
            return IdTypeHandler.decode(id);
        }
        return idRaw;
    }

    public void setIdRaw(Long idRaw) {
        this.idRaw = idRaw;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
