package com.mxthn_.telegrambot.javarushclient.dto;

import lombok.Data;

@Data
public class GroupDiscussionInfo {
    private String avatarUrl;
    private Integer commentsCount;
    private String createTime;
    private String description;
    private Integer id;
    private String key;
    private Integer levelToEditor;
    private MeGroupInfo meGroupInfo;
    private String pictureUrl;
    private String title;
    private GroupInfoType type;
    private UserDiscussionInfo userDiscussionInfo;
    private Integer usersCount;
    private GroupVisibilityStatus visibilityStatus;
}
