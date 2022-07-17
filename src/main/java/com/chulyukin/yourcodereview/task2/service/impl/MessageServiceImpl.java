package com.chulyukin.yourcodereview.task2.service.impl;

import com.chulyukin.yourcodereview.task2.entity.Chat;
import com.chulyukin.yourcodereview.task2.entity.Message;
import com.chulyukin.yourcodereview.task2.entity.User;
import com.chulyukin.yourcodereview.task2.exception.ServiceException;
import com.chulyukin.yourcodereview.task2.repository.ChatRepository;
import com.chulyukin.yourcodereview.task2.repository.MessageRepository;
import com.chulyukin.yourcodereview.task2.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;

    /**
     * Создание сообщения
     * @param message сообщение пользователя
     * @return id идентификатор сообщения
     */
    @Override
    public Long create(Message message) {
        Chat chat = chatRepository.findById(message.getChat().getId()).get();

        Set<User> userSet = chat.getUsers();

        long count = userSet.stream()
                .filter(x -> x.getId().equals(message.getAuthor().getId()))
                .count();

        if (count > 0) {
            message.setCreatedAt(new Date());
            return messageRepository.save(message).getId();
        }
        else
            throw new ServiceException("Author: " + message.getAuthor() + " not exist in " + message.getChat().getId());
    }

    /**
     * Получение списка всех сообщений чата со всеми полями,
     * отсортированный по времени создания сообщения (от раннего к позднему)
     * @param chat чат
     * @return Set<Message> список сообщений чата
     */
    @Override
    public Set<Message> getMessages(Chat chat) {
        Set<Message> messages = new TreeSet<>(Comparator.reverseOrder());
        messageRepository.findAll().forEach(m -> {
            if (m.getChat().getId().equals(chat.getId())) {
                messages.add(m);
            }
        });
        return messages;
    }
}
