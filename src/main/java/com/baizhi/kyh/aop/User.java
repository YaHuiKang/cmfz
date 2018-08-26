package com.baizhi.kyh.aop;

import org.springframework.beans.factory.annotation.Value;

public class User {
    @Value(value = "${user.name}")
    private String name;
}
