package com.mxthn_.telegrambot.service;

import com.mxthn_.telegrambot.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserService {
    void save(TelegramUser telegramUser);
    List<TelegramUser> retrieveAllActiveUser();
    Optional<TelegramUser> findByChatId(Long chatId);
}
