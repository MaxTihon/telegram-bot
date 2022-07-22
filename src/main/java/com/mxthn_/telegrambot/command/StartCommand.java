package com.mxthn_.telegrambot.command;

import com.mxthn_.telegrambot.repository.entity.TelegramUser;
import com.mxthn_.telegrambot.service.SendBotMessageService;
import com.mxthn_.telegrambot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Implementation of {@link Command}
 */
@Component
public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;
    public static final String START_MESSAGE = "QQ epta. Это самый пиздатый бот, что ты видел. Он пока нихрена не умеет, но и у тебя писюн не сразу вырос.";

    @Autowired
    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                telegramUser -> {
                    telegramUser.switchIsActive(true);
                    telegramUserService.save(telegramUser);
                    },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.switchIsActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                });

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
