package com.chulyukin.yourcodereview.task2.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatDTO {

    private Long id;
    private String name;
    private Date createdAt;
}
