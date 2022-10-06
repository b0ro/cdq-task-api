package org.boro.cdqtaskapi.adapter.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Value;
import org.boro.cdqtaskapi.domain.Task;

@Value
public class TaskResponse {

    long id;

    String status;

    String progress;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    TaskResultResponse result;

    public static TaskResponse of(Task task) {
        return new TaskResponse(
                task.getId().getRaw(),
                task.getStatus()
                        .name()
                        .toLowerCase(),
                String.format("%s%%", task.getProgress()),
                TaskResultResponse.of(task.getResult())
        );
    }
}
