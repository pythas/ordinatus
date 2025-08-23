package com.ordinatus.task.api.v1.tasks

import com.ordinatus.task.domain.task.model.TaskStatus
import jakarta.validation.constraints.NotBlank
import java.util.*

data class TaskDto(
    val id: UUID,
    val title: String,
    val status: TaskStatus,
)

data class CreateTaskRequest(
    @field:NotBlank val title: String
)
