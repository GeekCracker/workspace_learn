package com.springboot.learn.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class UserQueryForm extends BaseForm {

    @Email
    @NotBlank
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
