package com.ordinatus.ai.infra.messaging.kafka

import com.ordinatus.contracts.events.TaskCreated
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@EnableKafka
@Service
class TaskCreatedListener {
    @KafkaListener(topics = ["task.created"])
    fun onTaskCreated(event: TaskCreated) {
        System.out.println("asd")
    }
}