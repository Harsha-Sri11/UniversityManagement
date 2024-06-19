package com.example.UMS.controllers;

import com.example.UMS.entities.UserInfo;
import com.example.UMS.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserInfoService userInfoService;


    @GetMapping("/show")
    public String openAPI(){
        return "Endpoint is not secured";
    }

    @PostMapping("/adduser")     // For user sign up
    public UserInfo addNewUser(@RequestBody UserInfo userInfo) {
        return userInfoService.addNewUser(userInfo);
    }

    @GetMapping("/getusers")
    public List<UserInfo> getUsers(){
        return userInfoService.getUsers();
    }

    @DeleteMapping("/deleteuser/{userid}")
    public String deleteUser(@PathVariable int userid){
        userInfoService.deleteUser(userid);
        return "Record deleted successfully";
    }
}
