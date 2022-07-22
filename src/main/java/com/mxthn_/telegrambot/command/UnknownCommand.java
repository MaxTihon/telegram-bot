package com.mxthn_.telegrambot.command;

import com.mxthn_.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.mxthn_.telegrambot.command.CommandName.*;

public class UnknownCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    public static final String UNKNOWN_MESSAGE = String.format("""
                    <b>Моя твоя не понимать</b>

                    %s - получить помощь в работе со мной
                    """, HELP.getCommandName());

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();

        sendBotMessageService.sendMessage(chatId, UNKNOWN_MESSAGE);
    }
}
