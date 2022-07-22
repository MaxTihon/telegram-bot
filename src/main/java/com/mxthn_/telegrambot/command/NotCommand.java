package com.mxthn_.telegrambot.command;

import com.mxthn_.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Implementation of {@link Command}.
 * NotCommand will return the received message.
 */
public class NotCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public NotCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        String message = update.getMessage().getText();

        sendBotMessageService.sendMessage(chatId, message);
    }
}
