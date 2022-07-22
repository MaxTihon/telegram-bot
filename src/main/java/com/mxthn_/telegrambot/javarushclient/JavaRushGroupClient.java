package com.mxthn_.telegrambot.javarushclient;

import com.mxthn_.telegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.mxthn_.telegrambot.javarushclient.dto.GroupInfo;
import com.mxthn_.telegrambot.javarushclient.dto.GroupRequestArgs;
import com.mxthn_.telegrambot.javarushclient.dto.GroupsCountRequestArgs;

import java.util.List;

public interface JavaRushGroupClient {
    List<GroupInfo> getGroupList(GroupRequestArgs groupRequestArgs);
    List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs groupRequestArgs);
    Integer getGroupsCount(GroupsCountRequestArgs groupsCountRequestArgs);
    GroupDiscussionInfo getGroupById(Integer id);
}
