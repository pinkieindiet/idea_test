package com.lyx.controller;

import com.lyx.pojo.User;
import com.lyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get/{id}")
    public User findById(@PathVariable(name = "id") Integer id) {
        System.out.println("2222222222222222222222222");
        return userService.findById(id);
    }

}
