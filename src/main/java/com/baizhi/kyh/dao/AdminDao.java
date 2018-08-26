package com.baizhi.kyh.dao;

import com.baizhi.kyh.enity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    //查一个
    Admin selectOneAdmin(String name);
}
