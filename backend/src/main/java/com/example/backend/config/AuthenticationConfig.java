package com.example.backend.config;

import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AuthenticationConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/login", "/signup", "/denied", "/resources/**").permitAll() // 로그인 권한은 누구나, resources 파일도 모든 권한
                    // USER, ADMIN 접근 허용
                    .antMatchers("/userAccess").hasRole("USER")
                    .antMatchers("/userAccess").hasRole("ADMIN")
                    .antMatchers("/personal").authenticated()

                .and()
                .csrf().disable(); // 로그인 창
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService); // UserService를 사용하여 사용자 정보를 로드하고 인증
    }

}
