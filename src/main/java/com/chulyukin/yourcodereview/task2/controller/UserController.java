package com.chulyukin.yourcodereview.task2.controller;

import com.chulyukin.yourcodereview.task2.entity.User;
import com.chulyukin.yourcodereview.task2.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * POST запрос на создание пользователя
     * @param user пользователь
     * @return id или HTTP-код ошибки + описание ошибки
     */
    @PostMapping(value = "/add")
    public @ResponseBody Long  createUser(@RequestBody User user) {
        return userService.create(user);
    }
}
