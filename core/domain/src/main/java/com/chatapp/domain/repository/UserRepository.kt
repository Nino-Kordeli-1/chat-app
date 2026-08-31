package com.chatapp.domain.repository

import com.chatapp.domain.data.User

interface UserRepository {
    suspend fun registerUser(user: User)
    suspend fun getUserByEmail(email: String): User?
    suspend fun getUserById(id: Int): User?
}