package com.baizhi.kyh.dao;

import com.baizhi.kyh.enity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    //查所有
    List<Menu> selectAllMenu();
}
