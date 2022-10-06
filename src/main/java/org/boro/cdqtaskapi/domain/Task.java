package org.boro.cdqtaskapi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Task {

    private TaskId id;
    private final String input;

    private final String pattern;

    private final Status status;

    private int progress;

    private TaskResult result;

    public Task(TaskId id, String input, String pattern, Status status) {
        this.id = id;
        this.input = input;
        this.pattern = pattern;
        this.status = status;
    }

    public enum Status {
        NEW, RUNNING, FINISHED
    }
}
