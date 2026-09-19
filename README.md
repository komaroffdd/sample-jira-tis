    public <T> T execute(String cookie, String columnsBy, Integer pageSize, Integer startIndex, Integer filterId, Class<T> clazz) {
        HttpEntity<String> entity = prepareHttpEntity(cookie, columnsBy, pageSize, startIndex, filterId);
        return executeRequest(entity, clazz);
    }


    private <T> T executeRequest(HttpEntity<String> entity, Class<T> responseType) {
        String url = jiraClientProperties.getFullUrl();
        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
        return response.getBody();
    }

    private HttpEntity<String> prepareHttpEntity(String cookie, String columnsBy, Integer pageSize, Integer startIndex, Integer filterId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Cookie", "JSESSIONID=" + cookie);

        StringBuilder body = buildForm(columnsBy, pageSize, startIndex, filterId.toString());

        return new HttpEntity<>(body.toString(), headers);
    }

    private StringBuilder buildForm(String columnsBy, Integer pageSize, Integer startIndex, String filterId) {
        StringBuilder body = new StringBuilder();
        add(body, "filterType", "jqlfilter");
        add(body, "user", "DDKomarov");
        add(body, "projectKey", "DEV");
        add(body, "jqlFilterID", filterId);
        add(body, "sprintID", "");
        add(body, "boardID", "");
        add(body, "customJql", "");
        add(body, "columnsBy", columnsBy);
        add(body, "calendar", "normalHours");
        add(body, "dayLength", "24HourDays");
        add(body, "viewFormat", "seconds");
        add(body, "pageSize", pageSize.toString());
        add(body, "dateType", "period");
        add(body, "startDate", "");
        add(body, "endDate", "");
        add(body, "dateRangeField", "created");
        add(body, "trimHistoryStartDate", "");
        add(body, "trimHistoryEndDate", "");
        add(body, "startIssueIndex", startIndex.toString());
        add(body, "includeDeletedStatuses", "true");
        add(body, "outputType", "tableList");
        add(body, "dataBar", "false");
        add(body, "dbsMetrics", "[]");
        add(body, "multiVisitBehavior", "total");
        add(body, "visitCounts", "false");
        add(body, "averageDenominator", "nonNull");


        // Все статусы
        String[] statusIds = {
                "10000", "1", "10002", "10003", "3", "10010", "10004", "10007", "10008",
                "10203", "10283", "10291", "10388", "10502", "10504", "10505", "10506",
                "10507", "13200", "10006", "10005"
        };


        for (int i = 0; i < statusIds.length; i++) {
            add(body, String.format("statuses[%d].id", i), statusIds[i]);
            add(body, String.format("statuses[%d].type", i), "std");
        }
        List<String> fields = List.of("customfield_10320", "resolutiondate", "issuetype", "created");
        for (String field : fields) {
            add(body, "fields", field);
        }
        return body;
    }

    private void add(StringBuilder sb, String key, String value) {
        if (!sb.isEmpty()) sb.append("&");
        sb.append(URLEncoder.encode(key, StandardCharsets.UTF_8));
        sb.append("=");
        sb.append(URLEncoder.encode(value, StandardCharsets.UTF_8));
    }
