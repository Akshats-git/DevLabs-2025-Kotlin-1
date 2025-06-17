package org.openlake.devlabs2025kotlin1.presentation


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.openlake.devlabs2025kotlin1.data.model.Note
import org.openlake.devlabs2025kotlin1.data.model.Task
import org.openlake.devlabs2025kotlin1.data.repository.AuthRepository
import org.openlake.devlabs2025kotlin1.data.repository.NotesRepository
import org.openlake.devlabs2025kotlin1.data.repository.TaskRepository
import org.openlake.devlabs2025kotlin1.data.utils.TokenManager

/**
 * TaskifyViewModel - A beginner-friendly ViewModel for managing Tasks and Notes
 *
 * This ViewModel serves as a central point for all Task and Note operations.
 * It exposes LiveData objects that the UI can observe for changes.
 */
class TaskifyViewModel(
    private val taskRepository: TaskRepository,
    private val notesRepository: NotesRepository,
    private val authRepository: AuthRepository,
    private val sessionManager: TokenManager
) : ViewModel() {

    // --- TASKS ---

    // LiveData for all tasks
    private val _tasks = MutableLiveData<List<Task>>(emptyList())
    val tasks: LiveData<List<Task>> = _tasks

    val login = mutableStateOf(false)
    val register = mutableStateOf(false)

    // --- NOTES ---

    // LiveData for all notes
    private val _notes = MutableLiveData<List<Note>>(emptyList())
    val notes: LiveData<List<Note>> = _notes


    // Initialize by loading data
    init {
        loadTasks()
        loadNotes()
    }

    fun login(email: String, password: String){
    }

    fun register(fullName: String, email: String, password: String) {
    }

    fun resetStates() {
        login.value = false
        register.value = false
    }

    /**
     * --- TASK FUNCTIONS ---
     */

    /**
     * Load all tasks from the repository
     */
    fun loadTasks() {

    }

    /**
     * Add a new task
     */
    fun addTask(task: Task) {

    }

    /**
     * Update an existing task
     */
    fun updateTask(task: Task, taskId: Int) {

    }

    /**
     * Delete a task by its ID
     */
    fun deleteTask(taskId: Int) {

    }

    /**
     * Mark a task as completed
     */
    fun markTaskAsCompleted(taskId: Int) {

    }

    /**
     * Move a task to "In Progress" status
     * (This assumes your Task model has a status field that can be updated)
     */
    fun moveTaskToInProgress(taskId: Int) {


    }


    /**
     * --- NOTE FUNCTIONS ---
     */

    /**
     * Load all notes from the repository
     */
    fun loadNotes() {

    }

    /**
     * Add a new note
     */
    fun addNote(note: Note) {

    }

    /**
     * Update an existing note
     */
    fun updateNote(note: Note, noteId: Int) {

    }

    /**
     * Delete a note by its ID
     */
    fun deleteNote(noteId: Int) {

    }

    fun clearStates() {
        _notes.value = emptyList()
        _tasks.value = emptyList()
    }

}