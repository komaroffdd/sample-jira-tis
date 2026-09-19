package ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ColumnBy {
    FT_TO_STATUS_DATE("firstTransitionToStatusDate"),
    STATUS_DURATION_BY_ASSIGNEE("statusDurationByAssignee"),
    LT_FROM_STATUS_DATE("lastTransitionFromStatusDate");
    private final String column;
}
