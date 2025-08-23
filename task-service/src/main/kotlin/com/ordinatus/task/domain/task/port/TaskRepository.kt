package com.ordinatus.task.domain.task.port

import com.ordinatus.task.domain.task.model.Task
import java.util.UUID

interface TaskRepository {
    fun findById(id: UUID): Task?
    fun save(task: Task): Task
}
