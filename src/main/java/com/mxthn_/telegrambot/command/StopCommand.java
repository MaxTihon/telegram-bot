package com.mxthn_.telegrambot.command;

import com.mxthn_.telegrambot.service.SendBotMessageService;
import com.mxthn_.telegrambot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Implementation of {@link Command}
 */
public class StopCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;
    public static final String STOP_MESSAGE = "Ну и ладно(";

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();

        sendBotMessageService.sendMessage(chatId, STOP_MESSAGE);

        telegramUserService.findByChatId(chatId).ifPresent(telegramUser -> {
            telegramUser.switchIsActive(false);
            telegramUserService.save(telegramUser);
        });
    }
}
