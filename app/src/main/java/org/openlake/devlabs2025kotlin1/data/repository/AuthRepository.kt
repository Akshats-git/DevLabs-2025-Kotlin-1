package org.openlake.devlabs2025kotlin1.data.repository

import io.ktor.client.HttpClient

class AuthRepository(private val ktorHttpClient: HttpClient) {

    suspend fun register(fullName: String, email: String, password: String): Boolean {
        return TODO("Provide the return value")
    }

    suspend fun login(email: String, password: String): String? {
        return TODO("Provide the return value")
    }

}
