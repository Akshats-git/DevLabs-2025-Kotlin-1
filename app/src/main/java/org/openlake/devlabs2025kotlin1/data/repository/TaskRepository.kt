package org.openlake.devlabs2025kotlin1.data.repository

import io.ktor.client.HttpClient
import org.openlake.devlabs2025kotlin1.data.model.Task

class TaskRepository (private val ktorHttpClient: HttpClient){
    suspend fun getTasks(): List<Task> {
        return TODO("Provide the return value")
    }

    suspend fun addTask(task: Task): Boolean {
        return TODO("Provide the return value")
    }

    suspend fun updateTask(task: Task, taskId: Int): Boolean {
        return TODO("Provide the return value")
    }

    suspend fun deleteTask(taskId: Int): Boolean {
        return TODO("Provide the return value")
    }

    suspend fun markTaskAsCompleted(taskId: Int): Boolean {
        return TODO("Provide the return value")
    }

    suspend fun markTaskAsInProgress(taskId: Int): Boolean {
        return TODO("Provide the return value")

    }
}