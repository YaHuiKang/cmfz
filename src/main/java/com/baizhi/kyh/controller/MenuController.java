package com.baizhi.kyh.controller;

import com.baizhi.kyh.enity.Menu;
import com.baizhi.kyh.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {
    @Resource(name = "menuService")
    private MenuService menuService;

    //查所有
    @RequestMapping("queryAllMenu")
    @ResponseBody
    public List<Menu> queryAllMenu(){
        return menuService.queryAllMenu();
    }
}
