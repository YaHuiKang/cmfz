package com.baizhi.kyh.service;

import com.baizhi.kyh.dao.AdminDao;
import com.baizhi.kyh.enity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource(name = "adminDao")
    private AdminDao adminDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin queryOneAdmin(String name) {
        return adminDao.selectOneAdmin(name);
    }
}
