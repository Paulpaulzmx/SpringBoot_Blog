package com.z5n.springboot.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.naming.AuthenticationException;

/**
 * 安全配置类
 * @author zmx
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 访问静态文件不设限制，访问用户界面需要ADMIN权限；
     * 验证成功访问“/login”，失败访问“/login-error”
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index/**").permitAll() //静态文件都可以访问
                .antMatchers("/users/**").hasRole("ADMIN")                              //需要相应角色才可访问
                .and()
                .formLogin() // 基于form表单验证
                .loginPage("/login").failureUrl("/login-error");  // 自定义登陆页面
    }

    /**
     * 认证信息管理
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()   //认证信息存储与内存中
                .withUser("z5n").password("123456").roles("ADMIN");
    }
}
