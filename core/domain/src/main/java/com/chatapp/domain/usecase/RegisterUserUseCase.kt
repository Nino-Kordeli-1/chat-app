package com.chatapp.domain.usecase

import com.chatapp.domain.data.User
import com.chatapp.domain.repository.UserRepository

class RegisterUserUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(
        user: User,
        confirmPassword: String
    ): Result<Unit> {
        if (user.password != confirmPassword) {
            return Result.failure(Exception("Passwords do not match"))
        }

        if (user.name.isBlank() || user.email.isBlank() || user.password.isBlank()) {
            return Result.failure(Exception("Please fill in all fields"))
        }

        val existingUser = userRepository.getUserByEmail(user.email)
        if (existingUser != null) {
            return Result.failure(Exception("Email is already registered"))
        }

        userRepository.registerUser(user)
        return Result.success(Unit)
    }
}