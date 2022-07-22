package com.mxthn_.telegrambot.service;

import com.mxthn_.telegrambot.repository.TelegramUserRepository;
import com.mxthn_.telegrambot.repository.entity.TelegramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelegramUserServiceImpl implements TelegramUserService {
    private final TelegramUserRepository repository;

    @Autowired
    public TelegramUserServiceImpl(TelegramUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(TelegramUser telegramUser) {
        repository.save(telegramUser);
    }

    @Override
    public List<TelegramUser> retrieveAllActiveUser() {
        return repository.findAllByIsActiveTrue();
    }

    @Override
    public Optional<TelegramUser> findByChatId(Long chatId) {
        return repository.findById(chatId);
    }
}
