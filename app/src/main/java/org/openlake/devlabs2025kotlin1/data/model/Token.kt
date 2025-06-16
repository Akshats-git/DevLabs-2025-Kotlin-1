package org.openlake.devlabs2025kotlin1.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRequest(
    val fullName: String,
    val email: String,
    val password: String
)

@Serializable
data class AuthenticationRequest(
    val email: String,
    val password: String
)

@Serializable
data class AuthenticationResponse(
    val access_token: String
)
