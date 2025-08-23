package com.ordinatus.task.infra.messaging.kafka

import com.ordinatus.task.domain.task.port.EventPublisher
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaEventPublisher(
    private val kafka: KafkaTemplate<String, Any>
) : EventPublisher {
    override fun publish(topic: String, payload: Any) {
        kafka.send(topic, payload)
    }
}
