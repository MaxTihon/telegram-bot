package com.mxthn_.telegrambot.command;

import com.mxthn_.telegrambot.javarushclient.JavaRushGroupClient;
import com.mxthn_.telegrambot.javarushclient.dto.GroupRequestArgs;
import com.mxthn_.telegrambot.service.JavaRushGroupSubscriptionService;
import com.mxthn_.telegrambot.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.stream.Collectors;

public class ShowCommand implements Command {
    private final JavaRushGroupClient javaRushGroupClient;
    private final SendBotMessageService sendBotMessageService;

    public ShowCommand(JavaRushGroupClient javaRushGroupClient, SendBotMessageService sendBotMessageService) {
        this.javaRushGroupClient = javaRushGroupClient;
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        long chatId = update.getMessage().getChatId();

        String groupIds = javaRushGroupClient.getGroupList(GroupRequestArgs.builder().build())
                .stream()
                .map(groupInfo -> String.format("%s - %d \n", groupInfo.getTitle(), groupInfo.getId()))
                .collect(Collectors.joining());

        String message = """
                Чтобы подписаться на группу - напиши /subscribe ID группы.\s

                Вот список групп:\s

                имя группы - ID группы\s

                %s""";

        sendBotMessageService.sendMessage(chatId, String.format(message, groupIds));
    }
}
