package ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Header {
    @JsonProperty("baseHeader")
    private BaseHeader baseHeader;

    @JsonProperty("valueColumns")
    private List<StatusColumn> valueColumns;

    @JsonProperty("subHeader")
    private SubHeader subHeader;
}