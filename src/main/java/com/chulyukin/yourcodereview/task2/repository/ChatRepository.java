package com.chulyukin.yourcodereview.task2.repository;


import com.chulyukin.yourcodereview.task2.entity.Chat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с чатом
 */
@Repository
public interface ChatRepository extends CrudRepository<Chat, Long> {
}
