package org.openlake.devlabs2025kotlin1.data.repository

import org.openlake.devlabs2025kotlin1.presentation.components.Task
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class TaskRepository {

    private val mutex = Mutex()
    private val taskList = mutableListOf<Task>()
    private var nextId = 1

    suspend fun getTasks(): List<Task> = mutex.withLock {
        taskList.toList()
    }

    suspend fun addTask(task: Task): Boolean = mutex.withLock {
        try {
            val taskWithId = task.copy(id = nextId++)
            taskList.add(taskWithId)
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun updateTask(task: Task, taskId: Int): Boolean = mutex.withLock {
        val index = taskList.indexOfFirst { it.id == taskId }
        if (index == -1) return false
        try {
            taskList[index] = task.copy(id = taskId)
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun deleteTask(taskId: Int): Boolean = mutex.withLock {
        try {
            taskList.removeIf { it.id == taskId }
        } catch (e: Exception) {
            false
        }
    }

    suspend fun markTaskAsCompleted(taskId: Int): Boolean = mutex.withLock {
        val index = taskList.indexOfFirst { it.id == taskId }
        if (index == -1) return false
        val task = taskList[index]
        taskList[index] = task.copy(status = "Done")
        true
    }

    suspend fun markTaskAsInProgress(taskId: Int): Boolean = mutex.withLock {
        val index = taskList.indexOfFirst { it.id == taskId }
        if (index == -1) return false
        val task = taskList[index]
        taskList[index] = task.copy(status = "In Progress")
        true
    }

    suspend fun getTasksByStatus(status: String): List<Task> = mutex.withLock {
        taskList.filter { it.status == status }
    }
}
