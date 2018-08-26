package com.baizhi.kyh.service;

import com.baizhi.kyh.dao.MenuDao;
import com.baizhi.kyh.enity.Menu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService{
    @Resource(name = "menuDao")
    private MenuDao menuDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAllMenu() {
        return menuDao.selectAllMenu();
    }
}
