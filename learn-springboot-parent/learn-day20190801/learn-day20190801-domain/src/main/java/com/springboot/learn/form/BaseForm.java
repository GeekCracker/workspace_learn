package com.springboot.learn.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BaseForm implements Serializable {

    /**记录ID*/
    @NotNull(message = "ID不能为空")
    private String id;
}
