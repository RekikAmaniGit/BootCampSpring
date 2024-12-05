package com.sip.controllers;

import com.sip.entities.User;
import com.sip.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class LoginTestController {
    UserService userService;
    public LoginTestController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addUser(){
    	System.out.println("treeeeee");
        User user = new User();
        user.setEmail("email@dsqd");
        user.setName("name");
        user.setAddress("adresse");
        user.setPassword("password");
        user.setLastName("lastName");
        this.userService.saveUser(user);
        
        System.out.println("treeeeee");
        return "added";
    }
}
