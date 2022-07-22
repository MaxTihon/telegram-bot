package com.mxthn_.telegrambot.command;

import static com.mxthn_.telegrambot.command.CommandName.NO;
import static org.junit.jupiter.api.Assertions.*;

class NotCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return null;
    }

    @Override
    Command getCommand() {
        return new NotCommand(sendBotMessageService);
    }
}