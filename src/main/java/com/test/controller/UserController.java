package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
public class UserController {

    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        UserController.userService = userService;
    }

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin-config/set-user-inactive", method = RequestMethod.POST)
    @ResponseBody
    public void setUserInactive(@RequestBody String json) {
        Long userId = Long.parseLong(json, 10);
        User user = userService.findById(userId);
        user.setActive(false);
        userService.update(user);
    }

    @RequestMapping(value = "/admin-config/set-user-active", method = RequestMethod.POST)
    @ResponseBody
    public void setUserActive(@RequestBody String json) {
        Long userId = Long.parseLong(json, 10);
        User user = userService.findById(userId);
        user.setActive(true);
        userService.update(user);
    }
}
