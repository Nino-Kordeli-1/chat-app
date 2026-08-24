package com.chatapp.data.di.repository

import com.chatapp.data.repository.UserRepositoryImpl
import com.chatapp.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl(userDao = get()) }
}