package com.chulyukin.yourcodereview.task2.controller;

import com.chulyukin.yourcodereview.task2.dto.ChatDTO;
import com.chulyukin.yourcodereview.task2.entity.Chat;
import com.chulyukin.yourcodereview.task2.entity.User;
import com.chulyukin.yourcodereview.task2.mappers.ChatMapper;
import com.chulyukin.yourcodereview.task2.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chats")
public class ChatController {

    private final ChatService chatService;
    private final ChatMapper chatMapper;

    /**
     * POST запрос на создание чата
     * @param chat чат
     * @return id или HTTP-код ошибки + описание ошибки
     */
    @PostMapping(value = "/add")
    public ResponseEntity<Long> createChat(@RequestBody Chat chat) {
        return new ResponseEntity<>(chatService.create(chat), HttpStatus.CREATED);
    }

    /**
     * POST запрос для получения списка чатов конкретного пользователя
     * @param user пользователь
     * @return Set<ChatDTO> или HTTP-код ошибки + описание ошибки
     */
    @PostMapping(value = "/get")
    public ResponseEntity<Set<ChatDTO>> getChats(@RequestBody User user) {
        Set<Chat> chats = chatService.getChatsByUser(user);
        return new ResponseEntity<>(chats.stream().map(chatMapper::toDTO).collect(Collectors.toSet()), HttpStatus.OK);
    }
}
