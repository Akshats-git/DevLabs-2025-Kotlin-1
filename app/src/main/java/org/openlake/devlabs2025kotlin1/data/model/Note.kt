package org.openlake.devlabs2025kotlin1.data.model

import kotlinx.serialization.Serializable
@Serializable
data class Note(
    val id: Int? = null,
    val title: String,
    val content: String,
)