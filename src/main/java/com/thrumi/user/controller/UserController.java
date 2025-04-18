package com.thrumi.user.controller;

import com.thrumi.user.VO.ResponseTemplateVO;
import com.thrumi.user.entity.User;
import com.thrumi.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method in UserController");
        return userService.saveUser(user);
    }

//    @GetMapping("/{id}")
//    public User findByUserId(@PathVariable("id") Long userId) {
//        log.info("Inside findByUserId method in UserController");
//        return userService.findByUserId(userId);
//    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment method in UserController");
        return userService.getUserWithDepartment(userId);
    }
}
