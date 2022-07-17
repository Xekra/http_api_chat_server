package com.chulyukin.yourcodereview.task2.service;

import com.chulyukin.yourcodereview.task2.dto.ChatDTO;
import com.chulyukin.yourcodereview.task2.entity.Chat;
import com.chulyukin.yourcodereview.task2.entity.User;

import java.util.Set;

/**
 * Сервис для работы с чатами
 */
public interface ChatService {

    /**
     * Создание чата
     * @param chat чат
     * @return id идентификатор чата
     */
    Long create(Chat chat);

    /**
     * Получить список чатов
     * @param user пользователь
     * @return Set<Chat> Список чатов пользователя
     */
    Set<Chat> getChatsByUser(User user);
}
