package com.chatapp.data.di

import com.chatapp.data.di.database.databaseModule
import com.chatapp.data.di.repository.repositoryModule
import com.chatapp.data.di.usecase.useCaseModule

val coreDataModule = listOf(
    databaseModule,
    repositoryModule,
    useCaseModule
)
