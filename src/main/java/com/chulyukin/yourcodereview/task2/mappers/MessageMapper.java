package com.chulyukin.yourcodereview.task2.mappers;

import com.chulyukin.yourcodereview.task2.dto.MessageDTO;
import com.chulyukin.yourcodereview.task2.entity.Message;
import org.mapstruct.Mapper;

@Mapper
public interface MessageMapper {

    MessageDTO toDTO(Message message);
}
