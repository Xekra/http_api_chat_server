CREATE TABLE `api`.`users`
(
    `id`         BIGINT(20) NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(45) NOT NULL,
    `created_at` DATETIME    NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE
);

CREATE TABLE `api`.`chats`
(
    `id`         BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(45) NOT NULL,
    `created_at` DATETIME    NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
);

CREATE TABLE `api`.`messages`
(
    `id`         BIGINT(20) NOT NULL AUTO_INCREMENT,
    `text`       VARCHAR(45) NULL,
    `created_at` DATETIME NOT NULL,
    `chat_id`    BIGINT(20) NOT NULL,
    `user_id`    BIGINT(20) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX        `fk_users_id_idx` (`user_id` ASC) VISIBLE,
    INDEX        `fk_chats_id_idx` (`chat_id` ASC) VISIBLE,
    CONSTRAINT `fk_chats`
        FOREIGN KEY (`chat_id`)
            REFERENCES `api`.`chats` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_users`
        FOREIGN KEY (`user_id`)
            REFERENCES `api`.`users` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);



CREATE TABLE `api`.`chats_users`
(
    `chat_id` BIGINT(20) NOT NULL,
    `user_id` BIGINT(20) NOT NULL,
    INDEX     `fk_chats_idx` (`chat_id` ASC) VISIBLE,
    INDEX     `fk_users_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_chat`
        FOREIGN KEY (`chat_id`)
            REFERENCES `api`.`chats` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `api`.`users` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);



INSERT INTO `api`.`users` (`id`, `username`, `created_at`)
VALUES ('1', 'Roman', '2022-05-28 00:10:00');
INSERT INTO `api`.`users` (`id`, `username`, `created_at`)
VALUES ('2', 'Natasha', '2022-05-28 00:10:00');
INSERT INTO `api`.`users` (`id`, `username`, `created_at`)
VALUES ('3', 'Barry', '2022-05-28 00:10:00');

INSERT INTO `api`.`chats` (`id`, `name`, `created_at`)
VALUES ('1', 'Roman_Natasha', '2022-05-28 00:12:00');
INSERT INTO `api`.`chats` (`id`, `name`, `created_at`)
VALUES ('2', 'Natasha_Barry', '2022-05-28 00:13:00');
INSERT INTO `api`.`chats` (`id`, `name`, `created_at`)
VALUES ('3', 'Barry_Roman', '2022-05-28 00:14:00');


INSERT INTO `api`.`messages` (`id`, `text`, `created_at`, `chat_id`, `user_id`)
VALUES ('1', 'Привет Рома!', '2022-05-28 00:15:00', '1', '2');
INSERT INTO `api`.`messages` (`id`, `text`, `created_at`, `chat_id`, `user_id`)
VALUES ('2', 'Привет Наташа!', '2022-05-28 00:15:10', '1', '1');
INSERT INTO `api`.`messages` (`id`, `text`, `created_at`, `chat_id`, `user_id`)
VALUES ('3', 'Как дела Барри?', '2022-05-28 00:15:15', '2', '2');
INSERT INTO `api`.`messages` (`id`, `text`, `created_at`, `chat_id`, `user_id`)
VALUES ('4', 'Хорошо. Как у тебя Наташа?', '2022-05-28 00:15:20', '2', '3');
INSERT INTO `api`.`messages` (`id`, `text`, `created_at`, `chat_id`, `user_id`)
VALUES ('5', 'Ты меня покормишь сегодня?', '2022-05-28 00:16:00', '3', '3');
INSERT INTO `api`.`messages` (`id`, `text`, `created_at`, `chat_id`, `user_id`)
VALUES ('6', 'Уже положил покушать', '2022-05-28 00:16:10', '3', '1');

INSERT INTO api.chats_users (chat_id, user_id) VALUES (1, 1);
INSERT INTO api.chats_users (chat_id, user_id) VALUES (1, 2);
INSERT INTO api.chats_users (chat_id, user_id) VALUES (2, 2);
INSERT INTO api.chats_users (chat_id, user_id) VALUES (2, 3);
INSERT INTO api.chats_users (chat_id, user_id) VALUES (3, 1);
INSERT INTO api.chats_users (chat_id, user_id) VALUES (3, 3);



# AUTO_INCREMENT