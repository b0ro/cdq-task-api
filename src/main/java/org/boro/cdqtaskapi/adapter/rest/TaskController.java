package org.boro.cdqtaskapi.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.boro.cdqtaskapi.adapter.rest.dto.NewTaskRequest;
import org.boro.cdqtaskapi.adapter.rest.dto.TaskIdResponse;
import org.boro.cdqtaskapi.adapter.rest.dto.TaskResponse;
import org.boro.cdqtaskapi.domain.TaskFacade;
import org.boro.cdqtaskapi.domain.TaskId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
class TaskController {

    private final TaskFacade facade;

    @PostMapping
    TaskIdResponse create(@RequestBody @Valid NewTaskRequest request) {
        var task = facade.create(request.toDomain());
        return TaskIdResponse.of(task.getId());
    }

    @GetMapping("/{id}")
    TaskResponse get(@PathVariable int id) {
        var task = facade.findById(TaskId.of(id));
        return TaskResponse.of(task);
    }

    @GetMapping
    List<TaskResponse> getAll() {
        return facade.findAll()
                .stream()
                .map(TaskResponse::of)
                .toList();
    }
}
