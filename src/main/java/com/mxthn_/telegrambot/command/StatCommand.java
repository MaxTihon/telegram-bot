package com.mxthn_.telegrambot.command;

import com.mxthn_.telegrambot.service.SendBotMessageService;
import com.mxthn_.telegrambot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StatCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STAT_MESSAGE = "Now is %d active users";

    public StatCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }



    @Override
    public void execute(Update update) {
        int activeUserCount = telegramUserService.retrieveAllActiveUser().size();
        long chatId = update.getMessage().getChatId();

        sendBotMessageService.sendMessage(chatId, String.format(STAT_MESSAGE, activeUserCount));
    }
}
