package com.chulyukin.yourcodereview.task2.controller;

import com.chulyukin.yourcodereview.task2.entity.Chat;
import com.chulyukin.yourcodereview.task2.entity.User;
import com.chulyukin.yourcodereview.task2.service.impl.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatServiceImpl chatService;

    /**
     * POST запрос на создание чата
     * @param chat чат
     * @return id или HTTP-код ошибки + описание ошибки
     */
    @PostMapping(value = "/add")
    public @ResponseBody Long createChat(@RequestBody Chat chat) {
        return chatService.create(chat);
    }

    /**
     * POST запрос для получения списка чатов конкретного пользователя
     * @param user пользователь
     * @return Set<Chat> или HTTP-код ошибки + описание ошибки
     */
    @PostMapping(value = "/get")
    public @ResponseBody Set<Chat> getChats(@RequestBody User user) {
        return chatService.getChatsByUser(user);
    }
}
