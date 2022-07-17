package com.chulyukin.yourcodereview.task2.controller;

import com.chulyukin.yourcodereview.task2.dto.MessageDTO;
import com.chulyukin.yourcodereview.task2.entity.Chat;
import com.chulyukin.yourcodereview.task2.entity.Message;
import com.chulyukin.yourcodereview.task2.exception.InvalidRequestException;
import com.chulyukin.yourcodereview.task2.exception.ServiceException;
import com.chulyukin.yourcodereview.task2.mappers.MessageMapper;
import com.chulyukin.yourcodereview.task2.service.impl.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageServiceImpl messageService;
    private final MessageMapper messageMapper;

    /**
     * POST запрос на создание сообщения
     * @param message сообщение пользователя в чате
     * @return id или HTTP-код ошибки + описание ошибки
     */
    @PostMapping(value = "/add")
    public ResponseEntity<Long> createMessage(@RequestBody Message message) {

        if (message == null || message.getChat() == null) {
            throw new InvalidRequestException("Message or chat id must not be null!");
        } else if (message.getAuthor() == null || message.getText() == null) {
            throw new InvalidRequestException("Author of message or text of message must not be null!");
        }
        return new ResponseEntity<>(messageService.create(message), HttpStatus.CREATED);
    }

    /**
     * POST запрос для получения списка сообщений в конкретном чате
     * @param chat чат
     * @return Set<MessageDTO> или HTTP-код ошибки + описание ошибки
     */
    @PostMapping(value = "/get")
    public ResponseEntity<Set<MessageDTO>> getMessages(@RequestBody Chat chat) {
        Set<Message> messages = messageService.getMessages(chat);
        return new ResponseEntity<>(messages.stream().map(messageMapper::toDTO).collect(Collectors.toSet()), HttpStatus.OK);
    }
}
