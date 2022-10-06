package org.boro.cdqtaskapi.adapter.db;

import lombok.RequiredArgsConstructor;
import org.boro.cdqtaskapi.domain.Task;
import org.boro.cdqtaskapi.domain.TaskId;
import org.boro.cdqtaskapi.domain.TaskRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaTaskRepository implements TaskRepository {

    private final SpringDataJpaTaskRepository repository;

    @Override
    public Task save(Task task) {
        var entity = TaskEntity.of(task);
        return repository.save(entity).toDomain();
    }

    @Override
    public Optional<Task> findById(TaskId id) {
        return repository.findById(id.getRaw()).map(TaskEntity::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll()
                .stream()
                .map(TaskEntity::toDomain)
                .toList();
    }
}
