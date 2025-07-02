package com.example.demo.controller;

import com.example.demo.pojo.dto.request.LoginRequest;
import com.example.demo.pojo.dto.request.RegisterRequest;
import com.example.demo.pojo.dto.response.AuthResponse;
import com.example.demo.pojo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {
    UserService userService;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        if (userService.existsByUsername(request.getUsername())){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("用户名不可重复");
        }
        String userId = "Usr_" + System.currentTimeMillis() + (int)(Math.random() * 1000);
        String password = encoder.encode(request.getPassword());
        userService.registerUser(new User(userId,request.getUsername(),password));
        return ResponseEntity.ok("用户" + request.getUsername()+"注册成功");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        if (userService.loginUser(request.getUsername(),request.getPassword())){
            return ResponseEntity.ok("登录成功: " + request.getUsername());
        }
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("用户名或密码错误");
    }
}
