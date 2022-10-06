package org.boro.cdqtaskapi.domain.exception;

import org.boro.cdqtaskapi.domain.TaskId;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(TaskId id) {
        super(String.format("Task with id %s not found!", id.getRaw()));
    }
}
