package com.ordinatus.task.domain.task.port

interface EventPublisher {
    fun publish(topic: String, payload: Any)
}
