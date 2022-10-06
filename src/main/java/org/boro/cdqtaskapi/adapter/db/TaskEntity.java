package org.boro.cdqtaskapi.adapter.db;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.boro.cdqtaskapi.domain.Task;
import org.boro.cdqtaskapi.domain.TaskId;
import org.boro.cdqtaskapi.domain.TaskResult;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String input;

    private String pattern;

    private String status;

    private int progress;

    private Integer resultPosition;

    private Integer resultTypos;

    public TaskEntity(Integer id, String input, String pattern, String status, int progress) {
        this.id = id;
        this.input = input;
        this.pattern = pattern;
        this.status = status;
        this.progress = progress;
    }

    public static TaskEntity of(Task task) {
        var entity = new TaskEntity(
                task.getId() != null ? task.getId().getRaw() : null,
                task.getInput(),
                task.getPattern(),
                task.getStatus()
                        .name()
                        .toLowerCase(),
                task.getProgress()
        );
        if (task.getResult() != null) {
            entity.resultPosition = task.getResult().getPosition();
            entity.resultTypos = task.getResult().getTypos();
        }

        return entity;
    }

    public Task toDomain() {
        var task = new Task(
                TaskId.of(id),
                input,
                pattern,
                Task.Status.valueOf(status.toUpperCase())
        );
        task.setProgress(progress);
        if (resultPosition != null && resultTypos != null) {
            task.setResult(new TaskResult(
                    resultPosition,
                    resultTypos
            ));
        }

        return task;
    }
}
