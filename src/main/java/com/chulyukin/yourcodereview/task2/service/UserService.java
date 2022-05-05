package com.chulyukin.yourcodereview.task2.service;

import com.chulyukin.yourcodereview.task2.entity.User;

/**
 * Сервис для работы с пользователями
 */
public interface UserService {

    /**
     * Создание нового пользователя
     * @param user пользователь
     * @return id идентификатор пользователя
     */
    Long create(User user);
}
