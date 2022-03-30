package com.zyp.springboot06security.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//AOP横切思想
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问,功能页只有相应权限的人才能访问
        //请求授权的规则~
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                        .antMatchers("/level2/**").hasRole("vip2")
                        .antMatchers("/level3/**").hasRole("vip3");
        //super.configure(http);
        //没有权限默认回到登录页面
        //定制登录页
        http.formLogin().loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/login");
        //开启注销功能
        //防止网站遭攻击 get，post
        http.csrf().disable();//关闭csrf，登录失败可能存在的原因
        http.logout().logoutSuccessUrl("/");
        //开启记住我的功能 cookie,默认保存两周，自定义接收前端的参数
        http.rememberMe().rememberMeParameter("remember");

    }
//认证，spring boot2.1.x可以直接使用~
    //密码编码：passwordEncoder
    //在spring Security 5.0+新增了许多加密方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据正常应该从数据库中读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zyp").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and().withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and().withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
