package com.ordinatus.task.infra.persistence.jpa

import com.ordinatus.task.domain.task.model.Task
import com.ordinatus.task.domain.task.port.TaskRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class TaskRepositoryAdapter(
    private val jpa: TaskJpaRepository
) : TaskRepository {
    override fun findById(id: UUID): Task? = jpa.findById(id).orElse(null)?.toDomain()
    override fun save(task: Task): Task = jpa.save(TaskEntity.fromDomain(task)).toDomain()
}

