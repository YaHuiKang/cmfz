package com.baizhi.kyh.dao;

import com.baizhi.kyh.dto.UserEchartsDto;
import com.baizhi.kyh.enity.User;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserDao{
    //查所有
    List<User> selectAllUser();
    //添加
    void insertUser(User user);
    //根据性别查用户
    List<UserEchartsDto> seletUserBySex(Integer sex);

    //查询注册时间小于某几天的人
    Integer countUserByTime(Date time);
}
