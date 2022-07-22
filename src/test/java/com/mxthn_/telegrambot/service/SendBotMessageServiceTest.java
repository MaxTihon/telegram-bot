package com.mxthn_.telegrambot.service;

import com.mxthn_.telegrambot.bot.TihonTelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.*;

class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    private TihonTelegramBot bot;

    @BeforeEach
    void setUp() {
        bot = Mockito.mock(TihonTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(bot);
    }

    @Test
    public void ShouldProperlySendMessage() throws TelegramApiException {
        Long chatId = 12345L;
        String message = "Test message";

        SendMessage sm = new SendMessage();
        sm.setChatId(chatId);
        sm.setText(message);
        sm.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(bot).execute(sm);
    }
}