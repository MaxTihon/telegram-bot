ALTER TABLE telegram_user ADD PRIMARY KEY (chat_id);

DROP TABLE IF EXISTS jr_group_sub;
CREATE TABLE jr_group_sub (
    id int PRIMARY KEY,
    title character varying(100),
    last_article_id int
);

DROP TABLE IF EXISTS sub_x_tg_user;
CREATE TABLE sub_x_tg_user (
    sub_id int NOT NULL,
    tg_user_id bigint NOT NULL,
    FOREIGN KEY (tg_user_id) REFERENCES telegram_user(chat_id),
    FOREIGN KEY (sub_id) REFERENCES jr_group_sub(id),
    UNIQUE (sub_id, tg_user_id)
);