package com.mxthn_.telegrambot.javarushclient;

import com.mxthn_.telegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.mxthn_.telegrambot.javarushclient.dto.GroupInfo;
import com.mxthn_.telegrambot.javarushclient.dto.GroupRequestArgs;
import com.mxthn_.telegrambot.javarushclient.dto.GroupsCountRequestArgs;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class JavaRushGroupClientImpl implements JavaRushGroupClient {
    @Value("${javarush.api.url}")
    private String javarushApiUrl;
    private static final String PATH_SUFFIX = "/groups";

    @Override
    public List<GroupInfo> getGroupList(GroupRequestArgs groupRequestArgs) {
        return Unirest.get(javarushApiUrl + PATH_SUFFIX)
                .queryString(groupRequestArgs.populateQueries())
                .asObject(new GenericType<List<GroupInfo>>() {

                })
                .getBody();
    }

    @Override
    public List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs groupRequestArgs) {
        return Unirest.get(javarushApiUrl + PATH_SUFFIX)
                .queryString(groupRequestArgs.populateQueries())
                .asObject(new GenericType<List<GroupDiscussionInfo>>() {
                })
                .getBody();
    }

    @Override
    public Integer getGroupsCount(GroupsCountRequestArgs groupsCountRequestArgs) {
        return Integer.valueOf(
                Unirest.get(String.format("%s/count", javarushApiUrl + PATH_SUFFIX))
                        .queryString(groupsCountRequestArgs.populateQueries())
                        .asString()
                        .getBody()
        );
    }

    @Override
    public GroupDiscussionInfo getGroupById(Integer id) {
        return Unirest.get(String.format("%s/group%d", javarushApiUrl + PATH_SUFFIX, id))
                .asObject(GroupDiscussionInfo.class)
                .getBody();
    }
}
