package ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentState {
    @JsonProperty("id")
    private String id;

    @JsonProperty("baseHeaderId")
    private String baseHeaderId;

    @JsonProperty("subHeaderId")
    private String subHeaderId;

    @JsonProperty("value")
    private String formattedValue;

    @JsonProperty("raw")
    private long rawValue;
}
