package ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SubHeader {
    @JsonProperty("valueColumns")
    private List<UserColumn> valueColumns;
}
