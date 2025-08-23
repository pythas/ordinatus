package com.ordinatus.task.infra.persistence.jpa

import com.ordinatus.task.domain.task.model.Task
import com.ordinatus.task.domain.task.model.TaskStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "tasks")
class TaskEntity(
    @Id val id: UUID,
    val title: String,
    @Enumerated(EnumType.STRING) val status: TaskStatus,
) {
    fun toDomain() = Task(id, title, status)

    companion object {
        fun fromDomain(task: Task) = TaskEntity(
            id = task.id,
            title = task.title,
            status = task.status,
        )
    }
}
