package ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;
import java.util.stream.Collectors;


@Data
public class AnalyticsData {
    @JsonProperty("table")
    private Table table;
    private int pageSize;
    private int total;
    private int startIssueIndex;
    private int endIssueIndex;

    public Map<String, String> statuses() {
        return table.getHeader()
                .getBaseHeader()
                .getValueColumns()
                .stream()
                .collect(Collectors.toMap(StatusColumn::getId, StatusColumn::getValue));
    }
}
