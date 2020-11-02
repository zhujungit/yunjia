package com.hp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecConfig extends WebSecurityConfigurerAdapter {

    @Autowired//从spring容器中找ds，如何保证spring容器中有ds:1.依赖 2.配置参数
    private DataSource dataSource;

    @Override//认证--登录，授权
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中加入两个用户信息，作为登录验证
        //1.创建一个密码加密器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //2.添加两个用户信息
       /* auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("曹操").password(encoder.encode("666")).roles("房东")
                .and()
                .withUser("貂蝉").password(encoder.encode("123")).roles("租客");*/
       //jdbc连接数据库进行用户验证
        String p6 = encoder.encode("666");
        String p1 = encoder.encode("123");
        System.out.println(p6);
        System.out.println(p1);

        auth.jdbcAuthentication().passwordEncoder(encoder)
                .dataSource(dataSource)
                //根据用户名查询用户信息--登录校验
                .usersByUsernameQuery("select name ,psw ,1 from h_users where name=?")
                //根据用户名查询用户权限--登录成功后的用户授权(房东，租客)
                .authoritiesByUsernameQuery("select name,role authority from h_users where name=?");

    }


    @Override//页面访问权限控制
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//对请求进行权限管理
                .antMatchers("/").permitAll()//不拦截，随意访问
                .antMatchers("/house/**","/users/**","/admin","/index").hasAuthority("房东")
                .antMatchers("/index").hasAuthority("租客")
                .anyRequest().authenticated()
                .and().formLogin();//通过系统自带的登录页面，登录进去后，上面的权限控制就会生效
    }
}
