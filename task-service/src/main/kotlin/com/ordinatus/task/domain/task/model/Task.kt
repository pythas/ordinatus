package com.ordinatus.task.domain.task.model

import java.util.UUID

data class Task(
    val id: UUID,
    val title: String,
    val status: TaskStatus,
)

enum class TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE
}
