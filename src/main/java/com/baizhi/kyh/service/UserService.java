package com.baizhi.kyh.service;

import com.baizhi.kyh.dto.UserEchartsDto;
import com.baizhi.kyh.enity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService{
    //查所有
    List<User> queryAllUser();
    //添加
    void addUser(User user, MultipartFile photo, HttpServletRequest request);
    //上传
    void uploadExcel(User user,MultipartFile excel);
    //根据性别查用户
    List<UserEchartsDto> queryUserBySex(Integer sex);
    //根据时间查用户数量
    Map<String , Object> conutUserByTime();
}
