package com.mxthn_.telegrambot.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "telegram_user")
public class TelegramUser {
    @Id
    @Column(name = "chat_id")
    private Long chatId;
    @Column(name = "is_active")
    private boolean isActive;

    public void switchIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }
}
