package com.ordinatus.contracts.events

import java.util.UUID

data class TaskCreated(
    val id: UUID,
    val title: String,
)
