package com.day20190916.test1;

public class Bean1 {

    private Bean2 bean2;

    private String name="����";

    public Bean1(){}

    public Bean1(Bean2 bean2){
        this.bean2 = bean2;
    }

    public Bean2 getBean2() {
        return bean2;
    }

    public void setBean2(Bean2 bean2) {
        this.bean2 = bean2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
