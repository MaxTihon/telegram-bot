package com.mxthn_.telegrambot.repository;

import com.mxthn_.telegrambot.repository.entity.JavaRushGroupSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JavaRushGroupRepository extends JpaRepository<JavaRushGroupSubscription, Integer> {
}
