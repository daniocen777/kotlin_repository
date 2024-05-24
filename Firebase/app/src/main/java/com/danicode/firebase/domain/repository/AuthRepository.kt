package com.danicode.firebase.domain.repository

interface AuthRepository {
    suspend fun login(email: String, password: String): Boolean

    suspend fun signup(email: String, password: String): Boolean
}