package com.mxthn_.telegrambot.command;

import com.mxthn_.telegrambot.bot.TihonTelegramBot;
import com.mxthn_.telegrambot.service.SendBotMessageService;
import com.mxthn_.telegrambot.service.SendBotMessageServiceImpl;
import com.mxthn_.telegrambot.service.TelegramUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class AbstractCommandTest {
    protected TihonTelegramBot bot;
    protected SendBotMessageService sendBotMessageService;
    protected TelegramUserService telegramUserService;

    abstract String getCommandName();
    abstract String getCommandMessage();
    abstract Command getCommand();

    @BeforeEach
    void setUp() {
        bot = Mockito.mock(TihonTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(bot);
        telegramUserService = Mockito.mock(TelegramUserService.class);
    }

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chatId = 12345L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sm = new SendMessage();
        sm.setChatId(chatId);
        sm.setText(getCommandMessage());
        sm.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(bot).execute(sm);
    }
}
