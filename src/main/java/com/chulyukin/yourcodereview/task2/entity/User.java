package com.chulyukin.yourcodereview.task2.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Имя пользователя
     */
    @Column(unique = true)
    private String username;

    /**
     * Дата создания
     */
    private Date created_at;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Chat> chats = new HashSet<>();

    @ManyToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Message> messages = new HashSet<>();

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Set<Chat> getChats() {
        return chats;
    }

    public void setChats(Set<Chat> chats) {
        this.chats = chats;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(created_at, user.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, created_at);
    }
}
