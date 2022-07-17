package com.chulyukin.yourcodereview.task2.mappers;

import com.chulyukin.yourcodereview.task2.dto.ChatDTO;
import com.chulyukin.yourcodereview.task2.entity.Chat;
import org.mapstruct.Mapper;

@Mapper
public interface ChatMapper {

    ChatDTO toDTO(Chat chat);
}
