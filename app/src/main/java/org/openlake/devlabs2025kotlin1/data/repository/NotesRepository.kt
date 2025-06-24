package org.openlake.devlabs2025kotlin1.data.repository

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.openlake.devlabs2025kotlin1.data.model.Note

class NotesRepository(private val client: HttpClient) {

    private val baseUrl = "https://localhost:8080/note"

    suspend fun getNotes(): List<Note> = withContext(Dispatchers.IO) {
        try {
            client.get("$baseUrl/all").body()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    suspend fun getNote(noteId: Int): Note? = withContext(Dispatchers.IO) {
        try {
            client.get("$baseUrl/$noteId").body()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun addNote(note: Note): Boolean = withContext(Dispatchers.IO) {
        try {
            val response: HttpResponse = client.post("$baseUrl/add") {
                setBody(note)
            }
            response.status == HttpStatusCode.OK || response.status == HttpStatusCode.Created
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    suspend fun updateNote(note: Note, noteId: Int): Boolean = withContext(Dispatchers.IO) {
        try {
            val response: HttpResponse = client.put("$baseUrl/update/$noteId") {
                setBody(note)
            }
            response.status == HttpStatusCode.OK
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    suspend fun deleteNoteById(noteId: Int): Boolean = withContext(Dispatchers.IO) {
        try {
            val response: HttpResponse = client.delete("$baseUrl/delete/$noteId")
            response.status == HttpStatusCode.OK
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
