package com.baizhi.kyh.enity;

import java.io.Serializable;

public class Admin implements Serializable {
    private String id;
    private String name;
    private String password;
    private Integer level;

    public Admin() {
        super();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Admin(String id, String name, String password, Integer level) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.level = level;
    }
}
