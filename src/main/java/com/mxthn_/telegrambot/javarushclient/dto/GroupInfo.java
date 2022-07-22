package com.mxthn_.telegrambot.javarushclient.dto;

import lombok.Data;

@Data
public class GroupInfo {
    private String avatarUrl;
    private String createTime;
    private String description;
    private Integer id;
    private String key;
    private Integer levelToEditor;
    private MeGroupInfo meGroupInfo;
    private String pictureUrl;
    private String title;
    private GroupInfoType type;
    private Integer usersCount;
    private GroupVisibilityStatus visibilityStatus;
}
