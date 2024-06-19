package com.example.UMS.services;

import com.example.UMS.entities.UserInfo;
import com.example.UMS.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserInfo addNewUser(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return userRepository.save(userInfo);}

    public List<UserInfo> getUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(int userid){
         userRepository.deleteById(userid);
    }
}
