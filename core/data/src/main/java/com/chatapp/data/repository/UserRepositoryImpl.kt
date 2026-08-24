package com.chatapp.data.repository

import com.chatapp.data.local.dao.UserDao
import com.chatapp.data.local.mapper.toDomain
import com.chatapp.data.local.mapper.toEntity
import com.chatapp.domain.data.User
import com.chatapp.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun registerUser(user: User) {
        userDao.registerUser(user.toEntity())
    }

    override suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)?.toDomain()
    }

    override suspend fun getUserById(id: Int): User? {
        return userDao.getUserById(id)?.toDomain()
    }
}