package org.boro.cdqtaskapi.domain;

import lombok.RequiredArgsConstructor;
import org.boro.cdqtaskapi.domain.exception.TaskNotFoundException;

import java.util.List;

@RequiredArgsConstructor
public class TaskFacade {
    private final TaskRepository repository;

    public Task create(Task task) {
        return repository.save(task);
    }

    public Task findById(TaskId id) {
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public List<Task> findAll() {
        return repository.findAll();
    }
}
