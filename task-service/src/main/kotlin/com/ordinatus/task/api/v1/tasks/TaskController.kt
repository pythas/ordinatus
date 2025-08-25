package com.ordinatus.task.api.v1.tasks

import com.ordinatus.task.domain.task.model.Task
import com.ordinatus.task.domain.task.service.CreateTask
import com.ordinatus.task.domain.task.service.TaskAppService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/tasks")
class TaskController(
    private val service: TaskAppService,
    private val mapper: TaskMapper,
) {
    @PostMapping
    fun create(@RequestBody request: CreateTaskRequest) = mapper.toDto(
        service.create(CreateTask(request.title))
    )

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID) = mapper.toDto(service.get(id))
}
