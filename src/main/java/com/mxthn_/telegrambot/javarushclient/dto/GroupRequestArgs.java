package com.mxthn_.telegrambot.javarushclient.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@Builder
@Getter
public class GroupRequestArgs {
    private final String query;
    private final String type;
    private final Integer userId;
    private final String order;
    private final String filter;
    private final Boolean includeDiscussion;
    private final Integer offset;
    private final Integer limit;

    public Map<String, Object> populateQueries() {
        Map<String, Object> queries = new HashMap<>();
        if(nonNull(query)) {
            queries.put("query", query);
        }
        if(nonNull(type)) {
            queries.put("type", type);
        }
        if(nonNull(userId)) {
            queries.put("userId", userId);
        }
        if(nonNull(order)) {
            queries.put("order", order);
        }
        if(nonNull(filter)) {
            queries.put("filter", filter);
        }
        if(nonNull(includeDiscussion)) {
            queries.put("includeDiscussion", includeDiscussion);
        }
        if(nonNull(offset)) {
            queries.put("offset", offset);
        }
        if(nonNull(limit)) {
            queries.put("limit", limit);
        }
        return queries;
    }
}
