package com.mxthn_.telegrambot.service;

import com.mxthn_.telegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.mxthn_.telegrambot.repository.entity.JavaRushGroupSubscription;

public interface JavaRushGroupSubscriptionService {
    JavaRushGroupSubscription save(Long chatId, GroupDiscussionInfo groupDiscussionInfo);
}
