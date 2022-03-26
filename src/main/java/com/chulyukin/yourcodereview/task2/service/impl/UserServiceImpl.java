package com.chulyukin.yourcodereview.task2.service.impl;

import com.chulyukin.yourcodereview.task2.entity.User;
import com.chulyukin.yourcodereview.task2.repository.UserRepository;
import com.chulyukin.yourcodereview.task2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Создание пользователя
     * @param user пользователь
     * @return id идентификатор пользователя
     */
    @Override
    public Long create(User user) {
        user.setCreated_at(new Date());
        return userRepository.save(user).getId();
    }
}
