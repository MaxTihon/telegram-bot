package com.mxthn_.telegrambot.command;

import static com.mxthn_.telegrambot.command.CommandName.HELP;
import static com.mxthn_.telegrambot.command.HelpCommand.HELP_MESSAGE;

class HelpCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}