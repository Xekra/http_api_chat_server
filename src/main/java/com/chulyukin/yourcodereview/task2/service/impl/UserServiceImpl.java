package com.chulyukin.yourcodereview.task2.service.impl;

import com.chulyukin.yourcodereview.task2.entity.User;
import com.chulyukin.yourcodereview.task2.exception.ServiceException;
import com.chulyukin.yourcodereview.task2.repository.UserRepository;
import com.chulyukin.yourcodereview.task2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Создание пользователя
     * @param user пользователь
     * @return id идентификатор пользователя
     */
    @Override
    public Long create(User user){
        if (user.getUsername() != null && !Objects.equals(user.getUsername(), "")) {
            user.setCreatedAt(new Date());
            return userRepository.save(user).getId();
        }else
            throw new ServiceException("userName field is null.");
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }
}
