package com.example.UMS.controllers;

import com.example.UMS.entities.UserInfo;
import com.example.UMS.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserInfoService userInfoService;


    @GetMapping("/show")
    public String openAPI(){
        return "Endpoint is not secured";
    }

    @PostMapping("/adduser")
    public UserInfo addNewUser(@RequestBody UserInfo userInfo) {
        return userInfoService.addNewUser(userInfo);
    }

    @GetMapping("/getusers")
    public List<UserInfo> getUsers(){
        return userInfoService.getUsers();
    }
}
