package ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Column {
    @JsonProperty("id")
    private String id;

    @JsonProperty("value")
    private String value;
}
