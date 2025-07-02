package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // 关闭CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()  // 开放auth路径
                        .anyRequest().authenticated()              // 其他请求需要认证
                );
        return http.build();
    }
}