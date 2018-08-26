package com.baizhi.kyh.dto;

import java.io.Serializable;

public class UserEchartsDto implements Serializable {
    private String name;
    private Integer value;

    public UserEchartsDto() {
        super();
    }

    @Override
    public String toString() {
        return "UserEchartsDto{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public UserEchartsDto(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
