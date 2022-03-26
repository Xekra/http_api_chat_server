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
     * @param message сообщение пользователя
     * @return id идентификатор сообщения
     */
    Long create(Message message);

    /**
     * Получение списка сообщений
     * @param chat чат
     * @return Set<Message> сообщения чата
     */
    Set<Message> getMessages(Chat chat);
}
