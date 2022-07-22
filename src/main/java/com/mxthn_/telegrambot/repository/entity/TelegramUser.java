package com.mxthn_.telegrambot.repository.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "telegram_user")
public class TelegramUser {
    @Id
    @Column(name = "chat_id")
    private Long chatId;
    @Column(name = "is_active")
    private boolean isActive;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<JavaRushGroupSubscription> groups;

    public void switchIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TelegramUser that = (TelegramUser) o;
        return chatId != null && Objects.equals(chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
