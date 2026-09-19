package ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StatusColumn {
    @JsonProperty("id")
    private String id;

    @JsonProperty("value")
    private String value;

    @JsonProperty("isConsolidated")
    private boolean isConsolidated;
}
