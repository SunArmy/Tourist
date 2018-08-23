package com.sunarmy.cn.Controller;

import com.sunarmy.cn.entity.User;
import com.sunarmy.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wb-wsj429645 on 2018/8/23.
 */
@RestController(value = "/")
public class LoginController {
    @Autowired
    UserService userService;


    @PostMapping(value = "login")
    public void login(String username,String password){
        System.out.println(username+"---------"+password);
    }
    @GetMapping(value = "register")
    public User register(User user){
        User user1 = userService.insertUser(user);
        return user1;
    }

}
