package com.cjq;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 开启服务认证
 * @author cjq
 * @date 2020/8/12
 */
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf验证
        http.csrf().disable();
        //开启验证，URl格式登录必须是httpBasic
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
