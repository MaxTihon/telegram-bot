package com.mxthn_.telegrambot.bot;

import com.mxthn_.telegrambot.command.CommandContainer;
import com.mxthn_.telegrambot.javarushclient.JavaRushGroupClient;
import com.mxthn_.telegrambot.service.SendBotMessageServiceImpl;
import com.mxthn_.telegrambot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.mxthn_.telegrambot.command.CommandName.*;

@Component
public class TihonTelegramBot extends TelegramLongPollingBot {
    private static final String COMMAND_PREFIX = "/";
    @Value("${telegram-bot.api.username}")
    private String botUsername;
    @Value("${telegram-bot.api.token}")
    private String botToken;

    private final CommandContainer commandContainer;
    private final TelegramUserService telegramUserService;

    @Autowired
    public TihonTelegramBot(TelegramUserService telegramUserService, JavaRushGroupClient javaRushGroupClient) {
        this.telegramUserService = telegramUserService;
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this), this.telegramUserService, javaRushGroupClient);
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();

            if (message.startsWith(COMMAND_PREFIX)) {
                String command = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(command).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }
}
