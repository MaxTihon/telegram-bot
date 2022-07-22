package com.mxthn_.telegrambot.service;

import com.mxthn_.telegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.mxthn_.telegrambot.repository.JavaRushGroupRepository;
import com.mxthn_.telegrambot.repository.entity.JavaRushGroupSubscription;
import com.mxthn_.telegrambot.repository.entity.TelegramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.Optional;

@Service
public class JavaRushGroupSubscriptionServiceImpl implements JavaRushGroupSubscriptionService {
    private final JavaRushGroupRepository javaRushGroupRepository;
    private final TelegramUserService telegramUserService;

    @Autowired
    public JavaRushGroupSubscriptionServiceImpl(JavaRushGroupRepository javaRushGroupRepository, TelegramUserService telegramUserService) {
        this.javaRushGroupRepository = javaRushGroupRepository;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public JavaRushGroupSubscription save(Long chatId, GroupDiscussionInfo groupDiscussionInfo) {
        TelegramUser telegramUser = telegramUserService.findByChatId(chatId).orElseThrow(NotFoundException::new);

        JavaRushGroupSubscription javaRushGroupSubscription;
        Optional<JavaRushGroupSubscription> optionalJavaRushGroup = javaRushGroupRepository.findById(groupDiscussionInfo.getId());
        if (optionalJavaRushGroup.isPresent()) {
            javaRushGroupSubscription = optionalJavaRushGroup.get();

            Optional<TelegramUser> subscriber = javaRushGroupSubscription.getUsers()
                    .stream()
                    .filter(user -> user.getChatId().equals(chatId))
                    .findFirst();

            if (subscriber.isPresent()) {
                javaRushGroupSubscription.addUser(telegramUser);
            }
        } else {
            javaRushGroupSubscription = new JavaRushGroupSubscription();
            javaRushGroupSubscription.addUser(telegramUser);
            javaRushGroupSubscription.setId(groupDiscussionInfo.getId());
            javaRushGroupSubscription.setTitle(groupDiscussionInfo.getTitle());
        }

        return javaRushGroupRepository.save(javaRushGroupSubscription);
    }
}
