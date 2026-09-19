package ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.transitions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status.Column;
import ru.gitlab.collector.gitlabcollector.integration.model.jira.analytics.status.StatusColumn;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransitionReportResponse {
    private int startIssueIndex;
    private int endIssueIndex;
    private int pageSize;
    private int total;
    private String dateTimeFormat;
    private String dateFormat;
    private String timeZone;
    private String locale;
    private boolean isComposite;
    private String columnsBy;
    private String query;
    private String trimHistoryStartDate;
    private String trimHistoryEndDate;
    private String reportDate;
    private String version;
    private List<Status> includedStatuses;
    private List<Status> excludedStatuses;
    private List<Status> deletedStatuses;
    private boolean isAggregationType;
    private boolean isOverall;
    private boolean isAverage;
    private boolean isSum;
    private boolean isMedian;
    private boolean isStddev;
    private Table table;

    public Map<String, String> statuses() {
        return includedStatuses
                .stream()
                .collect(Collectors.toMap(Status::getId, Status::getName));
    }


    @Data
    public static class Status {
        private String id;
        private String name;
        private boolean deleted;
    }

    @Data
    public static class Table {
        private Header header;
        private Body body;
    }

    @Data
    public static class Header {
        private List<Column> headerColumns;
        private List<Column> groupByColumns;
        private List<Column> fieldColumns;
        private List<ValueColumn> valueColumns;
    }

    @Data
    public static class Body {
        private List<Row> rows;
    }

    @Data
    public static class Column {
        private String id;
        private String value;
    }

    @Data
    public static class ValueColumn {
        private String id;
        private String value;
        private String raw; // may be null

        public boolean hasValue() {
            return value.equalsIgnoreCase("-");
        }
    }

    @Data
    public static class Row {
        private List<Column> headerColumns;
        private List<Column> groupByColumns;
        private List<Column> fieldColumns;
        private List<ValueColumn> valueColumns;

        @JsonProperty("currentState")
        private List<String> currentState;

        public String getIssueKey() {
            return headerColumns.stream()
                    .filter(hc -> "issuekey".equals(hc.getId()))
                    .findFirst()
                    .map(c -> c.value)
                    .orElse("0");
        }

    }
}

