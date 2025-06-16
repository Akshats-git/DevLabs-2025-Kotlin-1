package org.openlake.devlabs2025kotlin1.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: Int? = null ,
    val title: String,
    val description: String,
    val status: String,
    val priority: Int,
)
