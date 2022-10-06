package org.boro.cdqtaskapi.adapter.rest.dto;

import lombok.Value;
import org.boro.cdqtaskapi.domain.Task;

@Value
public class NewTaskRequest {

    String input;
    String pattern;

    public Task toDomain() {
        return new Task(input, pattern, Task.Status.NEW);
    }
}
