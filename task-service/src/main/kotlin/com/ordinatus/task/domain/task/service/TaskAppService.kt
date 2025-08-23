package com.ordinatus.task.domain.task.service

import com.ordinatus.task.domain.task.model.Task
import com.ordinatus.task.domain.task.port.EventPublisher
import com.ordinatus.task.domain.task.port.TaskRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TaskAppService(
    private val repo: TaskRepository,
    private val events: EventPublisher,
) {
    fun get(id: UUID): Task = repo.findById(id) ?: throw TaskNotFound(id)
    fun create(cmd: CreateTask): Task {
        val task = cmd.toDomain()
        val saved = repo.save(task)

        events.publish(
            "task.created", TaskCreated(saved.id, saved.title)
        )

        return saved
    }
}

data class CreateTask(val title: String)
class TaskNotFound(id: UUID) : RuntimeException("Task $id not found")

private fun CreateTask.toDomain(): Task = Task(
    id = UUID.randomUUID(),
    title = title.trim(),
    status = com.ordinatus.task.domain.task.model.TaskStatus.TODO
)

data class TaskCreated(val id: UUID, val title: String)
