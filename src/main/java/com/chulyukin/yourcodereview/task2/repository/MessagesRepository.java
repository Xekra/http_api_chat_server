package com.chulyukin.yourcodereview.task2.repository;

import com.chulyukin.yourcodereview.task2.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с сообщениями
 */
@Repository
public interface MessagesRepository extends CrudRepository<Message, Long> {
}
