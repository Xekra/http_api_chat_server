package com.chulyukin.yourcodereview.task2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "messages")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Comparable<Message>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Текст отправленного сообщения
     */
    @Column(name = "text")
    private String text;
    /**
     * Дата содания
     */
    @Column(name = "created_at")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    private Date createdAt;
    /**
     * Ссылка на идентификатор чата, в который было отправлено сообщение
     */
    @OneToOne
    @JoinColumn(name = "CHAT_ID", referencedColumnName = "id")
    private Chat chat;
    /**
     * Ссылка на идентификатор отправителя сообщения
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User author;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(chat, message.chat) &&
                Objects.equals(author, message.author) &&
                Objects.equals(text, message.text) &&
                Objects.equals(createdAt, message.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chat, author, text, createdAt);
    }

    @Override
    public int compareTo(Message o) {
        return (int) (this.getCreatedAt().getTime() - o.getCreatedAt().getTime());
    }
}
