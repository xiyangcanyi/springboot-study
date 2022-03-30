package com.zyp.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

//自定义的Realm
public class UserRealm extends AuthorizingRealm {
   //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=》doGetAuthorizationInfo");

        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=》doGetAuthenticationInfo");
        //获取当前用户
//        Subject subject = SecurityUtils.getSubject();
//        //封装用户的登陆数据
        String name="root";
        String password="123456";
        UsernamePasswordToken userToken=(UsernamePasswordToken) authenticationToken;
        if(!userToken.getUsername().equals(name)){
            return null;//抛出异常
        }
        //密码做shiro做
        //md5加密
        return new SimpleAuthenticationInfo("",password,"");
    }
}
