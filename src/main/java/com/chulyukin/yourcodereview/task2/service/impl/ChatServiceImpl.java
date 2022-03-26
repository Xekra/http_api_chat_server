package com.chulyukin.yourcodereview.task2.service.impl;

import com.chulyukin.yourcodereview.task2.entity.Chat;
import com.chulyukin.yourcodereview.task2.entity.User;
import com.chulyukin.yourcodereview.task2.repository.ChatRepository;
import com.chulyukin.yourcodereview.task2.repository.UserRepository;
import com.chulyukin.yourcodereview.task2.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Создание чата
     * @param chat чат
     * @return id идентификатор чата
     */
    @Override
    public Long create(Chat chat) {
        chat.setCreated_at(new Date());
        return chatRepository.save(chat).getId();
    }

    /**
     * Получение списка всех чатов со всеми полями, отсортированный по
     * времени создания последнего сообщения в чате (от позднего к раннему).
     * @param user пользователь
     * @return Set<Chat> список чатов пользователя
     */
    @Override
    public Set<Chat> getChatsByUser(User user) {
        return userRepository.findById(user.getId())
                .get().getChats().stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
