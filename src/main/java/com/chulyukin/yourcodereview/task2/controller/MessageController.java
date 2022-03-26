package com.chulyukin.yourcodereview.task2.controller;

import com.chulyukin.yourcodereview.task2.entity.Chat;
import com.chulyukin.yourcodereview.task2.entity.Message;
import com.chulyukin.yourcodereview.task2.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    /**
     * POST запрос на создание сообщения
     * @param message сообщение пользователя в чате
     * @return id или HTTP-код ошибки + описание ошибки
     */
    @PostMapping(value = "/add")
    public @ResponseBody Long createMessage(@RequestBody Message message) {
        return messageService.create(message);
    }

    /**
     * POST запрос для получения списка сообщений в конкретном чате
     * @param chat чат
     * @return Set<Message> или HTTP-код ошибки + описание ошибки
     */
    @PostMapping(value = "/get")
    public @ResponseBody Set<Message> getMessages(@RequestBody Chat chat) {
        return messageService.getMessages(chat);
    }

}
