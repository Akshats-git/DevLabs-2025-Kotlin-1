package org.openlake.devlabs2025kotlin1.data.repository

import androidx.wear.ongoing.Status
import io.ktor.client.HttpClient
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.openlake.devlabs2025kotlin1.data.model.Task

class TaskRepository(private val ktorHttpClient: HttpClient) {

    private val mutex = Mutex()
    private val tasks = mutableListOf<Task>()
    private var nextId = 1

    suspend fun getTasks(): List<Task> = mutex.withLock {
        tasks.toList()
    }

    suspend fun addTask(task: Task): Boolean = mutex.withLock {
        try {
            val taskWithId = task.copy(id = nextId++)
            tasks.add(taskWithId)
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun updateTask(task: Task, taskId: Int): Boolean = mutex.withLock {
        val index = tasks.indexOfFirst { it.id == taskId }
        if (index == -1) return false
        try {
            tasks[index] = task.copy(id = taskId)
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun deleteTask(taskId: Int): Boolean = mutex.withLock {
        try {
            tasks.removeIf { it.id == taskId }
        } catch (e: Exception) {
            false
        }
    }

    suspend fun markTaskAsCompleted(taskId: Int): Boolean = mutex.withLock {
        val index = tasks.indexOfFirst { it.id == taskId }
        if (index == -1) return false
        val task = tasks[index]
        tasks[index] = task.copy(status = Task.Status.DONE)
        true
    }

    suspend fun markTaskAsInProgress(taskId: Int): Boolean = mutex.withLock {
        val index = tasks.indexOfFirst { it.id == taskId }
        if (index == -1) return false
        val task = tasks[index]
        tasks[index] = task.copy(status = Task.Status.IN_PROGRESS)
        true
    }
}
