package cn.itweet.common.config;

import cn.itweet.common.security.CustomUserService;
import cn.itweet.common.security.MyFilterSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Created by yangyibo on 17/1/18.
 */


@EnableAutoConfiguration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Bean
    public UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new CustomUserService();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                // Spring Security should completely ignore URLs starting with /resources/
                .antMatchers("/resources/*","/style/**","/blog/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());   //user Details Service验证
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable().headers().frameOptions().disable();
        http
                .authorizeRequests()
                .antMatchers("/admin/login", "/blog/**","/*").permitAll()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/admin/login")
                .failureUrl("/admin/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll(); //注销行为任意访问

        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }
}

