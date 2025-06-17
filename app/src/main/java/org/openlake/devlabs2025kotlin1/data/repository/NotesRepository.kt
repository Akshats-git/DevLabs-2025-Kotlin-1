package org.openlake.devlabs2025kotlin1.data.repository


import io.ktor.client.HttpClient
import org.openlake.devlabs2025kotlin1.data.model.Note


class NotesRepository(private val ktorHttpClient: HttpClient) {
    /**
     * Fetches all notes from the server
     * @return List of notes, or empty list if there was an error
     */
    suspend fun getNotes(): List<Note> {
        return TODO("Provide the return value")
    }

    /**
     * Fetches a specific note by ID
     * @param noteId The ID of the note to fetch
     * @return The requested note or null if not found or error occurred
     */
    suspend fun getNote(noteId: Int): Note? {
        return TODO("Provide the return value")
    }

    /**
     * Adds a new note to the server
     * @param note The note to add
     * @return True if successful, false otherwise
     */
    suspend fun addNote(note: Note): Boolean {
        return TODO("Provide the return value")
    }

    /**
     * Updates an existing note on the server
     * @param note The note with updated data
     * @return True if successful, false otherwise
     */
    suspend fun updateNote(note: Note, noteId: Int): Boolean {
        return TODO("Provide the return value")
    }

    /**
     * Alternative version that deletes a note using just its ID
     * @param noteId The ID of the note to delete
     * @return True if successful, false otherwise
     */
    suspend fun deleteNoteById(noteId: Int): Boolean {
        return TODO("Provide the return value")
    }
}