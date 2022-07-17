package com.chulyukin.yourcodereview.task2.controller;

import com.chulyukin.yourcodereview.task2.dto.UserDTO;
import com.chulyukin.yourcodereview.task2.entity.User;
import com.chulyukin.yourcodereview.task2.mappers.UserMapper;
import com.chulyukin.yourcodereview.task2.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    /**
     * POST запрос на создание пользователя
     * @param user пользователь
     * @return id или HTTP-код ошибки + описание ошибки
     */
    @PostMapping(value = "/add")
    public ResponseEntity<Long> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    /**
     * GET запрос на получение пользователя по id
     * @param id идентификатор пользователя
     * @return UserDTO представление пользователя в DTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }
}