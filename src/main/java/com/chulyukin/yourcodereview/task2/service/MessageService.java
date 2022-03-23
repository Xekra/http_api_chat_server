package com.chulyukin.yourcodereview.task2.service;

import com.chulyukin.yourcodereview.task2.entity.Chat;
import com.chulyukin.yourcodereview.task2.entity.Message;

import java.util.Set;

/**
 * Сервис для работы с сообщениями
 */
public interface MessageService {

    /**
     * Создание сообщения
     * @param message
     * @return id
     */
    Long create(Message message);

    /**
     * Получение списка сообщений
     * @param chat
     * @return сообщения чата
     */
    Set<Message> getMessages(Chat chat);
}
