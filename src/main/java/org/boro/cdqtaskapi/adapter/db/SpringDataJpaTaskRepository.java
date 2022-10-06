package org.boro.cdqtaskapi.adapter.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataJpaTaskRepository extends JpaRepository<TaskEntity, Integer> {
}
