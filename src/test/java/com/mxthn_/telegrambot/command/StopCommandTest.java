package com.mxthn_.telegrambot.command;

import static com.mxthn_.telegrambot.command.CommandName.STOP;
import static com.mxthn_.telegrambot.command.StopCommand.STOP_MESSAGE;

class StopCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService, telegramUserService);
    }
}