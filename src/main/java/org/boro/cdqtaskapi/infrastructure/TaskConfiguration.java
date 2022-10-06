package org.boro.cdqtaskapi.infrastructure;

import org.boro.cdqtaskapi.adapter.db.JpaTaskRepository;
import org.boro.cdqtaskapi.adapter.db.SpringDataJpaTaskRepository;
import org.boro.cdqtaskapi.domain.TaskFacade;
import org.boro.cdqtaskapi.domain.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfiguration {

    @Bean
    TaskRepository taskRepository(SpringDataJpaTaskRepository repository) {
        return new JpaTaskRepository(repository);
    }

    @Bean
    TaskFacade taskFacade(TaskRepository repository) {
        return new TaskFacade(repository);
    }
}
