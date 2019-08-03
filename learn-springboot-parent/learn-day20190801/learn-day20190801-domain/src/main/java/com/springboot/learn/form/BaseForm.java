package com.springboot.learn.form;

import org.apache.tomcat.util.modeler.BaseModelMBean;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BaseForm extends BaseModelMBean {

    //@NotNull(message = "ID不能为空")
    private String id;

    //@NotNull(message = "企业ID不能为空")
    private String companyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
