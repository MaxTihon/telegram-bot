package com.mxthn_.telegrambot.command;

import static com.mxthn_.telegrambot.command.CommandName.STAT;
import static com.mxthn_.telegrambot.command.StatCommand.STAT_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class StatCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}