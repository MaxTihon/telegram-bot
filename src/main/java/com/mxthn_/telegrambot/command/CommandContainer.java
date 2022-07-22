package com.mxthn_.telegrambot.command;

import com.google.common.collect.ImmutableMap;
import com.mxthn_.telegrambot.javarushclient.JavaRushGroupClient;
import com.mxthn_.telegrambot.service.SendBotMessageService;
import com.mxthn_.telegrambot.service.TelegramUserService;

import static com.mxthn_.telegrambot.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService, JavaRushGroupClient javaRushGroupClient) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(STAT.getCommandName(), new StatCommand(sendBotMessageService, telegramUserService))
                .put(NO.getCommandName(), new NotCommand(sendBotMessageService))
                .put(SHOW.getCommandName(), new ShowCommand(javaRushGroupClient, sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
