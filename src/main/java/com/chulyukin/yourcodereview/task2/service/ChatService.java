package com.chulyukin.yourcodereview.task2.service;

import com.chulyukin.yourcodereview.task2.entity.Chat;
import com.chulyukin.yourcodereview.task2.entity.User;

import java.util.Set;

/**
 * Сервис для работы с чатами
 */
public interface ChatService {

    /**
     * Создание чата
     * @param chat
     * @return id
     */
    Long create(Chat chat);

    /**
     * Получить список чатов
     * @param user
     * @return Список чатов пользователя
     */
    Set<Chat> getChatsByUser(User user);
}
