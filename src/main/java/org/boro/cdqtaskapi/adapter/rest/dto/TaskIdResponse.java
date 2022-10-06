package org.boro.cdqtaskapi.adapter.rest.dto;

import lombok.Value;
import org.boro.cdqtaskapi.domain.TaskId;

@Value
public class TaskIdResponse {

    int id;

    public static TaskIdResponse of(TaskId id) {
        return new TaskIdResponse(id.getRaw());
    }
}
