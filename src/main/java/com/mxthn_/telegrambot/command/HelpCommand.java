package com.mxthn_.telegrambot.command;

import com.mxthn_.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.mxthn_.telegrambot.command.CommandName.*;

/**
 * Implementation of {@link Command}
 */
public class HelpCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    public static final String HELP_MESSAGE = String.format("""
                    ✨<b>Смотри чё могу:</b>✨

                    <b>Начать\\закончить работу с ботом</b>
                    %s - начать работу со мной
                    %s - приостановить работу со мной
                    %s - получить статистику по работе бота
                    %s - список доступных для подписки групп
                    %s - получить помощь в работе со мной
                    
                    Будешь писать всякую ересь - буду передразнивать
                    """,
            START.getCommandName(), STOP.getCommandName(), STAT.getCommandName(), SHOW.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();

        sendBotMessageService.sendMessage(chatId, HELP_MESSAGE);
    }
}
