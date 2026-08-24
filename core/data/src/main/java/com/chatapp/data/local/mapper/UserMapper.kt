package com.chatapp.data.local.mapper

import com.chatapp.data.local.entity.UserEntity
import com.chatapp.domain.data.User

fun UserEntity.toDomain(): User {
    return User(
        id = this.id,
        name = this.name,
        email = this.email,
        password = this.password
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name,
        email = this.email,
        password = this.password
    )
}