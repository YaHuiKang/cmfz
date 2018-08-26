package com.baizhi.kyh.shiro;

import com.baizhi.kyh.enity.Admin;
import com.baizhi.kyh.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
public class MyRealm extends AuthorizingRealm {
    @Resource(name = "adminService")
    private AdminService adminService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String  principal = (String) authenticationToken.getPrincipal();
        Admin admin = adminService.queryOneAdmin(principal);
        if(admin != null){
            return new SimpleAuthenticationInfo(principal, admin.getPassword(), this.getName());
        }else {

        }
        return null;
    }
}
