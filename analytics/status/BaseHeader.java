package ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BaseHeader {
    @JsonProperty("headerColumns")
    private List<Column> headerColumns;
    @JsonProperty("fieldColumns")
    private List<Column> fieldColumns;
    @JsonProperty("valueColumns")
    private List<StatusColumn> valueColumns;
}
