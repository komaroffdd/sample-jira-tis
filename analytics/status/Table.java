package ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Table {
    @JsonProperty("header")
    private Header header;

    @JsonProperty("body")
    private Body body;
}
