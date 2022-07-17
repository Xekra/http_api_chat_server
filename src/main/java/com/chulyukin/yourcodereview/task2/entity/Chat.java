package com.chulyukin.yourcodereview.task2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "chats")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Chat implements Comparable<Chat>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Уникальное имя чата
     */
    @Column(name = "name")
    private String name;

    /**
     * Время создания
     */
    @Column(name = "created_at")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    private Date createdAt;

    /**
     * Список пользователей чата
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "chats_users",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @ToString.Exclude
    private Set<User> users = new HashSet<>();


    public Chat(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(id, chat.id) &&
                Objects.equals(name, chat.name) &&
                Objects.equals(users, chat.users) &&
                Objects.equals(createdAt, chat.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, users, createdAt);
    }

    @Override
    public int compareTo(Chat o) {
        return (int) (this.getCreatedAt().getTime() - o.getCreatedAt().getTime());
    }
}
