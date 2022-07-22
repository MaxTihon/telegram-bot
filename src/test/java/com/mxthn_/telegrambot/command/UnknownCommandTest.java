package com.mxthn_.telegrambot.command;

import static com.mxthn_.telegrambot.command.UnknownCommand.UNKNOWN_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "/s";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}