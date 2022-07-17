package com.chulyukin.yourcodereview.task2.repository;

import com.chulyukin.yourcodereview.task2.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с пользователями
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User getUserById(Long id);
}
