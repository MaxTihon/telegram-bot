package com.mxthn_.telegrambot.repository;

import com.mxthn_.telegrambot.repository.entity.TelegramUser;
import com.mxthn_.telegrambot.service.TelegramUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TelegramUserRepositoryTest {
    @Autowired
    private TelegramUserRepository telegramUserRepository;

    @Sql(statements = {"""
            INSERT INTO telegram_user VALUES (12345, true);
            INSERT INTO telegram_user VALUES (1234567, true);
            INSERT INTO telegram_user VALUES (123456, false);
            """})
    @Test
    public void properlyFindAllActiveUsers() {
        List<TelegramUser> activeUsers = telegramUserRepository.findAllByIsActiveTrue();

        assertThat(activeUsers.size()).isEqualTo(2);
    }

    @Test
    public void properlySaveNewUser() {
        // тут тест
    }
}