package com.chulyukin.yourcodereview.task2.mappers;

import com.chulyukin.yourcodereview.task2.dto.UserDTO;
import com.chulyukin.yourcodereview.task2.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDTO toDTO(User user);
}
