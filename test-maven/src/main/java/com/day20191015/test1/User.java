package com.day20191015.test1;

public class User {

    private Integer id;

    private Integer moduleId;

    private String name;

    public User() {
    }

    public User(Integer id, Integer moduleId, String name) {
        this.id = id;
        this.moduleId = moduleId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", moduleId=" + moduleId +
                ", name='" + name + '\'' +
                '}';
    }
}
