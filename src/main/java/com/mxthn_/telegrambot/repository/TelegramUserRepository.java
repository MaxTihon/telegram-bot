package com.mxthn_.telegrambot.repository;

import com.mxthn_.telegrambot.repository.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long> {
    List<TelegramUser> findAllByIsActiveTrue();
}
