package ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Row {
    @JsonProperty("headerColumns")
    private List<Column> headerColumns;

    @JsonProperty("fieldColumns")
    private List<Column> fieldColumns;

    @JsonProperty("valueColumns")
    private List<TimeValueColumn> valueColumns;

    @JsonProperty("currentState")
    private List<CurrentState> currentState;

    public String getIssueKey() {
        return headerColumns.stream()
                .filter(hc -> "issuekey".equals(hc.getId()))
                .findFirst()
                .map(Column::getValue)
                .orElse("0");
    }

    public Map<String, String> groupFieldColumns() {
        return fieldColumns.stream()
                .collect(Collectors.toMap(
                        c->c.getId().toLowerCase(),
                        Column::getValue
                ));
    }
}
