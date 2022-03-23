package com.chulyukin.yourcodereview.task2.service;

import com.chulyukin.yourcodereview.task2.entity.User;

/**
 * Сервис для работы с пользователями
 */
public interface UserService {

    /**
     * Создание нового пользователя
     * @param user
     * @return id
     */
    Long create(User user);
}
