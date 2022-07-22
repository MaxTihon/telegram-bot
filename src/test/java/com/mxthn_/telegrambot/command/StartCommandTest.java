package com.mxthn_.telegrambot.command;

import static com.mxthn_.telegrambot.command.CommandName.START;
import static com.mxthn_.telegrambot.command.StartCommand.START_MESSAGE;

class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService, telegramUserService);
    }
}