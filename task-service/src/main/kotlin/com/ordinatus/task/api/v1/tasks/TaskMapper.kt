package com.ordinatus.task.api.v1.tasks

import com.ordinatus.task.domain.task.model.Task
import org.springframework.stereotype.Component

@Component
class TaskMapper {
    fun toDto(task: Task) = TaskDto(
        id = task.id,
        title = task.title,
        status = task.status,
    )
}
