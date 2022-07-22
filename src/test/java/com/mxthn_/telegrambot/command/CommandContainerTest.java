package com.mxthn_.telegrambot.command;

import com.mxthn_.telegrambot.service.SendBotMessageService;
import com.mxthn_.telegrambot.service.TelegramUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
class CommandContainerTest {
    private CommandContainer commandContainer;

    private TelegramUserService telegramUserService;

    @BeforeEach
    void setUp() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService, telegramUserService);
    }

    @Test
    public void getAllTheExistingCommands() {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    assertThat(command.getClass()).isNotEqualTo(UnknownCommand.class);
                });
    }

    @Test
    public void getUnknownCommand() {
        String unknownCommand = "/s";

        Command command = commandContainer.retrieveCommand(unknownCommand);

        assertThat(command.getClass()).isEqualTo(UnknownCommand.class);
    }
}