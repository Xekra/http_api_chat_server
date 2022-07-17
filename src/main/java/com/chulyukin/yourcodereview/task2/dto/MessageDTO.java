package com.chulyukin.yourcodereview.task2.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private Long id;
    private ChatDTO chat;
    private UserDTO author;
    private String text;
    private Date createdAt;
}
