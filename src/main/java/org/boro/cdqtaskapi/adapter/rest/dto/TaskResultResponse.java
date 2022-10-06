package org.boro.cdqtaskapi.adapter.rest.dto;

import lombok.Value;
import org.boro.cdqtaskapi.domain.TaskResult;

@Value
class TaskResultResponse {
    Integer position;
    Integer typos;

    public static TaskResultResponse of(TaskResult result) {
        if (result == null) {
            return null;
        }
        return new TaskResultResponse(
                result.getPosition(),
                result.getTypos()
        );
    }
}
