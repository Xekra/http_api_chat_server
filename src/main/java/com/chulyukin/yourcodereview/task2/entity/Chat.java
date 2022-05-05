package com.chulyukin.yourcodereview.task2.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "chats")
public class Chat implements Comparable<Chat>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Уникальное имя чата
     */
    @Column(unique = true)
    private String name;

    /**
     * Список пользователей чата
     */
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "CHAT_USER",
            joinColumns = @JoinColumn(name = "CHAT_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )
    private Set<User> users = new HashSet<>();

    /**
     * Время создания
     */
    private Date created_at;

    public Chat() {
    }

    public Chat(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(id, chat.id) &&
                Objects.equals(name, chat.name) &&
                Objects.equals(users, chat.users) &&
                Objects.equals(created_at, chat.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, users, created_at);
    }

    @Override
    public int compareTo(Chat o) {
        return (int) (this.getCreated_at().getTime() - o.getCreated_at().getTime());
    }
}
