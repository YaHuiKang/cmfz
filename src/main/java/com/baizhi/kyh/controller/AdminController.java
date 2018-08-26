package com.baizhi.kyh.controller;

import com.baizhi.kyh.enity.Admin;
import com.baizhi.kyh.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource(name = "adminService")
    private AdminService adminService;

    //查一个
    @RequestMapping("/checkLogin")
    public String checkLogin(String enCode, String name, String password,
                             HttpSession session){
        String vrifyCode = (String)session.getAttribute("vrifyCode");
        String s = enCode.toUpperCase();

        Subject subject = SecurityUtils.getSubject();
        Boolean flag = false;
        if(vrifyCode.equals(s)){
           /* Admin admin = adminService.queryOneAdmin(name);
            if(admin != null && admin.getPassword().equals(password)){
                session.setAttribute("admin",admin);
                return "redirect:/main/main.jsp";
            }else {
                return "redirect:/login.jsp";
            }*/
            try {
                subject.login(new UsernamePasswordToken(name ,password));
                flag = true;
                String principal = (String) subject.getPrincipal();
                session.setAttribute("admin",principal);
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
            if (flag){
                return "redirect:/main/main.jsp";
            }else {
                return "redirect:/login.jsp";
            }
        }else{
            return "login";
        }
    }
    //退出
    @RequestMapping("logout")
    public String logout(HttpSession session){
        if(session== null){
            return "redirect:/login.jsp";
        }else{
            String str = (String) session.getAttribute("admin");
            session.setAttribute("str" ,null);
            session.removeAttribute("str");
            return "redirect:/login.jsp";
        }
    }

}
