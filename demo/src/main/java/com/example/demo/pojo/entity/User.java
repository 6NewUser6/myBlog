package com.example.demo.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;           // 用户ID，格式为：usr_+UUID
    private String username;     // 用户名
    private String password;     // 密码哈希值
}